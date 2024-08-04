/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodels.LoaiKhachHangViewModel;

/**
 *
 * @author khact
 */
public interface IQLLoaiKhachHangService {

    public List<LoaiKhachHangViewModel> getLoaiKhachHangService();

    public Integer addLoaiKhachHang(LoaiKhachHangViewModel kh);

    public Integer updateLoaiKhachHang(LoaiKhachHangViewModel kh);

}
