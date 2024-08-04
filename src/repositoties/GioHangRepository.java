/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoties;

import Utilities.DBConnection;
import domainmodels.NongDonCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import viewmodels.GioHangBarCodeViewModel;

/**
 *
 * @author Nham
 */
public class GioHangRepository {

    public List<GioHangBarCodeViewModel> getListGioHangBarCodeViewModels(String ma) {
        List<GioHangBarCodeViewModel> listData = new ArrayList<>();
        String sql = "select TenSp,masp,giabantheothung,giabantheolon,solonmoithung,soLuongThung,soLuongLon from sanpham\n"
                + "where mavach= ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, ma);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listData.add(new GioHangBarCodeViewModel(rs.getString(1), rs.getString(2),
                        rs.getFloat(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));

            }
            return listData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
