/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Nham
 */
public class GiamGiaThanhToanViewModel {

    private String hoTen;
    private int loaiKhachHang;
    private float donHangToiThieu;
    private float giaTriKhuyenMai;
    private String maPhuongThucGiamGia;
    private int trangThai;

    public GiamGiaThanhToanViewModel() {
    }

    public GiamGiaThanhToanViewModel(String hoTen, int loaiKhachHang, float donHangToiThieu, float giaTriKhuyenMai, String maPhuongThucGiamGia, int trangThai) {
        this.hoTen = hoTen;
        this.loaiKhachHang = loaiKhachHang;
        this.donHangToiThieu = donHangToiThieu;
        this.giaTriKhuyenMai = giaTriKhuyenMai;
        this.maPhuongThucGiamGia = maPhuongThucGiamGia;
        this.trangThai = trangThai;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(int loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public float getDonHangToiThieu() {
        return donHangToiThieu;
    }

    public void setDonHangToiThieu(float donHangToiThieu) {
        this.donHangToiThieu = donHangToiThieu;
    }

    public float getGiaTriKhuyenMai() {
        return giaTriKhuyenMai;
    }

    public void setGiaTriKhuyenMai(float giaTriKhuyenMai) {
        this.giaTriKhuyenMai = giaTriKhuyenMai;
    }

    public String getMaPhuongThucGiamGia() {
        return maPhuongThucGiamGia;
    }

    public void setMaPhuongThucGiamGia(String maPhuongThucGiamGia) {
        this.maPhuongThucGiamGia = maPhuongThucGiamGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
