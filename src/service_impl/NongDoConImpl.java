/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import domainmodels.NongDonCon;
import java.util.ArrayList;
import java.util.List;
import repositoties.NongDonConRepository;
import service.NongDoConService;
import viewmodels.NongDoConViewModel;

/**
 *
 * @author Nham
 */
public class NongDoConImpl implements NongDoConService {

    private NongDonConRepository rs = new NongDonConRepository();

    @Override
    public List<NongDoConViewModel> getList() {
        List<NongDonCon> listTemp = rs.getListXuatXu();
        List<NongDoConViewModel> list = new ArrayList<>();
        for (NongDonCon o : listTemp) {
            list.add(new NongDoConViewModel(o.getId(), o.getNongDoCon()));
        }
        return list;

    }

    @Override
    public String Add(NongDoConViewModel n) {
        NongDonCon s = new NongDonCon();
        s.setId(n.getId());
        s.setNongDoCon(n.getNongDoCon());
        if (rs.add(s) > 0) {
            return "Thêm Thành Công ";

        } else {
            return "Thêm Thất Bại";
        }
    }

}
