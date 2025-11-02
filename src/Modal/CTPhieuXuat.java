/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author vinhn
 */
public class CTPhieuXuat {
    private int MaPX, MaSP, SoLuong;
    private long Gia;

    public CTPhieuXuat() {
    }

    public CTPhieuXuat(int MaPX, int MaSP, int SoLuong, long Gia) {
        this.MaPX = MaPX;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
    }

    public int getMaPX() {
        return MaPX;
    }

    public void setMaPX(int MaPX) {
        this.MaPX = MaPX;
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
