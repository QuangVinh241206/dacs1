/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modal.NhanVien;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author vinhn
 */
public class NhanVienDAO {
    ConnectDB cn = new ConnectDB();
    public boolean ThemNhanVien(NhanVien nv){
        Connection conn = cn.getConnection();
        String sql = "insert into NhanVien(TenNV, GioiTinh, NgaySinh, SDT, Email) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getTenNV());
            ps.setInt(2, nv.getGioiTinh());
            ps.setDate(3, nv.getNgaySinh());
            ps.setString(4, nv.getSDT());
            ps.setString(5, nv.getEmail());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean SuaNhanVien(NhanVien nv){
        Connection conn = cn.getConnection();
        String sql = "update NhanVien set TenNV=?, GioiTinh=?, NgaySinh=?, SDT=?, Email=? where MaNV=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getTenNV());
            ps.setInt(2, nv.getGioiTinh());
            ps.setDate(3, nv.getNgaySinh());
            ps.setString(4, nv.getSDT());
            ps.setString(5, nv.getEmail());
            ps.setInt(6, nv.getMaNV());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean XoaNVByID(int id){
        Connection conn = cn.getConnection();
        String sql = "update NhanVien set TrangThai=0 where MaNV=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<NhanVien> getListNV(){
        ArrayList<NhanVien> list = new ArrayList<>();
        Connection conn = cn.getConnection();
        String sql = "select * from NhanVien where TrangThai=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getInt("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setSDT(rs.getString("SDT"));
                nv.setEmail(rs.getString("Email"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<NhanVien> getFindNV(String tukhoa){
         ArrayList<NhanVien> list = new ArrayList<>();
        Connection conn = cn.getConnection();
        String sql = "select * from NhanVien where concat(MaNV,TenNV, GioiTinh, NgaySinh, SDT, Email) like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+tukhoa+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getInt("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setSDT(rs.getString("SDT"));
                nv.setEmail(rs.getString("Email"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<NhanVien> getListNVChuaTK() {
    ArrayList<NhanVien> list = new ArrayList<>();
    Connection conn = cn.getConnection();

    String sql = """
        SELECT NV.MaNV AS MaNV_NV, NV.TenNV, NV.GioiTinh, NV.NgaySinh,
               NV.SDT, NV.Email
        FROM NhanVien NV
        LEFT JOIN TaiKhoan TK ON NV.MaNV = TK.MaNV
        WHERE TK.MaNV IS NULL AND NV.TrangThai = 1
    """;

    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            NhanVien nv = new NhanVien();
            nv.setMaNV(rs.getInt("MaNV_NV"));
            nv.setTenNV(rs.getString("TenNV"));
            nv.setGioiTinh(rs.getInt("GioiTinh"));
            nv.setNgaySinh(rs.getDate("NgaySinh"));
            nv.setSDT(rs.getString("SDT"));
            nv.setEmail(rs.getString("Email"));

            list.add(nv);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
    public NhanVien getNhanVienByID(int id){
        Connection conn = cn.getConnection();
        String sql = "select * from NhanVien where MaNV=?";
        NhanVien nv = new NhanVien();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nv.setMaNV(rs.getInt("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setSDT(rs.getString("SDT"));
                nv.setEmail(rs.getString("Email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }
}
