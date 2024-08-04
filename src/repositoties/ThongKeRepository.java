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
import viewmodels.ThongKeViewModel;

/**
 *
 * @author Nham
 */
public class ThongKeRepository {

    public List<ThongKeViewModel> getListThongKe(String sqlWhere) {
        List<ThongKeViewModel> listData = new ArrayList<>();
        String sql = "SELECT sp.MaSp, sp.TenSp, SUM(ct.sothungmua), SUM(ct.solonmua), sum (ct.thanhtien), sp.hinhanh\n"
                + "FROM chitiethoadon ct \n"
                + "JOIN sanPham sp ON ct.idsanpham = sp.Id \n"
                + "JOIN hoadon hd ON ct.idhoadon = hd.idhoadon\n"
                + "WHERE " + sqlWhere;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listData.add(new ThongKeViewModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getLong(5), rs.getString(6)));

            }
            return listData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getKqDoanhThu(String sqlWhere) {
        String kq = "";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sqlWhere)) {
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                kq = rs.getString(1);
            }

            return kq;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
