/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author Nham
 */
public class XuatXuViewModel {

    private String id;
    private String tenQuocGia;

    public XuatXuViewModel(String id, String tenQuocGia) {
        this.id = id;
        this.tenQuocGia = tenQuocGia;
    }

    public XuatXuViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenQuocGia() {
        return tenQuocGia;
    }

    public void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }

    public Object[] dataRow() {
        return new Object[]{id, tenQuocGia};
    }

}
