/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import java.util.List;
import repositoties.LsHoaDonChiTietRepository;
import service.LsHoaDonChiTietService;
import viewmodels.LsHoaDonChiTietViewModel;

/**
 *
 * @author Nham
 */
public class LsHoaDonChiTietImpl implements LsHoaDonChiTietService {

    private LsHoaDonChiTietRepository rs = new LsHoaDonChiTietRepository();

    @Override
    public List<LsHoaDonChiTietViewModel> lists(String idHoaDon) {
        return rs.getListLsChiTietHoaDon(idHoaDon);

    }

}
