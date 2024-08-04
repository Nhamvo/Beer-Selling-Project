/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoties;

import Utilities.DBConnection;
import viewmodels.HoaDonViewModel;
import java.sql.*;

/**
 *
 * @author Nham
 */
public class HoaDonRepository {

    public void add(HoaDonViewModel sp) {
        int check;
        String sql = "insert into hoadon (idkhachhang,manv,tienhang,\n"
                + "tongthanhtoan,trangthai,giamgia,tientralai,thoigian,ghiChu)\n"
                + "values ( (select id from khachhang where sdt = ? )\n"
                + ",?, ?, ?,?,?,?, ?,? )";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, sp.getSdt());
            ps.setObject(2, sp.getManv());
            ps.setObject(3, sp.getTienHang());
            ps.setObject(4, sp.getTongThanhToan());
            ps.setObject(5, sp.getTrangThai());
            ps.setObject(6, sp.getGiamGia());
            ps.setObject(7, sp.getTienTraLai());
            ps.setObject(8, sp.getThoiGian());
            ps.setObject(9, sp.getGhiChu());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
