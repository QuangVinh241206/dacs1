/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author vinhn
 */
public class TaiKhoan {
   private int MaNV, Quyen, TrangThai;
   private String TenDangNhap, MatKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(int MaNV, int Quyen, int TrangThai, String TenDangNhap, String MatKhau) {
        this.MaNV = MaNV;
        this.Quyen = Quyen;
        this.TrangThai = TrangThai;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public int getQuyen() {
        return Quyen;
    }

    public void setQuyen(int Quyen) {
        this.Quyen = Quyen;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }
   
}
