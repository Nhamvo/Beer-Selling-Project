/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodels.NhanVien;
import java.util.ArrayList;
import java.util.List;
import viewmodels.NhanVienViewModel;

/**
 *
 * @author os
 */
public interface NhanVienService {

    public ArrayList<NhanVienViewModel> getList();

    public ArrayList<NhanVienViewModel> searchByNhanVien(String txtManv);

    public ArrayList<NhanVienViewModel> searchByNhanVien(int tt);

    public void update(NhanVien n);

}
