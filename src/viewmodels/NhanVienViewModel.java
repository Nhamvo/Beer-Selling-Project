/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

import domainmodels.*;

/**
 *
 * @author os
 */
public class NhanVienViewModel {

    private String maNV;
    private String tenNV;
    private String diaChi;
    private int gioiTinh;
    private String ngaySinh;
    private String sdt;
    private int trangThai;
    private String hinhAnh;
    private int quyen;

    public NhanVienViewModel() {
    }

    public NhanVienViewModel(String maNV, String tenNV, String diaChi, int gioiTinh, String ngaySinh, String sdt, int trangThai, String hinhAnh, int quyen) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.hinhAnh = hinhAnh;
        this.quyen = quyen;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getQuyen() {
        return quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }

    public Object[] dataRow() {
        return new Object[]{maNV, tenNV, diaChi, gioiTinh == 0 ? "Nam" : "Nữ", ngaySinh, sdt, trangThai == 1 ? "Đang Làm Việc" : "Đã Nghỉ Việc", quyen == 0 ? "Nhân Viên" : "Quản Lý", hinhAnh};
    }
}
