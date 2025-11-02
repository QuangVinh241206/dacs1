/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modal.CTPhieuNhap;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author vinhn
 */
public class CTPhieuNhapDAO {

    ConnectDB cn = new ConnectDB();

    public ArrayList<CTPhieuNhap> getListCTPhieuNhap(int id) {
        Connection conn = cn.getConnection();
        ArrayList list = new ArrayList();
        String sql = "select * from ChiTietPhieuNhap where MaPN=? and TrangThai=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CTPhieuNhap ctpn = new CTPhieuNhap();
                ctpn.setMaPN(rs.getInt("MaPN"));
                ctpn.setMaSP(rs.getInt("MaSP"));
                ctpn.setSoLuong(rs.getInt("SoLuong"));
                ctpn.setGia(rs.getInt("DonGia"));
                list.add(ctpn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void ThemCTPN(CTPhieuNhap ctpn){
        Connection conn = cn.getConnection();
        String sql = "insert into ChiTietPhieuNhap(MaPN, MaSP, SoLuong, DonGia) values(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ctpn.getMaPN());
            ps.setInt(2, ctpn.getMaSP());
            ps.setInt(3, ctpn.getSoLuong());
            ps.setLong(4, ctpn.getGia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void XoaCTPNByID(int id){
        Connection conn = cn.getConnection();
        String sql = "update ChiTietPhieuNhap set TrangThai=0 where MaPN=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
