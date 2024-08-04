/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service_impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import repositoties.SanPhamRepository;
import service.SanPhamService;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author Nham
 */
public class SanPhamImpl implements SanPhamService {

    SanPhamRepository rs = new SanPhamRepository();

    @Override
    public List<SanPhamViewModel> getList() {
        return rs.getListSanPham();

    }

    @Override
    public String Add(SanPhamViewModel n) {
        if (rs.add(n) > 0) {
            return "Thêm Thông Tin Sản Phẩm Thành Công";

        } else {
            return "Thêm  Thông Tin Sản Phẩm Thất Bại";
        }
    }

    @Override
    public String update(SanPhamViewModel n) {
        if (rs.update(n) > 0) {
            return "Cập Nhật Thông Tin Sản Phẩm Thành Công";

        } else {
            return "Cập Nhật Thông Tin Sản Phẩm Thất Bại";
        }
    }

    @Override
    public void sapXep(List<SanPhamViewModel> list, int index) {
        if (index == 3) {
            Collections.sort(list, new Comparator<SanPhamViewModel>() {
                @Override
                public int compare(SanPhamViewModel o1, SanPhamViewModel o2) {
                    return Float.compare(o1.getGiaBanTheoLon(), o2.getGiaBanTheoLon());
                }
            });
        } else if (index == 2) {
            Collections.sort(list, new Comparator<SanPhamViewModel>() {
                @Override
                public int compare(SanPhamViewModel o1, SanPhamViewModel o2) {
                    return o1.getSoLuongThung() - o2.getSoLuongThung();
                }
            });
        }
    }

    @Override
    public List<SanPhamViewModel> timKiemSanPham(String txtTimKiem) {
        List<SanPhamViewModel> listSearch = rs.timKiemSanPham(txtTimKiem);

        return listSearch;
    }

    @Override
    public List<SanPhamViewModel> hienThiTrangThaiSp(int tt) {
        List<SanPhamViewModel> listSearch = rs.hienThiTrangThaiSp(tt);

        return listSearch;
    }

}
