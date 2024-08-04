/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import domainmodels.BoSungTTNhanVien;
import javax.swing.JOptionPane;
import repositoties.BoSungTTNhanVienRepository;
import service.BoSungTTNhanVienService;
import viewmodels.BoSungTTNhanVienViewModel;

/**
 *
 * @author ADMIN
 */
public class BoSungTTNhanVienImpl implements BoSungTTNhanVienService {

    private BoSungTTNhanVienRepository repo = new BoSungTTNhanVienRepository();

    @Override
    public String add(BoSungTTNhanVienViewModel nv) {
        BoSungTTNhanVien nvv = new BoSungTTNhanVien();
       nvv.setManv(nv.getManv());
        nvv.setTennv(nv.getTennv());
        nvv.setDiachi(nv.getDiachi());
        nvv.setSdt(nv.getSdt());
        nvv.setGioitinh(nv.getGioitinh());
        nvv.setNgaysinh(nv.getNgaysinh());
        if (repo.them(nvv)) {
            return "Lưu Thông Tin Thành Công";
        } else {
            return "Lưu Thông Tin Thất Bại";
        }
    }

}
