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
import viewmodels.LichSuHoaDonViewModel;

/**
 *
 * @author Nham
 */
public class LichSuHoaDonRepository {

    public List<LichSuHoaDonViewModel> getListLsHoaDon() {
        List<LichSuHoaDonViewModel> listData = new ArrayList<>();
        String sql = "select idhoadon ,manv ,thoigian,(select hoten from khachhang\n"
                + "where id = idkhachhang),tienhang,giamgia \n"
                + ",tongthanhtoan,tientralai,trangthai from hoadon order by idhoadon desc";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listData.add(new LichSuHoaDonViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getLong(5), rs.getLong(6), rs.getLong(7), rs.getLong(8), rs.getInt(9)));
            }
            return listData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
