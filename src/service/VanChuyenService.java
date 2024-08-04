/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodels.HoaDonChoViewModel;
import viewmodels.LsHoaDonChiTietViewModel;
import viewmodels.VanChuyenViewModel;

/**
 *
 * @author Nham
 */
public interface VanChuyenService {

    String add(VanChuyenViewModel vc);

    List<HoaDonChoViewModel> listHoaDonCho();

    String updateTrangThaiVanChuyen(int tt, String maVc, String tb);

    void updateTrangThaiHoaDon(int tt, String maVc);

    void updateSlSanPham(List<LsHoaDonChiTietViewModel> listsGh);

    List<String> getDsThongTinvanChuyen(String sdt);

}
