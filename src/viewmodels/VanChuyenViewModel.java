/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Nham
 */
public class VanChuyenViewModel {

    private String thoiGianGiao;
    private String tenNguoiNhan;
    private String sdt;
    private String diaChiGiao;
    private long phiShip;
    private String ghiChu;

    public VanChuyenViewModel() {
    }

    public VanChuyenViewModel(String thoiGianGiao, String tenNguoiNhan, String sdt, String diaChiGiao, long phiShip, String ghiChu) {

        this.thoiGianGiao = thoiGianGiao;
        this.tenNguoiNhan = tenNguoiNhan;
        this.sdt = sdt;
        this.diaChiGiao = diaChiGiao;
        this.phiShip = phiShip;
        this.ghiChu = ghiChu;
    }

    public String getThoiGianGiao() {
        return thoiGianGiao;
    }

    public void setThoiGianGiao(String thoiGianGiao) {
        this.thoiGianGiao = thoiGianGiao;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChiGiao() {
        return diaChiGiao;
    }

    public void setDiaChiGiao(String diaChiGiao) {
        this.diaChiGiao = diaChiGiao;
    }

    public long getPhiShip() {
        return phiShip;
    }

    public void setPhiShip(long phiShip) {
        this.phiShip = phiShip;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
