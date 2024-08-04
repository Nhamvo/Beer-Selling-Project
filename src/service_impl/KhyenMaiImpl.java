/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import domainmodels.KhuyenMai;
import java.util.ArrayList;
import repositoties.KhuyenMaiRepository;
import service.KhuyenMaiService;
import viewmodels.KhuyenMaiViewModel;

/**
 *
 * @author ADMIN
 */
public class KhyenMaiImpl implements KhuyenMaiService {

    private KhuyenMaiRepository repo = new KhuyenMaiRepository();

    @Override
    public ArrayList<KhuyenMaiViewModel> getList() {
        return repo.getList();
    }

    @Override
    public String Add(KhuyenMaiViewModel km) {
        if (repo.Add(km)) {
            return "Thêm Khuyến Mại Thành Công";
        } else {
            return "Thêm Khuyến Mại Thất Bại";
        }
    }

    @Override
    public String Update(KhuyenMaiViewModel km, String makhuyenmai) {
        if (repo.Update(km, makhuyenmai)) {
            return "Sửa Khuyến Mại Thành Công";
        } else {
            return "Sửa Khuyến Mại Thất Bại";
        }
    }

    @Override
    public ArrayList<KhuyenMaiViewModel> timKiemQlKhuyenMai(String timKiem) {
        return repo.timKiemQlKhuyenMai(timKiem);
    }

    @Override
    public ArrayList<KhuyenMaiViewModel> trangThai(int TrangThai) {
return repo.trangThai(TrangThai);
    }

}
