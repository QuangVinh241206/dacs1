package Controller;


import org.jfree.data.category.DefaultCategoryDataset;
import java.sql.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vinhn
 */
public class ThongKeDoanhThuDAO {
    ConnectDB cn = new ConnectDB();
     public DefaultCategoryDataset getDoanhThuTheoNam(int nam) {
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String sql = """
            WITH thang_cte AS (
                SELECT 1 AS thang UNION ALL
                SELECT 2 UNION ALL
                SELECT 3 UNION ALL
                SELECT 4 UNION ALL
                SELECT 5 UNION ALL
                SELECT 6 UNION ALL
                SELECT 7 UNION ALL
                SELECT 8 UNION ALL
                SELECT 9 UNION ALL
                SELECT 10 UNION ALL
                SELECT 11 UNION ALL
                SELECT 12
            )
            SELECT 
                t.thang,
                ISNULL(xuat.tong_xuat, 0) - ISNULL(nhap.tong_nhap, 0) AS doanh_thu
            FROM 
                thang_cte t
            LEFT JOIN (
                SELECT MONTH(ThoiGian) AS thang, SUM(TongTien) AS tong_xuat
                FROM phieuxuat
                WHERE YEAR(ThoiGian) = ? AND TrangThai = 1
                GROUP BY MONTH(ThoiGian)
            ) AS xuat ON t.thang = xuat.thang
            LEFT JOIN (
                SELECT MONTH(ThoiGian) AS thang, SUM(TongTien) AS tong_nhap
                FROM phieunhap
                WHERE YEAR(ThoiGian) = ? AND TrangThai = 1
                GROUP BY MONTH(ThoiGian)
            ) AS nhap ON t.thang = nhap.thang
            ORDER BY t.thang;
        """;

        try (
            Connection conn = cn.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, nam);
            ps.setInt(2, nam);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int thang = rs.getInt("thang");
                    double doanhThu = rs.getDouble("doanh_thu");
                    dataset.addValue(doanhThu, "Doanh thu", "Tháng " + thang);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }
    
}
