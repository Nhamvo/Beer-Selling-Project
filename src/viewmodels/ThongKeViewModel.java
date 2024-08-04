/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Nham
 */
public class ThongKeViewModel {

    private String maSp;
    private String tenSp;
    private String soThungDaban;
    private String soLonDaBan;
    private long doanhThu;
    private String hinhAnh;

    public ThongKeViewModel() {
    }

    public ThongKeViewModel(String maSp, String tenSp, String soThungDaban, String soLonDaBan, long doanhThu, String hinhAnh) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soThungDaban = soThungDaban;
        this.soLonDaBan = soLonDaBan;
        this.doanhThu = doanhThu;
        this.hinhAnh = hinhAnh;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getSoThungDaban() {
        return soThungDaban;
    }

    public void setSoThungDaban(String soThungDaban) {
        this.soThungDaban = soThungDaban;
    }

    public String getSoLonDaBan() {
        return soLonDaBan;
    }

    public void setSoLonDaBan(String soLonDaBan) {
        this.soLonDaBan = soLonDaBan;
    }

    public long getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(long doanhThu) {
        this.doanhThu = doanhThu;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Object[] dataRow() {
        return new Object[]{maSp, tenSp, soThungDaban + " Thùng", soLonDaBan + " Lon", doanhThu + " VND", hinhAnh};
    }

}
