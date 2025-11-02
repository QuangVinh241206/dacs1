/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modal.PhieuXuatKho;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author vinhn
 */
public class PhieuXuatDAO {
    ConnectDB cn = new ConnectDB();
    public boolean ThemPhieuXuat(PhieuXuatKho px){
        Connection conn = cn.getConnection();
        String sql = "insert PhieuXuat(MaPX, KhachHang, NVXuat, TongTien)"
                + " values(?,?,?,?) ";
        try {
            PreparedStatement ps =conn.prepareStatement(sql);
        ps.setInt(1, px.getMaPX());
        ps.setInt(2, px.getMaKH());
        ps.setInt(3, px.getMaNV());
        ps.setLong(4, px.getTongTien());
        return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }      
        return false;
    }
    public boolean XoaPhieuXuatByID(int id){
        Connection conn = cn.getConnection();
        String sql = "update PhieuXuat set TrangThai=0 where MaPX=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<PhieuXuatKho> getAllPhieuXuat() {
        Connection conn = cn.getConnection();
        ArrayList list = new ArrayList();
        String sql = "select * from PhieuXuat";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuXuatKho px = new PhieuXuatKho();
                px.setMaPX(rs.getInt("MaPX"));
                px.setMaKH(rs.getInt("KhachHang"));
                px.setMaNV(rs.getInt("NVXuat"));
                px.setThoiGian(rs.getTimestamp("ThoiGian"));
                px.setTongTien(rs.getInt("TongTien"));
                list.add(px);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<PhieuXuatKho> getListPhieuXuat() {
        Connection conn = cn.getConnection();
        ArrayList list = new ArrayList();
        String sql = "select * from PhieuXuat where TrangThai=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuXuatKho px = new PhieuXuatKho();
                px.setMaPX(rs.getInt("MaPX"));
                px.setMaKH(rs.getInt("KhachHang"));
                px.setMaNV(rs.getInt("NVXuat"));
                px.setThoiGian(rs.getTimestamp("ThoiGian"));
                px.setTongTien(rs.getInt("TongTien"));
                list.add(px);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public PhieuXuatKho getPXbyID(int id){
        Connection conn = cn.getConnection();
        String sql = "select * from PhieuXuat where MaPX=?";
        PhieuXuatKho pn = new PhieuXuatKho();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pn.setMaPX(rs.getInt("MaPX"));
                pn.setMaKH(rs.getInt("KhachHang"));
                pn.setMaNV(rs.getInt("NVXuat"));
                pn.setThoiGian(rs.getTimestamp("ThoiGian"));
                pn.setTongTien(rs.getInt("TongTien"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pn;
    }
}
