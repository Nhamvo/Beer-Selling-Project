/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Nham
 */
public class LsHoaDonChiTietViewModel {

    private String idHoaDon;
    private String masp;
    private String tenSp;
    private int soThungMua;
    private int soLonMua;
    private long thanhTien;
    private String hinhAnh;
    private int soThungKho;
    private int soLonKho;
    private int soLonMOiThung;

    public LsHoaDonChiTietViewModel() {
    }

    public LsHoaDonChiTietViewModel(String idHoaDon, String masp, String tenSp, int soThungMua, int soLonMua, long thanhTien, String hinhAnh, int soThungKho, int soLonKho, int soLonMOiThung) {
        this.idHoaDon = idHoaDon;
        this.masp = masp;
        this.tenSp = tenSp;
        this.soThungMua = soThungMua;
        this.soLonMua = soLonMua;
        this.thanhTien = thanhTien;
        this.hinhAnh = hinhAnh;
        this.soThungKho = soThungKho;
        this.soLonKho = soLonKho;
        this.soLonMOiThung = soLonMOiThung;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoThungMua() {
        return soThungMua;
    }

    public void setSoThungMua(int soThungMua) {
        this.soThungMua = soThungMua;
    }

    public int getSoLonMua() {
        return soLonMua;
    }

    public void setSoLonMua(int soLonMua) {
        this.soLonMua = soLonMua;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getSoThungKho() {
        return soThungKho;
    }

    public void setSoThungKho(int soThungKho) {
        this.soThungKho = soThungKho;
    }

    public int getSoLonKho() {
        return soLonKho;
    }

    public void setSoLonKho(int soLonKho) {
        this.soLonKho = soLonKho;
    }

    public int getSoLonMOiThung() {
        return soLonMOiThung;
    }

    public void setSoLonMOiThung(int soLonMOiThung) {
        this.soLonMOiThung = soLonMOiThung;
    }

    public Object[] dataRow() {
        return new Object[]{"HD" + idHoaDon, "SP" + masp, tenSp, soThungMua + " Thùng", soLonMua + " Lon", thanhTien + " VND", hinhAnh, soThungKho, soLonKho};
    }

}
