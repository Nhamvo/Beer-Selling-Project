/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoties;

import Utilities.DBConnection;
import domainmodels.KhuyenMai;
import java.util.ArrayList;
import java.sql.*;
import viewmodels.KhuyenMaiViewModel;

/**
 *
 * @author ADMIN
 */
public class KhuyenMaiRepository {

    private DBConnection connection;

    public ArrayList<KhuyenMaiViewModel> getList() {
        ArrayList<KhuyenMaiViewModel> list = new ArrayList<>();
        String sql = "select  km.makhuyenmai, km.tenkhuyenmai ,lkh.loai , pt.phuongthuc,km.donhangtoithieu,\n"
                + "km.giatrikhuyenmai , km.mota,km.trangthai from khuyenmai km join loaiKhachHang lkh on idloaiKhachHang= lkh.id\n"
                + "join phuongthucgiamgia pt on idphuongthuc = pt.id";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhuyenMaiViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getFloat(6), rs.getString(7), rs.getInt(8)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Boolean Add(KhuyenMaiViewModel km) {
        int check;
        String sql = "insert into khuyenmai(makhuyenmai,\n"
                + "tenkhuyenmai ,\n"
                + "idphuongthuc ,\n"
                + "idloaiKhachHang,\n"
                + "donhangtoithieu ,\n"
                + "giatrikhuyenmai,\n"
                + "mota,\n"
                + "trangthai) values (?,?,(select id from phuongthucgiamgia where phuongthuc =?),(select id from loaiKhachHang where loai=?),?,?,?,?)";
        try ( Connection con = connection.getConnection();  PreparedStatement ps1 = con.prepareStatement(sql)) {
            ps1.setObject(1, km.getMaKM());
            ps1.setObject(2, km.getTenKm());
            ps1.setObject(3, km.getIdPhuongThuc());
            ps1.setObject(4, km.getIdLoaiKhachHang());
            ps1.setObject(5, km.getDonHangToiThieu());
            ps1.setObject(6, km.getGiaTriKhuyenMai());
            ps1.setObject(7, km.getMoTa());
            ps1.setObject(8, km.getTrangThai());
            check = ps1.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Boolean Update(KhuyenMaiViewModel km, String makhuyenmai) {
        int check2;
        String sql = "update khuyenmai set  tenkhuyenmai =?,idphuongthuc=(select id from phuongthucgiamgia where phuongthuc=?),"
                + "idloaikhachhang=(select id from loaikhachhang where loai=?)"
                + ",donhangtoithieu=?,giatrikhuyenmai=?,mota=?,trangthai=? where makhuyenmai=?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps2 = con.prepareStatement(sql)) {
            ps2.setObject(1, km.getTenKm());
            ps2.setObject(2, km.getIdPhuongThuc());
            ps2.setObject(3, km.getIdLoaiKhachHang());
            ps2.setObject(4, km.getDonHangToiThieu());
            ps2.setObject(5, km.getGiaTriKhuyenMai());
            ps2.setObject(6, km.getMoTa());
            ps2.setObject(7, km.getTrangThai());
            ps2.setObject(8, makhuyenmai);
            check2 = ps2.executeUpdate();
            return check2 > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<KhuyenMaiViewModel> timKiemQlKhuyenMai(String timKiem) {
        ArrayList<KhuyenMaiViewModel> list = new ArrayList<>();
        String sql = "select  km.makhuyenmai, km.tenkhuyenmai ,lkh.loai , pt.phuongthuc,km.donhangtoithieu,\n"
                + "km.giatrikhuyenmai , km.mota,km.trangthai from khuyenmai km join loaiKhachHang lkh on idloaiKhachHang= lkh.id\n"
                + "join phuongthucgiamgia pt on idphuongthuc = pt.id where km.makhuyenmai =? or km.tenkhuyenmai =?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, timKiem);
            ps.setString(2, timKiem);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhuyenMaiViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getFloat(6), rs.getString(7), rs.getInt(8)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<KhuyenMaiViewModel> trangThai(int trangThai) {
        ArrayList<KhuyenMaiViewModel> list = new ArrayList<>();
        String sql = "select  km.makhuyenmai, km.tenkhuyenmai ,lkh.loai , pt.phuongthuc,km.donhangtoithieu,\n"
                + "km.giatrikhuyenmai , km.mota,km.trangthai from khuyenmai km join loaiKhachHang lkh on idloaiKhachHang= lkh.id\n"
                + "join phuongthucgiamgia pt on idphuongthuc = pt.id where km.trangthai=?";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, trangThai);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhuyenMaiViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getFloat(6), rs.getString(7), rs.getInt(8)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
