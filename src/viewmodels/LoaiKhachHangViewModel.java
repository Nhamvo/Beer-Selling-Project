/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author khact
 */
public class LoaiKhachHangViewModel {

    private String id;
    private String ma;
    private int loai;

    public LoaiKhachHangViewModel() {
    }

    public LoaiKhachHangViewModel(String id, String ma, int loai) {
        this.id = id;
        this.ma = ma;
        this.loai = loai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    @Override
    public String toString() {
        return loai + "";
    }

}
