/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoties;

import Utilities.DBConnection;
import domainmodels.NongDonCon;
import domainmodels.TheTich;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nham
 */
public class NongDonConRepository {

    public List<NongDonCon> getListXuatXu() {
        List<NongDonCon> listData = new ArrayList<>();
        String sql = "select * from nongdocon";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listData.add(new NongDonCon(rs.getString(1), rs.getString(2)));

            }
            return listData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int add(NongDonCon sp) {
        int check;
        String sql = "insert into NongDoCon( id,nongdocon) values (newid(),?)";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, sp.getNongDoCon());
            check = ps.executeUpdate();
            return check;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
