/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import domainmodels.NhanVien;
import java.util.ArrayList;
import repositoties.NhanVienRepository;
import service.NhanVienService;
import viewmodels.NhanVienViewModel;

/**
 *
 * @author os
 */
public class NhanVienImpl implements NhanVienService {

    private ArrayList<NhanVien> list = new ArrayList<>();
    private NhanVienRepository rs = new NhanVienRepository();

    @Override
    public void update(NhanVien n) {
        rs.update(n);
    }

    @Override
    public ArrayList<NhanVienViewModel> getList() {
        return rs.getAll();
    }

    @Override
    public ArrayList<NhanVienViewModel> searchByNhanVien(String txtManv) {
        return rs.searchByNhanViens(txtManv);
    }

    @Override
    public ArrayList<NhanVienViewModel> searchByNhanVien(int tt) {
        return rs.searchByTrangThai(tt);
    }

}
