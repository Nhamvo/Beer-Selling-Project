package repositoties;

import Utilities.JDBCHelper;
import domainmodels.LoaiKhachHang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khact
 */
public class QLLoaiKhachHangRepositoty implements IQLLoaiKhachHang {

    @Override
    public List<LoaiKhachHang> getLoaiKhachHangRepos() {
        List<LoaiKhachHang> list = new ArrayList<>();
        try {
            String sql = "select id, ma, loai from loaiKhachHang order by (loai) desc";
            java.sql.ResultSet rs = JDBCHelper.ExecuteQuerry(sql);
            while (rs.next()) {
                LoaiKhachHang hang = new LoaiKhachHang();
                hang.setId(rs.getString("id"));
                hang.setMa(rs.getString("ma"));
                hang.setLoai(rs.getInt("loai"));
                list.add(hang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Integer addLoaiKhachHangRepons(LoaiKhachHang hang) {
        Integer rs = null;
        try {
            String sql = "insert into loaiKhachHang (ma,loai) values (?,?)";
            rs = JDBCHelper.ExecuteUpdate(sql, hang.getMa(), hang.getLoai());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public Integer updateKhachHangRepons(LoaiKhachHang hang) {
        Integer rs = null;
        try {
            String sql = "update loaiKhachHang set ma = ?, loai = ? where id = ?";
            rs = JDBCHelper.ExecuteUpdate(sql, hang.getMa(), hang.getLoai(), hang.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

}
