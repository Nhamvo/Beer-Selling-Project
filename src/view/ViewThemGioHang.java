/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import viewmodels.GioHangViewModel;

/**
 *
 * @author Nham
 */
public class ViewThemGioHang extends javax.swing.JFrame {

    public static ViewThemGioHang Instance;

    public ViewThemGioHang(String tenSp, String giaThung, String giaLon, String soLonMoiThung, String soLuongLon, String soLuongThung) {
        initComponents();
        this.setLocationRelativeTo(null);
        lblSoLonMoiThung.setText(soLonMoiThung);
        lblTenSp.setText(tenSp);
        txtGiaLon.setText(giaLon);
        txtGiaThung.setText(giaThung);
        lblSoLuongLon.setText(soLuongLon);
        lblSoLuongThung.setText(soLuongThung);
        Instance = this;
        changeSoLon();
        changeSoThung();

    }

    public void soLuongCapNhat() {
        int soThungConLai = 0;
        int soLonConLai = 0;
        int soLonTrongKho = Integer.valueOf(lblSoLuongLon.getText());
        int soThungTrongKho = Integer.valueOf(lblSoLuongThung.getText());
        int soLonMThung = Integer.valueOf(lblSoLonMoiThung.getText());
        int soThungMua = Integer.valueOf(jspSoThung.getValue() + "");
        int soLonMua = Integer.valueOf(jspSoLon.getValue() + "");
        int temp = soLonTrongKho - soLonMua;
        if (temp < 0) {
            soLonConLai = soLonMThung + temp;
            soThungConLai = soThungTrongKho - 1 - soThungMua;
        } else if (temp >= 0) {
            soLonConLai = soLonTrongKho - soLonMua;
            soThungConLai = soThungTrongKho - soThungMua;
        }
        TrangChu.Instance.soLonConLai = soLonConLai + "";
        TrangChu.Instance.soThungConLai = soThungConLai + "";
    }

    public void changeSum() {
        String soThungString = jspSoThung.getValue() + "";
        int soThung = Integer.valueOf(soThungString);
        float giaThung = Float.valueOf(txtGiaThung.getText());
        String soLonString = jspSoLon.getValue() + "";
        int soLon = Integer.valueOf(soLonString);
        float giaLon = Float.valueOf(txtGiaLon.getText());
        float tong = 0;
        int soLonMThung = Integer.valueOf(lblSoLonMoiThung.getText());
        if (soLon < 0) {
            JOptionPane.showMessageDialog(this, "Số Lượng Không Hợp Lệ");
            jspSoLon.setValue(1);
            return;
        } else if (soThung < 0) {

            JOptionPane.showMessageDialog(this, "Số Lượng Không Hợp Lệ");
            jspSoThung.setValue(1);
            return;
        }

        if (soLon >= soLonMThung) {
            jspSoLon.setValue(0);
            jspSoThung.setValue(soThung + 1);

        }
        float soThungTrongKho = Float.valueOf(lblSoLuongThung.getText());
        if (soThung > soThungTrongKho) {
            JOptionPane.showMessageDialog(this, "Số Lượng Thùng Trong Kho Không Đủ");
            jspSoThung.setValue(soThung - 1);
            return;
        }
        float soLonTrongKho = Float.valueOf(lblSoLuongLon.getText());
        if (soThung == soThungTrongKho) {
            if (soLon > soLonTrongKho) {
                JOptionPane.showMessageDialog(this, "Số Lượng Lon Trong Kho Không Đủ");
                jspSoLon.setValue(soLon - 1);
                return;
            }

        }

        tong = (soThung * giaThung) + (soLon * giaLon);

        lblThanhTien.setText(tong + "");
    }

    public void changeSoThung() {
        jspSoThung.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                changeSum();
            }
        });
    }

    public void changeSoLon() {
        jspSoLon.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                changeSum();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTenSp = new javax.swing.JLabel();
        jspSoThung = new javax.swing.JSpinner();
        jspSoLon = new javax.swing.JSpinner();
        txtGiaThung = new javax.swing.JTextField();
        txtGiaLon = new javax.swing.JTextField();
        lblThanhTien = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblSoLonMoiThung = new javax.swing.JLabel();
        lblSoLuongLon = new javax.swing.JLabel();
        lblSoLuongThung = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Số Thùng ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Số Lon");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Giá Thùng ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Giá Lon ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Tên Sản Phẩm");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Thành Tiền");

        lblTenSp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenSp.setForeground(new java.awt.Color(204, 0, 51));
        lblTenSp.setText(" ");

        jspSoThung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jspSoThung.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jspSoThungStateChanged(evt);
            }
        });

        jspSoLon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jspSoLon.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jspSoLonStateChanged(evt);
            }
        });

        txtGiaThung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtGiaLon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        btnLogin.setBackground(new java.awt.Color(204, 102, 0));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Thêm Vào Giỏ Hàng");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblSoLonMoiThung.setForeground(new java.awt.Color(242, 242, 242));
        lblSoLonMoiThung.setText(" ");

        lblSoLuongLon.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        lblSoLuongLon.setForeground(new java.awt.Color(255, 255, 255));
        lblSoLuongLon.setText(" ");

        lblSoLuongThung.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        lblSoLuongThung.setForeground(new java.awt.Color(255, 255, 255));
        lblSoLuongThung.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTenSp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jspSoThung)
                    .addComponent(jspSoLon, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(txtGiaThung)
                    .addComponent(txtGiaLon)
                    .addComponent(lblThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSoLuongLon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSoLuongThung, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSoLonMoiThung, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSoLonMoiThung, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lblTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jspSoThung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jspSoLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGiaThung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGiaLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblThanhTien)
                    .addComponent(lblSoLuongLon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoLuongThung))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jspSoThungStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jspSoThungStateChanged
        changeSoThung();
    }//GEN-LAST:event_jspSoThungStateChanged

    private void jspSoLonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jspSoLonStateChanged
        changeSoLon();
    }//GEN-LAST:event_jspSoLonStateChanged

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String soThung = String.valueOf(jspSoThung.getValue());
        String soLon = String.valueOf(jspSoLon.getValue());
        float soThungFL = Float.valueOf(soThung);
        float soLonFl = Float.valueOf(soLon);
        if (soLonFl < 1 && soThungFL < 1) {
            JOptionPane.showMessageDialog(this, "Nhập Số Lượng Để Thêm");
            return;

        }
        String tt = lblThanhTien.getText();
        TrangChu.Instance.jspGhSoThung = soThung;
        TrangChu.Instance.jspGhSoLon = soLon;
        TrangChu.Instance.lbGhThanhTien = tt;
        soLuongCapNhat();
        TrangChu.Instance.hienThiGioHang();
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(ViewThemGioHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewThemGioHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewThemGioHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewThemGioHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewThemGioHang("", "", "", "", "", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner jspSoLon;
    private javax.swing.JSpinner jspSoThung;
    private javax.swing.JLabel lblSoLonMoiThung;
    private javax.swing.JLabel lblSoLuongLon;
    private javax.swing.JLabel lblSoLuongThung;
    private javax.swing.JLabel lblTenSp;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JTextField txtGiaLon;
    private javax.swing.JTextField txtGiaThung;
    // End of variables declaration//GEN-END:variables
}
