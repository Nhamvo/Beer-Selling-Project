/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import java.util.List;
import repositoties.ThongKeRepository;
import service.ThongKeServie;
import viewmodels.ThongKeViewModel;

/**
 *
 * @author Nham
 */
public class ThongKeImpl implements ThongKeServie {

    ThongKeRepository rs = new ThongKeRepository();

    @Override
    public List<ThongKeViewModel> getListThongKe(String sql) {
        return rs.getListThongKe(sql);
    }

    @Override
    public String kq(String sql) {
        return rs.getKqDoanhThu(sql);
    }

}
