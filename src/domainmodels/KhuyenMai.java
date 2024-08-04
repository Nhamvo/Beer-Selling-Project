/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author ADMIN
 */
public class KhuyenMai {
    private String maKM;
    private String tenKm;
    private String idPhuongThuc;
    private String idLoaiKhachHang;
    private int donHangToiThieu;
    private float giaTriKhuyenMai;
    private String moTa;
    private int trangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String tenKm, String idPhuongThuc, String idLoaiKhachHang, int donHangToiThieu, float giaTriKhuyenMai, String moTa, int trangThai) {
        this.maKM = maKM;
        this.tenKm = tenKm;
        this.idPhuongThuc = idPhuongThuc;
        this.idLoaiKhachHang = idLoaiKhachHang;
        this.donHangToiThieu = donHangToiThieu;
        this.giaTriKhuyenMai = giaTriKhuyenMai;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKm() {
        return tenKm;
    }

    public void setTenKm(String tenKm) {
        this.tenKm = tenKm;
    }

    public String getIdPhuongThuc() {
        return idPhuongThuc;
    }

    public void setIdPhuongThuc(String idPhuongThuc) {
        this.idPhuongThuc = idPhuongThuc;
    }

    public String getIdLoaiKhachHang() {
        return idLoaiKhachHang;
    }

    public void setIdLoaiKhachHang(String idLoaiKhachHang) {
        this.idLoaiKhachHang = idLoaiKhachHang;
    }

    public int getDonHangToiThieu() {
        return donHangToiThieu;
    }

    public void setDonHangToiThieu(int donHangToiThieu) {
        this.donHangToiThieu = donHangToiThieu;
    }

    public float getGiaTriKhuyenMai() {
        return giaTriKhuyenMai;
    }

    public void setGiaTriKhuyenMai(float giaTriKhuyenMai) {
        this.giaTriKhuyenMai = giaTriKhuyenMai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
    
    
    
    
}
