/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Nham
 */
public class SanPhamViewModel {

    private int masp;
    private String tenSp;
    private String XuatXu;
    private String ThuongHieu;
    private String TheTich;
    private String NongDoCon;
    private String ngaySanXuat;
    private String ngayHetHan;
    private String maVach;
    private int soLonMoiThung;
    private float giaBanTheoThung;
    private float giaBanTheoLon;
    private int soLuongThung;
    private int soLuongLon;
    private String hinhAnh;
    private int trangThai;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(int masp, String tenSp, String XuatXu, String ThuongHieu, String TheTich, String NongDoCon, String ngaySanXuat, String ngayHetHan, String maVach, int soLonMoiThung, float giaBanTheoThung, float giaBanTheoLon, int soLuongThung, int soLuongLon, String hinhAnh, int trangThai) {
        this.masp = masp;
        this.tenSp = tenSp;
        this.XuatXu = XuatXu;
        this.ThuongHieu = ThuongHieu;
        this.TheTich = TheTich;
        this.NongDoCon = NongDoCon;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.maVach = maVach;
        this.soLonMoiThung = soLonMoiThung;
        this.giaBanTheoThung = giaBanTheoThung;
        this.giaBanTheoLon = giaBanTheoLon;
        this.soLuongThung = soLuongThung;
        this.soLuongLon = soLuongLon;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getXuatXu() {
        return XuatXu;
    }

    public void setXuatXu(String XuatXu) {
        this.XuatXu = XuatXu;
    }

    public String getThuongHieu() {
        return ThuongHieu;
    }

    public void setThuongHieu(String ThuongHieu) {
        this.ThuongHieu = ThuongHieu;
    }

    public String getTheTich() {
        return TheTich;
    }

    public void setTheTich(String TheTich) {
        this.TheTich = TheTich;
    }

    public String getNongDoCon() {
        return NongDoCon;
    }

    public void setNongDoCon(String NongDoCon) {
        this.NongDoCon = NongDoCon;
    }

    public String getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

    public int getSoLonMoiThung() {
        return soLonMoiThung;
    }

    public void setSoLonMoiThung(int soLonMoiThung) {
        this.soLonMoiThung = soLonMoiThung;
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

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Object[] dataRow() {
        return new Object[]{"SP0" + masp, tenSp, XuatXu, ThuongHieu, TheTich, NongDoCon, ngaySanXuat, ngayHetHan, maVach, soLonMoiThung, giaBanTheoThung,
            giaBanTheoLon, soLuongThung, soLuongLon, trangThai == 1 ? "Đang Bán" : "Ngừng Bán", hinhAnh};
    }
}
