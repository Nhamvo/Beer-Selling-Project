/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.sql.*;

public class JDBCHelper {

    public static ResultSet ExecuteQuerry(String sql, Object... args) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = DBConnection.getConnection();
            ps = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static Integer ExecuteUpdate(String sql, Object... args) {
        Connection cn = null;
        PreparedStatement ps = null;
        Integer rs = null;
        try {
            cn = DBConnection.getConnection();
            ps = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

}
