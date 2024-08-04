/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author Nham
 */
public interface SanPhamService {

    public List<SanPhamViewModel> getList();

    public String Add(SanPhamViewModel n);

    public String update(SanPhamViewModel n);

    public void sapXep(List<SanPhamViewModel> n, int check);

    public List<SanPhamViewModel> timKiemSanPham(String maSp);

    public List<SanPhamViewModel> hienThiTrangThaiSp(int tt);
}
