/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Nham
 */
public class HoaDonViewModel {

    private String sdt;
    private String manv;
    private float tienHang;
    private float tongThanhToan;
    private int trangThai;
    private float giamGia;
    private float tienTraLai;
    private String thoiGian;
    private String ghiChu;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String sdt, String manv, float tienHang, float tongThanhToan, int trangThai, float giamGia, float tienTraLai, String thoiGian, String ghiChu) {
        this.sdt = sdt;
        this.manv = manv;
        this.tienHang = tienHang;
        this.tongThanhToan = tongThanhToan;
        this.trangThai = trangThai;
        this.giamGia = giamGia;
        this.tienTraLai = tienTraLai;
        this.thoiGian = thoiGian;
        this.ghiChu = ghiChu;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public float getTienHang() {
        return tienHang;
    }

    public void setTienHang(float tienHang) {
        this.tienHang = tienHang;
    }

    public float getTongThanhToan() {
        return tongThanhToan;
    }

    public void setTongThanhToan(float tongThanhToan) {
        this.tongThanhToan = tongThanhToan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
    }

    public float getTienTraLai() {
        return tienTraLai;
    }

    public void setTienTraLai(float tienTraLai) {
        this.tienTraLai = tienTraLai;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Object[] dataRow() {
        return new Object[]{sdt, manv, tienHang, tongThanhToan, trangThai, giamGia, tienTraLai, thoiGian, ghiChu};
    }

}
