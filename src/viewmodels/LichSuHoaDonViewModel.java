/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Nham
 */
public class LichSuHoaDonViewModel {

    private String idHoaDon;
    private String manv;
    private String thoiGian;
    private String hoTen;
    private long tienHang;
    private long giamGia;
    private long tongThanhToan;
    private long tienTraLai;
    private int trangThai;

    public LichSuHoaDonViewModel(String idHoaDon, String manv, String thoiGian, String hoTen, long tienHang, long giamGia, long tongThanhToan, long tienTraLai, int trangThai) {
        this.idHoaDon = idHoaDon;
        this.manv = manv;
        this.thoiGian = thoiGian;
        this.hoTen = hoTen;
        this.tienHang = tienHang;
        this.giamGia = giamGia;
        this.tongThanhToan = tongThanhToan;
        this.tienTraLai = tienTraLai;
        this.trangThai = trangThai;
    }

    public LichSuHoaDonViewModel() {
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public long getTienHang() {
        return tienHang;
    }

    public void setTienHang(long tienHang) {
        this.tienHang = tienHang;
    }

    public long getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(long giamGia) {
        this.giamGia = giamGia;
    }

    public long getTongThanhToan() {
        return tongThanhToan;
    }

    public void setTongThanhToan(long tongThanhToan) {
        this.tongThanhToan = tongThanhToan;
    }

    public long getTienTraLai() {
        return tienTraLai;
    }

    public void setTienTraLai(long tienTraLai) {
        this.tienTraLai = tienTraLai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String checkTrangThai() {
        if (trangThai == 1) {
            return "Đã Thanh Toán";
        } else if (trangThai == 0) {
            return "Đã Hủy";
        } else {
            return "Chưa Thanh Toán";
        }
    }

    public Object[] dataRow() {
        return new Object[]{"HD" + idHoaDon, manv, thoiGian, hoTen == null ? "Khách Hàng Mua Lẻ" : hoTen, tienHang + " VND", giamGia + " VND", tongThanhToan + " VND", tienTraLai + " VND", checkTrangThai()};
    }
}
