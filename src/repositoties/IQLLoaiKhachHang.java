/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositoties;

import domainmodels.LoaiKhachHang;
import java.util.List;

/**
 *
 * @author khact
 */
public interface IQLLoaiKhachHang {

    public List<LoaiKhachHang> getLoaiKhachHangRepos();

    public Integer addLoaiKhachHangRepons(LoaiKhachHang hang);

    public Integer updateKhachHangRepons(LoaiKhachHang hang);

}
