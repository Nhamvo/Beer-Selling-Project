/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author khact
 */
public class KhachHang {

    private String idKH;
    private LoaiKhachHang idLoaiKhachHang;
    private String tenKH;
    private byte gioiTinh;
    private String soDienThoaiKH;
    private String diaChiKH;
    private long soTienDaChi;

    public KhachHang() {
    }

    public KhachHang(String idKH, LoaiKhachHang idLoaiKhachHang, String tenKH, byte gioiTinh, String soDienThoaiKH, String diaChiKH, long soTienDaChi) {
        this.idKH = idKH;
        this.idLoaiKhachHang = idLoaiKhachHang;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.soDienThoaiKH = soDienThoaiKH;
        this.diaChiKH = diaChiKH;
        this.soTienDaChi = soTienDaChi;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public LoaiKhachHang getIdLoaiKhachHang() {
        return idLoaiKhachHang;
    }

    public void setIdLoaiKhachHang(LoaiKhachHang idLoaiKhachHang) {
        this.idLoaiKhachHang = idLoaiKhachHang;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public byte getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(byte gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoaiKH() {
        return soDienThoaiKH;
    }

    public void setSoDienThoaiKH(String soDienThoaiKH) {
        this.soDienThoaiKH = soDienThoaiKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public long getSoTienDaChi() {
        return soTienDaChi;
    }

    public void setSoTienDaChi(long soTienDaChi) {
        this.soTienDaChi = soTienDaChi;
    }
}
