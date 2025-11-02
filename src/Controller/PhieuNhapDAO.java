/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Modal.PhieuNhapKho;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author vinhn
 */
public class PhieuNhapDAO {
    ConnectDB cn = new ConnectDB();
    public boolean ThemPhieuNhap(PhieuNhapKho pn){
        Connection conn = cn.getConnection();
        String sql = "insert PhieuNhap(MaPN, MaNCC, NVNhap, TongTien)"
                + " values(?,?,?,?) ";
        try {
            PreparedStatement ps =conn.prepareStatement(sql);
        ps.setInt(1, pn.getMaPN());
        ps.setInt(2, pn.getMaNCC());
        ps.setInt(3, pn.getMaNVNhap());
        ps.setLong(4, pn.getTongTien());
        return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }      
        return false;
    }
    public boolean XoaPhieuNhapByID(int id){
        Connection conn = cn.getConnection();
        String sql = "update PhieuNhap set TrangThai=0 where MaPN=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<PhieuNhapKho> getAllPhieuNhap() {
        Connection conn = cn.getConnection();
        ArrayList list = new ArrayList();
        String sql = "select * from PhieuNhap";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuNhapKho pn = new PhieuNhapKho();
                pn.setMaPN(rs.getInt("MaPN"));
                pn.setMaNCC(rs.getInt("MaNCC"));
                pn.setMaNVNhap(rs.getInt("NVNhap"));
                pn.setThoiGian(rs.getTimestamp("ThoiGian"));
                pn.setTongTien(rs.getInt("TongTien"));
                list.add(pn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<PhieuNhapKho> getListPhieuNhap() {
        Connection conn = cn.getConnection();
        ArrayList list = new ArrayList();
        String sql = "select * from PhieuNhap where TrangThai=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuNhapKho pn = new PhieuNhapKho();
                pn.setMaPN(rs.getInt("MaPN"));
                pn.setMaNCC(rs.getInt("MaNCC"));
                pn.setMaNVNhap(rs.getInt("NVNhap"));
                pn.setThoiGian(rs.getTimestamp("ThoiGian"));
                pn.setTongTien(rs.getInt("TongTien"));
                list.add(pn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public PhieuNhapKho getPNbyID(int id){
        Connection conn = cn.getConnection();
        String sql = "select * from PhieuNhap where MaPN=?";
        PhieuNhapKho pn = new PhieuNhapKho();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pn.setMaPN(rs.getInt("MaPN"));
                pn.setMaNCC(rs.getInt("MaNCC"));
                pn.setMaNVNhap(rs.getInt("NVNhap"));
                pn.setThoiGian(rs.getTimestamp("ThoiGian"));
                pn.setTongTien(rs.getInt("TongTien"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pn;
    }
}
