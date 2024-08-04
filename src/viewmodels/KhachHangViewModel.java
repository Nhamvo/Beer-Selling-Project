/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

import java.util.stream.Stream;

/**
 *
 * @author khact
 */
public class KhachHangViewModel {

    private String idKH;
    private LoaiKhachHangViewModel idLoaiKhachHang;
    private String tenKH;
    private byte gioiTinh;
    private String soDienThoaiKH;
    private String diaChiKH;
    private long soTienDaChi;

    public KhachHangViewModel() {
    }

    public KhachHangViewModel(String idKH, LoaiKhachHangViewModel idLoaiKhachHang, String tenKH, byte gioiTinh, String soDienThoaiKH, String diaChiKH, long soTienDaChi) {
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

    public LoaiKhachHangViewModel getIdLoaiKhachHang() {
        return idLoaiKhachHang;
    }

    public void setIdLoaiKhachHang(LoaiKhachHangViewModel idLoaiKhachHang) {
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

    public Stream<KhachHangViewModel> equals() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
