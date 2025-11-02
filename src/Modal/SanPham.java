/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author vinhn
 */
public class SanPham {
    private double KichThuocMan;
    private int MaSP, soLuong, GiaNhap, GiaBan, DungLuongPin;
    private String TenSP, ThuongHieu, HeDieuHanh, ChipXuLy, XuatXu;
    public SanPham(){
        
    }

    public SanPham(int soLuong, int GiaNhap, int GiaBan, String TenSP, String ThuongHieu, String HeDieuHanh, double KichThuocMan, String ChipXuLy, int DungLuongPin, String XuatXu) {
        this.soLuong = soLuong;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.TenSP = TenSP;
        this.ThuongHieu = ThuongHieu;
        this.HeDieuHanh = HeDieuHanh;
        this.KichThuocMan = KichThuocMan;
        this.ChipXuLy = ChipXuLy;
        this.DungLuongPin = DungLuongPin;
        this.XuatXu = XuatXu;
    }

    public SanPham(int MaSP, int soLuong, int GiaNhap, int GiaBan, String TenSP, String ThuongHieu, String HeDieuHanh, double KichThuocMan, String ChipXuLy, int DungLuongPin, String XuatXu) {
        this.MaSP = MaSP;
        this.soLuong = soLuong;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.TenSP = TenSP;
        this.ThuongHieu = ThuongHieu;
        this.HeDieuHanh = HeDieuHanh;
        this.KichThuocMan = KichThuocMan;
        this.ChipXuLy = ChipXuLy;
        this.DungLuongPin = DungLuongPin;
        this.XuatXu = XuatXu;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(int GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public int getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(int GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getThuongHieu() {
        return ThuongHieu;
    }

    public void setThuongHieu(String ThuongHieu) {
        this.ThuongHieu = ThuongHieu;
    }

    public String getHeDieuHanh() {
        return HeDieuHanh;
    }

    public void setHeDieuHanh(String HeDieuHanh) {
        this.HeDieuHanh = HeDieuHanh;
    }

    public double getKichThuocMan() {
        return KichThuocMan;
    }

    public void setKichThuocMan(double KichThuocMan) {
        this.KichThuocMan = KichThuocMan;
    }

    public String getChipXuLy() {
        return ChipXuLy;
    }

    public void setChipXuLy(String ChipXuLy) {
        this.ChipXuLy = ChipXuLy;
    }

    public int getDungLuongPin() {
        return DungLuongPin;
    }

    public void setDungLuongPin(int DungLuongPin) {
        this.DungLuongPin = DungLuongPin;
    }

    public String getXuatXu() {
        return XuatXu;
    }

    public void setXuatXu(String XuatXu) {
        this.XuatXu = XuatXu;
    }
    
}
