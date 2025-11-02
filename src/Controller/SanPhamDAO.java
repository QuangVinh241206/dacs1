package Controller;

import Controller.ConnectDB;
import Modal.SanPham;
import java.sql.*;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vinhn
 */
public class SanPhamDAO {

    ConnectDB cn = new ConnectDB();

    public boolean ThemSanPham(SanPham sp) {
        Connection conn = cn.getConnection();
        String sql = "insert into SanPham(TenSP, SoLuong, ThuongHieu"
                + ", HeDieuHanh, KichThuocMan, ChipXuLy, DungLuongPin, XuatXu"
                + ", GiaNhap, GiaBan) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setInt(2, sp.getSoLuong());
            ps.setString(3, sp.getThuongHieu());
            ps.setString(4, sp.getHeDieuHanh());
            ps.setDouble(5, sp.getKichThuocMan());
            ps.setString(6, sp.getChipXuLy());
            ps.setInt(7, sp.getDungLuongPin());
            ps.setString(8, sp.getXuatXu());
            ps.setInt(9, sp.getGiaNhap());
            ps.setInt(10, sp.getGiaBan());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<SanPham> getListSP() {
        Connection conn = cn.getConnection();
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select * from SanPham where TrangThai=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setThuongHieu(rs.getString("ThuongHieu"));
                sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
                sp.setKichThuocMan(rs.getDouble("KichThuocMan"));
                sp.setChipXuLy(rs.getString("ChipXuLy"));
                sp.setDungLuongPin(rs.getInt("DungLuongPin"));
                sp.setXuatXu(rs.getString("XuatXu"));
                sp.setGiaNhap(rs.getInt("GiaNhap"));
                sp.setGiaBan(rs.getInt("GiaBan"));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean SuaSanPham(SanPham sp) {
        Connection conn = cn.getConnection();
        String sql = "update SanPham set TenSP=?,SoLuong=?,ThuongHieu=?"
                + ",HeDieuHanh=?,KichThuocMan=?,ChipXuLy=?,DungLuongPin=?"
                + ",XuatXu=?,GiaNhap=?,GiaBan=? where MaSP=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setInt(2, sp.getSoLuong());
            ps.setString(3, sp.getThuongHieu());
            ps.setString(4, sp.getHeDieuHanh());
            ps.setDouble(5, sp.getKichThuocMan());
            ps.setString(6, sp.getChipXuLy());
            ps.setInt(7, sp.getDungLuongPin());
            ps.setString(8, sp.getXuatXu());
            ps.setInt(9, sp.getGiaNhap());
            ps.setInt(10, sp.getGiaBan());
            ps.setInt(11, sp.getMaSP());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean XoaSanPhamByID(int id) {
        Connection conn = cn.getConnection();
        String sql = "update SanPham set TrangThai=0 where MaSP=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<SanPham> getFindSP(String tukhoa) {
        Connection conn = cn.getConnection();
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select * from SanPham where concat(MaSP, TenSP, SoLuong, ThuongHieu"
                + ", HeDieuHanh, KichThuocMan, ChipXuLy, DungLuongPin, XuatXu"
                + ", GiaNhap, GiaBan) like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tukhoa + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setThuongHieu(rs.getString("ThuongHieu"));
                sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
                sp.setKichThuocMan(rs.getDouble("KichThuocMan"));
                sp.setChipXuLy(rs.getString("ChipXuLy"));
                sp.setDungLuongPin(rs.getInt("DungLuongPin"));
                sp.setXuatXu(rs.getString("XuatXu"));
                sp.setGiaNhap(rs.getInt("GiaNhap"));
                sp.setGiaBan(rs.getInt("GiaBan"));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void CongSoLuong(int masp, int sl) {
        Connection conn = cn.getConnection();
        String sql = "update SanPham set SoLuong = SoLuong + ? where MaSP = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sl);
            ps.setInt(2, masp);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void TruSoLuong(int masp, int sl) {
        Connection conn = cn.getConnection();
        String sql = "update SanPham set SoLuong = SoLuong - ? where MaSP = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sl);
            ps.setInt(2, masp);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public SanPham getSPbyID(int id){
        Connection conn = cn.getConnection();
        String sql = "select * from SanPham where MaSP = ?";
        SanPham sp = new SanPham();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setThuongHieu(rs.getString("ThuongHieu"));
                sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
                sp.setKichThuocMan(rs.getDouble("KichThuocMan"));
                sp.setChipXuLy(rs.getString("ChipXuLy"));
                sp.setDungLuongPin(rs.getInt("DungLuongPin"));
                sp.setXuatXu(rs.getString("XuatXu"));
                sp.setGiaNhap(rs.getInt("GiaNhap"));
                sp.setGiaBan(rs.getInt("GiaBan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }
}
