/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import java.util.List;
import repositoties.LichSuHoaDonRepository;
import service.LichSuHoaDonService;
import viewmodels.LichSuHoaDonViewModel;

/**
 *
 * @author Nham
 */
public class LichSuHoaDonImpl implements LichSuHoaDonService {

    LichSuHoaDonRepository rs = new LichSuHoaDonRepository();

    @Override
    public List<LichSuHoaDonViewModel> lists() {
        return rs.getListLsHoaDon();
    }

}
