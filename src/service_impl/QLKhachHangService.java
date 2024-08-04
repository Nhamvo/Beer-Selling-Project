/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import domainmodels.KhachHang;
import domainmodels.LoaiKhachHang;
import java.util.ArrayList;
import java.util.List;
import repositoties.QLKhachHangRepositoty;
import service.IKhachHangService;
import viewmodels.KhachHangViewModel;
import viewmodels.LoaiKhachHangViewModel;

/**
 *
 * @author khact
 */
public class QLKhachHangService implements IKhachHangService {

    private final QLKhachHangRepositoty qLKhachHangRepositoty;

    public QLKhachHangService() {
        qLKhachHangRepositoty = new QLKhachHangRepositoty();
    }

    @Override
    public List<KhachHangViewModel> getKhachHangService() {
        List<KhachHang> hangs = qLKhachHangRepositoty.getKhachHangRepo();
        List<KhachHangViewModel> list = new ArrayList<>();
        for (KhachHang a : hangs) {
            LoaiKhachHangViewModel hang = new LoaiKhachHangViewModel(a.getIdLoaiKhachHang().getId(), a.getIdLoaiKhachHang().getMa(), a.getIdLoaiKhachHang().getLoai());
            KhachHangViewModel kh = new KhachHangViewModel(a.getIdKH(), hang, a.getTenKH(), a.getGioiTinh(), a.getSoDienThoaiKH(), a.getDiaChiKH(), a.getSoTienDaChi());
            list.add(kh);
        }
        return list;
    }

    @Override
    public Integer addKhachHangService(KhachHangViewModel kh) {
        KhachHang hang = new KhachHang();
        LoaiKhachHang lkh = new LoaiKhachHang();
        lkh.setId(kh.getIdLoaiKhachHang().getId());
        hang.setIdLoaiKhachHang(lkh);
        hang.setTenKH(kh.getTenKH());
        hang.setGioiTinh(kh.getGioiTinh());
        hang.setSoDienThoaiKH(kh.getSoDienThoaiKH());
        hang.setDiaChiKH(kh.getDiaChiKH());
        hang.setSoTienDaChi(kh.getSoTienDaChi());

        return qLKhachHangRepositoty.addKhachHangRepo(hang);
    }

    @Override
    public Integer updateKhachHangService(KhachHangViewModel kh, String sdt) {
        KhachHang hang = new KhachHang();
        LoaiKhachHang lkh = new LoaiKhachHang();
        lkh.setId(kh.getIdLoaiKhachHang().getId());
        hang.setIdLoaiKhachHang(lkh);
        hang.setTenKH(kh.getTenKH());
        hang.setGioiTinh(kh.getGioiTinh());
        hang.setSoDienThoaiKH(kh.getSoDienThoaiKH());
        hang.setDiaChiKH(kh.getDiaChiKH());
        hang.setSoTienDaChi(kh.getSoTienDaChi());

        return qLKhachHangRepositoty.updateKhachHangRepo(hang, sdt);
    }

    @Override
    public List<KhachHangViewModel> searchKhachHangService(String kh) {
        List<KhachHang> list = qLKhachHangRepositoty.searchKhachHangRepo(kh);
        List<KhachHangViewModel> list1 = new ArrayList<>();
        for (KhachHang a : list) {
            LoaiKhachHangViewModel lkhvm = new LoaiKhachHangViewModel(a.getIdLoaiKhachHang().getId(), a.getIdLoaiKhachHang().getMa(), a.getIdLoaiKhachHang().getLoai());
            KhachHangViewModel kh01 = new KhachHangViewModel(a.getIdKH(), lkhvm, a.getTenKH(), a.getGioiTinh(), a.getSoDienThoaiKH(), a.getDiaChiKH(), a.getSoTienDaChi());
            list1.add(kh01);
        }
        return list1;
    }

    @Override
    public List<KhachHangViewModel> sapXepKhachHangService(String x) {
        List<KhachHang> list = qLKhachHangRepositoty.xapXepKhachHangRepo(x);
        List<KhachHangViewModel> list1 = new ArrayList<>();
        for (KhachHang a : list) {
            LoaiKhachHangViewModel lkhvm = new LoaiKhachHangViewModel(a.getIdLoaiKhachHang().getId(), a.getIdLoaiKhachHang().getMa(), a.getIdLoaiKhachHang().getLoai());
            KhachHangViewModel kh01 = new KhachHangViewModel(a.getIdKH(), lkhvm, a.getTenKH(), a.getGioiTinh(), a.getSoDienThoaiKH(), a.getDiaChiKH(), a.getSoTienDaChi());
            list1.add(kh01);
        }
        return list1;
    }

    @Override
    public Integer deleteKhachHang(KhachHangViewModel kh) {
        KhachHang khvm = new KhachHang();
        khvm.setSoDienThoaiKH(kh.getSoDienThoaiKH());
        return qLKhachHangRepositoty.deleteKhachHang(khvm);
    }

}
