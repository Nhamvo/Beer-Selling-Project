/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoties;

import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JTable;
import viewmodels.GioHangViewModel;

/**
 *
 * @author Nham
 */
public class HoaDonChiTietRepository {

//    public void add(JTable tb) {
//        String sql = "insert into chitiethoadon values ((SELECT TOP 1\n"
//                + "idhoadon FROM hoadon ORDER BY idhoadon DESC),\n"
//                + "(select id from sanpham where tensp = ?),\n"
//                + "?,?,?\n"
//                + ")";
//        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
//            for (int i = 0; i < tb.getRowCount(); i++) {
//                ps.setString(1, tb.getValueAt(i, 1).toString());
//                ps.setInt(2, Integer.valueOf(tb.getValueAt(i, 2).toString()));
//                ps.setInt(3, Integer.valueOf(tb.getValueAt(i, 3).toString()));
//                ps.setFloat(4, Float.valueOf(tb.getValueAt(i, 4).toString()));
//                ps.addBatch();
//            }
//            int[] rowsInserted = ps.executeBatch();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    public void add1(List<GioHangViewModel> listsGh) {
        String sql = "insert into chitiethoadon values ((SELECT TOP 1\n"
                + "idhoadon FROM hoadon ORDER BY idhoadon DESC),\n"
                + "(select id from sanpham where tensp = ?),\n"
                + "?,?,?\n"
                + ")";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            for (int i = 0; i < listsGh.size(); i++) {
                ps.setString(1, listsGh.get(i).getTen());
                ps.setInt(2, Integer.valueOf(listsGh.get(i).getSoLuongThung()));
                ps.setInt(3, Integer.valueOf(listsGh.get(i).getSoLuongLon()));
                ps.setFloat(4, Float.valueOf(listsGh.get(i).getThanhTien()));
                ps.addBatch();
            }
            int[] rowsInserted = ps.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateSlSanPham(List<GioHangViewModel> listsGh) {
        String sql = "update sanPham set soluonglon=? , soluongthung=? where TenSp= ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            for (int i = 0; i < listsGh.size(); i++) {
                ps.setInt(1, Integer.valueOf(listsGh.get(i).getSoLonConLai()));
                ps.setInt(2, Integer.valueOf(listsGh.get(i).getSoThungConLai()));
                ps.setString(3, listsGh.get(i).getTen());
                ps.addBatch();
            }
            int[] rowsInserted = ps.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
