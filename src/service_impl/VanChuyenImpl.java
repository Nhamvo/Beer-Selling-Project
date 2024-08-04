/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import java.util.ArrayList;
import java.util.List;
import repositoties.VanChuyenRepository;
import service.VanChuyenService;
import viewmodels.HoaDonChoViewModel;
import viewmodels.LsHoaDonChiTietViewModel;
import viewmodels.VanChuyenViewModel;

/**
 *
 * @author Nham
 */
public class VanChuyenImpl implements VanChuyenService {

    private VanChuyenRepository rs = new VanChuyenRepository();

    @Override
    public String add(VanChuyenViewModel vc) {
        if (rs.add(vc) > 0) {
            return "Đơn Hàng Đang Được Vận Chuyển";

        }
        return "Sai";
    }

    @Override
    public List<HoaDonChoViewModel> listHoaDonCho() {
        return rs.getListLsChiTietHoaDon();
    }

    @Override
    public String updateTrangThaiVanChuyen(int tt, String maVc, String Tb) {
        if (rs.updateTrangThaiVanChuyen(tt, maVc) > 0) {
            return "Đơn Hàng " + Tb;

        }
        return "Sai";
    }

    @Override
    public void updateTrangThaiHoaDon(int tt, String maVc) {
        rs.updateTrangThaiHoaDon(tt, maVc);
    }

    List<LsHoaDonChiTietViewModel> changeSoLuongSanPham(List<LsHoaDonChiTietViewModel> listsGh) {
        for (LsHoaDonChiTietViewModel o : listsGh) {
            int soThungMua = o.getSoThungMua();
            int soLonMua = o.getSoLonMua();
            int soLonTrongKho = o.getSoLonKho();
            int soThungTrongKho = o.getSoThungKho();
            int soLonMoiThung = o.getSoLonMOiThung();
            int tongSoLon = soLonMua + soLonTrongKho;
            int soThungMoiNhat = 0;
            int soLonMoiNhat = 0;
            if (tongSoLon < soLonMoiThung) {
                soThungMoiNhat = soThungTrongKho + soThungMua;
                soLonMoiNhat = tongSoLon;
            } else if (tongSoLon >= soLonMoiThung) {
                soThungMoiNhat = soThungTrongKho + soThungMua + 1;
                soLonMoiNhat = tongSoLon - soLonMoiThung;
            }
            o.setSoLonKho(soLonMoiNhat);
            o.setSoThungKho(soThungMoiNhat);

        }
        return listsGh;

    }

    @Override
    public void updateSlSanPham(List<LsHoaDonChiTietViewModel> listsGh) {
        listsGh = changeSoLuongSanPham(listsGh);
        rs.updateSlSanPham(listsGh);
    }

    @Override
    public List<String> getDsThongTinvanChuyen(String sdt) {
        return rs.getThongTinNguoiVc(sdt);
    }

}
