/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;
import java.sql.*;
/**
 *
 * @author vinhn
 */
public class PhieuNhapKho {
    private int MaPN, MaNCC, MaNVNhap;
    private Timestamp ThoiGian;
    private long TongTien;

    public PhieuNhapKho() {
    }

    public PhieuNhapKho(int MaNCC, int MaNVNhap, long TongTien, Timestamp ThoiGian) {
        this.MaNCC = MaNCC;
        this.MaNVNhap = MaNVNhap;
        this.TongTien = TongTien;
        this.ThoiGian = ThoiGian;
    }

    public PhieuNhapKho(int MaPN, int MaNCC, int MaNVNhap, long TongTien, Timestamp ThoiGian) {
        this.MaPN = MaPN;
        this.MaNCC = MaNCC;
        this.MaNVNhap = MaNVNhap;
        this.TongTien = TongTien;
        this.ThoiGian = ThoiGian;
    }

    public int getMaPN() {
        return MaPN;
    }

    public void setMaPN(int MaPN) {
        this.MaPN = MaPN;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
    }

    public int getMaNVNhap() {
        return MaNVNhap;
    }

    public void setMaNVNhap(int MaNVNhap) {
        this.MaNVNhap = MaNVNhap;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }

    public Timestamp getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Timestamp ThoiGian) {
        this.ThoiGian = ThoiGian;
    }
    
}
