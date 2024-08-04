/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoties;

import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import domainmodels.NhanVien;
import java.util.ArrayList;
import java.util.List;
import viewmodels.NhanVienViewModel;

/**
 *
 * @author NITRO
 */
public class NhanVienRepository {

    public ArrayList<NhanVienViewModel> getAll() {
        String query = "select nhanvien .*,quyen from nhanvien join taikhoan\n"
                + "on nhanvien.manv = taikhoan.username";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            ArrayList<NhanVienViewModel> listnv = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
                listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public ArrayList<NhanVienViewModel> searchByNhanViens(String txtManv) {
        ArrayList<NhanVienViewModel> listnv = new ArrayList<>();
        String query = "select nhanvien .*,quyen from nhanvien join taikhoan\n"
                + "on nhanvien.manv = taikhoan.username  where manv = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, txtManv);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getString(8), rs.getInt(9));
                listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public ArrayList<NhanVienViewModel> searchByTrangThai(int tt) {
        ArrayList<NhanVienViewModel> listnv = new ArrayList<>();
        String query = "select nhanvien .*,quyen from nhanvien join taikhoan\n"
                + "on nhanvien.manv = taikhoan.username\n"
                + "where trangthai=?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7), rs.getString(8), rs.getInt(9));
                listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public boolean update(NhanVien nv) {
        int check = 0;
        String query = """
                      UPDATE [dbo].[NhanVien]
                                        SET
                                                                                               [TenNv]= ?
                                                                                               ,[DiaChi]= ?
                                                                                               ,[GioiTinh]= ?
                                                                                               ,[NgaySinh]= ?
                                                                                               ,[Sdt]= ?
                                                                                               ,[TrangThai] = ?

                                      WHERE MaNv=?
                   """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, nv.getTenNV());
            ps.setObject(3, nv.getGioiTinh());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(2, nv.getDiaChi());
            ps.setObject(5, nv.getSdt());

            ps.setObject(6, nv.getTrangThai());
            ps.setObject(7, nv.getMaNV());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
