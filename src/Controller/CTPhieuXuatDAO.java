/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author vinhn
 */
import Modal.CTPhieuXuat;
import java.sql.*;
import java.util.ArrayList;
public class CTPhieuXuatDAO {
    ConnectDB cn = new ConnectDB();

    public ArrayList<CTPhieuXuat> getListCTPhieuXuat(int id) {
        Connection conn = cn.getConnection();
        ArrayList list = new ArrayList();
        String sql = "select * from ChiTietPhieuXuat where MaPX=? and TrangThai=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CTPhieuXuat ctpx = new CTPhieuXuat();
                ctpx.setMaPX(rs.getInt("MaPX"));
                ctpx.setMaSP(rs.getInt("MaSP"));
                ctpx.setSoLuong(rs.getInt("SoLuong"));
                ctpx.setGia(rs.getInt("DonGia"));
                list.add(ctpx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void ThemCTPX(CTPhieuXuat ctpx){
        Connection conn = cn.getConnection();
        String sql = "insert into ChiTietPhieuXuat(MaPX, MaSP, SoLuong, DonGia) values(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ctpx.getMaPX());
            ps.setInt(2, ctpx.getMaSP());
            ps.setInt(3, ctpx.getSoLuong());
            ps.setLong(4, ctpx.getGia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void XoaCTPXByID(int id){
        Connection conn = cn.getConnection();
        String sql = "update ChiTietPhieuXuat set TrangThai=0 where MaPX=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
