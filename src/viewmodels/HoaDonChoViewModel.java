/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Nham
 */
public class HoaDonChoViewModel {

    private String maHoaDon;
    private String maVanChuyen;
    private String thoiGian;
    private long tongTien;
    private int trangThai;

    public HoaDonChoViewModel() {
    }

    public HoaDonChoViewModel(String maHoaDon, String maVanChuyen, String thoiGian, long tongTien, int trangThai) {
        this.maHoaDon = maHoaDon;
        this.maVanChuyen = maVanChuyen;
        this.thoiGian = thoiGian;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaVanChuyen() {
        return maVanChuyen;
    }

    public void setMaVanChuyen(String maVanChuyen) {
        this.maVanChuyen = maVanChuyen;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String trangThaiDh() {
        if (trangThai == 1) {
            return "Ðang Vận Chuyển ";
        } else if (trangThai == 2) {
            return "Đã Hủy";
        } else {
            return "Đã Giao";
        }
    }

    public Object[] dataRow() {
        return new Object[]{"HD" + maHoaDon, "VC" + maVanChuyen, thoiGian, tongTien, trangThaiDh()};
    }

}
