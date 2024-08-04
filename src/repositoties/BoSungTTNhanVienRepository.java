/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoties;

import Utilities.DBConnection;
import domainmodels.BoSungTTNhanVien;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class BoSungTTNhanVienRepository {
    private DBConnection connection;
   public Boolean them(BoSungTTNhanVien nv){
       int check;
       String sql ="insert nhanvien(manv, tennv, diachi,gioitinh,ngaysinh,sdt) values (?,?,?,?,?,?)";
       try(Connection con = connection.getConnection();PreparedStatement ps = con.prepareStatement(sql)){
      ps.setObject(1, nv.getManv());
       ps.setObject(2, nv.getTennv());
       ps.setObject(3, nv.getDiachi());
       ps.setObject(4, nv.getGioitinh());
       ps.setObject(5, nv.getNgaysinh());
       ps.setObject(6, nv.getSdt());
       check = ps.executeUpdate();
       return check>0;
       }
       catch(Exception e){
               e.printStackTrace();}
   
   return null;
   }
    
    }
    

