/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import domainmodels.LoaiKhachHang;
import java.util.ArrayList;
import java.util.List;
import repositoties.QLLoaiKhachHangRepositoty;
import service.IQLLoaiKhachHangService;
import viewmodels.LoaiKhachHangViewModel;

/**
 *
 * @author khact
 */
public class QLLoaiKhachHangService implements IQLLoaiKhachHangService {

    private final QLLoaiKhachHangRepositoty qLLoaiKhachHangRepositoty;

    public QLLoaiKhachHangService() {
        qLLoaiKhachHangRepositoty = new QLLoaiKhachHangRepositoty();
    }

    @Override
    public List<LoaiKhachHangViewModel> getLoaiKhachHangService() {
        List<LoaiKhachHang> list = qLLoaiKhachHangRepositoty.getLoaiKhachHangRepos();
        List<LoaiKhachHangViewModel> list1 = new ArrayList<>();
        for (LoaiKhachHang a : list) {
            LoaiKhachHangViewModel lkh = new LoaiKhachHangViewModel();
            lkh.setId(a.getId());
            lkh.setMa(a.getMa());
            lkh.setLoai(a.getLoai());
            list1.add(lkh);
        }
        return list1;
    }

    @Override
    public Integer addLoaiKhachHang(LoaiKhachHangViewModel kh) {
        LoaiKhachHang hang = new LoaiKhachHang(kh.getId(), kh.getMa(), kh.getLoai());
        return qLLoaiKhachHangRepositoty.addLoaiKhachHangRepons(hang);
    }

    @Override
    public Integer updateLoaiKhachHang(LoaiKhachHangViewModel kh) {
        LoaiKhachHang hang = new LoaiKhachHang(kh.getId(), kh.getMa(), kh.getLoai());
        return qLLoaiKhachHangRepositoty.updateKhachHangRepons(hang);
    }

}
