/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author vinhn
 */
public class CTPhieuNhap {
    private int MaPN, MaSP, SoLuong;
    private long Gia;

    public CTPhieuNhap() {
    }

    public CTPhieuNhap(int MaPN, int MaSP, int SoLuong, long Gia) {
        this.MaPN = MaPN;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
    }

    public int getMaPN() {
        return MaPN;
    }

    public void setMaPN(int MaPN) {
        this.MaPN = MaPN;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public long getGia() {
        return Gia;
    }

    public void setGia(long Gia) {
        this.Gia = Gia;
    }
    
}
