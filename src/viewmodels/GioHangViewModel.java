/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Nham
 */
public class GioHangViewModel {

    private String ma;
    private String ten;
    private String soLuongThung;
    private String soLuongLon;
    private String thanhTien;
    private String soLonConLai;
    private String soThungConLai;

    public GioHangViewModel() {
    }

    public GioHangViewModel(String ma, String ten, String soLuongThung, String soLuongLon, String thanhTien, String soLonConLai, String soThungConLai) {
        this.ma = ma;
        this.ten = ten;
        this.soLuongThung = soLuongThung;
        this.soLuongLon = soLuongLon;
        this.thanhTien = thanhTien;
        this.soLonConLai = soLonConLai;
        this.soThungConLai = soThungConLai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoLuongThung() {
        return soLuongThung;
    }

    public void setSoLuongThung(String soLuongThung) {
        this.soLuongThung = soLuongThung;
    }

    public String getSoLuongLon() {
        return soLuongLon;
    }

    public void setSoLuongLon(String soLuongLon) {
        this.soLuongLon = soLuongLon;
    }

    public String getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getSoLonConLai() {
        return soLonConLai;
    }

    public void setSoLonConLai(String soLonConLai) {
        this.soLonConLai = soLonConLai;
    }

    public String getSoThungConLai() {
        return soThungConLai;
    }

    public void setSoThungConLai(String soThungConLai) {
        this.soThungConLai = soThungConLai;
    }

    public Object[] dataRow() {
        return new Object[]{ma, ten, soLuongThung, soLuongLon, thanhTien, soLonConLai, soThungConLai};
    }

}
