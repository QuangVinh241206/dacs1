/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import java.sql.Timestamp;

/**
 *
 * @author vinhn
 */
public class PhieuXuatKho {
    private int MaPX, MaKH, MaNV;
    private long TongTien;
    private Timestamp ThoiGian;

    public PhieuXuatKho() {
    }

    public PhieuXuatKho(int MaPX, int MaKH, int MaNV, long TongTien, Timestamp ThoiGian) {
        this.MaPX = MaPX;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.TongTien = TongTien;
        this.ThoiGian = ThoiGian;
    }

    public int getMaPX() {
        return MaPX;
    }

    public void setMaPX(int MaPX) {
        this.MaPX = MaPX;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
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
