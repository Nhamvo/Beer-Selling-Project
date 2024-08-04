/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import java.util.List;
import javax.swing.JTable;
import repositoties.HoaDonChiTietRepository;
import service.HoaDonChiTietService;
import viewmodels.GioHangViewModel;
import viewmodels.HoaDonViewModel;

/**
 *
 * @author Nham
 */
public class HoaDonChiTietimpl implements HoaDonChiTietService {

    private HoaDonChiTietRepository rs = new HoaDonChiTietRepository();

    @Override
    public void updateSlSanPham(List<GioHangViewModel> lists) {
        rs.updateSlSanPham(lists);
    }

    @Override
    public void insertHoaDonChiTiet(List<GioHangViewModel> lists) {
        rs.add1(lists);
    }

}
