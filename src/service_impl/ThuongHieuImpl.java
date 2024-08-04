/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import domainmodels.ThuongHieu;
import domainmodels.XuatXu;
import java.util.ArrayList;
import java.util.List;
import repositoties.ThuongHieuRepository;
import repositoties.XuatXuRepository;
import service.ThuongHieuService;
import viewmodels.ThuongHieuViewModel;
import viewmodels.XuatXuViewModel;

/**
 *
 * @author Nham
 */
public class ThuongHieuImpl implements ThuongHieuService {

    private ThuongHieuRepository rs = new ThuongHieuRepository();

    @Override
    public List<ThuongHieuViewModel> getList() {
        List<ThuongHieu> listTemp = rs.getListXuatXu();
        List<ThuongHieuViewModel> list = new ArrayList<>();
        for (ThuongHieu o : listTemp) {
            list.add(new ThuongHieuViewModel(o.getId(), o.getTen()));
        }
        return list;

    }

    @Override
    public String Add(ThuongHieuViewModel n) {
        ThuongHieu s = new ThuongHieu();
        s.setId(n.getId());
        s.setTen(n.getTen());
        if (rs.add(s) > 0) {
            return "Thêm Thành Công ";

        } else {
            return "Thêm Thất Bại";
        }
    }

}
