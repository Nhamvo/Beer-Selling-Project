/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import domainmodels.TheTich;
import java.util.ArrayList;
import java.util.List;
import repositoties.TheTichRepository;
import service.TheTichService;
import viewmodels.TheTichViewModel;

/**
 *
 * @author Nham
 */
public class TheTichImpl implements TheTichService {

    private TheTichRepository rs = new TheTichRepository();

    @Override
    public List<TheTichViewModel> getList() {
        List<TheTich> listTemp = rs.getListXuatXu();
        List<TheTichViewModel> list = new ArrayList<>();
        for (TheTich o : listTemp) {
            list.add(new TheTichViewModel(o.getId(), o.getTheTich()));
        }
        return list;

    }

    @Override
    public String Add(TheTichViewModel n) {
        TheTich s = new TheTich();
        s.setId(n.getId());
        s.setTheTich(n.getTheTich());
        if (rs.add(s) > 0) {
            return "Thêm Thành Công ";

        } else {
            return "Thêm Thất Bại";
        }
    }

}
