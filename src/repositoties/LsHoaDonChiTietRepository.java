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
import viewmodels.LsHoaDonChiTietViewModel;

/**
 *
 * @author Nham
 */
public class LsHoaDonChiTietRepository {

    public List<LsHoaDonChiTietViewModel> getListLsChiTietHoaDon(String idHoaDon) {
        List<LsHoaDonChiTietViewModel> listData = new ArrayList<>();
        String sql = "select idhoadon,sp.MaSp,sp.tensp ,sothungmua,solonmua,\n"
                + "thanhtien,sp.hinhanh,soluongthung,soluonglon,solonmoithung from chitiethoadon join sanpham sp \n"
                + "on chitiethoadon.idsanpham = sp.id\n"
                + "where idhoadon= ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, idHoaDon);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listData.add(new LsHoaDonChiTietViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
                        rs.getLong(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
            return listData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
