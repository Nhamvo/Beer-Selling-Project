/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositoties;

import domainmodels.KhachHang;
import java.util.List;

/**
 *
 * @author khact
 */
public interface IQLKhachHangRepository {

    public List<KhachHang> getKhachHangRepo();

    public Integer addKhachHangRepo(KhachHang kh);

    public Integer updateKhachHangRepo(KhachHang kh, String sdt);

    public List<KhachHang> searchKhachHangRepo(String kh);

    public List<KhachHang> xapXepKhachHangRepo(String x);

    public Integer deleteKhachHang(KhachHang kh);

    void updateSoTienDaChi(String sdt, float soTienDaChi);
}
