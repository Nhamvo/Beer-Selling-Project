/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoties;

import Utilities.DBConnection;
import Utilities.JDBCHelper;
import java.sql.*;
import domainmodels.KhachHang;
import domainmodels.LoaiKhachHang;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khact
 */
public class QLKhachHangRepositoty implements IQLKhachHangRepository {

    private final QLLoaiKhachHangRepositoty hangService = new QLLoaiKhachHangRepositoty();

    @Override
    public List<KhachHang> getKhachHangRepo() {
        List<KhachHang> list = new ArrayList<>();
        List<LoaiKhachHang> list1 = hangService.getLoaiKhachHangRepos();
        try {
            String sql = "select * from khachhang";
            java.sql.ResultSet rs = JDBCHelper.ExecuteQuerry(sql);
            while (rs.next()) {
                KhachHang kh = new KhachHang();

                // Loai Khach Hang
                LoaiKhachHang hang = new LoaiKhachHang();
                for (LoaiKhachHang a : list1) {
                    if (a.getId().equalsIgnoreCase(rs.getString("idloaiKhachHang"))) {
                        hang = a;
                        break;
                    }
                }
                kh.setIdLoaiKhachHang(hang);
                kh.setIdKH(rs.getString("id"));
                kh.setTenKH(rs.getString("hoten"));
                kh.setGioiTinh(rs.getByte("gioitinh"));
                kh.setSoDienThoaiKH(rs.getString("sdt"));
                kh.setDiaChiKH(rs.getString("diachi"));
                kh.setSoTienDaChi(rs.getLong("sotiendachi"));
                list.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Integer addKhachHangRepo(KhachHang kh) {
        Integer ketQua;
        String sql = "INSERT INTO khachhang (idloaiKhachHang, hoten,gioitinh, sdt, diachi, sotiendachi) VALUES  (?,?,?,?,?,?)";
        ketQua = JDBCHelper.ExecuteUpdate(sql, kh.getIdLoaiKhachHang().getId(), kh.getTenKH(), kh.getGioiTinh(), kh.getSoDienThoaiKH(), kh.getDiaChiKH(), kh.getSoTienDaChi());
        return ketQua;
    }

    @Override
    public Integer updateKhachHangRepo(KhachHang kh, String sdt) {
        Integer ketQua;
        String sql = "UPDATE  khachhang SET idloaiKhachHang = ? , hoten = ? , gioitinh = ? , sdt = ? , diachi = ? , sotiendachi = ? where sdt = ?";
        ketQua = JDBCHelper.ExecuteUpdate(sql, kh.getIdLoaiKhachHang().getId(), kh.getTenKH(), kh.getGioiTinh(), kh.getSoDienThoaiKH(), kh.getDiaChiKH(), kh.getSoTienDaChi(), sdt);
        return ketQua;
    }

    @Override
    public List<KhachHang> searchKhachHangRepo(String kh) {
        List<KhachHang> list = new ArrayList<>();
        List<LoaiKhachHang> list1 = hangService.getLoaiKhachHangRepos();
        try {
            String sql = "select * from khachhang where (hoten like ? or diachi like ? or sdt like ? )";
            String tenKH = "%" + kh + "%";
            String diaChi = "%" + kh + "%";
            String sdt = "%" + kh + "%";
            java.sql.ResultSet rs = JDBCHelper.ExecuteQuerry(sql, tenKH, diaChi, sdt);
            while (rs.next()) {
                KhachHang kh1 = new KhachHang();

                // Loai Khach Hang
                LoaiKhachHang hang = new LoaiKhachHang();
                for (LoaiKhachHang a : list1) {
                    if (a.getId().equalsIgnoreCase(rs.getString("idloaiKhachHang"))) {
                        hang = a;
                        break;
                    }
                }
                kh1.setIdLoaiKhachHang(hang);
                kh1.setIdKH(rs.getString("id"));
                kh1.setTenKH(rs.getString("hoten"));
                kh1.setGioiTinh(rs.getByte("gioitinh"));
                kh1.setSoDienThoaiKH(rs.getString("sdt"));
                kh1.setDiaChiKH(rs.getString("diachi"));
                kh1.setSoTienDaChi(rs.getLong("sotiendachi"));
                list.add(kh1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<KhachHang> xapXepKhachHangRepo(String x) {
        List<KhachHang> list = new ArrayList<>();
        List<LoaiKhachHang> list1 = hangService.getLoaiKhachHangRepos();
        try {
            String sql = "select kh.id,kh.idloaiKhachHang, kh.sdt, kh.hoten, kh.diachi, kh.gioitinh, kh.sotiendachi "
                    + "from khachhang as kh join loaiKhachHang as lkh on kh.idloaiKhachHang = lkh.id order by " + x;
            java.sql.ResultSet rs = JDBCHelper.ExecuteQuerry(sql);
            while (rs.next()) {
                KhachHang kh1 = new KhachHang();
                kh1.setIdKH(rs.getString("id"));
                // Loai Khach Hang
                LoaiKhachHang hang = new LoaiKhachHang();
                for (LoaiKhachHang a : list1) {
                    if (a.getId().equalsIgnoreCase(rs.getString("idloaiKhachHang"))) {
                        hang = a;
                        break;
                    }
                }
                kh1.setIdLoaiKhachHang(hang);
                kh1.setTenKH(rs.getString("hoten"));
                kh1.setGioiTinh(rs.getByte("gioitinh"));
                kh1.setSoDienThoaiKH(rs.getString("sdt"));
                kh1.setDiaChiKH(rs.getString("diachi"));
                kh1.setSoTienDaChi(rs.getLong("sotiendachi"));
                list.add(kh1);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    @Override
    public Integer deleteKhachHang(KhachHang kh) {
        var sql = "update khachhang set trangthai = 0 where sdt = ?";
        Integer a = JDBCHelper.ExecuteUpdate(sql, kh.getSoDienThoaiKH());
        return a;
    }

    @Override
    public void updateSoTienDaChi(String sdt, float soTienDaChi) {
        String sql = "update khachhang set sotiendachi=(select sotiendachi \n"
                + "from khachhang where sdt =?) + ? where sdt=?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, sdt);
            ps.setFloat(2, soTienDaChi);
            ps.setString(3, sdt);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
