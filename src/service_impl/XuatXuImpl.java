/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import domainmodels.XuatXu;
import java.util.ArrayList;
import java.util.List;
import repositoties.XuatXuRepository;
import service.XuatXuService;
import viewmodels.XuatXuViewModel;

/**
 *
 * @author Nham
 */
public class XuatXuImpl implements XuatXuService {

    private XuatXuRepository rs = new XuatXuRepository();

    @Override
    public List<XuatXuViewModel> getList() {
        List<XuatXu> listTemp = rs.getListXuatXu();
        List<XuatXuViewModel> list = new ArrayList<>();
        for (XuatXu o : listTemp) {
            list.add(new XuatXuViewModel(o.getId(), o.getTenQuocGia()));
        }
        return list;

    }

    @Override
    public String Add(XuatXuViewModel n) {
        XuatXu s = new XuatXu();
        s.setId(n.getId());
        s.setTenQuocGia(n.getTenQuocGia());
        if (rs.add(s) > 0) {
            return "Thêm Thành Công ";

        } else {
            return "Thêm Thất Bại";
        }
    }

}
