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
import viewmodels.SanPhamViewModel;

/**
 *
 * @author Nham
 */
public class SanPhamRepository {

    public List<SanPhamViewModel> getListSanPham() {
        List<SanPhamViewModel> listData = new ArrayList<>();
        String sql = "SELECT\n"
                + "  sp.MaSp, \n"
                + "  sp.TenSp, \n"
                + "  xx.tenquocgia AS TenQuocGia, \n"
                + "  th.tenthuonghieu AS TenThuongHieu, \n"
                + "  tv.thetich, \n"
                + "  ndc.nongdocon, \n"
                + "  sp.NgaySanXuat, \n"
                + "  sp.NgayHetHan, \n"
                + "  sp.MaVach, \n"
                + "  sp.SoLonMoiThung, \n"
                + "  sp.GiaBanTheoThung, \n"
                + "  sp.GiaBanTheoLon, \n"
                + "  sp.SoLuongThung, \n"
                + "  sp.SoLuongLon, \n"
                + "  sp.HinhAnh, \n"
                + "  sp.TrangThai \n"
                + "FROM \n"
                + "  sanPham sp \n"
                + "   JOIN xuatxu xx ON sp.idxuatxu = xx.id \n"
                + "   JOIN thuonghieu th ON sp.idthuonghieu = th.id \n"
                + "   JOIN thetich tv ON sp.idthetich = tv.id \n"
                + "   JOIN nongdocon ndc ON sp.idnongdoncon = ndc.id";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listData.add(new SanPhamViewModel(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getFloat(11),
                        rs.getFloat(12), rs.getInt(13), rs.getInt(14), rs.getString(15), rs.getInt(16)));
            }
            return listData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int add(SanPhamViewModel sp) {
        int check;
        String sql = "insert into sanpham ( tensp,idxuatxu,idthuonghieu,idthetich,idnongdoncon,\n"
                + "ngaysanxuat,ngayhethan,mavach,solonmoithung,giabantheothung,giabantheolon,soluongthung,soluonglon,\n"
                + "hinhanh,trangthai) values (?,(select id from xuatxu where tenquocgia = ?),"
                + " (select id from thuonghieu where tenthuonghieu = ? ),"
                + "(select id from thetich where thetich = ? ),"
                + "(select id from nongdocon where nongdocon = ? ),?,?,?,?,?,?,?,?,?,?) ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, sp.getTenSp());
            ps.setObject(2, sp.getXuatXu());
            ps.setObject(3, sp.getThuongHieu());
            ps.setObject(4, sp.getTheTich());
            ps.setObject(5, sp.getNongDoCon());
            ps.setObject(6, sp.getNgaySanXuat());
            ps.setObject(7, sp.getNgayHetHan());
            ps.setObject(8, sp.getMaVach());
            ps.setObject(9, sp.getSoLonMoiThung());
            ps.setObject(10, sp.getGiaBanTheoThung());
            ps.setObject(11, sp.getGiaBanTheoLon());
            ps.setObject(12, sp.getSoLuongThung());
            ps.setObject(13, sp.getSoLuongLon());
            ps.setObject(14, sp.getHinhAnh());
            ps.setObject(15, sp.getTrangThai());
            check = ps.executeUpdate();
            return check;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(SanPhamViewModel sp) {
        String sql = "UPDATE sanpham SET \n"
                + "    tensp = ?,\n"
                + "    idxuatxu = (SELECT id FROM xuatxu WHERE tenquocgia = ?),\n"
                + "    idthuonghieu = (SELECT id FROM thuonghieu WHERE tenthuonghieu = ?),\n"
                + "    idthetich = (SELECT id FROM thetich WHERE thetich = ?),\n"
                + "    idnongdoncon = (SELECT id FROM nongdocon WHERE nongdocon = ?),\n"
                + "    ngaysanxuat = ?,\n"
                + "    ngayhethan = ?,\n"
                + "    mavach = ?,\n"
                + "    solonmoithung = ?,\n"
                + "    giabantheothung = ?,\n"
                + "    giabantheolon = ?,\n"
                + "    soluongthung = ?,\n"
                + "    soluonglon = ?,\n"
                + "    hinhanh = ?,\n"
                + "    trangthai = ?\n"
                + "WHERE masp = ?; ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, sp.getTenSp());
            ps.setObject(2, sp.getXuatXu());
            ps.setObject(3, sp.getThuongHieu());
            ps.setObject(4, sp.getTheTich());
            ps.setObject(5, sp.getNongDoCon());
            ps.setObject(6, sp.getNgaySanXuat());
            ps.setObject(7, sp.getNgayHetHan());
            ps.setObject(8, sp.getMaVach());
            ps.setObject(9, sp.getSoLonMoiThung());
            ps.setObject(10, sp.getGiaBanTheoThung());
            ps.setObject(11, sp.getGiaBanTheoLon());
            ps.setObject(12, sp.getSoLuongThung());
            ps.setObject(13, sp.getSoLuongLon());
            ps.setObject(14, sp.getHinhAnh());
            ps.setObject(15, sp.getTrangThai());
            ps.setObject(16, sp.getMasp());
            int check = ps.executeUpdate();
            return check;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<SanPhamViewModel> timKiemSanPham(String txtTimKiem) {
        List<SanPhamViewModel> listData = new ArrayList<>();
        String sql = "SELECT\n"
                + "  sp.MaSp, \n"
                + "  sp.TenSp, \n"
                + "  xx.tenquocgia AS TenQuocGia, \n"
                + "  th.tenthuonghieu AS TenThuongHieu, \n"
                + "  tv.thetich, \n"
                + "  ndc.nongdocon, \n"
                + "  sp.NgaySanXuat, \n"
                + "  sp.NgayHetHan, \n"
                + "  sp.MaVach, \n"
                + "  sp.SoLonMoiThung, \n"
                + "  sp.GiaBanTheoThung, \n"
                + "  sp.GiaBanTheoLon, \n"
                + "  sp.SoLuongThung, \n"
                + "  sp.SoLuongLon, \n"
                + "  sp.HinhAnh, \n"
                + "  sp.TrangThai \n"
                + "FROM \n"
                + "  sanPham sp \n"
                + "   JOIN xuatxu xx ON sp.idxuatxu = xx.id \n"
                + "   JOIN thuonghieu th ON sp.idthuonghieu = th.id \n"
                + "   JOIN thetich tv ON sp.idthetich = tv.id \n"
                + "   JOIN nongdocon ndc ON sp.idnongdoncon = ndc.id\n"
                + "	where sp.tensp = ? or tenthuonghieu =? or tenquocgia = ? ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, txtTimKiem);
            pstm.setString(2, txtTimKiem);
            pstm.setString(3, txtTimKiem);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listData.add(new SanPhamViewModel(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getFloat(11),
                        rs.getFloat(12), rs.getInt(13), rs.getInt(14), rs.getString(15), rs.getInt(16)));
            }
            return listData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPhamViewModel> hienThiTrangThaiSp(int TrangThai) {
        List<SanPhamViewModel> listData = new ArrayList<>();
        String sql = "SELECT\n"
                + "  sp.MaSp, \n"
                + "  sp.TenSp, \n"
                + "  xx.tenquocgia AS TenQuocGia, \n"
                + "  th.tenthuonghieu AS TenThuongHieu, \n"
                + "  tv.thetich, \n"
                + "  ndc.nongdocon, \n"
                + "  sp.NgaySanXuat, \n"
                + "  sp.NgayHetHan, \n"
                + "  sp.MaVach, \n"
                + "  sp.SoLonMoiThung, \n"
                + "  sp.GiaBanTheoThung, \n"
                + "  sp.GiaBanTheoLon, \n"
                + "  sp.SoLuongThung, \n"
                + "  sp.SoLuongLon, \n"
                + "  sp.HinhAnh, \n"
                + "  sp.TrangThai \n"
                + "FROM \n"
                + "  sanPham sp \n"
                + "   JOIN xuatxu xx ON sp.idxuatxu = xx.id \n"
                + "   JOIN thuonghieu th ON sp.idthuonghieu = th.id \n"
                + "   JOIN thetich tv ON sp.idthetich = tv.id \n"
                + "   JOIN nongdocon ndc ON sp.idnongdoncon = ndc.id\n"
                + "	where sp.TrangThai= ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, TrangThai);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listData.add(new SanPhamViewModel(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getFloat(11),
                        rs.getFloat(12), rs.getInt(13), rs.getInt(14), rs.getString(15), rs.getInt(16)));
            }
            return listData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
