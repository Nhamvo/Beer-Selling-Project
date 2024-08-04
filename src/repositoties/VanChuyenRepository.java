/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoties;

import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import viewmodels.HoaDonChoViewModel;
import viewmodels.LsHoaDonChiTietViewModel;
import viewmodels.VanChuyenViewModel;

/**
 *
 * @author Nham
 */
public class VanChuyenRepository {

    public int add(VanChuyenViewModel sp) {
        int check;
        String sql = "insert into vanchuyen (idhoadon,thoigiangiao,tennguoinhan,\n"
                + "sdt,diachigiao,phigiaohang,mota)values ((SELECT TOP 1 idhoadon FROM hoadon ORDER BY idhoadon DESC),?,?,?,?,?,? )";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, sp.getThoiGianGiao());
            ps.setObject(2, sp.getTenNguoiNhan());
            ps.setObject(3, sp.getSdt());
            ps.setObject(4, sp.getDiaChiGiao());
            ps.setObject(5, sp.getPhiShip());
            ps.setObject(6, sp.getGhiChu());
            check = ps.executeUpdate();
            return check;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<HoaDonChoViewModel> getListLsChiTietHoaDon() {
        List<HoaDonChoViewModel> listData = new ArrayList<>();
        String sql = "select hoadon.idhoadon, mavanchuyen,thoigiangiao,hoadon.tongthanhtoan,\n"
                + "vanchuyen.trangthai from vanchuyen\n"
                + "join hoadon on vanchuyen.idhoadon = hoadon.idhoadon";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listData.add(new HoaDonChoViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getInt(5)));
            }
            return listData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getThongTinNguoiVc(String sdt) {
        List<String> listTtVanChuyen = new ArrayList<>();
        String sql = "select top 1  tennguoinhan ,diachigiao, phigiaohang from vanchuyen\n"
                + "where sdt = ? order by idhoadon desc";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, sdt);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listTtVanChuyen.add(rs.getString(1));
                listTtVanChuyen.add(rs.getString(2));
                listTtVanChuyen.add(rs.getString(3));

            }
            return listTtVanChuyen;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateTrangThaiVanChuyen(int trangThai, String maVanChuyen) {
        String sql = "update vanchuyen set trangthai =? where maVanChuyen = ?";
        int check;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, trangThai);
            ps.setObject(2, maVanChuyen);
            check = ps.executeUpdate();
            return check;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateTrangThaiHoaDon(int trangThai, String idHoaDon) {
        String sql = "update hoadon set trangthai =? where idhoadon = ?";
        int check;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, trangThai);
            ps.setObject(2, idHoaDon);
            check = ps.executeUpdate();
            return check;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void updateSlSanPham(List<LsHoaDonChiTietViewModel> listsGh) {
        String sql = "update sanPham set soluonglon=? , soluongthung=? where masp= ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            for (int i = 0; i < listsGh.size(); i++) {
                ps.setInt(1, Integer.valueOf(listsGh.get(i).getSoLonKho()));
                ps.setInt(2, Integer.valueOf(listsGh.get(i).getSoThungKho()));
                ps.setString(3, listsGh.get(i).getMasp());
                ps.addBatch();
            }
            int[] rowsInserted = ps.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
