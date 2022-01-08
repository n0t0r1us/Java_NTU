/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.controller;

/**
 *
 * @author n0t0r1us
 */
import com.qlhv.model.HocVien;
import com.qlhv.bll.HocVienBLL;
import com.qlhv.bll.HocVienBLLImpl;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class HocVienController {
    
    private JButton btnSubmit;
    private JTextField txtMaHocVien;
    private JTextField txtHoTen;
    private JDateChooser jdcNgaySinh;
    private JRadioButton jrdNam;
    private JRadioButton jrdNu;
    private JTextField txtSoDienThoai;
    private JTextArea jtaDiaChi;
    private JCheckBox jcbTinhTrang;
    private JLabel jlbMsg;

    private HocVien hocVien = null;

    private HocVienBLL hocVienBLL = null;

    public HocVienController(JButton btnSubmit, JTextField txtMaHocVien, 
            JTextField txtHoTen, JDateChooser jdcNgaySinh, JRadioButton jrdNam, 
            JRadioButton jrdNu, JTextField txtSoDienThoai, JTextArea jtaDiaChi, 
            JCheckBox jcbTinhTrang, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.txtMaHocVien = txtMaHocVien;
        this.txtHoTen = txtHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jrdNam = jrdNam;
        this.jrdNu = jrdNu;
        this.txtSoDienThoai = txtSoDienThoai;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;
        this.hocVienBLL = new HocVienBLLImpl();
    }
    
    

    public void setView(HocVien hocVien) {
        this.hocVien = hocVien;
        // set data
        txtMaHocVien.setText("#" + hocVien.getMa_hoc_vien());
        txtHoTen.setText(hocVien.getHo_ten());
        jdcNgaySinh.setDate(hocVien.getNgay_sinh());
        if (hocVien.isGioi_tinh()) {
            jrdNam.setSelected(true);
             jrdNam.setSelected(false);
        } else {
            jrdNam.setSelected(false);
             jrdNam.setSelected(true);
        }
        txtSoDienThoai.setText(hocVien.getSo_dien_thoai());
        jtaDiaChi.setText(hocVien.getDia_chi());
        jcbTinhTrang.setSelected(hocVien.isTinh_trang());
        
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (!checkNotNull()) {
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        hocVien.setHo_ten(txtHoTen.getText().trim());
                        hocVien.setNgay_sinh(covertDateToDateSql(jdcNgaySinh.getDate()));
                        hocVien.setGioi_tinh(jrdNam.isSelected());
                    
                        
                        hocVien.setSo_dien_thoai(txtSoDienThoai.getText());
                            hocVien.setDia_chi(jtaDiaChi.getText());
                        hocVien.setTinh_trang(jcbTinhTrang.isSelected());
                        if (showDialog()) {
                            int lastId = hocVienBLL.createOrUpdate(hocVien);
                            if (lastId != 0) {
                                hocVien.setMa_hoc_vien(lastId);
                                txtMaHocVien.setText("#" + hocVien.getMa_hoc_vien());
                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                            } else {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            }
                        }
                    }
                } catch (Exception ex) {
                    jlbMsg.setText(ex.toString());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
        });
    }

    private boolean checkNotNull() {
        return txtHoTen.getText() != null && !txtHoTen.getText().equalsIgnoreCase("");
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
    public java.sql.Date covertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
    
}
