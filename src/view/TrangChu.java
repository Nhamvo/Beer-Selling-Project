/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Utilities.CustomerSortingComparator;
import domainmodels.NhanVien;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import repositoties.IQLKhachHangRepository;
import repositoties.QLKhachHangRepositoty;
import service.GiamGiaThanhToanService;
import service.HoaDonChiTietService;
import service.NongDoConService;
import service.SanPhamService;
import service.TheTichService;
import service.ThuongHieuService;
import service.XuatXuService;
import service_impl.HoaDonImpl;
import service_impl.NongDoConImpl;
import service_impl.SanPhamImpl;
import service_impl.TheTichImpl;
import service_impl.ThuongHieuImpl;
import service_impl.XuatXuImpl;
import viewmodels.GioHangViewModel;
import viewmodels.NongDoConViewModel;
import viewmodels.SanPhamViewModel;
import viewmodels.TheTichViewModel;
import viewmodels.ThuongHieuViewModel;
import viewmodels.XuatXuViewModel;
import service.HoaDonService;
import service.KhuyenMaiService;
import service.LichSuHoaDonService;
import service.LsHoaDonChiTietService;
import service.NhanVienService;
import service.ThongKeServie;
import service.VanChuyenService;
import service_impl.GiamGiaThanhToanImpl;
import service_impl.HoaDonChiTietimpl;
import service_impl.KhyenMaiImpl;
import service_impl.LichSuHoaDonImpl;
import service_impl.LsHoaDonChiTietImpl;
import service_impl.NhanVienImpl;
import service_impl.QLKhachHangService;
import service_impl.QLLoaiKhachHangService;
import service_impl.ThongKeImpl;
import service_impl.VanChuyenImpl;
import viewmodels.GiamGiaThanhToanViewModel;
import viewmodels.HoaDonChoViewModel;
import viewmodels.HoaDonViewModel;
import viewmodels.KhachHangViewModel;
import viewmodels.KhuyenMaiViewModel;
import viewmodels.LichSuHoaDonViewModel;
import viewmodels.LoaiKhachHangViewModel;
import viewmodels.LsHoaDonChiTietViewModel;
import viewmodels.NhanVienViewModel;
import viewmodels.ThongKeViewModel;
import viewmodels.VanChuyenViewModel;

/**
 *
 * @author Nham
 */
public class TrangChu extends javax.swing.JFrame {

    public static TrangChu Instance;
    public JTextField txtGetBarCode;
    public JTextField txtGetSdtKh;
    public String jspGhSoThung;
    public String jspGhSoLon;
    public String soThungConLai;
    public String soLonConLai;
    public String lbGhThanhTien;
    public String txtMaSpGioHang;
    public String txtTenSpString;
    private SanPhamService rsSp = new SanPhamImpl();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtmBanHang = new DefaultTableModel();
    private DefaultTableModel dtmNhanVien = new DefaultTableModel();
    private DefaultTableModel dtmGioHang = new DefaultTableModel();
    private DefaultTableModel dtmHoaDon = new DefaultTableModel();
    private DefaultTableModel dtmHoaDonCho = new DefaultTableModel();
    private DefaultTableModel dtmThongKe = new DefaultTableModel();
    private DefaultTableModel dtmLsCtHoaDon = new DefaultTableModel();
    private DefaultComboBoxModel cbbXuatXu = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbThuongHieu = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbTheTichs = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbNongDoCons = new DefaultComboBoxModel();
    public List<GioHangViewModel> listGiohang = new ArrayList<>();
    public List<HoaDonChoViewModel> listHoaDonCho = new ArrayList<>();
    private HoaDonChiTietService hdct = new HoaDonChiTietimpl();
    private LichSuHoaDonService lshd = new LichSuHoaDonImpl();
    private HoaDonService bh = new HoaDonImpl();
    private VanChuyenService vcs = new VanChuyenImpl();
    private ThongKeServie tksv = new ThongKeImpl();
    LsHoaDonChiTietService sv = new LsHoaDonChiTietImpl();
    List<LsHoaDonChiTietViewModel> listLShD = new ArrayList<>();
    private NhanVienService nvSv = new NhanVienImpl();

    private KhuyenMaiService ser = new KhyenMaiImpl();
    private QLKhachHangService qLKhachHangService = new QLKhachHangService();
    private QLLoaiKhachHangService qLLoaiKhachHangService = new QLLoaiKhachHangService();
    private DefaultTableModel tableModelKh = new DefaultTableModel();
    String hinhanhSp;
    String hinhanhNhanVien;
    String soThung = "";
    String soLon = "";
    String thanhTien = "";
    String soLonCl = "";
    String soThungCl = "";
    CardLayout clo;
    CardLayout hoaDonCardLayout;
    String sdtSoTienDachi = "";

    public TrangChu(String manv, String chucVu) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        clo = (CardLayout) (jPanel1.getLayout());
        hoaDonCardLayout = (CardLayout) (jpHoaDonChung.getLayout());
        menuQuanLySp(manv, chucVu);
        Instance = this;
        banHang();
        loadDataKH(qLKhachHangService.getKhachHangService());
        hienThiListLichSuHd(lshd.lists());
        txtMaSpGioHang = "";
        txtTenSpString = "";
        jspGhSoThung = "";
        jspGhSoLon = "";
        sdtSoTienDachi = "";
        lbGhThanhTien = thanhTien;
        soLonConLai = soLonCl;
        soThungConLai = soThungCl;
        lblMaNvBanHang.setText(txtManv.getText());
        txtGetSdtKh = txtBhSdt;

