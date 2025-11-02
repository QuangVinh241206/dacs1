/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modal.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vinhn
 */
public class KhachHangDAO {

    ConnectDB cn = new ConnectDB();

    public boolean ThemKhachHang(KhachHang kh) {
        Connection conn = cn.getConnection();
        String sql = "insert into KhachHang(TenKH, DiaChi, SDT)"
                + " values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getDiaChi());
            ps.setString(3, kh.getSDT());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<KhachHang> getListKH() {
        Connection conn = cn.getConnection();
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "select * from KhachHang where TrangThai=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSDT(rs.getString("SDT"));
                kh.setNgayThamGia(rs.getDate("NgayThamGia"));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean SuaKhachHang(KhachHang kh) {
        Connection conn = cn.getConnection();
        String sql = "update KhachHang set TenKH=?,DiaChi=?,SDT=?"
                + "where MaKH=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getDiaChi());
            ps.setString(3, kh.getSDT());
            ps.setInt(4, kh.getMaKH());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean XoaKhachHangByID(int id) {
        Connection conn = cn.getConnection();
        String sql = "update KhachHang set TrangThai=0 where MaKH=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<KhachHang> getFindKH(String tukhoa) {
        Connection conn = cn.getConnection();
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "select * from KhachHang where concat(MaKH, TenKH, DiaChi"
                + ", SDT, NgayThamGia) like ?";              
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tukhoa + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSDT(rs.getString("SDT"));
                kh.setNgayThamGia(rs.getDate("NgayThamGia"));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public KhachHang getKHbyID(int id){
        Connection conn = cn.getConnection();
        String sql= "select * from KhachHang where MaKH=?";
        KhachHang kh = new KhachHang();
        try {
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSDT(rs.getString("SDT"));
                kh.setNgayThamGia(rs.getDate("NgayThamGia"));
            }          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }
}
