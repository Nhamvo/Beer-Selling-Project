/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodels.KhachHangViewModel;

/**
 *
 * @author khact
 */
public interface IKhachHangService {

    public List<KhachHangViewModel> getKhachHangService();

    public Integer addKhachHangService(KhachHangViewModel kh);

    public Integer updateKhachHangService(KhachHangViewModel kh, String sdt);

    public List<KhachHangViewModel> searchKhachHangService(String kh);

    public List<KhachHangViewModel> sapXepKhachHangService(String x);

    public Integer deleteKhachHang(KhachHangViewModel kh);

}