        load(ser.getList());
        listHoaDonCho();
        LoadTable(nvSv.getList());

    }

    public void checkThongKe() {

        String sql = "";
        if (rdoTkTheoNgay.isSelected()) {
            sql = "CONVERT(DATE, thoigian, 103) = CONVERT(DATE, GETDATE(), 103) and hd.trangthai=1\n"
                    + "GROUP BY sp.MaSp, sp.TenSp, sp.hinhanh\n"
                    + "ORDER BY SUM(hd.tongthanhtoan) DESC";

        } else if (rdoTkTheoThang.isSelected()) {
            sql = "MONTH(CONVERT(DATETIME, thoigian, 103)) = MONTH(GETDATE()) \n"
                    + "AND YEAR(CONVERT(DATETIME, thoigian, 103)) = YEAR(GETDATE())and hd.trangthai=1\n"
                    + "GROUP BY sp.MaSp, sp.TenSp, sp.hinhanh\n"
                    + "ORDER BY SUM(hd.tongthanhtoan) DESC";

        } else if (rdoTktheoNam.isSelected()) {
            sql = "YEAR(CONVERT(DATETIME, thoigian, 103)) = YEAR(GETDATE())and hd.trangthai=1\n"
                    + "GROUP BY sp.MaSp, sp.TenSp, sp.hinhanh\n"
                    + "ORDER BY SUM(hd.tongthanhtoan) DESC";
        }
        hienThiListThongke(tksv.getListThongKe(sql));
    }

    public void banHang() {
        hienThiSpBanHang(rsSp.getList());

    }

    public void hienThiListLichSuHd(List<LichSuHoaDonViewModel> ls) {

        dtmHoaDon = (DefaultTableModel) tbLsHoaDon.getModel();
        dtmHoaDon.setRowCount(0);
        for (LichSuHoaDonViewModel o : ls) {
            dtmHoaDon.addRow(o.dataRow());
        }
    }

    public void dateTime() {
        String temp = bh.dateTime();
        lblDateTime.setText(temp);
    }

    public void menuQuanLySp(String manv, String chucVu) {

        txtGetBarCode = txtQlMaVach;
        txtChucVu.setText(chucVu);
        txtManv.setText(manv);
        cbbAll();
        hienThi(rsSp.getList());
    }

    public void hienThiSpBanHang(List<SanPhamViewModel> listSp) {
        dtmBanHang = (DefaultTableModel) tbBhDanhSachSanPham.getModel();
        dtmBanHang.setRowCount(0);
        for (SanPhamViewModel o : listSp) {
            try {
                String time = o.getNgayHetHan();
                LocalDate futureDate = LocalDate.parse(time);
                LocalDate now = LocalDate.now();
                if (o.getTrangThai() == 1 && now.isBefore(futureDate)) {
                    dtmBanHang.addRow(new Object[]{"SP0" + o.getMasp(), o.getTenSp(), o.getSoLuongThung(),
                        o.getSoLuongLon(), o.getSoLonMoiThung(), o.getGiaBanTheoThung(), o.getGiaBanTheoLon(),
                        o.getHinhAnh(), o.getMaVach()});
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void clearFormBanHang() {
        lblBHTongTienHang.setText("0");
        lblGiamGia.setText("0");
        lblSoTienCanTra.setText("0");
        txtSoTienKhachTra.setText("");
        lblTienTraLai.setText("0");
        jtaGhiChu.setText("");
        lblThVnd.setText("");
        lblThVnd1.setText("");
        lblThVnd2.setText("");
        lblThVnd3.setText("");
        lblDateTime.setText("");
        txtBhSdt.setText("");
        lblBhTenKhachHang.setText("");
        lblBhHangKhachHang.setText("");

    }

    public void taoHoaDon(int tt) {
        try {
            DecimalFormat df = new DecimalFormat("#,###.##");
            float floatTienHang = Float.parseFloat(df.parse(lblBHTongTienHang.getText()).toString());
            float floatTongThanhToan = Float.parseFloat(df.parse(lblSoTienCanTra.getText()).toString());
            float floatGiamGia = Float.parseFloat(df.parse(lblGiamGia.getText()).toString());
            float floatTienTraLai = Float.parseFloat(df.parse(lblTienTraLai.getText()).toString());
            HoaDonViewModel h = new HoaDonViewModel();
            h.setSdt(txtBhSdt.getText());
            h.setManv(lblMaNvBanHang.getText());
            h.setTienHang(floatTienHang);
            h.setTongThanhToan(floatTongThanhToan);
            h.setTrangThai(tt);
            h.setGiamGia(floatGiamGia);
            h.setTienTraLai(floatTienTraLai);
            h.setThoiGian(lblDateTime.getText());
            h.setGhiChu(jtaGhiChu.getText());
            bh.insert(h);
            if (tt == 1) {
                IQLKhachHangRepository rs = new QLKhachHangRepositoty();
                rs.updateSoTienDaChi(txtBhSdt.getText(), floatTienHang);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void dataGioHangBarCode() {
        listGiohang.add(new GioHangViewModel(txtMaSpGioHang, txtTenSpString, jspGhSoThung, jspGhSoLon, lbGhThanhTien, soLonConLai, soThungConLai));
    }

    public void dataGioHang() {
        int row = tbBhDanhSachSanPham.getSelectedRow();
        String ma = tbBhDanhSachSanPham.getValueAt(row, 0).toString();
        String ten = tbBhDanhSachSanPham.getValueAt(row, 1).toString();
        listGiohang.add(new GioHangViewModel(ma, ten, jspGhSoThung, jspGhSoLon, lbGhThanhTien, soLonConLai, soThungConLai));
    }

    public void hienThiGioHang_delete() {
        dtmGioHang = (DefaultTableModel) tbBhGioHang.getModel();
        dtmGioHang.setRowCount(0);
        for (GioHangViewModel o : listGiohang) {
            dtmGioHang.addRow(new Object[]{o.getMa(), o.getTen(), o.getSoLuongThung(), o.getSoLuongLon(),
                o.getThanhTien(), o.getSoLonConLai(), o.getSoThungConLai()});
        }
    }

    public void hienThiGioHang() {
        dataGioHang();
        dtmGioHang = (DefaultTableModel) tbBhGioHang.getModel();
        dtmGioHang.setRowCount(0);
        for (GioHangViewModel o : listGiohang) {
            dtmGioHang.addRow(new Object[]{o.getMa(), o.getTen(), o.getSoLuongThung() + "Thùng", o.getSoLuongLon() + "Lon", o.getThanhTien() + "VND", o.getSoLonConLai(), o.getSoThungConLai()});
        }
    }

    public void hienThiGioHangClick(List<LsHoaDonChiTietViewModel> list) {

        dtmGioHang = (DefaultTableModel) tbBhGioHang.getModel();
        dtmGioHang.setRowCount(0);
        for (LsHoaDonChiTietViewModel o : list) {
            dtmGioHang.addRow(new Object[]{o.getMasp(), o.getTenSp(), o.getSoThungMua() + "Thùng",
                o.getSoLonMua() + "Lon", o.getThanhTien() + "VND", o.getSoLonKho(), o.getSoThungKho(), o.getSoLonMOiThung(), o.getHinhAnh()});
        }
    }

    private void hienThiLsChiTietHd(List<LsHoaDonChiTietViewModel> list) {
        dtmLsCtHoaDon = (DefaultTableModel) tbLsChiTietHoaDon.getModel();
        dtmLsCtHoaDon.setRowCount(0);
        for (LsHoaDonChiTietViewModel o : list) {
            dtmLsCtHoaDon.addRow(o.dataRow());
        }
    }

    private void hienThiListThongke(List<ThongKeViewModel> list) {
        dtmThongKe = (DefaultTableModel) TbThongKe.getModel();
        dtmThongKe.setRowCount(0);
        for (ThongKeViewModel o : list) {
            dtmThongKe.addRow(o.dataRow());
        }
    }

    public void hienThiGioHangBarcode() {
        dataGioHangBarCode();
        dtmGioHang = (DefaultTableModel) tbBhGioHang.getModel();
        dtmGioHang.setRowCount(0);
        for (GioHangViewModel o : listGiohang) {
            dtmGioHang.addRow(new Object[]{o.getMa(), o.getTen(), o.getSoLuongThung() + "Thùng", o.getSoLuongLon() + "Lon",
                o.getThanhTien() + "VND", o.getSoLonConLai(), o.getSoThungConLai()});
        }
    }

    public void hienThi(List<SanPhamViewModel> listSp) {
        dtm = (DefaultTableModel) tbQlHienThiSp.getModel();
        dtm.setRowCount(0);
        for (SanPhamViewModel o : listSp) {
            dtm.addRow(o.dataRow());
        }
    }

    public void cbbAll() {
        cbbQlXuatXu();
        cbbQlThuongHieu();
        cbbQlTheTich();
        cbbQlNongDoCon();
    }

    public void cbbQlXuatXu() {
        cbbQlXuatXu.removeAllItems();
        XuatXuService s = new XuatXuImpl();
        cbbXuatXu = (DefaultComboBoxModel) cbbQlXuatXu.getModel();
        var o = s.getList();
        for (XuatXuViewModel h : o) {
            cbbXuatXu.addElement(h.getTenQuocGia());
        }
    }

    public void listHoaDonCho() {
        listHoaDonCho = vcs.listHoaDonCho();
        dtmHoaDonCho = (DefaultTableModel) tbBhHoaDonCho.getModel();
        dtmHoaDonCho.setRowCount(0);
        for (HoaDonChoViewModel o : listHoaDonCho) {
            if (o.getTrangThai() == 1) {
                dtmHoaDonCho.addRow(new Object[]{"HD" + o.getMaHoaDon(), "VC" + o.getMaVanChuyen(),
                    o.getThoiGian(), o.getTongTien(), o.getTrangThai() == 1 ? "Ðang Vận Chuyển" : "Đã Hủy", sdtSoTienDachi});
            }

        }
    }

    public void cbbQlThuongHieu() {
        cbbQlThuongHieu.removeAllItems();
        ThuongHieuService s = new ThuongHieuImpl();
        cbbThuongHieu = (DefaultComboBoxModel) cbbQlThuongHieu.getModel();
        var o = s.getList();
        for (ThuongHieuViewModel h : o) {
            cbbThuongHieu.addElement(h.getTen());
        }
    }

    public void cbbQlTheTich() {
        cbbQlTheTich.removeAllItems();
        TheTichService s = new TheTichImpl();
        cbbTheTichs = (DefaultComboBoxModel) cbbQlTheTich.getModel();
        var o = s.getList();
        for (TheTichViewModel h : o) {
            cbbTheTichs.addElement(h.getTheTich());
        }

    }

    public void cbbQlNongDoCon() {
        cbbQlNdCon.removeAllItems();
        NongDoConService s = new NongDoConImpl();
        cbbNongDoCons = (DefaultComboBoxModel) cbbQlNdCon.getModel();
        var o = s.getList();
        for (NongDoConViewModel h : o) {
            cbbNongDoCons.addElement(h.getNongDoCon());
        }

    }

    public int checkChucVu(String chucVu) {
        if (chucVu.equalsIgnoreCase("Nhân viên")) {
            return 0;
        }
        return 1;
    }

    private TrangChu() {

    }

    public void clearFormQuanLyBia() {
        txtQlTenSp.setText("");
        cbbQlXuatXu.setSelectedIndex(0);
        cbbQlThuongHieu.setSelectedIndex(0);
        cbbQlTheTich.setSelectedIndex(0);
        cbbQlNdCon.setSelectedIndex(0);
        txtQlNsx.setText("");
        txtQlHsd.setText("");
        txtQlMaVach.setText("");
        jspSoLonMThung.setValue(0);
        txtQlGiaBanThung.setText("");
        txtQlGiaBanLon.setText("");
        jspQlSoLuong.setValue(0);
        cbbTrangThai.setSelectedIndex(0);
        txtQlTimKiem.setText("");
        cbbQlSxTrangThai.setSelectedIndex(0);
        cbbQlSapXepTheo.setSelectedIndex(0);
        lbQlLoadAnhSanPham.setIcon(null);

    }

    public void fillPhanTu(int row) {
        // Lấy dòng được chọn trong JTable

// Lấy giá trị của các ô trong dòng được chọn
        String qLmaSp = tbQlHienThiSp.getValueAt(row, 0).toString();
        String qLTenSp = tbQlHienThiSp.getValueAt(row, 1).toString();
        String qlXuatXu = tbQlHienThiSp.getValueAt(row, 2).toString();
        String qlThuongHieu = tbQlHienThiSp.getValueAt(row, 3).toString();
        String qlTheTich = tbQlHienThiSp.getValueAt(row, 4).toString();
        String qlNongDoCon = tbQlHienThiSp.getValueAt(row, 5).toString();
        String qlNsx = tbQlHienThiSp.getValueAt(row, 6).toString();
        String qlHsd = tbQlHienThiSp.getValueAt(row, 7).toString();
        String qlMaVach = tbQlHienThiSp.getValueAt(row, 8).toString();
        Object qlsoLonMoiThung = tbQlHienThiSp.getValueAt(row, 9);
        String qlgiaBanThung = tbQlHienThiSp.getValueAt(row, 10).toString();
        String qlgiaBanLon = tbQlHienThiSp.getValueAt(row, 11).toString();
        Object soLuongNhap = tbQlHienThiSp.getValueAt(row, 12);
        String qlTRangThai = tbQlHienThiSp.getValueAt(row, 14).toString();
        String hinhAnh = tbQlHienThiSp.getValueAt(row, 15).toString();
        if (hinhAnh.equalsIgnoreCase("No Avata")) {
            lbQlLoadAnhSanPham.setText("No Avata");
            lbQlLoadAnhSanPham.setIcon(null);
        } else {
            lbQlLoadAnhSanPham.setText("");
            showImg(hinhAnh, lbQlLoadAnhSanPham);
        }

// Fill giá trị vào các JTextField
        txtQlTenSp.setText(qLTenSp);
        cbbQlXuatXu.setSelectedItem(qlXuatXu);
        cbbQlThuongHieu.setSelectedItem(qlThuongHieu);
        cbbQlTheTich.setSelectedItem(qlTheTich);
        cbbQlNdCon.setSelectedItem(qlNongDoCon);
        txtQlNsx.setText(qlNsx);
        txtQlHsd.setText(qlHsd);
        txtQlMaVach.setText(qlMaVach);
        jspSoLonMThung.setValue(qlsoLonMoiThung);
        txtQlGiaBanLon.setText(qlgiaBanLon);
        txtQlGiaBanThung.setText(qlgiaBanThung);
        jspQlSoLuong.setValue(soLuongNhap);
        cbbTrangThai.setSelectedItem(qlTRangThai);

    }

    public void showImg(String sourceImg, JLabel image) {
        ImageIcon icon = new ImageIcon("C:\\Users\\Nham\\Documents\\FPT_Chuyen_Nganh\\DuanAgile\\QuanLyQuanDienThoai\\src\\image\\imageSanPham\\" + sourceImg);
        Image im = icon.getImage();
        ImageIcon icon1 = new ImageIcon(im.getScaledInstance(image.getWidth(), image.getHeight(), im.SCALE_SMOOTH));
        image.setIcon(icon1);
    }

    public void showImgNhanVien(String sourceImg, JLabel image) {
        ImageIcon icon = new ImageIcon("C:\\Users\\Nham\\Documents\\FPT_Chuyen_Nganh\\DuanAgile\\QuanLyQuanDienThoai\\src\\image\\imagenhanvien\\" + sourceImg);
        Image im = icon.getImage();
        ImageIcon icon1 = new ImageIcon(im.getScaledInstance(image.getWidth(), image.getHeight(), im.SCALE_SMOOTH));
        image.setIcon(icon1);
    }

    public void setMenuWhite() {
        menuBanHang.setForeground(Color.white);
        menuQuanLyKhachHang.setForeground(Color.white);
        menuQuanLyBia.setForeground(Color.white);
        menuLsThanhToan.setForeground(Color.white);
        menuThongKe.setForeground(Color.white);
        menuKhuyenMai.setForeground(Color.white);
        menuQuanLyKhachHang.setForeground(Color.white);
        menuQuanLyNhanVien.setForeground(Color.white);
    }

    public void setMenuClick(JLabel txtMenu) {
        setMenuWhite();
        txtMenu.setForeground(new Color(72, 228, 219));
    }

    public void setMenuEntered(JLabel txtMenu) {
        txtMenu.setBackground(new Color(100, 179, 244));
        txtMenu.setOpaque(true);
    }

    public void setMenuMouseExited(JLabel txtMenu) {
        txtMenu.setBackground(Color.white);
        txtMenu.setOpaque(false);
    }

    public void tinhSoTienDu() {
        try {
            txtSoTienKhachTra.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {

                    float soTienKhachTra = Float.valueOf(txtSoTienKhachTra.getText());
                    String soTienCanTraString = lblSoTienCanTra.getText();

                    DecimalFormat decimalFormat = new DecimalFormat("#,###.##");

                    float value;
                    try {
                        value = Float.parseFloat(decimalFormat.parse(soTienCanTraString).toString());
                        float soTienDu = soTienKhachTra - value;
                        String temp = bh.dinhDangTien(soTienDu);
                        lblTienTraLai.setText(temp);
                    } catch (Exception ex) {
                    }

                }
            });
        } catch (Exception e) {

        }
    }

    void changeGiamGiaDonHang() {
        try {

            txtBhSdt.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    if (txtBhSdt.getText().length() >= 10) {
                        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
                        float tth;
                        try {
                            tth = Float.parseFloat(decimalFormat.parse(lblBHTongTienHang.getText()).toString());
                            float giamGia = 0;

                            GiamGiaThanhToanService gh = new GiamGiaThanhToanImpl();
                            GiamGiaThanhToanViewModel vm = gh.searchBySdt(txtBhSdt.getText(), tth);
                            if (vm.getMaPhuongThucGiamGia() == null) {
                                lblBhTenKhachHang.setText("");
                                lblBhHangKhachHang.setText("");
                                lblSoTienCanTra.setText(lblBHTongTienHang.getText());
                                lblGiamGia.setText("0");
                                return;
                            }
                            if (vm.getTrangThai() != 1) {
                                lblBhHangKhachHang.setText("Hạng " + vm.getLoaiKhachHang());
                                lblBhTenKhachHang.setText(vm.getHoTen());
                                return;
                            }
                            if (vm.getMaPhuongThucGiamGia().equalsIgnoreCase("ggpt")) {
                                if (vm.getDonHangToiThieu() <= tth) {
                                    giamGia = tth * Float.valueOf(vm.getGiaTriKhuyenMai()) / 100;

                                }
                            } else if (vm.getMaPhuongThucGiamGia().equalsIgnoreCase("gggt")) {
                                if (vm.getDonHangToiThieu() <= tth) {
                                    giamGia = Float.valueOf(vm.getGiaTriKhuyenMai());
                                }
                            }
                            float soTienCanTra = tth - giamGia;
                            String temp = bh.dinhDangTien(soTienCanTra);
                            lblGiamGia.setText(bh.dinhDangTien(giamGia));
                            lblSoTienCanTra.setText(temp);
                            lblBhHangKhachHang.setText("Hạng " + vm.getLoaiKhachHang());
                            lblBhTenKhachHang.setText(vm.getHoTen());
                        } catch (ParseException ex) {
                        }
                        ;

                    } else {
                        lblGiamGia.setText("0");
                        lblBhHangKhachHang.setText("");
                        lblBhTenKhachHang.setText("");
                    }
                }
            });
        } catch (Exception e) {
        }

    }

    ////Khach Hang
    public void loadDataKH(List<KhachHangViewModel> list) {
        String column[] = {"Tên Khách Hàng", "Giới Tính", "Số Điện Thoại", "Địa Chỉ", "Loại Khách Hàng", "Số Tiền Đã Chi"};
        String sapXeps[] = {"Sắp Xếp Theo", "Số Điện Thoại", "Tên Khách Hàng", "Loại Khách Hàng", "Số Tiền Đã Chi"};
        cbbSapXepKhachHang.setModel(new DefaultComboBoxModel<>(sapXeps));
        CBBLoaiKhachHang();
        tableModelKh = new DefaultTableModel(column, 0);
        rdoNam.setSelected(true);
        tblBangKH.setModel(tableModelKh);
        txtHienThiSoLuongKH.setText("Số Lượng: " + list.size());
        hienThiKhachHang(list);
    }

    public void CBBLoaiKhachHang() {
        List<LoaiKhachHangViewModel> list = qLLoaiKhachHangService.getLoaiKhachHangService();
        cbbLoaiKhachHang.removeAllItems();
        for (LoaiKhachHangViewModel a : list) {
            cbbLoaiKhachHang.addItem(a);
        }
    }

    public StringBuilder builderKH() {
        StringBuilder builder = new StringBuilder();
        if (txtTenKH.getText().equals("")) {
            builder.append("Tên, ");
        }
        if (txtSDTKH.getText().equals("")) {
            builder.append("SÐT, ");
        }
        if (txtDiaChiKH.getText().equals("")) {
            builder.append("Địa Chỉ, ");
        }
        return builder;
    }

    public boolean checkValidateKH(String maKiemTra, String chuoiKiemTra) {
        Pattern pattern = Pattern.compile(maKiemTra);
        Matcher matcher = pattern.matcher(chuoiKiemTra);
        return matcher.matches();
    }

    public void AddKhachHang() {
        int thongBao = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Thêm Không?", "Thong Bao", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (thongBao == JOptionPane.NO_OPTION) {
        } else {
            StringBuilder builder = builderKH();
            if (builder.length() > 0) {
                builder.replace(builder.length() - 2, builder.length(), ".");
                JOptionPane.showMessageDialog(this, "Bạn Không Được Để Trống " + builder.toString(), "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!checkValidateKH("^[\\p{L}\\p{M} ]+$", txtTenKH.getText())) {
                JOptionPane.showMessageDialog(this, "Họ Tên Không Được Chứa Số Và Kí Tự Khác", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!checkValidateKH("^0\\d{9}$", txtSDTKH.getText())) {
                JOptionPane.showMessageDialog(this, "Số diện thoại phải đủ 10 số và bắt dầu 0!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            List<KhachHangViewModel> list = qLKhachHangService.getKhachHangService();
            if (list.stream().anyMatch(kh -> kh.getSoDienThoaiKH().equalsIgnoreCase(txtSDTKH.getText()))) {
                thongBaoMaKHLoi("SDT Khách Hàng Đã Tồn Tại!");
                return;
            }
            thongBaoSDTLoi.setText("");

            KhachHangViewModel kh = new KhachHangViewModel();
            long soTienDaChi = Long.parseLong(txtSoTienDaChi.getText());
            kh.setTenKH(txtTenKH.getText());
//            int loaiKhachHang = 5;
//            if (soTienDaChi >= 10000000) {
//                loaiKhachHang = 1;
//            } else if (soTienDaChi >= 5000000) {
//                loaiKhachHang = 2;
//            } else if (soTienDaChi >= 2500000) {
//                loaiKhachHang = 3;
//            }
            LoaiKhachHangViewModel hangViewModel = (LoaiKhachHangViewModel) cbbLoaiKhachHang.getSelectedItem();
            kh.setIdLoaiKhachHang(hangViewModel);

            byte gioiTinh = (byte) ((rdoNam.isSelected() == true) ? 1 : 0);
            kh.setGioiTinh(gioiTinh);
            kh.setSoDienThoaiKH(txtSDTKH.getText());
            kh.setDiaChiKH(txtDiaChiKH.getText());
            kh.setSoTienDaChi(soTienDaChi);
            Integer ketQua = qLKhachHangService.addKhachHangService(kh);
            if (ketQua != null) {
                JOptionPane.showMessageDialog(this, "Thêm Thành Công");
                xoaTrangBangKhachHang();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm Không Thành Công");
            }
            loadDataKH(qLKhachHangService.getKhachHangService());

        }
    }

    private void thongBaoMaKHLoi(String abc) {
        thongBaoSDTLoi.setText(abc);
        thongBaoSDTLoi.setForeground(Color.red);
        txtSDTKH.setText("");
    }
    static int index;

    public void UpdateKhachHang() {
        int thongBao = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Sửa Không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (thongBao == JOptionPane.NO_OPTION) {
        } else {
//            if (txtMaKH.getText().equals("")) {
//                thongBaoMaKHLoi("Không Ðê Trông Mã Khách Hàng");
//                return;
//            } else {
//                txtTTBaoLoiKH.setText("");
//            }
            StringBuilder builder = builderKH();
            if (builder.length() > 0) {
                builder.replace(builder.length() - 2, builder.length(), ".");
                JOptionPane.showMessageDialog(this, "Bạn Không Được Để Trống " + builder.toString(), "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!checkValidateKH("^[\\p{L}\\p{M} ]+$", txtTenKH.getText())) {
                JOptionPane.showMessageDialog(this, "Họ Tên Không Được Chứa Số Và Kí Tự Khác", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!checkValidateKH("^0[0-9]{9}$", txtSDTKH.getText())) {
                JOptionPane.showMessageDialog(this, "Số diện thoại phải đủ 10 số và bắt dầu 0!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            KhachHangViewModel kh = new KhachHangViewModel();
            kh.setTenKH(txtTenKH.getText());
            byte gioiTinh = (byte) ((rdoNam.isSelected() == true) ? 1 : 0);
            LoaiKhachHangViewModel lkhvm = (LoaiKhachHangViewModel) cbbLoaiKhachHang.getSelectedItem();
            kh.setIdLoaiKhachHang(lkhvm);
            kh.setGioiTinh(gioiTinh);
            kh.setSoDienThoaiKH(txtSDTKH.getText());
            kh.setDiaChiKH(txtDiaChiKH.getText());
            kh.setSoTienDaChi(Long.parseLong(txtSoTienDaChi.getText()));
            Integer ketQua = qLKhachHangService.updateKhachHangService(kh, tblBangKH.getValueAt(index, 2).toString());
            if (ketQua != null) {
                JOptionPane.showMessageDialog(this, "Sửa Thành Công");
                xoaTrangBangKhachHang();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa Không Thành Công");
            }
            loadDataKH(qLKhachHangService.getKhachHangService());

        }
    }

    public void xoaTrangBangKhachHang() {
        txtTenKH.setText("");
        rdoNam.setSelected(true);
        txtSDTKH.setText("");
        txtDiaChiKH.setText("");
        txtSoTienDaChi.setText("");
        cbbLoaiKhachHang.setSelectedIndex(0);
    }

    public void SearchKhachHang() {
        List<KhachHangViewModel> list = qLKhachHangService.searchKhachHangService(txtTimKiemKhachHang.getText().trim());
        tableModelKh.setRowCount(0);
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng!!!!!", "Thông báo", JOptionPane.QUESTION_MESSAGE);
        } else {
            hienThiKhachHang(list);
        }
    }

    public void sapXepKhachHang() {
        int i = cbbSapXepKhachHang.getSelectedIndex();
        switch (i) {
            case 1 -> {
                hienThiKhachHang(qLKhachHangService.sapXepKhachHangService("kh.sdt asc"));
            }
            case 2 -> {
                List<KhachHangViewModel> list = qLKhachHangService.getKhachHangService();
                Collections.sort(list, new CustomerSortingComparator());
                hienThiKhachHang(list);
            }
            case 3 -> {
                hienThiKhachHang(qLKhachHangService.sapXepKhachHangService("lkh.loai asc"));
            }
            case 4 -> {
                hienThiKhachHang(qLKhachHangService.sapXepKhachHangService("kh.sotiendachi desc"));
            }
        }

    }

    public void MouseClickedBangKH() {
        index = tblBangKH.getSelectedRow();
        txtTenKH.setText(tblBangKH.getValueAt(index, 0).toString());
        if (tblBangKH.getValueAt(index, 1).toString().equals("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtSDTKH.setText(tblBangKH.getValueAt(index, 2).toString());
        txtDiaChiKH.setText(tblBangKH.getValueAt(index, 3).toString());
        List<LoaiKhachHangViewModel> list = qLLoaiKhachHangService.getLoaiKhachHangService();
        int loaikh = Integer.parseInt(tblBangKH.getValueAt(index, 4).toString());
        cbbLoaiKhachHang.setSelectedIndex(list.size() - loaikh);
        txtSoTienDaChi.setText(tblBangKH.getValueAt(index, 5).toString().replace(".", ""));
    }

    public void hienThiKhachHang(List<KhachHangViewModel> list) {
        tableModelKh.setRowCount(0);
        for (KhachHangViewModel a : list) {
            String gioiTinh = (a.getGioiTinh() == 1) ? "Nam" : "Nữ";
            DecimalFormat df = new DecimalFormat("#,###");
            String soTienDaChi = df.format(a.getSoTienDaChi());
            tableModelKh.addRow(new Object[]{a.getTenKH(), gioiTinh, a.getSoDienThoaiKH(), a.getDiaChiKH(), a.getIdLoaiKhachHang().getLoai(), soTienDaChi, a.getIdKH()});
        }
    }
    // Khuyen mai

    public void load(ArrayList<KhuyenMaiViewModel> list) {
        DefaultTableModel dtm = (DefaultTableModel) tbHienThi.getModel();
        dtm.setRowCount(0);
        for (KhuyenMaiViewModel km : list) {
            dtm.addRow(km.dataRow());

        }

    }

    public void fillItemKhuyenMai() {
        int row = tbHienThi.getSelectedRow();
        String maKm = tbHienThi.getValueAt(row, 0).toString();
        String tenKm = tbHienThi.getValueAt(row, 1).toString();
        String GiaTriTT = tbHienThi.getValueAt(row, 4).toString().replace("VND", "").trim();
        String LoaiKh = tbHienThi.getValueAt(row, 2).toString();
        String PhuongThucKm = tbHienThi.getValueAt(row, 3).toString();
        String giaTien = tbHienThi.getValueAt(row, 5).toString().replace("%", "").trim();
        String GiaTriKm = giaTien.replace("VND", "");

        Object TrangThai = tbHienThi.getValueAt(row, 7);
        String MoTa = tbHienThi.getValueAt(row, 6).toString();

        txtQlMaKm.setText(maKm);
        txtQlTenKm.setText(tenKm);
        txtQlGiaTriTT.setText(GiaTriTT);
        cbbQlLoaiKh.setSelectedItem(LoaiKh);
        cbbQlPhuongThucKm.setSelectedItem(PhuongThucKm);
        txtQlGiaTriKm.setText(GiaTriKm);
        cbbQlTrangThaiKm.setSelectedItem(TrangThai);
        txtMoTaKm.setText(MoTa);

    }
    ////nhan vien

    private void LoadTable(ArrayList<NhanVienViewModel> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblHienThi.getModel();
        dtm.setRowCount(0);
        for (NhanVienViewModel nv : list) {
            dtm.addRow(nv.dataRow());
        }
    }

    private NhanVien getForm() {
        String ma = txtMaNv.getText();
        String ten = txtTen.getText();
        String ngaysinh = txtNgaySinh.getText();
        int trangThai = cbbNvTrangThai.getSelectedIndex();
        String sdt = txtSDT.getText();

        NhanVien p = new NhanVien();
        p.setMaNV(txtMaNv.getText());
        p.setTenNV(txtTen.getText());
        p.setDiaChi(txtDiaChi.getText());
        p.setNgaySinh(txtNgaySinh.getText());
        p.setSdt(txtSDT.getText());

        if (rdoNam.isSelected()) {
            p.setGioiTinh(0);
        } else {
            p.setGioiTinh(1);
        }
        if (trangThai == 0) {
            p.setTrangThai(1);

        } else if (trangThai == 1) {
            p.setTrangThai(0);
        }

        return p;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        cl1 = new Utilities.cl();
        menuBanHang = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        menuQuanLyKhachHang = new javax.swing.JLabel();
        menuQuanLyBia = new javax.swing.JLabel();
        menuLsThanhToan = new javax.swing.JLabel();
        menuThongKe = new javax.swing.JLabel();
        menuQuanLyNhanVien = new javax.swing.JLabel();
        txtManv = new javax.swing.JLabel();
        txtChucVu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btDangXuat = new javax.swing.JLabel();
        menuKhuyenMai = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jpBanHang = new javax.swing.JPanel();
        jpHoaDonChung = new javax.swing.JPanel();
        jpBanTaiQuay = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblMaNvBanHang = new javax.swing.JLabel();
        txtBhSdt = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        lblDateTime = new javax.swing.JLabel();
        lblBhTenKhachHang = new javax.swing.JLabel();
        lblBhHangKhachHang = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtaGhiChu = new javax.swing.JTextArea();
        btnBanTaiQuay = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        lblBHTongTienHang = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        lblSoTienCanTra = new javax.swing.JLabel();
        txtSoTienKhachTra = new javax.swing.JTextField();
        lblTienTraLai = new javax.swing.JLabel();
        lblThVnd = new javax.swing.JLabel();
        lblThVnd1 = new javax.swing.JLabel();
        lblThVnd2 = new javax.swing.JLabel();
        lblThVnd3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBhDanhSachSanPham = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBhHoaDonCho = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbBhGioHang = new javax.swing.JTable();
        lblBhHinhAnh = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        cbbTrangThaiDonHang = new javax.swing.JComboBox<>();
        jpQuanLyBia = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbQlHienThiSp = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtQlNsx = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbbQlXuatXu = new javax.swing.JComboBox<>();
        cbbQlThuongHieu = new javax.swing.JComboBox<>();
        cbbQlTheTich = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbQlNdCon = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtQlTenSp = new javax.swing.JTextField();
        txtQlHsd = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtQlMaVach = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jspSoLonMThung = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        txtQlGiaBanThung = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtQlGiaBanLon = new javax.swing.JTextField();
        jspQlSoLuong = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        tbnAddXuatXu = new javax.swing.JButton();
        btnAddThuongHieu = new javax.swing.JButton();
        btnAddTheTich = new javax.swing.JButton();
        btnAddNongDoCon = new javax.swing.JButton();
        btnOpenCam1 = new javax.swing.JButton();
        lbQlLoadAnhSanPham = new javax.swing.JLabel();
        btnQlThem = new javax.swing.JButton();
        btnQlSuaSp = new javax.swing.JButton();
        cbbQlSapXepTheo = new javax.swing.JComboBox<>();
        cbbQlSxTrangThai = new javax.swing.JComboBox<>();
        txtQlTimKiem = new javax.swing.JTextField();
        btnQlTimKiem = new javax.swing.JButton();
        jpQuanLyKhachHang = new javax.swing.JPanel();
        jpQuanLyKhachHang3 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txtDiaChiKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSoTienDaChi = new javax.swing.JTextField();
        txtSDTKH = new javax.swing.JTextField();
        txtHienThiSoLuongKH = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblBangKH = new javax.swing.JTable();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        cbbLoaiKhachHang = new javax.swing.JComboBox<>();
        txtTimKiemKhachHang = new javax.swing.JTextField();
        tbnTimKiemKhachHang = new javax.swing.JButton();
        cbbSapXepKhachHang = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        tbnThemKH = new javax.swing.JButton();
        tbnSuaKH = new javax.swing.JButton();
        tbnClearKH = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        tbnThemLoaiKhachHang = new javax.swing.JButton();
        thongBaoSDTLoi = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jpThongKe = new javax.swing.JPanel();
        lblImgThongke = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        lblTkHoaDonOnline = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        lblTkDoanhThu = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        lblTkHoaDonTaiQuay = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        lblTKSpGanHetHang = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        lblTkSpSapHetHan = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        lblTkSpHetHan = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        rdoTkTheoNgay = new javax.swing.JRadioButton();
        jLabel44 = new javax.swing.JLabel();
        rdoTkTheoThang = new javax.swing.JRadioButton();
        rdoTktheoNam = new javax.swing.JRadioButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        TbThongKe = new javax.swing.JTable();
        jpLichSuThanhToan = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbLsHoaDon = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbLsChiTietHoaDon = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        lblLsCtHinhAnh = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jpKhuyenMai = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbHienThi = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txtQlMaKm = new javax.swing.JTextField();
        txtQlTenKm = new javax.swing.JTextField();
        cbbQlLoaiKh = new javax.swing.JComboBox<>();
        txtQlGiaTriTT = new javax.swing.JTextField();
        cbbQlTrangThaiKm = new javax.swing.JComboBox<>();
        txtQlGiaTriKm = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        cbbQlPhuongThucKm = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtMoTaKm = new javax.swing.JTextArea();
        jLabel62 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        btnQlThemKm = new javax.swing.JButton();
        btnQlSuaKm = new javax.swing.JButton();
        txtQlTimKiemKhuyenMai = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        btnTrangThaiKm = new javax.swing.JComboBox<>();
        jpNhanVien = new javax.swing.JPanel();
        txtMaNv = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtAnh1 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblHienThi = new javax.swing.JTable();
        jLabel70 = new javax.swing.JLabel();
        rdnNvNu = new javax.swing.JRadioButton();
        rdoNvNam = new javax.swing.JRadioButton();
        jLabel63 = new javax.swing.JLabel();
        lblHinhAnhNhanVien = new javax.swing.JLabel();
        cbbNvTrangThai = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        cbbNvChucVu = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        txtNvTimKiem = new javax.swing.JTextField();
        btnNvTimKiem = new javax.swing.JButton();
        cbbNvSxTrangThai = new javax.swing.JComboBox<>();

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Microsoft.png"))); // NOI18N
        jMenu1.setText("Item");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh.png"))); // NOI18N
        jMenuItem1.setText("Refesh");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit.png"))); // NOI18N
        jMenuItem2.setText("Exit");
        jMenu1.add(jMenuItem2);

        jPopupMenu1.add(jMenu1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuBanHang.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        menuBanHang.setForeground(new java.awt.Color(255, 255, 255));
        menuBanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuBanHang.setText("Bán Hàng");
        menuBanHang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBanHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuBanHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuBanHangMouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/3.png"))); // NOI18N
        jLabel5.setText(" ");

        jLabel6.setFont(new java.awt.Font("Source Sans Pro Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quản Lý Bán Bia Nhóm 4");

        menuQuanLyKhachHang.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        menuQuanLyKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        menuQuanLyKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuQuanLyKhachHang.setText("Quản Lý Khách Hàng");
        menuQuanLyKhachHang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuQuanLyKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuQuanLyKhachHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuQuanLyKhachHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuQuanLyKhachHangMouseExited(evt);
            }
        });

        menuQuanLyBia.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        menuQuanLyBia.setForeground(new java.awt.Color(255, 255, 255));
        menuQuanLyBia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuQuanLyBia.setText("Quản Lý Bia");
        menuQuanLyBia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuQuanLyBia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuQuanLyBiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuQuanLyBiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuQuanLyBiaMouseExited(evt);
            }
        });

        menuLsThanhToan.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        menuLsThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        menuLsThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuLsThanhToan.setText("Lịch Sử Thanh Toán");
        menuLsThanhToan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuLsThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLsThanhToanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuLsThanhToanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuLsThanhToanMouseExited(evt);
            }
        });

        menuThongKe.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        menuThongKe.setForeground(new java.awt.Color(255, 255, 255));
        menuThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuThongKe.setText("Thống Kê");
        menuThongKe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuThongKeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuThongKeMouseExited(evt);
            }
        });

        menuQuanLyNhanVien.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        menuQuanLyNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        menuQuanLyNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuQuanLyNhanVien.setText("Quản Lý Nhân Viên");
        menuQuanLyNhanVien.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuQuanLyNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuQuanLyNhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuQuanLyNhanVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuQuanLyNhanVienMouseExited(evt);
            }
        });

        txtManv.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtManv.setForeground(new java.awt.Color(255, 255, 0));
        txtManv.setText(" ");

        txtChucVu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtChucVu.setForeground(new java.awt.Color(255, 255, 0));
        txtChucVu.setText(" ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("NV :");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("Chức Vụ: ");

        btDangXuat.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btDangXuat.setText("Đăng Xuất");
        btDangXuat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDangXuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDangXuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btDangXuatMouseExited(evt);
            }
        });

        menuKhuyenMai.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        menuKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        menuKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuKhuyenMai.setText("Khuyến Mãi");
        menuKhuyenMai.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuKhuyenMaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuKhuyenMaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuKhuyenMaiMouseExited(evt);
            }
        });

        javax.swing.GroupLayout cl1Layout = new javax.swing.GroupLayout(cl1);
        cl1.setLayout(cl1Layout);
        cl1Layout.setHorizontalGroup(
            cl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuQuanLyBia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuQuanLyNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cl1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(24, 24, 24))
            .addComponent(menuQuanLyKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(cl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(cl1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cl1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtManv, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(menuLsThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cl1Layout.setVerticalGroup(
            cl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cl1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(cl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtManv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cl1Layout.createSequentialGroup()
                        .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(28, 28, 28)
                .addComponent(menuBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuQuanLyBia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuQuanLyKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuLsThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());

        jpBanHang.setBackground(new java.awt.Color(255, 255, 255));
        jpBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jpBanHangMouseReleased(evt);
            }
        });

        jpHoaDonChung.setBackground(new java.awt.Color(204, 204, 255));
        jpHoaDonChung.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpHoaDonChung.setLayout(new java.awt.CardLayout());

        jpBanTaiQuay.setBackground(new java.awt.Color(255, 204, 204));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel29.setText("Tổng Tiền Hàng");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel30.setText("Giảm Giá");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel31.setText("Số Tiền Cần Trả");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel32.setText("Số Tiền Khách Trả");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel33.setText("Tiền Trả Lại");

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel22.setText("Mã Nhân Viên");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel27.setText("Tên Khách Hàng");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel25.setText("Số Điện Thoại");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel26.setText("Thời Gian Tạo");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel28.setText("Hạng Khách Hàng");

        lblMaNvBanHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNvBanHang.setForeground(new java.awt.Color(255, 0, 0));
        lblMaNvBanHang.setText(" ");

        txtBhSdt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBhSdt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBhSdtMouseClicked(evt);
            }
        });
        txtBhSdt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBhSdtKeyReleased(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 153, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        jButton9.setText("Đăng Ký Khách Hàng");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        lblDateTime.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDateTime.setForeground(new java.awt.Color(255, 0, 51));
        lblDateTime.setText(" ");

        lblBhTenKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblBhTenKhachHang.setForeground(new java.awt.Color(0, 0, 255));
        lblBhTenKhachHang.setText(" ");

        lblBhHangKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBhHangKhachHang.setForeground(new java.awt.Color(255, 0, 0));
        lblBhHangKhachHang.setText(" ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel26))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMaNvBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBhSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBhTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBhHangKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel25))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(69, 69, 69))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblMaNvBanHang))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lblDateTime))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtBhSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblBhTenKhachHang))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblBhHangKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(16, 16, 16))
        );

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel34.setText("Ghi Chú");

        jtaGhiChu.setColumns(20);
        jtaGhiChu.setRows(5);
        jScrollPane5.setViewportView(jtaGhiChu);

        btnBanTaiQuay.setBackground(new java.awt.Color(0, 153, 153));
        btnBanTaiQuay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBanTaiQuay.setForeground(new java.awt.Color(255, 255, 255));
        btnBanTaiQuay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/barcode-scanner.png"))); // NOI18N
        btnBanTaiQuay.setText("Bán Tại Quầy");
        btnBanTaiQuay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanTaiQuayActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 102));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search.png"))); // NOI18N
        jButton8.setText("Bán Online");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        lblBHTongTienHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblBHTongTienHang.setText("0");

        lblGiamGia.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblGiamGia.setText("0");

        lblSoTienCanTra.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblSoTienCanTra.setText("0");

        txtSoTienKhachTra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSoTienKhachTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoTienKhachTraKeyReleased(evt);
            }
        });

        lblTienTraLai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTienTraLai.setText("0");

        lblThVnd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblThVnd.setText(" ");

        lblThVnd1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblThVnd1.setText(" ");

        lblThVnd2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblThVnd2.setText(" ");

        lblThVnd3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblThVnd3.setText(" ");

        javax.swing.GroupLayout jpBanTaiQuayLayout = new javax.swing.GroupLayout(jpBanTaiQuay);
        jpBanTaiQuay.setLayout(jpBanTaiQuayLayout);
        jpBanTaiQuayLayout.setHorizontalGroup(
            jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBanTaiQuayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBanTaiQuayLayout.createSequentialGroup()
                        .addComponent(btnBanTaiQuay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpBanTaiQuayLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBanTaiQuayLayout.createSequentialGroup()
                                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBanTaiQuayLayout.createSequentialGroup()
                                        .addComponent(lblTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblThVnd3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBanTaiQuayLayout.createSequentialGroup()
                                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpBanTaiQuayLayout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSoTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpBanTaiQuayLayout.createSequentialGroup()
                                        .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jpBanTaiQuayLayout.createSequentialGroup()
                                                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel30)
                                                    .addComponent(jLabel29))
                                                .addGap(31, 31, 31)
                                                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lblGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                                    .addComponent(lblBHTongTienHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(jpBanTaiQuayLayout.createSequentialGroup()
                                                .addComponent(jLabel31)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                                .addComponent(lblSoTienCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpBanTaiQuayLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblThVnd2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblThVnd1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jpBanTaiQuayLayout.createSequentialGroup()
                                                .addComponent(lblThVnd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGap(16, 16, 16)))))
                .addGap(8, 8, 8))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpBanTaiQuayLayout.setVerticalGroup(
            jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBanTaiQuayLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lblBHTongTienHang)
                    .addComponent(lblThVnd))
                .addGap(28, 28, 28)
                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(lblGiamGia)
                    .addComponent(lblThVnd1))
                .addGap(27, 27, 27)
                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lblSoTienCanTra)
                    .addComponent(lblThVnd2))
                .addGap(34, 34, 34)
                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtSoTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(lblTienTraLai)
                    .addComponent(lblThVnd3))
                .addGap(35, 35, 35)
                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jpBanTaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBanTaiQuay, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        jpHoaDonChung.add(jpBanTaiQuay, "cardBanTaiQuay");

        tbBhDanhSachSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbBhDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng Thùng", "Số Lượng Lon", "Số Lon Mỗi Thùng", "Đơn Giá Thùng", "Đơn Giá Lon", "Hình Ảnh", "Mã Vạch"
            }
        ));
        tbBhDanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBhDanhSachSanPhamMouseClicked(evt);
            }
        });
        tbBhDanhSachSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbBhDanhSachSanPhamKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbBhDanhSachSanPham);
        if (tbBhDanhSachSanPham.getColumnModel().getColumnCount() > 0) {
            tbBhDanhSachSanPham.getColumnModel().getColumn(0).setMinWidth(90);
            tbBhDanhSachSanPham.getColumnModel().getColumn(0).setPreferredWidth(90);
            tbBhDanhSachSanPham.getColumnModel().getColumn(0).setMaxWidth(90);
            tbBhDanhSachSanPham.getColumnModel().getColumn(7).setMinWidth(0);
            tbBhDanhSachSanPham.getColumnModel().getColumn(7).setPreferredWidth(0);
            tbBhDanhSachSanPham.getColumnModel().getColumn(7).setMaxWidth(0);
            tbBhDanhSachSanPham.getColumnModel().getColumn(8).setMinWidth(0);
            tbBhDanhSachSanPham.getColumnModel().getColumn(8).setPreferredWidth(0);
            tbBhDanhSachSanPham.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbBhHoaDonCho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã Vận Chuyển", "Thời Gian", "Tổng Tiền", "Trạng Thái", "sdt"
            }
        ));
        tbBhHoaDonCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBhHoaDonChoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbBhHoaDonCho);
        if (tbBhHoaDonCho.getColumnModel().getColumnCount() > 0) {
            tbBhHoaDonCho.getColumnModel().getColumn(5).setMinWidth(0);
            tbBhHoaDonCho.getColumnModel().getColumn(5).setPreferredWidth(0);
            tbBhHoaDonCho.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText(" Danh Sách Sản Phẩm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addContainerGap())
        );

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Giỏ Hàng ");

        tbBhGioHang.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tbBhGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên Sp", "Số Lượng Thùng", "Số Lượng Lon", "Thành Tiền", "Số Lon Còn Lại", "Số Thùng Còn Lại", "Solonmthung", "HInh Anh"
            }
        ));
        tbBhGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBhGioHangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbBhGioHang);
        if (tbBhGioHang.getColumnModel().getColumnCount() > 0) {
            tbBhGioHang.getColumnModel().getColumn(5).setMinWidth(0);
            tbBhGioHang.getColumnModel().getColumn(5).setPreferredWidth(0);
            tbBhGioHang.getColumnModel().getColumn(5).setMaxWidth(0);
            tbBhGioHang.getColumnModel().getColumn(6).setMinWidth(0);
            tbBhGioHang.getColumnModel().getColumn(6).setPreferredWidth(0);
            tbBhGioHang.getColumnModel().getColumn(6).setMaxWidth(0);
            tbBhGioHang.getColumnModel().getColumn(7).setMinWidth(0);
            tbBhGioHang.getColumnModel().getColumn(7).setPreferredWidth(0);
            tbBhGioHang.getColumnModel().getColumn(7).setMaxWidth(0);
            tbBhGioHang.getColumnModel().getColumn(8).setMinWidth(0);
            tbBhGioHang.getColumnModel().getColumn(8).setPreferredWidth(0);
            tbBhGioHang.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblBhHinhAnh.setBackground(new java.awt.Color(0, 0, 255));
        lblBhHinhAnh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBhHinhAnh.setText(" ");
        lblBhHinhAnh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/garbage.png"))); // NOI18N
        jButton1.setText("Xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("  Hóa Đơn Chờ");

        jButton3.setBackground(new java.awt.Color(51, 153, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit.png"))); // NOI18N
        jButton3.setText("Tạo Hóa Đơn");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/garbage.png"))); // NOI18N
        jButton4.setText("Sửa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 153, 153));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/barcode-scanner.png"))); // NOI18N
        jButton5.setText("Quét Mã");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton2.setBackground(new java.awt.Color(255, 255, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 153, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shopping.png"))); // NOI18N
        jButton6.setText("Thêm Vào Giỏ Hàng");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText(" Danh Sách Sản Phẩm");

        cbbTrangThaiDonHang.setBackground(new java.awt.Color(255, 153, 0));
        cbbTrangThaiDonHang.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        cbbTrangThaiDonHang.setForeground(new java.awt.Color(255, 255, 255));
        cbbTrangThaiDonHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Vận Chuyển", "Đã Giao", "Hủy Đơn" }));
        cbbTrangThaiDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiDonHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBanHangLayout = new javax.swing.GroupLayout(jpBanHang);
        jpBanHang.setLayout(jpBanHangLayout);
        jpBanHangLayout.setHorizontalGroup(
            jpBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBanHangLayout.createSequentialGroup()
                .addGroup(jpBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBanHangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpBanHangLayout.createSequentialGroup()
                        .addGroup(jpBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBanHangLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120)
                                .addComponent(jButton3)
                                .addGap(37, 37, 37))
                            .addGroup(jpBanHangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jpBanHangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jpBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpBanHangLayout.createSequentialGroup()
                                        .addComponent(cbbTrangThaiDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton5))
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)))
                        .addGroup(jpBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBhHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBanHangLayout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(2, 2, 2))))
                    .addComponent(jScrollPane2))
                .addComponent(jpHoaDonChung, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpBanHangLayout.setVerticalGroup(
            jpBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHoaDonChung, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jpBanHangLayout.createSequentialGroup()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBanHangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBanHangLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblBhHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTrangThaiDonHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jpBanHang, "cardBanHang");

        jpQuanLyBia.setBackground(new java.awt.Color(255, 255, 255));

        tbQlHienThiSp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sp", "Tên Sp", "Xuất Xứ", "Thương Hiệu", "Thể Tích", "Nồng Độ Cồn", "NSX", "HSD", "Mã Vạch Sp", "Số Lon Mỗi Thùng", "Giá Bán Thùng", "Giá Bán Lon", "Số Thùng", "Số Lon", "Trạng Thái", "Ảnh"
            }
        ));
        tbQlHienThiSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbQlHienThiSpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbQlHienThiSp);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nhập Thông Tin Sản Phẩm");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tên Sp :");

        txtQlNsx.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQlNsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQlNsxActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Nồng D.Cồn :");

        cbbQlXuatXu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbQlXuatXu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbQlXuatXuMouseClicked(evt);
            }
        });

        cbbQlThuongHieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbQlThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbQlThuongHieuMouseClicked(evt);
            }
        });

        cbbQlTheTich.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbQlTheTich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbQlTheTichMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Thương Hiệu :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Xuất Xứ :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Thể Tích :");

        cbbQlNdCon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbQlNdCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbQlNdConMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Ngày Sản Xuất :");

        txtQlTenSp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQlTenSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQlTenSpActionPerformed(evt);
            }
        });

        txtQlHsd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQlHsd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQlHsdActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Ngày Hết Hạn :");

        txtQlMaVach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQlMaVach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtQlMaVachMouseEntered(evt);
            }
        });
        txtQlMaVach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQlMaVachActionPerformed(evt);
            }
        });
        txtQlMaVach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQlMaVachKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Mã Vạch :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Số Lon M.Thùng :");

        jspSoLonMThung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jspSoLonMThung.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jspSoLonMThungStateChanged(evt);
            }
        });
        jspSoLonMThung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jspSoLonMThungMouseClicked(evt);
            }
        });
        jspSoLonMThung.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jspSoLonMThungKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Giá Bán Thùng :");

        txtQlGiaBanThung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQlGiaBanThung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQlGiaBanThungActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Giá Bán Lon :");

        txtQlGiaBanLon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQlGiaBanLon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQlGiaBanLonActionPerformed(evt);
            }
        });

        jspQlSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Số Lượng Nhập :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Trạng Thái Sp :");

        cbbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Bán", "Ngừng Bán" }));

        tbnAddXuatXu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        tbnAddXuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnAddXuatXuActionPerformed(evt);
            }
        });

        btnAddThuongHieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        btnAddThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddThuongHieuActionPerformed(evt);
            }
        });

        btnAddTheTich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        btnAddTheTich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTheTichActionPerformed(evt);
            }
        });

        btnAddNongDoCon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        btnAddNongDoCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNongDoConActionPerformed(evt);
            }
        });

        btnOpenCam1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/footer-icon-two.png"))); // NOI18N
        btnOpenCam1.setPreferredSize(new java.awt.Dimension(28, 28));
        btnOpenCam1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenCam1ActionPerformed(evt);
            }
        });

        lbQlLoadAnhSanPham.setBackground(new java.awt.Color(0, 0, 255));
        lbQlLoadAnhSanPham.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbQlLoadAnhSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQlLoadAnhSanPham.setText("Thêm Ảnh");
        lbQlLoadAnhSanPham.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 51), null, null, new java.awt.Color(0, 0, 255)));
        lbQlLoadAnhSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQlLoadAnhSanPhamMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(txtQlTenSp))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbQlNdCon, 0, 208, Short.MAX_VALUE)
                            .addComponent(cbbQlThuongHieu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbQlXuatXu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbQlTheTich, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbnAddXuatXu)
                    .addComponent(btnAddThuongHieu)
                    .addComponent(btnAddTheTich)
                    .addComponent(btnAddNongDoCon))
                .addGap(92, 92, 92)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(131, 131, 131)
                                    .addComponent(txtQlGiaBanLon, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(22, 22, 22)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQlNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQlHsd, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jspSoLonMThung, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQlGiaBanThung, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQlMaVach, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOpenCam1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jspQlSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbQlLoadAnhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAddNongDoCon))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbnAddXuatXu, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbbQlXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10)))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbbQlThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel15)
                                        .addComponent(jspSoLonMThung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnAddThuongHieu))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbbQlTheTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11)
                                        .addComponent(txtQlGiaBanThung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16))
                                    .addComponent(btnAddTheTich, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cbbQlNdCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQlGiaBanLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQlNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel18)
                            .addComponent(jspQlSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtQlTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtQlHsd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13)))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtQlMaVach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14))
                                    .addComponent(btnOpenCam1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lbQlLoadAnhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        btnQlThem.setBackground(new java.awt.Color(204, 102, 0));
        btnQlThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQlThem.setForeground(new java.awt.Color(255, 255, 255));
        btnQlThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        btnQlThem.setText("Thêm SP");
        btnQlThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQlThemActionPerformed(evt);
            }
        });

        btnQlSuaSp.setBackground(new java.awt.Color(204, 102, 0));
        btnQlSuaSp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQlSuaSp.setForeground(new java.awt.Color(255, 255, 255));
        btnQlSuaSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Bookmark.png"))); // NOI18N
        btnQlSuaSp.setText("Sửa Sp");
        btnQlSuaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQlSuaSpActionPerformed(evt);
            }
        });

        cbbQlSapXepTheo.setBackground(new java.awt.Color(0, 102, 255));
        cbbQlSapXepTheo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbQlSapXepTheo.setForeground(new java.awt.Color(255, 255, 255));
        cbbQlSapXepTheo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp Xếp Theo", "Hạn Sử Dụng", "Số Lượng Trong Kho", "Giá Bán Theo Lon" }));
        cbbQlSapXepTheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbQlSapXepTheoActionPerformed(evt);
            }
        });

        cbbQlSxTrangThai.setBackground(new java.awt.Color(0, 204, 51));
        cbbQlSxTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbQlSxTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        cbbQlSxTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trạng Thái", "Đang Bán", "Ngừng Kinh Doanh" }));
        cbbQlSxTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbQlSxTrangThaiActionPerformed(evt);
            }
        });

        txtQlTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQlTimKiem.setPreferredSize(new java.awt.Dimension(64, 28));
        txtQlTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQlTimKiemKeyReleased(evt);
            }
        });

        btnQlTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search.png"))); // NOI18N
        btnQlTimKiem.setPreferredSize(new java.awt.Dimension(20, 20));
        btnQlTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQlTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpQuanLyBiaLayout = new javax.swing.GroupLayout(jpQuanLyBia);
        jpQuanLyBia.setLayout(jpQuanLyBiaLayout);
        jpQuanLyBiaLayout.setHorizontalGroup(
            jpQuanLyBiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpQuanLyBiaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnQlThem, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(btnQlSuaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(cbbQlSapXepTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(cbbQlSxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(txtQlTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQlTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jpQuanLyBiaLayout.setVerticalGroup(
            jpQuanLyBiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpQuanLyBiaLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpQuanLyBiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnQlSuaSp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQlTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQlTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpQuanLyBiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnQlThem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbQlSxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbQlSapXepTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jpQuanLyBia, "cardQuanLyBia");

        jpQuanLyKhachHang.setBackground(new java.awt.Color(255, 255, 255));

        jpQuanLyKhachHang3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel57.setText("Tên Khách Hàng:");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel58.setText("Số Điện Thoại:");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel59.setText("Giới Tính:");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setText("Địa Chỉ:");

        txtHienThiSoLuongKH.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtHienThiSoLuongKH.setForeground(new java.awt.Color(0, 0, 204));
        txtHienThiSoLuongKH.setText("Số Lượng: 0");

        tblBangKH.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        tblBangKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBangKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangKHMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblBangKH);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setText("Loại Khách Hàng:");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setText(" Số Tiền Đã Chi:");

        cbbLoaiKhachHang.setBackground(new java.awt.Color(255, 204, 204));

        txtTimKiemKhachHang.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtTimKiemKhachHang.setForeground(new java.awt.Color(51, 0, 51));
        txtTimKiemKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập dữ liệu cần tìm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12), new java.awt.Color(0, 204, 204))); // NOI18N

        tbnTimKiemKhachHang.setBackground(new java.awt.Color(0, 204, 51));
        tbnTimKiemKhachHang.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        tbnTimKiemKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        tbnTimKiemKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search.png"))); // NOI18N
        tbnTimKiemKhachHang.setText("Search");
        tbnTimKiemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnTimKiemKhachHangActionPerformed(evt);
            }
        });

        cbbSapXepKhachHang.setBackground(new java.awt.Color(255, 153, 51));
        cbbSapXepKhachHang.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        cbbSapXepKhachHang.setForeground(new java.awt.Color(0, 153, 153));
        cbbSapXepKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSapXepKhachHangActionPerformed(evt);
            }
        });

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        tbnThemKH.setBackground(new java.awt.Color(0, 102, 255));
        tbnThemKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbnThemKH.setForeground(new java.awt.Color(255, 255, 255));
        tbnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        tbnThemKH.setText("Add");
        tbnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnThemKHActionPerformed(evt);
            }
        });

        tbnSuaKH.setBackground(new java.awt.Color(0, 51, 255));
        tbnSuaKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbnSuaKH.setForeground(new java.awt.Color(255, 255, 255));
        tbnSuaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit.png"))); // NOI18N
        tbnSuaKH.setText("Update");
        tbnSuaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSuaKHActionPerformed(evt);
            }
        });

        tbnClearKH.setBackground(new java.awt.Color(0, 102, 255));
        tbnClearKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbnClearKH.setForeground(new java.awt.Color(255, 255, 255));
        tbnClearKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh.png"))); // NOI18N
        tbnClearKH.setText("Refesh");
        tbnClearKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnClearKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(tbnSuaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(tbnClearKH, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnClearKH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnSuaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        tbnThemLoaiKhachHang.setBackground(new java.awt.Color(0, 204, 51));
        tbnThemLoaiKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        tbnThemLoaiKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnThemLoaiKhachHangActionPerformed(evt);
            }
        });

        thongBaoSDTLoi.setForeground(new java.awt.Color(255, 0, 0));

        rdoNam.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        rdoNu.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        rdoNu.setText("Nữ");

        javax.swing.GroupLayout jpQuanLyKhachHang3Layout = new javax.swing.GroupLayout(jpQuanLyKhachHang3);
        jpQuanLyKhachHang3.setLayout(jpQuanLyKhachHang3Layout);
        jpQuanLyKhachHang3Layout.setHorizontalGroup(
            jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpQuanLyKhachHang3Layout.createSequentialGroup()
                .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpQuanLyKhachHang3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(txtTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(tbnTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbSapXepKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216))
                    .addGroup(jpQuanLyKhachHang3Layout.createSequentialGroup()
                        .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpQuanLyKhachHang3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpQuanLyKhachHang3Layout.createSequentialGroup()
                                        .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel57)
                                            .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(45, 45, 45)
                                        .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtTenKH)
                                                .addGroup(jpQuanLyKhachHang3Layout.createSequentialGroup()
                                                    .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(thongBaoSDTLoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(jpQuanLyKhachHang3Layout.createSequentialGroup()
                                                .addComponent(rdoNu)
                                                .addGap(91, 91, 91)
                                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpQuanLyKhachHang3Layout.createSequentialGroup()
                                                .addGap(203, 203, 203)
                                                .addComponent(jLabel60)
                                                .addGap(67, 67, 67))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpQuanLyKhachHang3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel46)
                                                    .addComponent(jLabel45))))
                                        .addGap(18, 18, 18)
                                        .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDiaChiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jpQuanLyKhachHang3Layout.createSequentialGroup()
                                                .addComponent(cbbLoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tbnThemLoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtSoTienDaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtHienThiSoLuongKH, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpQuanLyKhachHang3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 151, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpQuanLyKhachHang3Layout.setVerticalGroup(
            jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpQuanLyKhachHang3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtHienThiSoLuongKH)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbSapXepKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpQuanLyKhachHang3Layout.createSequentialGroup()
                        .addComponent(tbnTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(jpQuanLyKhachHang3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtTimKiemKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(txtDiaChiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel59)
                        .addComponent(rdoNu)
                        .addComponent(rdoNam)
                        .addComponent(jLabel45)
                        .addComponent(cbbLoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tbnThemLoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(thongBaoSDTLoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSDTKH)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpQuanLyKhachHang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(txtSoTienDaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout jpQuanLyKhachHangLayout = new javax.swing.GroupLayout(jpQuanLyKhachHang);
        jpQuanLyKhachHang.setLayout(jpQuanLyKhachHangLayout);
        jpQuanLyKhachHangLayout.setHorizontalGroup(
            jpQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1305, Short.MAX_VALUE)
            .addGroup(jpQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpQuanLyKhachHang3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpQuanLyKhachHangLayout.setVerticalGroup(
            jpQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
            .addGroup(jpQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpQuanLyKhachHangLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpQuanLyKhachHang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jpQuanLyKhachHang, "cardKhachHang");

        jpThongKe.setBackground(new java.awt.Color(255, 255, 255));
        jpThongKe.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jpThongKe.setPreferredSize(new java.awt.Dimension(1310, 800));
        jpThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jpThongKeMouseReleased(evt);
            }
        });

        lblImgThongke.setText(" ");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setText("Thống Kê");

        jPanel9.setBackground(new java.awt.Color(0, 204, 255));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel10.setBackground(new java.awt.Color(51, 102, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Hóa Đơn Online");

        lblTkHoaDonOnline.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTkHoaDonOnline.setForeground(new java.awt.Color(255, 255, 255));
        lblTkHoaDonOnline.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(lblTkHoaDonOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTkHoaDonOnline)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(0, 153, 102));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Doanh Thu ");

        lblTkDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTkDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        lblTkDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTkDoanhThu.setText("0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTkDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTkDoanhThu)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(153, 255, 153));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Hóa Đơn Tại Quầy");

        lblTkHoaDonTaiQuay.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTkHoaDonTaiQuay.setForeground(new java.awt.Color(255, 255, 255));
        lblTkHoaDonTaiQuay.setText("0");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(lblTkHoaDonTaiQuay, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTkHoaDonTaiQuay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 153, 0));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("SP Sắp Hết Hàng");

        lblTKSpGanHetHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTKSpGanHetHang.setForeground(new java.awt.Color(255, 255, 255));
        lblTKSpGanHetHang.setText("0");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTKSpGanHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTKSpGanHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(102, 102, 102));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("SP Sắp Hết Hạn");

        lblTkSpSapHetHan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTkSpSapHetHan.setForeground(new java.awt.Color(255, 255, 255));
        lblTkSpSapHetHan.setText("0");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(lblTkSpSapHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTkSpSapHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 0, 0));
        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("SP Hết Hạn");

        lblTkSpHetHan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTkSpHetHan.setForeground(new java.awt.Color(255, 255, 255));
        lblTkSpHetHan.setText("0");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(lblTkSpHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTkSpHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(246, 246, 246)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        jPanel19.setBackground(new java.awt.Color(255, 204, 204));
        jPanel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonGroup1.add(rdoTkTheoNgay);
        rdoTkTheoNgay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rdoTkTheoNgay.setText("Theo Ngày");
        rdoTkTheoNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTkTheoNgayActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel44.setText("Thống Kê Theo");

        buttonGroup1.add(rdoTkTheoThang);
        rdoTkTheoThang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rdoTkTheoThang.setText("Theo Tháng");
        rdoTkTheoThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTkTheoThangActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTktheoNam);
        rdoTktheoNam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rdoTktheoNam.setText("Theo Năm");
        rdoTktheoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTktheoNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(rdoTkTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259)
                .addComponent(rdoTkTheoThang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                .addComponent(rdoTktheoNam)
                .addGap(147, 147, 147))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoTkTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoTktheoNam)
                            .addComponent(rdoTkTheoThang))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TbThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Thùng Đã Bán", "Số Lon Đã Bán", "Doanh Thu", "Hinh Anh"
            }
        ));
        TbThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbThongKeMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TbThongKe);
        if (TbThongKe.getColumnModel().getColumnCount() > 0) {
            TbThongKe.getColumnModel().getColumn(5).setMinWidth(0);
            TbThongKe.getColumnModel().getColumn(5).setPreferredWidth(0);
            TbThongKe.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        javax.swing.GroupLayout jpThongKeLayout = new javax.swing.GroupLayout(jpThongKe);
        jpThongKe.setLayout(jpThongKeLayout);
        jpThongKeLayout.setHorizontalGroup(
            jpThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpThongKeLayout.createSequentialGroup()
                .addComponent(jScrollPane8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImgThongke, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpThongKeLayout.setVerticalGroup(
            jpThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpThongKeLayout.createSequentialGroup()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addComponent(lblImgThongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jpThongKe, "cardThongKe");

        jpLichSuThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        jpLichSuThanhToan.setPreferredSize(new java.awt.Dimension(1310, 800));
        jpLichSuThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jpLichSuThanhToanMouseReleased(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(204, 153, 0));

        tbLsHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbLsHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Hóa Đơn", "Mã Nhân Viên", "Thời Gian", "Tên Khách Hàng", "Tiền Hàng", "Giảm Giá", "Tổng Thanh Toán", "Tiền Trả Lại", "Trạng Thái"
            }
        ));
        tbLsHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLsHoaDonMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbLsHoaDon);
        if (tbLsHoaDon.getColumnModel().getColumnCount() > 0) {
            tbLsHoaDon.getColumnModel().getColumn(0).setMinWidth(90);
            tbLsHoaDon.getColumnModel().getColumn(0).setPreferredWidth(90);
            tbLsHoaDon.getColumnModel().getColumn(0).setMaxWidth(90);
            tbLsHoaDon.getColumnModel().getColumn(1).setMinWidth(110);
            tbLsHoaDon.getColumnModel().getColumn(1).setPreferredWidth(110);
            tbLsHoaDon.getColumnModel().getColumn(1).setMaxWidth(110);
            tbLsHoaDon.getColumnModel().getColumn(2).setMinWidth(180);
            tbLsHoaDon.getColumnModel().getColumn(2).setPreferredWidth(180);
            tbLsHoaDon.getColumnModel().getColumn(2).setMaxWidth(180);
        }

        jPanel7.setBackground(new java.awt.Color(255, 153, 153));

        tbLsChiTietHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbLsChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Hoá Đơn", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Thùng Mua", "Số Lon Mua", "Thành Tiền", "Hình Ảnh"
            }
        ));
        tbLsChiTietHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLsChiTietHoaDonMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbLsChiTietHoaDon);
        if (tbLsChiTietHoaDon.getColumnModel().getColumnCount() > 0) {
            tbLsChiTietHoaDon.getColumnModel().getColumn(0).setMinWidth(140);
            tbLsChiTietHoaDon.getColumnModel().getColumn(0).setPreferredWidth(140);
            tbLsChiTietHoaDon.getColumnModel().getColumn(0).setMaxWidth(140);
            tbLsChiTietHoaDon.getColumnModel().getColumn(1).setMinWidth(140);
            tbLsChiTietHoaDon.getColumnModel().getColumn(1).setPreferredWidth(140);
            tbLsChiTietHoaDon.getColumnModel().getColumn(1).setMaxWidth(140);
            tbLsChiTietHoaDon.getColumnModel().getColumn(2).setMinWidth(250);
            tbLsChiTietHoaDon.getColumnModel().getColumn(2).setPreferredWidth(250);
            tbLsChiTietHoaDon.getColumnModel().getColumn(2).setMaxWidth(250);
            tbLsChiTietHoaDon.getColumnModel().getColumn(6).setMinWidth(0);
            tbLsChiTietHoaDon.getColumnModel().getColumn(6).setPreferredWidth(0);
            tbLsChiTietHoaDon.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel35.setText("Chi Tiết Hóa Đơn");

        lblLsCtHinhAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLsCtHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLsCtHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        jPanel8.setBackground(new java.awt.Color(204, 153, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton7.setBackground(new java.awt.Color(0, 153, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh.png"))); // NOI18N
        jButton7.setText("Làm Mới");
        jButton7.setPreferredSize(new java.awt.Dimension(116, 35));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 204));
        jLabel36.setText("Lịch Sử Hóa Đơn");

        jButton10.setBackground(new java.awt.Color(255, 255, 102));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search.png"))); // NOI18N
        jButton10.setText("Search");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(0, 204, 204));
        jComboBox2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trạng Thái", "Đã Thanh Toán", "Đang Giao", "Đã Hủy" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton10)
                .addGap(75, 75, 75)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2)))))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane6)
                .addContainerGap())
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jpLichSuThanhToanLayout = new javax.swing.GroupLayout(jpLichSuThanhToan);
        jpLichSuThanhToan.setLayout(jpLichSuThanhToanLayout);
        jpLichSuThanhToanLayout.setHorizontalGroup(
            jpLichSuThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpLichSuThanhToanLayout.setVerticalGroup(
            jpLichSuThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLichSuThanhToanLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jpLichSuThanhToan, "cardLichSuThanhToan");

        jpKhuyenMai.setBackground(new java.awt.Color(204, 255, 204));

        tbHienThi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbHienThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KM", "Tên KM", "Loại Khách Hàng", "Phương Thức Khuyến Mại", "Đơn Hàng Tối Thiểu", "Giá Trị Khuyến Mãi", "Mô tả", "Trạng Thái"
            }
        ));
        tbHienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHienThiMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tbHienThi);

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel47.setText("Mã Khuyến Mãi");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel48.setText("Tên Khuyến Mãi");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel49.setText("Giá Trị Khuyến Mại");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel52.setText("Mô Tả");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel54.setText("Loại Khách Hàng Áp Dụng");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel55.setText("Giá Trị  Đơn Hàng tối thiểu");

        txtQlMaKm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQlMaKm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQlMaKmActionPerformed(evt);
            }
        });

        txtQlTenKm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbQlLoaiKh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbQlLoaiKh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        txtQlGiaTriTT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cbbQlTrangThaiKm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbQlTrangThaiKm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Áp Dụng", "Không Áp Dụng" }));

        txtQlGiaTriKm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel56.setText("Phương Thức Km");

        cbbQlPhuongThucKm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbQlPhuongThucKm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm Giá Theo Phần Trăm", "Giảm Giá Theo Giá Tiền" }));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 51, 255));
        jLabel61.setText("QUẢN LÝ KHUYẾN MÃI");

        txtMoTaKm.setColumns(20);
        txtMoTaKm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMoTaKm.setRows(5);
        jScrollPane10.setViewportView(txtMoTaKm);

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel62.setText("Trạng Thái");

        jPanel14.setBackground(new java.awt.Color(0, 204, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));

        btnQlThemKm.setBackground(new java.awt.Color(0, 204, 51));
        btnQlThemKm.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnQlThemKm.setForeground(new java.awt.Color(255, 255, 255));
        btnQlThemKm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        btnQlThemKm.setText("Thêm KM");
        btnQlThemKm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQlThemKmActionPerformed(evt);
            }
        });

        btnQlSuaKm.setBackground(new java.awt.Color(51, 51, 255));
        btnQlSuaKm.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnQlSuaKm.setForeground(new java.awt.Color(255, 255, 255));
        btnQlSuaKm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit.png"))); // NOI18N
        btnQlSuaKm.setText("Sửa KM");
        btnQlSuaKm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQlSuaKmActionPerformed(evt);
            }
        });

        txtQlTimKiemKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQlTimKiemKhuyenMaiActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 204, 51));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search.png"))); // NOI18N
        jButton11.setText("Tìm Kiếm");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        btnTrangThaiKm.setBackground(new java.awt.Color(0, 102, 204));
        btnTrangThaiKm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTrangThaiKm.setForeground(new java.awt.Color(255, 255, 255));
        btnTrangThaiKm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Áp Dụng", "Không Áp Dụng" }));
        btnTrangThaiKm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangThaiKmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnQlThemKm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(btnQlSuaKm)
                .addGap(104, 104, 104)
                .addComponent(txtQlTimKiemKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addGap(93, 93, 93)
                .addComponent(btnTrangThaiKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQlThemKm)
                            .addComponent(btnQlSuaKm))
                        .addGap(1, 1, 1))
                    .addComponent(txtQlTimKiemKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnTrangThaiKm, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton11, txtQlTimKiemKhuyenMai});

        javax.swing.GroupLayout jpKhuyenMaiLayout = new javax.swing.GroupLayout(jpKhuyenMai);
        jpKhuyenMai.setLayout(jpKhuyenMaiLayout);
        jpKhuyenMaiLayout.setHorizontalGroup(
            jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpKhuyenMaiLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpKhuyenMaiLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel53)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpKhuyenMaiLayout.createSequentialGroup()
                        .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpKhuyenMaiLayout.createSequentialGroup()
                                .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbbQlTrangThaiKm, javax.swing.GroupLayout.Alignment.LEADING, 0, 199, Short.MAX_VALUE)
                                    .addComponent(cbbQlLoaiKh, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpKhuyenMaiLayout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQlMaKm, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpKhuyenMaiLayout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQlTenKm, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(265, 265, 265)
                        .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpKhuyenMaiLayout.createSequentialGroup()
                                .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel52))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                                .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbQlPhuongThucKm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpKhuyenMaiLayout.createSequentialGroup()
                                .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel49)
                                    .addComponent(jLabel55))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtQlGiaTriTT, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(txtQlGiaTriKm))))
                        .addGap(48, 48, 48))
                    .addGroup(jpKhuyenMaiLayout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(372, 372, 372)
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jpKhuyenMaiLayout.createSequentialGroup()
                .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpKhuyenMaiLayout.setVerticalGroup(
            jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpKhuyenMaiLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel50)
                .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpKhuyenMaiLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQlMaKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47)
                            .addComponent(jLabel55)
                            .addComponent(txtQlGiaTriTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel53)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtQlGiaTriKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(txtQlTenKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpKhuyenMaiLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(cbbQlPhuongThucKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpKhuyenMaiLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(cbbQlLoaiKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpKhuyenMaiLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jpKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbQlTrangThaiKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52)
                            .addComponent(jLabel62))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpKhuyenMaiLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)))
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jpKhuyenMai, "cardKhuyenMai");

        jpNhanVien.setBackground(new java.awt.Color(255, 255, 204));

        txtMaNv.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel51.setText("Mã Nhân Viên");

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel64.setText("Tên Nhân Viên");

        txtTen.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel65.setText("Trạng Thái");

        txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel66.setText("Ngày Sinh :");

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel67.setText("Địa Chỉ");

        txtSDT.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel68.setText("Số Điện Thoại");

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        tblHienThi.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblHienThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Địa Chỉ", "Giới Tính", "Ngày Sinh", "Số Điện Thoại", "Trạng Thái", "Chức Vụ", "Ảnh"
            }
        ));
        tblHienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHienThiMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblHienThi);

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel70.setText("Giới Tính");

        buttonGroup2.add(rdnNvNu);
        rdnNvNu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rdnNvNu.setText("Nữ");

        buttonGroup2.add(rdoNvNam);
        rdoNvNam.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rdoNvNam.setText("Nam");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 204));
        jLabel63.setText("QUẢN LÝ NHÂN VIÊN");

        lblHinhAnhNhanVien.setBackground(new java.awt.Color(255, 204, 204));
        lblHinhAnhNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblHinhAnhNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhNhanVienMouseClicked(evt);
            }
        });

        cbbNvTrangThai.setBackground(new java.awt.Color(0, 102, 255));
        cbbNvTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbbNvTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        cbbNvTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Làm Việc", "Đã Nghỉ Việc" }));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel69.setText("Chức Vụ");

        cbbNvChucVu.setBackground(new java.awt.Color(255, 153, 153));
        cbbNvChucVu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbbNvChucVu.setForeground(new java.awt.Color(255, 255, 255));
        cbbNvChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên", "Quản Lý" }));

        jPanel16.setBackground(new java.awt.Color(204, 204, 204));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel16.setForeground(new java.awt.Color(255, 255, 255));

        btnSua.setBackground(new java.awt.Color(0, 204, 51));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit.png"))); // NOI18N
        btnSua.setText("Sửa Thông Tin ");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 153, 0));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh.png"))); // NOI18N
        jButton12.setText("Làm Mới");
        jButton12.setPreferredSize(new java.awt.Dimension(116, 35));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        btnNvTimKiem.setBackground(new java.awt.Color(255, 255, 102));
        btnNvTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNvTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search.png"))); // NOI18N
        btnNvTimKiem.setText("Search");
        btnNvTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNvTimKiemActionPerformed(evt);
            }
        });

        cbbNvSxTrangThai.setBackground(new java.awt.Color(0, 204, 204));
        cbbNvSxTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbNvSxTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        cbbNvSxTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trạng Thái", "Đang Làm Việc", "Ðã Nghỉ Việc" }));
        cbbNvSxTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNvSxTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(txtNvTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(btnNvTimKiem)
                .addGap(86, 86, 86)
                .addComponent(cbbNvSxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbbNvSxTrangThai, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNvTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btnNvTimKiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpNhanVienLayout = new javax.swing.GroupLayout(jpNhanVien);
        jpNhanVien.setLayout(jpNhanVienLayout);
        jpNhanVienLayout.setHorizontalGroup(
            jpNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAnh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(199, 199, 199))
            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jpNhanVienLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jpNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(jLabel64)
                    .addComponent(jLabel67)
                    .addComponent(jLabel70))
                .addGap(73, 73, 73)
                .addGroup(jpNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpNhanVienLayout.createSequentialGroup()
                        .addComponent(rdoNvNam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(rdnNvNu))
                    .addComponent(txtDiaChi)
                    .addComponent(txtTen)
                    .addComponent(txtMaNv))
                .addGap(132, 182, Short.MAX_VALUE)
                .addGroup(jpNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addComponent(jLabel68)
                    .addComponent(jLabel65)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(cbbNvTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbNvChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(lblHinhAnhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jpNhanVienLayout.createSequentialGroup()
                .addGap(480, 480, 480)
                .addComponent(jLabel63)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpNhanVienLayout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpNhanVienLayout.setVerticalGroup(
            jpNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addGroup(jpNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNhanVienLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jpNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(txtMaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jpNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jpNhanVienLayout.createSequentialGroup()
                                .addGroup(jpNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(117, 117, 117))
                            .addGroup(jpNhanVienLayout.createSequentialGroup()
                                .addGroup(jpNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel64)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jpNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel67)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel65)
                                    .addComponent(cbbNvTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)))
                        .addGroup(jpNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(rdoNvNam)
                            .addComponent(rdnNvNu)
                            .addComponent(jLabel69)
                            .addComponent(cbbNvChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpNhanVienLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblHinhAnhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnh1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jpNhanVien, "cardNhanVien");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1305, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, Short.MAX_VALUE)
            .addComponent(cl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBanHangMouseClicked
        setMenuClick(menuBanHang);
        clo.show(jPanel1, "cardBanHang");
    }//GEN-LAST:event_menuBanHangMouseClicked

    private void menuQuanLyKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyKhachHangMouseClicked
        setMenuClick(menuQuanLyKhachHang);
        clo.show(jPanel1, "cardKhachHang");
    }//GEN-LAST:event_menuQuanLyKhachHangMouseClicked

    private void menuBanHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBanHangMouseEntered
        setMenuEntered(menuBanHang);
    }//GEN-LAST:event_menuBanHangMouseEntered

    private void menuBanHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBanHangMouseExited
        setMenuMouseExited(menuBanHang);
    }//GEN-LAST:event_menuBanHangMouseExited

    private void menuQuanLyKhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyKhachHangMouseEntered
        setMenuEntered(menuQuanLyKhachHang);
    }//GEN-LAST:event_menuQuanLyKhachHangMouseEntered

    private void menuQuanLyKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyKhachHangMouseExited
        setMenuMouseExited(menuQuanLyKhachHang);
    }//GEN-LAST:event_menuQuanLyKhachHangMouseExited

    private void menuQuanLyBiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyBiaMouseClicked

        if (checkChucVu(txtChucVu.getText()) == 1) {
            setMenuClick(menuQuanLyBia);
            clo.show(jPanel1, "cardQuanLyBia");
        } else {
            JOptionPane.showMessageDialog(this, "Chỉ Có Quyền Quản Lý Mới Có Thể Truy Cập Menu " + menuQuanLyBia.getText());
        }

    }//GEN-LAST:event_menuQuanLyBiaMouseClicked

    private void menuQuanLyBiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyBiaMouseEntered

        setMenuEntered(menuQuanLyBia);
    }//GEN-LAST:event_menuQuanLyBiaMouseEntered

    private void menuQuanLyBiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyBiaMouseExited
        setMenuMouseExited(menuQuanLyBia);
    }//GEN-LAST:event_menuQuanLyBiaMouseExited

    private void menuLsThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLsThanhToanMouseClicked

        setMenuClick(menuLsThanhToan);
        clo.show(jPanel1, "cardLichSuThanhToan");
    }//GEN-LAST:event_menuLsThanhToanMouseClicked

    private void menuLsThanhToanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLsThanhToanMouseEntered
        setMenuEntered(menuLsThanhToan);
    }//GEN-LAST:event_menuLsThanhToanMouseEntered

    private void menuLsThanhToanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLsThanhToanMouseExited
        setMenuMouseExited(menuLsThanhToan);
    }//GEN-LAST:event_menuLsThanhToanMouseExited

    private void menuThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThongKeMouseClicked

        setMenuClick(menuThongKe);
        clo.show(jPanel1, "cardThongKe");

    }//GEN-LAST:event_menuThongKeMouseClicked

    private void menuThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThongKeMouseEntered
        setMenuEntered(menuThongKe);
    }//GEN-LAST:event_menuThongKeMouseEntered

    private void menuThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThongKeMouseExited
        setMenuMouseExited(menuThongKe);
    }//GEN-LAST:event_menuThongKeMouseExited

    private void menuQuanLyNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyNhanVienMouseClicked

        setMenuClick(menuQuanLyNhanVien);
        clo.show(jPanel1, "cardNhanVien");

    }//GEN-LAST:event_menuQuanLyNhanVienMouseClicked

    private void menuQuanLyNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyNhanVienMouseEntered
        setMenuEntered(menuQuanLyNhanVien);
    }//GEN-LAST:event_menuQuanLyNhanVienMouseEntered

    private void menuQuanLyNhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQuanLyNhanVienMouseExited
        setMenuMouseExited(menuQuanLyNhanVien);    }//GEN-LAST:event_menuQuanLyNhanVienMouseExited

    private void btDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDangXuatMouseClicked
        int check = JOptionPane.showConfirmDialog(this, "Dang Xuat ?");
        if (check == 0) {
            this.dispose();
            ViewSignIn v = new ViewSignIn();
            v.setVisible(true);

        }
    }//GEN-LAST:event_btDangXuatMouseClicked

    private void btDangXuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDangXuatMouseEntered

    }//GEN-LAST:event_btDangXuatMouseEntered

    private void btDangXuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDangXuatMouseExited

    }//GEN-LAST:event_btDangXuatMouseExited

    private void menuKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuKhuyenMaiMouseClicked

        setMenuClick(menuKhuyenMai);
        clo.show(jPanel1, "cardKhuyenMai");
    }//GEN-LAST:event_menuKhuyenMaiMouseClicked

    private void menuKhuyenMaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuKhuyenMaiMouseEntered
        setMenuEntered(menuKhuyenMai);

    }//GEN-LAST:event_menuKhuyenMaiMouseEntered

    private void menuKhuyenMaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuKhuyenMaiMouseExited
        setMenuMouseExited(menuKhuyenMai);

    }//GEN-LAST:event_menuKhuyenMaiMouseExited

    private void txtQlNsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQlNsxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQlNsxActionPerformed

    private void txtQlTenSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQlTenSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQlTenSpActionPerformed

    private void txtQlHsdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQlHsdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQlHsdActionPerformed

    private void txtQlMaVachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQlMaVachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQlMaVachActionPerformed

    private void txtQlGiaBanThungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQlGiaBanThungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQlGiaBanThungActionPerformed

    private void txtQlGiaBanLonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQlGiaBanLonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQlGiaBanLonActionPerformed

    private void tbnAddXuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnAddXuatXuActionPerformed
        new ViewXuatXu().setVisible(true);
    }//GEN-LAST:event_tbnAddXuatXuActionPerformed

    private void btnAddThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddThuongHieuActionPerformed
        new ViewThuongHieu().setVisible(true);
    }//GEN-LAST:event_btnAddThuongHieuActionPerformed

    private void btnAddTheTichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTheTichActionPerformed
        new ViewTheTich().setVisible(true);
    }//GEN-LAST:event_btnAddTheTichActionPerformed

    private void btnAddNongDoConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNongDoConActionPerformed
        new ViewNongDoCon().setVisible(true);
    }//GEN-LAST:event_btnAddNongDoConActionPerformed

    private void btnOpenCam1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenCam1ActionPerformed
        new quetQr().setVisible(true);

    }//GEN-LAST:event_btnOpenCam1ActionPerformed

    private void btnQlThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQlThemActionPerformed

        try {
            SanPhamViewModel n = new SanPhamViewModel();
            n.setTenSp(txtQlTenSp.getText());
            n.setXuatXu(cbbQlXuatXu.getSelectedItem().toString());
            n.setThuongHieu(cbbQlThuongHieu.getSelectedItem().toString());
            n.setTheTich(cbbQlTheTich.getSelectedItem().toString());
            n.setNongDoCon(cbbQlNdCon.getSelectedItem().toString());
            n.setNgaySanXuat(txtQlNsx.getText());
            n.setNgayHetHan(txtQlHsd.getText());
            n.setMaVach(txtQlMaVach.getText());
            n.setSoLonMoiThung((Integer) jspSoLonMThung.getValue());
            n.setGiaBanTheoThung(Float.valueOf(txtQlGiaBanThung.getText()));
            n.setGiaBanTheoLon(Float.valueOf(txtQlGiaBanLon.getText()));
            n.setSoLuongThung((Integer) jspQlSoLuong.getValue());
            if (cbbTrangThai.getSelectedIndex() == 0) {
                n.setTrangThai(1);
            } else {
                n.setTrangThai(0);
            }
            if (hinhanhSp == null) {
                n.setHinhAnh("No Avata");
            } else {
                n.setHinhAnh(hinhanhSp);
            }
            String kq = rsSp.Add(n);
            hienThi(rsSp.getList());
            clearFormQuanLyBia();
            JOptionPane.showMessageDialog(this, kq);
        } catch (Exception e) {
            String fail = String.valueOf(e);
            if (fail.contains("'UQ__sanPham__4CF9DC34F122C5BD'. Cannot insert duplicate key in object 'dbo.sanPham'")) {
                JOptionPane.showMessageDialog(this, "Không Thể Trùng Tên Sản Phẩm");
                return;

            }

        }

    }//GEN-LAST:event_btnQlThemActionPerformed

    private void btnQlSuaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQlSuaSpActionPerformed
        int row = tbQlHienThiSp.getSelectedRow();
        SanPhamViewModel n = rsSp.getList().get(row);
        n.setTenSp(txtQlTenSp.getText());
        n.setXuatXu(cbbQlXuatXu.getSelectedItem().toString());
        n.setThuongHieu(cbbQlThuongHieu.getSelectedItem().toString());
        n.setTheTich(cbbQlTheTich.getSelectedItem().toString());
        n.setNongDoCon(cbbQlNdCon.getSelectedItem().toString());
        n.setNgaySanXuat(txtQlNsx.getText());
        n.setNgayHetHan(txtQlHsd.getText());
        n.setMaVach(txtQlMaVach.getText());
        n.setSoLonMoiThung((Integer) jspSoLonMThung.getValue());
        n.setGiaBanTheoThung(Float.valueOf(txtQlGiaBanThung.getText()));
        n.setGiaBanTheoLon(Float.valueOf(txtQlGiaBanLon.getText()));
        n.setSoLuongThung((Integer) jspQlSoLuong.getValue());
        if (cbbTrangThai.getSelectedIndex() == 0) {
            n.setTrangThai(1);
        } else {
            n.setTrangThai(0);
        }

        if (hinhanhSp != null) {
            n.setHinhAnh(hinhanhSp);
        } else if (hinhanhSp == null) {
            n.setHinhAnh(n.getHinhAnh());

        }
        System.out.println(hinhanhSp);
        n.setMasp(n.getMasp());
        String kq = rsSp.update(n);
        hienThi(rsSp.getList());
        clearFormQuanLyBia();
        JOptionPane.showMessageDialog(this, kq);

    }//GEN-LAST:event_btnQlSuaSpActionPerformed

    private void cbbQlXuatXuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbQlXuatXuMouseClicked

        cbbQlXuatXu();
    }//GEN-LAST:event_cbbQlXuatXuMouseClicked

    private void cbbQlThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbQlThuongHieuMouseClicked

        cbbQlThuongHieu();

    }//GEN-LAST:event_cbbQlThuongHieuMouseClicked

    private void cbbQlTheTichMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbQlTheTichMouseClicked
        cbbQlTheTich();
    }//GEN-LAST:event_cbbQlTheTichMouseClicked

    private void cbbQlNdConMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbQlNdConMouseClicked

        cbbQlNdCon.removeAllItems();
        NongDoConService s = new NongDoConImpl();
        cbbNongDoCons = (DefaultComboBoxModel) cbbQlNdCon.getModel();
        var o = s.getList();
        for (NongDoConViewModel h : o) {
            cbbNongDoCons.addElement(h.getNongDoCon());
        }

    }//GEN-LAST:event_cbbQlNdConMouseClicked

    private void jspSoLonMThungKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jspSoLonMThungKeyReleased

    }//GEN-LAST:event_jspSoLonMThungKeyReleased

    private void txtQlMaVachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQlMaVachKeyReleased

    }//GEN-LAST:event_txtQlMaVachKeyReleased

    private void jspSoLonMThungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jspSoLonMThungMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jspSoLonMThungMouseClicked

    private void jspSoLonMThungStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jspSoLonMThungStateChanged

        jspSoLonMThung.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

            }
        });

    }//GEN-LAST:event_jspSoLonMThungStateChanged

    private void tbQlHienThiSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbQlHienThiSpMouseClicked
        int row = tbQlHienThiSp.getSelectedRow();
        fillPhanTu(row);
    }//GEN-LAST:event_tbQlHienThiSpMouseClicked

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(this, evt.getX() + 250, evt.getY());
        }
    }//GEN-LAST:event_jPanel2MouseReleased

    private void jpBanHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpBanHangMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(this, evt.getX() + 250, evt.getY());
        }
    }//GEN-LAST:event_jpBanHangMouseReleased

    private void jpThongKeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongKeMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(this, evt.getX() + 250, evt.getY());
        }
    }//GEN-LAST:event_jpThongKeMouseReleased

    private void cbbQlSapXepTheoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbQlSapXepTheoActionPerformed

        SanPhamService sv = new SanPhamImpl();
        int check = cbbQlSapXepTheo.getSelectedIndex();
        List<SanPhamViewModel> temp = rsSp.getList();
        if (check == 3) {
            sv.sapXep(temp, check);
        } else if (check == 2) {
            sv.sapXep(temp, check);
        }

        hienThi(temp);
    }//GEN-LAST:event_cbbQlSapXepTheoActionPerformed

    private void btnQlTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQlTimKiemActionPerformed

        List<SanPhamViewModel> l = rsSp.timKiemSanPham(txtQlTimKiem.getText());
        if (l.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy Sản Phẩm");
            return;
        }
        hienThi(l);
        fillPhanTu(0);
    }//GEN-LAST:event_btnQlTimKiemActionPerformed

    private void txtQlTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQlTimKiemKeyReleased

    }//GEN-LAST:event_txtQlTimKiemKeyReleased

    public void clearAllFormBanHang() {
        clearFormQuanLyBia();
        clearFormBanHang();
        hienThi(rsSp.getList());
        listGiohang.clear();
        hienThiGioHang_delete();

        hienThiSpBanHang(rsSp.getList());
        hienThiListLichSuHd(lshd.lists());
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        clearAllFormBanHang();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void lbQlLoadAnhSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQlLoadAnhSanPhamMouseClicked
        try {
            JFileChooser fc = new JFileChooser("C:\\Users\\Nham\\Documents\\FPT_Chuyen_Nganh\\DuanAgile\\QuanLyQuanDienThoai\\src\\image\\imageSanPham");
            fc.showOpenDialog(null);
            File file = fc.getSelectedFile();
            if (file == null) {
                return;
            }
            Image img = ImageIO.read(file);
            hinhanhSp = file.getName();
            lbQlLoadAnhSanPham.setText("");
            int width = lbQlLoadAnhSanPham.getWidth();
            int height = lbQlLoadAnhSanPham.getHeight();
            lbQlLoadAnhSanPham.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (IOException ex) {
            System.out.println("fails");
        }
    }//GEN-LAST:event_lbQlLoadAnhSanPhamMouseClicked

    private void cbbQlSxTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbQlSxTrangThaiActionPerformed
        int check = cbbQlSxTrangThai.getSelectedIndex();
        List<SanPhamViewModel> l = new ArrayList<>();
        if (check == 1) {
            l = rsSp.hienThiTrangThaiSp(check);
        } else {
            l = rsSp.hienThiTrangThaiSp(0);
        }
        hienThi(l);
    }//GEN-LAST:event_cbbQlSxTrangThaiActionPerformed

    private void txtQlMaVachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQlMaVachMouseEntered

    }//GEN-LAST:event_txtQlMaVachMouseEntered

    private void tbBhDanhSachSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBhDanhSachSanPhamMouseClicked
        int row = tbBhDanhSachSanPham.getSelectedRow();
        String hinhAnh = tbBhDanhSachSanPham.getValueAt(row, 7).toString();
        showImg(hinhAnh, lblBhHinhAnh);
    }//GEN-LAST:event_tbBhDanhSachSanPhamMouseClicked

    private void tbBhDanhSachSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbBhDanhSachSanPhamKeyReleased

    }//GEN-LAST:event_tbBhDanhSachSanPhamKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int row = tbBhGioHang.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chọn Để Xóa");
            return;
        }
        GioHangViewModel gh = listGiohang.get(row);
        listGiohang.remove(gh);
        hienThiGioHang_delete();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        int row = tbBhDanhSachSanPham.getSelectedRow();
        String maSp = tbBhDanhSachSanPham.getValueAt(row, 0).toString();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chọn Sản Phẩm Để Thêm");
            return;
        }
        for (GioHangViewModel o : listGiohang) {
            if (maSp.equalsIgnoreCase(o.getMa())) {
                JOptionPane.showMessageDialog(this, "Sản Phẩm Đã Có Trong Giỏ Hàng");
                return;
            }

        }
        String tenSp = tbBhDanhSachSanPham.getValueAt(row, 1).toString();
        String giaThung = tbBhDanhSachSanPham.getValueAt(row, 5).toString();
        String giaLon = tbBhDanhSachSanPham.getValueAt(row, 6).toString();
        String soLonMoiThung = tbBhDanhSachSanPham.getValueAt(row, 4).toString();
        String soLuongLon = tbBhDanhSachSanPham.getValueAt(row, 3).toString();
        String soLuongThung = tbBhDanhSachSanPham.getValueAt(row, 2).toString();
        new ViewThemGioHang(tenSp, giaThung, giaLon, soLonMoiThung, soLuongLon, soLuongThung).setVisible(true);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (listGiohang.size() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa Có Sản Phẩm Nào Trong Giỏ Hàng");
            return;
        }
        float tong = 0;
        for (GioHangViewModel o : listGiohang) {
            tong += Float.valueOf(o.getThanhTien());
        }
        DecimalFormat df = new DecimalFormat("#,###.##");
        float giamGia;
        try {
            giamGia = Float.parseFloat(df.parse(lblGiamGia.getText()).toString());
            float soTienCanTra = tong - giamGia;
            String dinhDangSoTienCanTra = bh.dinhDangTien(soTienCanTra);
            String dinhDangTongTien = bh.dinhDangTien(tong);
            lblBHTongTienHang.setText(dinhDangTongTien);
            lblSoTienCanTra.setText(dinhDangSoTienCanTra);
            lblThVnd.setText(" VND");
            lblThVnd1.setText("VND");
            lblThVnd2.setText("VND");
            lblThVnd3.setText("VND");
            dateTime();
        } catch (ParseException ex) {
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new ViewBanHangBarcode().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    public boolean checkHoaDon() {
        try {

            if (txtSoTienKhachTra.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Nhập Số Tiền Khách Thanh Toán ! ");
                return false;
            }
            DecimalFormat df = new DecimalFormat("#,###.##");
            float floatTongThanhToan = Float.parseFloat(df.parse(lblSoTienCanTra.getText()).toString());
            float tienKhachTra = Float.valueOf(txtSoTienKhachTra.getText());
            if (tienKhachTra < floatTongThanhToan) {
                JOptionPane.showMessageDialog(this, "Số Tiền Khách Thanh Toán Chưa Đủ");
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    private void btnBanTaiQuayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanTaiQuayActionPerformed

        if (checkHoaDon()) {
            taoHoaDon(1);
            hdct.insertHoaDonChiTiet(listGiohang);
            hdct.updateSlSanPham(listGiohang);
            listGiohang.clear();
            hienThiGioHang_delete();
            clearFormBanHang();
            hienThiSpBanHang(rsSp.getList());
            JOptionPane.showMessageDialog(this, "Thanh Toán Thành Công");
        }

    }//GEN-LAST:event_btnBanTaiQuayActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (checkHoaDon()) {
            taoHoaDon(2);
            hdct.insertHoaDonChiTiet(listGiohang);
            hdct.updateSlSanPham(listGiohang);
//            listGiohang.clear();
//            hienThiGioHang_delete();
//            clearFormBanHang();
//            hienThiSpBanHang(rsSp.getList());
            new ViewThongTinVanChuyen(txtBhSdt.getText()).setVisible(true);
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtSoTienKhachTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoTienKhachTraKeyReleased
        tinhSoTienDu();

    }//GEN-LAST:event_txtSoTienKhachTraKeyReleased

    private void cbbTrangThaiDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiDonHangActionPerformed

        int check = cbbTrangThaiDonHang.getSelectedIndex();
        int row = tbBhHoaDonCho.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chọn Hóa Đơn Để Cập Nhật");
            return;
        }
        String kq = "";
        String maVanChuyen = tbBhHoaDonCho.getValueAt(tbBhHoaDonCho.getSelectedRow(), 1).toString();
        String idHoaDon = tbBhHoaDonCho.getValueAt(tbBhHoaDonCho.getSelectedRow(), 0).toString();
        String sdt = tbBhHoaDonCho.getValueAt(tbBhHoaDonCho.getSelectedRow(), 5).toString();
        String tongTien = tbBhHoaDonCho.getValueAt(tbBhHoaDonCho.getSelectedRow(), 3).toString();
        IQLKhachHangRepository rs = new QLKhachHangRepositoty();

        String resultVanChuyen = maVanChuyen.substring(2);
        String resultHoaDon = idHoaDon.substring(2);
        if (check == 1) {
            int choice = JOptionPane.showConfirmDialog(this, "Đơn Hàng Này Đã Được Giao ? ", "Messeger", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                kq = vcs.updateTrangThaiVanChuyen(0, resultVanChuyen, "Đơn Hàng Đã Được Giao");
                vcs.updateTrangThaiHoaDon(1, resultHoaDon);
                rs.updateSoTienDaChi(sdt, Float.valueOf(tongTien));
                listLShD.clear();
                hienThiGioHangClick(listLShD);
                JOptionPane.showMessageDialog(this, kq);
            }
        } else if (check == 2) {
            int choice = JOptionPane.showConfirmDialog(this, "Đơn Hàng Này Đã Bị Hủy ? ", "Messeger", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                kq = vcs.updateTrangThaiVanChuyen(check, resultVanChuyen, "Đơn Hàng Đã Được Hủy");
                vcs.updateSlSanPham(listLShD);
                vcs.updateTrangThaiHoaDon(0, resultHoaDon);
                hienThiSpBanHang(rsSp.getList());
                listLShD.clear();
                hienThiGioHangClick(listLShD);
                JOptionPane.showMessageDialog(this, kq);
            }

        }
        cbbTrangThaiDonHang.setSelectedIndex(0);
        listHoaDonCho();

    }//GEN-LAST:event_cbbTrangThaiDonHangActionPerformed

    private void tbBhGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBhGioHangMouseClicked

        try {
            int row = tbBhGioHang.getSelectedRow();
            showImg(tbBhGioHang.getValueAt(row, 8).toString(), lblBhHinhAnh);
            System.out.println(tbBhGioHang.getValueAt(row, 5).toString());
            System.out.println(tbBhGioHang.getValueAt(row, 6).toString());
            System.out.println(tbBhGioHang.getValueAt(row, 7).toString());

        } catch (Exception e) {
            System.out.println("");
        }

    }//GEN-LAST:event_tbBhGioHangMouseClicked

    private void txtBhSdtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBhSdtKeyReleased

        changeGiamGiaDonHang();
    }//GEN-LAST:event_txtBhSdtKeyReleased

    private void jpLichSuThanhToanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpLichSuThanhToanMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jpLichSuThanhToanMouseReleased

    private void tbLsHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLsHoaDonMouseClicked
        int row = tbLsHoaDon.getSelectedRow();
        String idHoaDon = tbLsHoaDon.getValueAt(row, 0).toString();
        String result = idHoaDon.substring(2);
        LsHoaDonChiTietService sv = new LsHoaDonChiTietImpl();
        List<LsHoaDonChiTietViewModel> list = sv.lists(result);
        hienThiLsChiTietHd(list);
        lblLsCtHinhAnh.setIcon(null);

    }//GEN-LAST:event_tbLsHoaDonMouseClicked

    private void tbLsChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLsChiTietHoaDonMouseClicked
        int row = tbLsChiTietHoaDon.getSelectedRow();
        String hinhAnh = tbLsChiTietHoaDon.getValueAt(row, 6).toString();
        showImg(hinhAnh, lblLsCtHinhAnh);

    }//GEN-LAST:event_tbLsChiTietHoaDonMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        hienThiListLichSuHd(lshd.lists());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    String fomartMonney(String monney) {
        int temp = Integer.valueOf(monney);
        DecimalFormat stringFormat = new DecimalFormat("#,###.##");
        String formattedNumber = stringFormat.format(temp);
        return formattedNumber;
    }

    private void tbBhHoaDonChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBhHoaDonChoMouseClicked

        int row = tbBhHoaDonCho.getSelectedRow();
        String idHoaDon = tbBhHoaDonCho.getValueAt(row, 0).toString();
        String result = idHoaDon.substring(2);
        listLShD = sv.lists(result);
        hienThiGioHangClick(listLShD);

    }//GEN-LAST:event_tbBhHoaDonChoMouseClicked

    private void rdoTkTheoNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTkTheoNgayActionPerformed
        String hoaDonTaiQuay = tksv.kq("select count(idhoadon) as sohoadon from hoadon\n"
                + "WHERE CONVERT(DATE, thoigian, 103) = CONVERT(DATE, GETDATE(), 103)");
        String hoaDonOnline = tksv.kq("select count(hoadon.idhoadon) as sohoadon from hoadon join vanchuyen\n"
                + "on hoadon.idhoadon = vanchuyen.idhoadon\n"
                + "WHERE CONVERT(DATE, thoigian, 103) = CONVERT(DATE, GETDATE(), 103)\n"
                + "and hoadon.idhoadon = vanchuyen.idhoadon");

        String slSpSapHetHan = tksv.kq("SELECT COUNT(id)\n"
                + "FROM SanPham\n"
                + "WHERE DATEDIFF(day, GETDATE(), ngayhethan) < 10 and \n"
                + "DATEDIFF(day, GETDATE(), ngayhethan) > 0");
        String spHetHan = tksv.kq("SELECT COUNT(id)\n"
                + "FROM SanPham\n"
                + "WHERE DATEDIFF(day, GETDATE(), ngayhethan) <0");

        String tongDoanhThuNgay = tksv.kq("SELECT SUM(thanhtien) AS doanhthu\n"
                + "FROM chitiethoadon ct JOIN hoadon hd ON ct.idhoadon = hd.idhoadon where trangthai=1\n"
                + "and CONVERT(DATE, thoigian, 103) = CONVERT(DATE, GETDATE(), 103)");
        lblTkHoaDonOnline.setText(hoaDonOnline);
        lblTkHoaDonTaiQuay.setText(Integer.valueOf(hoaDonTaiQuay) - Integer.valueOf(hoaDonOnline) + "");
        lblTkSpSapHetHan.setText(slSpSapHetHan);
        lblTkSpHetHan.setText(spHetHan);
        lblTkDoanhThu.setText(fomartMonney(tongDoanhThuNgay) + " VND");
        checkThongKe();

    }//GEN-LAST:event_rdoTkTheoNgayActionPerformed

    private void TbThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbThongKeMouseClicked
        int row = TbThongKe.getSelectedRow();
        String img = TbThongKe.getValueAt(row, 5).toString();
        showImg(img, lblImgThongke);

    }//GEN-LAST:event_TbThongKeMouseClicked

    private void rdoTkTheoThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTkTheoThangActionPerformed

        String hoaDonTaiQuay = tksv.kq("select count(idhoadon) as sohoadon from hoadon\n"
                + "WHERE MONTH(CONVERT(DATETIME, thoigian, 103)) = MONTH(GETDATE()) \n"
                + "AND YEAR(CONVERT(DATETIME, thoigian, 103)) = YEAR(GETDATE())");
        String hoaDonOnline = tksv.kq("select count(hoadon.idhoadon) as sohoadon from hoadon join vanchuyen\n"
                + "on hoadon.idhoadon = vanchuyen.idhoadon\n"
                + "WHERE MONTH(CONVERT(DATETIME, thoigian, 103)) = MONTH(GETDATE()) \n"
                + "AND YEAR(CONVERT(DATETIME, thoigian, 103)) = YEAR(GETDATE())\n"
                + "and hoadon.idhoadon = vanchuyen.idhoadon");

        String slSpSapHetHan = tksv.kq("SELECT COUNT(id)\n"
                + "FROM SanPham\n"
                + "WHERE DATEDIFF(day, GETDATE(), ngayhethan) < 10 and \n"
                + "DATEDIFF(day, GETDATE(), ngayhethan) > 0");
        String spHetHan = tksv.kq("SELECT COUNT(id)\n"
                + "FROM SanPham\n"
                + "WHERE DATEDIFF(day, GETDATE(), ngayhethan) <0");
        String tongDoanhThu = tksv.kq("SELECT SUM(thanhtien) AS doanhthu\n"
                + "FROM chitiethoadon ct JOIN hoadon hd ON ct.idhoadon = hd.idhoadon where trangthai=1\n"
                + "and  MONTH(CONVERT(DATETIME, thoigian, 103)) = MONTH(GETDATE()) \n"
                + "AND YEAR(CONVERT(DATETIME, thoigian, 103)) = YEAR(GETDATE())");
        lblTkHoaDonOnline.setText(hoaDonOnline);
        lblTkHoaDonTaiQuay.setText(Integer.valueOf(hoaDonTaiQuay) - Integer.valueOf(hoaDonOnline) + "");
        lblTkSpSapHetHan.setText(slSpSapHetHan);
        lblTkSpHetHan.setText(spHetHan);
        lblTkDoanhThu.setText(fomartMonney(tongDoanhThu) + " VND");
        checkThongKe();
    }//GEN-LAST:event_rdoTkTheoThangActionPerformed

    private void rdoTktheoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTktheoNamActionPerformed
        String hoaDonTaiQuay = tksv.kq("select count(idhoadon) as sohoadon from hoadon\n"
                + "WHERE YEAR(CONVERT(DATETIME, thoigian, 103)) = YEAR(GETDATE())");
        String hoaDonOnline = tksv.kq("select count(hoadon.idhoadon) as sohoadon from hoadon join vanchuyen\n"
                + "on hoadon.idhoadon = vanchuyen.idhoadon\n"
                + "WHERE YEAR(CONVERT(DATETIME, thoigian, 103)) = YEAR(GETDATE())\n"
                + "and hoadon.idhoadon = vanchuyen.idhoadon");

        String slSpSapHetHan = tksv.kq("SELECT COUNT(id)\n"
                + "FROM SanPham\n"
                + "WHERE DATEDIFF(day, GETDATE(), ngayhethan) < 10 and \n"
                + "DATEDIFF(day, GETDATE(), ngayhethan) > 0");
        String spHetHan = tksv.kq("SELECT COUNT(id)\n"
                + "FROM SanPham\n"
                + "WHERE DATEDIFF(day, GETDATE(), ngayhethan) <0");

        String tongDoanhThu = tksv.kq("SELECT SUM(thanhtien) AS doanhthu\n"
                + "FROM chitiethoadon ct JOIN hoadon hd ON ct.idhoadon = hd.idhoadon where trangthai=1\n"
                + "and YEAR(CONVERT(DATETIME, thoigian, 103)) = YEAR(GETDATE()) ");
        lblTkHoaDonOnline.setText(hoaDonOnline);
        lblTkHoaDonTaiQuay.setText(Integer.valueOf(hoaDonTaiQuay) - Integer.valueOf(hoaDonOnline) + "");
        lblTkSpSapHetHan.setText(slSpSapHetHan);
        lblTkSpHetHan.setText(spHetHan);
        lblTkDoanhThu.setText(fomartMonney(tongDoanhThu) + " VND");
        checkThongKe();
    }//GEN-LAST:event_rdoTktheoNamActionPerformed

    private void tblBangKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangKHMouseClicked
        MouseClickedBangKH();
    }//GEN-LAST:event_tblBangKHMouseClicked

    private void tbnTimKiemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnTimKiemKhachHangActionPerformed
        SearchKhachHang();
    }//GEN-LAST:event_tbnTimKiemKhachHangActionPerformed

    private void cbbSapXepKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSapXepKhachHangActionPerformed
        sapXepKhachHang();
    }//GEN-LAST:event_cbbSapXepKhachHangActionPerformed

    private void tbnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnThemKHActionPerformed
        AddKhachHang();
    }//GEN-LAST:event_tbnThemKHActionPerformed

    private void tbnSuaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSuaKHActionPerformed
        UpdateKhachHang();
    }//GEN-LAST:event_tbnSuaKHActionPerformed

    private void tbnClearKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnClearKHActionPerformed
        xoaTrangBangKhachHang();
        loadDataKH(qLKhachHangService.getKhachHangService());
    }//GEN-LAST:event_tbnClearKHActionPerformed

    private void tbnThemLoaiKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnThemLoaiKhachHangActionPerformed
        new ViewLoaiKhachHang().setVisible(true);
    }//GEN-LAST:event_tbnThemLoaiKhachHangActionPerformed

    private void tbHienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHienThiMouseClicked
        int row = tbHienThi.getSelectedRow();
        fillItemKhuyenMai();
    }//GEN-LAST:event_tbHienThiMouseClicked

    private void txtQlMaKmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQlMaKmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQlMaKmActionPerformed

    private void btnQlThemKmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQlThemKmActionPerformed
        KhuyenMaiViewModel km = new KhuyenMaiViewModel();
        km.setMaKM(txtQlMaKm.getText());
        km.setTenKm(txtQlTenKm.getText());
        km.setIdLoaiKhachHang(cbbQlLoaiKh.getSelectedItem().toString());
        km.setIdPhuongThuc(cbbQlPhuongThucKm.getSelectedItem().toString());
        km.setDonHangToiThieu(Integer.parseInt(txtQlGiaTriTT.getText()));
        km.setGiaTriKhuyenMai(Float.parseFloat(txtQlGiaTriKm.getText()));
        km.setMoTa(txtMoTaKm.getText());

        if (cbbQlTrangThaiKm.getSelectedItem().equals("Đang Áp Dụng")) {
            km.setTrangThai(1);
        } else if (cbbQlTrangThaiKm.getSelectedItem().equals("Không Áp Dụng")) {
            km.setTrangThai(0);
        }
        String kq = ser.Add(km);
        JOptionPane.showMessageDialog(this, kq);
        load(ser.getList());
    }//GEN-LAST:event_btnQlThemKmActionPerformed

    private void btnQlSuaKmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQlSuaKmActionPerformed
        int row = tbHienThi.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn Dòng Muốn Sửa");
            return;
        }
        KhuyenMaiViewModel km = ser.getList().get(row);
        String makhuyenmai = km.getMaKM();
        km.setMaKM(txtQlMaKm.getText());
        km.setTenKm(txtQlTenKm.getText());
        km.setIdLoaiKhachHang(cbbQlLoaiKh.getSelectedItem().toString());
        km.setIdPhuongThuc(cbbQlPhuongThucKm.getSelectedItem().toString());
        km.setDonHangToiThieu(Integer.parseInt(txtQlGiaTriTT.getText()));
        km.setGiaTriKhuyenMai(Float.parseFloat(txtQlGiaTriKm.getText()));
        km.setMoTa(txtMoTaKm.getText());

        if (cbbQlTrangThaiKm.getSelectedItem().equals("Đang Áp Dụng")) {
            km.setTrangThai(1);
        } else if (cbbQlTrangThaiKm.getSelectedItem().equals("Không Áp Dụng")) {
            km.setTrangThai(0);
        }
        String kq = ser.Update(km, makhuyenmai);
        JOptionPane.showMessageDialog(this, kq);
        load(ser.getList());
    }//GEN-LAST:event_btnQlSuaKmActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        ArrayList<KhuyenMaiViewModel> list = ser.timKiemQlKhuyenMai(txtQlTimKiemKhuyenMai.getText());
        load(list);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void txtQlTimKiemKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQlTimKiemKhuyenMaiActionPerformed
    }//GEN-LAST:event_txtQlTimKiemKhuyenMaiActionPerformed

    private void btnTrangThaiKmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangThaiKmActionPerformed
        int row = (btnTrangThaiKm.getSelectedIndex() == 0) ? 1 : 0;
        ArrayList<KhuyenMaiViewModel> list = ser.trangThai(row);
        load(list);
    }//GEN-LAST:event_btnTrangThaiKmActionPerformed

    private void txtBhSdtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBhSdtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBhSdtMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        NhanVien s = this.getForm();
        if (s == null) {
            return;
        }

        int row = this.tblHienThi.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chon 1 dong de sua");
            return;
        }

        this.nvSv.update(s);
        JOptionPane.showMessageDialog(this, "sua thanh cong");
        this.LoadTable(nvSv.getList());
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblHienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHienThiMouseClicked
        int row = this.tblHienThi.getSelectedRow();
        if (row == -1) {
            return;
        }

        String ma = this.tblHienThi.getValueAt(row, 0).toString();
        String ten = this.tblHienThi.getValueAt(row, 1).toString();
        String diaChi = this.tblHienThi.getValueAt(row, 2).toString();
        String gioiTinh = this.tblHienThi.getValueAt(row, 3).toString();
        String ngaySinh = this.tblHienThi.getValueAt(row, 4).toString();
        String sdt = this.tblHienThi.getValueAt(row, 5).toString();
        String trangThai = this.tblHienThi.getValueAt(row, 6).toString();

        String hinhAnh = this.tblHienThi.getValueAt(row, 8).toString();
        if (hinhAnh != null) {
            showImgNhanVien(hinhAnh, lblHinhAnhNhanVien);
        }

        this.txtMaNv.setText(ma);

        this.txtTen.setText(ten);
        this.txtDiaChi.setText(diaChi);
        this.txtNgaySinh.setText(ngaySinh);
        this.txtSDT.setText(sdt);

        //        this.txtAnh.setText(hinhAnh);
        if (tblHienThi.getValueAt(row, 3).equals("Nam")) {
            this.rdoNam.setSelected(true);
        } else {
            this.rdoNu.setSelected(true);
        }
        if (tblHienThi.getValueAt(row, 3).equals("Nu")) {
            this.rdoNu.setSelected(true);
        } else {
            this.rdoNam.setSelected(true);
        }
    }//GEN-LAST:event_tblHienThiMouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        this.LoadTable(nvSv.getList());
    }//GEN-LAST:event_jButton12ActionPerformed

    private void btnNvTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNvTimKiemActionPerformed

        String manv = txtNvTimKiem.getText();
        NhanVien s = this.getForm();
        ArrayList<NhanVienViewModel> listSearch = nvSv.searchByNhanVien(manv);
        this.LoadTable(listSearch);

    }//GEN-LAST:event_btnNvTimKiemActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

    private void lblHinhAnhNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhNhanVienMouseClicked

        try {
            JFileChooser fc = new JFileChooser("C:\\Users\\Nham\\Documents\\FPT_Chuyen_Nganh\\DuanAgile\\QuanLyQuanDienThoai\\src\\image\\imagenhanvien");
            fc.showOpenDialog(null);
            File file = fc.getSelectedFile();
            if (file == null) {
                return;
            }
            Image img = ImageIO.read(file);
            hinhanhNhanVien = file.getName();
            lblHinhAnhNhanVien.setText("");
            int width = lblHinhAnhNhanVien.getWidth();
            int height = lblHinhAnhNhanVien.getHeight();
            lblHinhAnhNhanVien.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (IOException ex) {
            System.out.println("fails");
        }

    }//GEN-LAST:event_lblHinhAnhNhanVienMouseClicked

    private void cbbNvSxTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNvSxTrangThaiActionPerformed

        int tt = cbbNvSxTrangThai.getSelectedIndex();
        ArrayList<NhanVienViewModel> listSearch = new ArrayList<>();
        if (tt == 1) {
            listSearch = nvSv.searchByNhanVien(1);
        } else if (tt == 2) {
            listSearch = nvSv.searchByNhanVien(0);
        }
        NhanVien s = this.getForm();
        this.LoadTable(listSearch);

    }//GEN-LAST:event_cbbNvSxTrangThaiActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        new ViewDangKyKhachHang().setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbThongKe;
    private javax.swing.JLabel btDangXuat;
    private javax.swing.JButton btnAddNongDoCon;
    private javax.swing.JButton btnAddTheTich;
    private javax.swing.JButton btnAddThuongHieu;
    private javax.swing.JButton btnBanTaiQuay;
    private javax.swing.JButton btnNvTimKiem;
    private javax.swing.JButton btnOpenCam1;
    private javax.swing.JButton btnQlSuaKm;
    private javax.swing.JButton btnQlSuaSp;
    private javax.swing.JButton btnQlThem;
    private javax.swing.JButton btnQlThemKm;
    private javax.swing.JButton btnQlTimKiem;
    private javax.swing.JButton btnSua;
    private javax.swing.JComboBox<String> btnTrangThaiKm;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<Object> cbbLoaiKhachHang;
    private javax.swing.JComboBox<String> cbbNvChucVu;
    private javax.swing.JComboBox<String> cbbNvSxTrangThai;
    private javax.swing.JComboBox<String> cbbNvTrangThai;
    private javax.swing.JComboBox<String> cbbQlLoaiKh;
    private javax.swing.JComboBox<String> cbbQlNdCon;
    private javax.swing.JComboBox<String> cbbQlPhuongThucKm;
    private javax.swing.JComboBox<String> cbbQlSapXepTheo;
    private javax.swing.JComboBox<String> cbbQlSxTrangThai;
    private javax.swing.JComboBox<String> cbbQlTheTich;
    private javax.swing.JComboBox<String> cbbQlThuongHieu;
    private javax.swing.JComboBox<String> cbbQlTrangThaiKm;
    private javax.swing.JComboBox<String> cbbQlXuatXu;
    private javax.swing.JComboBox<String> cbbSapXepKhachHang;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JComboBox<String> cbbTrangThaiDonHang;
    private Utilities.cl cl1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel jpBanHang;
    private javax.swing.JPanel jpBanTaiQuay;
    private javax.swing.JPanel jpHoaDonChung;
    private javax.swing.JPanel jpKhuyenMai;
    private javax.swing.JPanel jpLichSuThanhToan;
    private javax.swing.JPanel jpNhanVien;
    private javax.swing.JPanel jpQuanLyBia;
    private javax.swing.JPanel jpQuanLyKhachHang;
    private javax.swing.JPanel jpQuanLyKhachHang3;
    private javax.swing.JPanel jpThongKe;
    private javax.swing.JSpinner jspQlSoLuong;
    private javax.swing.JSpinner jspSoLonMThung;
    private javax.swing.JTextArea jtaGhiChu;
    private javax.swing.JLabel lbQlLoadAnhSanPham;
    private javax.swing.JLabel lblBHTongTienHang;
    private javax.swing.JLabel lblBhHangKhachHang;
    private javax.swing.JLabel lblBhHinhAnh;
    private javax.swing.JLabel lblBhTenKhachHang;
    private javax.swing.JLabel lblDateTime;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblHinhAnhNhanVien;
    private javax.swing.JLabel lblImgThongke;
    private javax.swing.JLabel lblLsCtHinhAnh;
    private javax.swing.JLabel lblMaNvBanHang;
    private javax.swing.JLabel lblSoTienCanTra;
    private javax.swing.JLabel lblTKSpGanHetHang;
    private javax.swing.JLabel lblThVnd;
    private javax.swing.JLabel lblThVnd1;
    private javax.swing.JLabel lblThVnd2;
    private javax.swing.JLabel lblThVnd3;
    private javax.swing.JLabel lblTienTraLai;
    private javax.swing.JLabel lblTkDoanhThu;
    private javax.swing.JLabel lblTkHoaDonOnline;
    private javax.swing.JLabel lblTkHoaDonTaiQuay;
    private javax.swing.JLabel lblTkSpHetHan;
    private javax.swing.JLabel lblTkSpSapHetHan;
    private javax.swing.JLabel menuBanHang;
    private javax.swing.JLabel menuKhuyenMai;
    private javax.swing.JLabel menuLsThanhToan;
    private javax.swing.JLabel menuQuanLyBia;
    private javax.swing.JLabel menuQuanLyKhachHang;
    private javax.swing.JLabel menuQuanLyNhanVien;
    private javax.swing.JLabel menuThongKe;
    private javax.swing.JRadioButton rdnNvNu;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoNvNam;
    private javax.swing.JRadioButton rdoTkTheoNgay;
    private javax.swing.JRadioButton rdoTkTheoThang;
    private javax.swing.JRadioButton rdoTktheoNam;
    private javax.swing.JTable tbBhDanhSachSanPham;
    private javax.swing.JTable tbBhGioHang;
    private javax.swing.JTable tbBhHoaDonCho;
    private javax.swing.JTable tbHienThi;
    private javax.swing.JTable tbLsChiTietHoaDon;
    private javax.swing.JTable tbLsHoaDon;
    private javax.swing.JTable tbQlHienThiSp;
    private javax.swing.JTable tblBangKH;
    private javax.swing.JTable tblHienThi;
    private javax.swing.JButton tbnAddXuatXu;
    private javax.swing.JButton tbnClearKH;
    private javax.swing.JButton tbnSuaKH;
    private javax.swing.JButton tbnThemKH;
    private javax.swing.JButton tbnThemLoaiKhachHang;
    private javax.swing.JButton tbnTimKiemKhachHang;
    private javax.swing.JLabel thongBaoSDTLoi;
    private javax.swing.JLabel txtAnh1;
    private javax.swing.JTextField txtBhSdt;
    private javax.swing.JLabel txtChucVu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiaChiKH;
    private javax.swing.JLabel txtHienThiSoLuongKH;
    private javax.swing.JTextField txtMaNv;
    private javax.swing.JLabel txtManv;
    private javax.swing.JTextArea txtMoTaKm;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNvTimKiem;
    private javax.swing.JTextField txtQlGiaBanLon;
    private javax.swing.JTextField txtQlGiaBanThung;
    private javax.swing.JTextField txtQlGiaTriKm;
    private javax.swing.JTextField txtQlGiaTriTT;
    private javax.swing.JTextField txtQlHsd;
    private javax.swing.JTextField txtQlMaKm;
    private javax.swing.JTextField txtQlMaVach;
    private javax.swing.JTextField txtQlNsx;
    private javax.swing.JTextField txtQlTenKm;
    private javax.swing.JTextField txtQlTenSp;
    private javax.swing.JTextField txtQlTimKiem;
    private javax.swing.JTextField txtQlTimKiemKhuyenMai;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSDTKH;
    private javax.swing.JTextField txtSoTienDaChi;
    private javax.swing.JTextField txtSoTienKhachTra;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiemKhachHang;
    // End of variables declaration//GEN-END:variables
}
