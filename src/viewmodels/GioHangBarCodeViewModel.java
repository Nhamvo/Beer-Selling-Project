/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Nham
 */
public class GioHangBarCodeViewModel {

    private String tenSp;
    private String maSp;

    private float giaBanTheoThung;
    private float giaBanTheoLon;
    private int soLonMoiThung;
    private int soLuongThung;
    private int soLuongLon;

    public GioHangBarCodeViewModel() {

    }

    public GioHangBarCodeViewModel(String tenSp, String maSp, float giaBanTheoThung, float giaBanTheoLon, int soLonMoiThung, int soLuongThung, int soLuongLon) {
        this.tenSp = tenSp;
        this.maSp = maSp;
        this.giaBanTheoThung = giaBanTheoThung;
        this.giaBanTheoLon = giaBanTheoLon;
        this.soLonMoiThung = soLonMoiThung;
        this.soLuongThung = soLuongThung;
        this.soLuongLon = soLuongLon;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public float getGiaBanTheoThung() {
        return giaBanTheoThung;
    }

    public void setGiaBanTheoThung(float giaBanTheoThung) {
        this.giaBanTheoThung = giaBanTheoThung;
    }

    public float getGiaBanTheoLon() {
        return giaBanTheoLon;
    }

    public void setGiaBanTheoLon(float giaBanTheoLon) {
        this.giaBanTheoLon = giaBanTheoLon;
    }

    public int getSoLonMoiThung() {
        return soLonMoiThung;
    }

    public void setSoLonMoiThung(int soLonMoiThung) {
        this.soLonMoiThung = soLonMoiThung;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public int getSoLuongThung() {
        return soLuongThung;
    }

    public void setSoLuongThung(int soLuongThung) {
        this.soLuongThung = soLuongThung;
    }

    public int getSoLuongLon() {
        return soLuongLon;
    }

    public void setSoLuongLon(int soLuongLon) {
        this.soLuongLon = soLuongLon;
    }

    public Object[] dataRow() {
        return new Object[]{tenSp, giaBanTheoThung, giaBanTheoLon, soLonMoiThung, soLuongThung, soLuongLon};
    }
}
