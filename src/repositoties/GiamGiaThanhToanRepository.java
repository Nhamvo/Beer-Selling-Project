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
import viewmodels.GiamGiaThanhToanViewModel;

/**
 *
 * @author Nham
 */
public class GiamGiaThanhToanRepository {

    public GiamGiaThanhToanViewModel timKiemSanPham(String txtTimKiem, float thanhTien) {
        GiamGiaThanhToanViewModel gh = new GiamGiaThanhToanViewModel();
        String sql = "SELECT top 1 hoten, lkh.loai, km.donhangtoithieu, km.giatrikhuyenmai,\n"
                + "ptgg.ma, km.trangthai, \n"
                + "       CASE WHEN ptgg.ma = 'gggt' THEN km.giatrikhuyenmai \n"
                + "            ELSE ? * km.giatrikhuyenmai / 100 END as arrange\n"
                + "FROM khachhang \n"
                + "JOIN loaiKhachHang lkh ON khachhang.idloaiKhachHang = lkh.id \n"
                + "JOIN khuyenmai km ON lkh.id = km.idloaiKhachHang \n"
                + "JOIN phuongthucgiamgia ptgg ON km.idphuongthuc = ptgg.id\n"
                + "WHERE sdt = ? AND km.trangthai = 1 and ? >= km.donhangtoithieu \n"
                + "order by arrange desc";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setFloat(1, thanhTien);
            pstm.setFloat(3, thanhTien);
            pstm.setString(2, txtTimKiem);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                gh.setHoTen(rs.getString(1));
                gh.setLoaiKhachHang(rs.getInt(2));
                gh.setDonHangToiThieu(rs.getFloat(3));
                gh.setGiaTriKhuyenMai(rs.getFloat(4));
                gh.setMaPhuongThucGiamGia(rs.getString(5));
                gh.setTrangThai(rs.getInt(6));

            }
            return gh;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
