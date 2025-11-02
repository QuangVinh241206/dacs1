/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modal.NhaCungCap;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author vinhn
 */
public class NhaCungCapDAO {

    ConnectDB cn = new ConnectDB();

    public boolean ThemNCC(NhaCungCap ncc) {
        Connection conn = cn.getConnection();
        String sql = "insert NhaCungCap(TenNCC, DiaChi, Email, SDT) values(?,?,?,?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getDiaChi());
            ps.setString(3, ncc.getEmail());
            ps.setString(4, ncc.getSDT());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean SuaNCC(NhaCungCap ncc) {
        Connection conn = cn.getConnection();
        String sql = "update NhaCungCap set TenNCC=?, DiaChi=?, Email=?, SDT=? where MaNCC=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getDiaChi());
            ps.setString(3, ncc.getEmail());
            ps.setString(4, ncc.getSDT());
            ps.setInt(5, ncc.getMaNCC());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean XoaNCCByID(int id) {
        Connection conn = cn.getConnection();
        String sql = "update NhaCungCap set TrangThai=0 where MaNCC=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<NhaCungCap> getListNCC() {
        Connection conn = cn.getConnection();
        ArrayList<NhaCungCap> list = new ArrayList<>();
        String sql = "select * from NhaCungCap where TrangThai=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt("MaNCC"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setEmail(rs.getString("Email"));
                ncc.setSDT(rs.getString("SDT"));
                list.add(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<NhaCungCap> getFindNCC(String tukhoa) {
        Connection conn = cn.getConnection();
        ArrayList<NhaCungCap> list = new ArrayList<>();
        String sql = "select * from NhaCungCap where concat(MaNCC, TenNCC, DiaChi, Email, SDT) like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tukhoa + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt("MaNCC"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setEmail(rs.getString("Email"));
                ncc.setSDT(rs.getString("SDT"));
                list.add(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public NhaCungCap getNCCByID(int id) {
        Connection conn = cn.getConnection();
        String sql = "select * from NhaCungCap where MaNCC=?";
        NhaCungCap ncc = new NhaCungCap();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ncc.setMaNCC(rs.getInt("MaNCC"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setEmail(rs.getString("Email"));
                ncc.setSDT(rs.getString("SDT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ncc;
    }
}
