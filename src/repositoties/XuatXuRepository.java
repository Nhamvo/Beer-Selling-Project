/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoties;

import Utilities.DBConnection;
import domainmodels.XuatXu;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class XuatXuRepository {

    public List<XuatXu> getListXuatXu() {
        List<XuatXu> listData = new ArrayList<>();
        String sql = "select * from xuatXu";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listData.add(new XuatXu(rs.getString(1), rs.getString(2)));

            }
            return listData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int add(XuatXu sp) {
        int check;
        String sql = "insert into xuatxu( id,tenquocgia) values (newid(),?)";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setObject(1, sp.getTenQuocGia());
            check = ps.executeUpdate();
            return check;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
