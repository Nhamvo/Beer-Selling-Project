/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoties;

import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Nham
 */
public class Account {

    public int showAccount(String name, String passWord) {
        String sql = "select username ,matkhau,quyen from taikhoan";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                if (name.equals(rs.getString("username")) && passWord.equals(rs.getString("matkhau"))) {
                    if (rs.getInt("quyen") == 0) {
                        return 1;
                    } else if (rs.getInt("quyen") == 1) {
                        return 2;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int checkEmail(String email) {
        String sql = "select email from taikhoan ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                if (email.equals(rs.getString("email"))) {
                    return 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int signUp(String name, String email, String matkhau) {
        String sql = "insert into taikhoan(userName,email,matkhau) values (?,?,?)";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setString(3, matkhau);
            pstm.executeUpdate();
            return 1;
        } catch (Exception e) {
            String temp = String.valueOf(e);
            if (temp.contains(" The duplicate key value is")) {
                return 0;
            } else {
                e.printStackTrace();
            }
        }
        return 2;

    }

}
