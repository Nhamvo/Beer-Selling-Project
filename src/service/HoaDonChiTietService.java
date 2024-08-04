/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import javax.swing.JTable;
import viewmodels.GioHangViewModel;

/**
 *
 * @author Nham
 */
public interface HoaDonChiTietService {

    void insertHoaDonChiTiet(List<GioHangViewModel> lists);

    void updateSlSanPham(List<GioHangViewModel> lists);
}
