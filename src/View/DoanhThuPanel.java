/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author vinhn
 */
import Controller.ThongKeDoanhThuDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;

public class DoanhThuPanel extends JPanel {
    private ChartPanel chartPanel;
    private JComboBox<Integer> cboNam;

    public DoanhThuPanel() {
        setLayout(new BorderLayout());

        // ComboBox chọn năm
        cboNam = new JComboBox<>();
        for (int i = 2020; i <= 2025; i++) {
            cboNam.addItem(i);
        }
        cboNam.setSelectedItem(2025); // mặc định

        // Panel trên chứa comboBox
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Chọn năm:"));
        topPanel.add(cboNam);

        add(topPanel, BorderLayout.NORTH);

        // Biểu đồ ban đầu
        int nam = (Integer) cboNam.getSelectedItem();
        DefaultCategoryDataset dataset = new ThongKeDoanhThuDAO().getDoanhThuTheoNam(nam);
        JFreeChart chart = ChartFactory.createBarChart(
            "Doanh thu theo tháng - năm " + nam,
            "Tháng", "Doanh thu (VNĐ)", dataset
        );
        chart.setBackgroundPaint(Color.WHITE);
        chart.getCategoryPlot().setBackgroundPaint(Color.WHITE);
        chart.getCategoryPlot().setRangeGridlinePaint(Color.LIGHT_GRAY);
        

        chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(Color.WHITE);
        add(chartPanel, BorderLayout.CENTER);

        // Sự kiện chọn năm
        cboNam.addActionListener(e -> capNhatBieuDo((Integer) cboNam.getSelectedItem()));
    }

    private void capNhatBieuDo(int nam) {
        DefaultCategoryDataset dataset =new  ThongKeDoanhThuDAO().getDoanhThuTheoNam(nam);
        JFreeChart chart = ChartFactory.createBarChart(
            "Doanh thu theo tháng năm " + nam,
            "Tháng", "Doanh thu (VNĐ)", dataset
        );
        chart.setBackgroundPaint(Color.WHITE);
        chart.getCategoryPlot().setBackgroundPaint(Color.WHITE);
        chart.getCategoryPlot().setRangeGridlinePaint(Color.LIGHT_GRAY);
        chartPanel.setChart(chart);
    }
}

