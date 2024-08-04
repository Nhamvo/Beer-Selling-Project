/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author ADMIN
 */
public class BoSungTTNhanVien {
    private String manv;
    private String tennv;
    private String diachi;
    private int gioitinh;
    private String ngaysinh;
    private String sdt;
    private int socccd;
    private int trangthai;
    private String hinhanh;

    public BoSungTTNhanVien() {
    }

    public BoSungTTNhanVien(String manv, String tennv, String diachi, int gioitinh, String ngaysinh, String sdt, int socccd, int trangthai, String hinhanh) {
        this.manv = manv;
        this.tennv = tennv;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.socccd = socccd;
        this.trangthai = trangthai;
        this.hinhanh = hinhanh;
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

    public int getSocccd() {
        return socccd;
    }

    public void setSocccd(int socccd) {
        this.socccd = socccd;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    
    
    
}
