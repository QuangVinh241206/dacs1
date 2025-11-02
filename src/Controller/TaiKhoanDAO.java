/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modal.TaiKhoan;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author vinhn
 */
public class TaiKhoanDAO {

    ConnectDB cn = new ConnectDB();

    public boolean ThemTaiKhoan(TaiKhoan tk) {
        Connection conn = cn.getConnection();
        String sql = "insert into TaiKhoan values(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tk.getMaNV());
            ps.setString(2, tk.getTenDangNhap());
            ps.setString(3, tk.getMatKhau());
            ps.setInt(4, tk.getQuyen());
            ps.setInt(5, tk.getTrangThai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean SuaTaiKhoan(TaiKhoan tk) {
        Connection conn = cn.getConnection();
        String sql = "update TaiKhoan set TenDangNhap=?, MatKhau=?, Quyen=?, TrangThai=? where MaNV=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);          
            ps.setString(1, tk.getTenDangNhap());
            ps.setString(2, tk.getMatKhau());
            ps.setInt(3, tk.getQuyen());
            ps.setInt(4, tk.getTrangThai());
            ps.setInt(5, tk.getMaNV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean XoaTKByID(int id){
        Connection conn = cn.getConnection();
        String sql = "delete TaiKhoan where MaNV=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<TaiKhoan> getListTK(){
        ArrayList<TaiKhoan> list = new ArrayList<>();
        Connection conn = cn.getConnection();
        String sql = "select * from TaiKhoan";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TaiKhoan tk = new TaiKhoan();
                tk.setMaNV(rs.getInt("MaNV"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setQuyen(rs.getInt("Quyen"));
                tk.setTrangThai(rs.getInt("TrangThai"));
                list.add(tk);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public boolean checkHoatDong(String tdn){
        Connection conn = cn.getConnection();
        String sql = "select * from TaiKhoan where TenDangNhap=? and TrangThai=0";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tdn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean checkTenDangNhap(String tdn){
        Connection conn = cn.getConnection();
        String sql = "select * from TaiKhoan where TenDangNhap=? and TrangThai=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tdn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkMatKhau(String tdn, String mk){
        Connection conn = cn.getConnection();
        String sql = "select * from TaiKhoan where TenDangNhap=? and MatKhau=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tdn);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public TaiKhoan getTaiKhoan(String tdn, String mk){
        Connection conn = cn.getConnection();
        String sql = "select * from TaiKhoan where TenDangNhap=? and MatKhau=?";
        TaiKhoan tk = new TaiKhoan();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tdn);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();          
            if (rs.next()) {
                tk.setMaNV(rs.getInt("MaNV"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setQuyen(rs.getInt("Quyen"));
                tk.setTrangThai(rs.getInt("TrangThai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }
    public boolean DoiMatKhau(String tdn, String mk){
        Connection conn = cn.getConnection();
        String sql= "update TaiKhoan set MatKhau=? where TenDangNhap=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mk);
            ps.setString(2, tdn);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
