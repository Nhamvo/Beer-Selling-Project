/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author ADMIN
 */
public class BoSungTTNhanVienViewModel {

    private String manv;
    private String tennv;
    private String diachi;

    private int gioitinh;
    private String ngaysinh;
    private String sdt;

    public BoSungTTNhanVienViewModel() {

    }

    public BoSungTTNhanVienViewModel(String manv, String tennv, String diachi, int gioitinh, String ngaysinh, String sdt) {
        this.manv = manv;
        this.tennv = tennv;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Object[] dataRow() {

        return new Object[]{manv, tennv, diachi, sdt, gioitinh == 1 ? "Nam" : "Nu", ngaysinh};
    }

}
