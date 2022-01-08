/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.controller;

import com.qlhv.bll.KhoaHocBLL;
import com.qlhv.bll.KhoaHocBLLImpl;
import com.qlhv.model.KhoaHoc;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author n0t0r1us
 */
public class KhoaHocController {
    private JButton btnSubmit;
    private JTextField txtMaKhoaHoc;
    private JTextField txtTenKhoaHoc;
    private JTextField txtMoTa;
    private JDateChooser jdcNgayBD;
    private JDateChooser jdcNgayKT;
    private JCheckBox jcbTinhTrang;
    private JLabel jlbMsg;
    private KhoaHoc khoaHoc = null;
    private KhoaHocBLL khoaHocBLL = null;

    public KhoaHocController(JButton btnSubmit, JTextField txtMaKhoaHoc, JTextField txtTenKhoaHoc, JTextField txtMoTa, JDateChooser jdcNgayBD, JDateChooser jdcNgayKT, JCheckBox jcbTinhTrang, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.txtMaKhoaHoc = txtMaKhoaHoc;
        this.txtTenKhoaHoc = txtTenKhoaHoc;
        this.txtMoTa = txtMoTa;
        this.jdcNgayBD = jdcNgayBD;
        this.jdcNgayKT = jdcNgayKT;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;
        this.khoaHocBLL = new KhoaHocBLLImpl();
    }
    
     public void setView(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
        // set data
        txtMaKhoaHoc.setText("#" + khoaHoc.getMa_khoa_hoc());
        txtTenKhoaHoc.setText(khoaHoc.getTen_khoa_hoc());
        txtMoTa.setText(khoaHoc.getMo_ta());
        jdcNgayBD.setDate(khoaHoc.getNgay_bat_dau());
        jdcNgayKT.setDate(khoaHoc.getNgay_ket_thuc());
     
       
        jcbTinhTrang.setSelected(khoaHoc.isTinh_trang());
        
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (!checkNotNull()) {
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        khoaHoc.setTen_khoa_hoc(txtTenKhoaHoc.getText().trim());
                        khoaHoc.setNgay_bat_dau(covertDateToDateSql(jdcNgayBD.getDate()));
                       khoaHoc.setNgay_ket_thuc(covertDateToDateSql(jdcNgayKT.getDate()));
                        khoaHoc.setTinh_trang(jcbTinhTrang.isSelected());
                        if (showDialog()) {
                            int lastId = khoaHocBLL.createOrUpdate(khoaHoc);
                            if (lastId != 0) {
                                khoaHoc.setMa_khoa_hoc(lastId);
                                txtMaKhoaHoc.setText("#" + khoaHoc.getMa_khoa_hoc());
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
        return txtTenKhoaHoc.getText() != null && !txtTenKhoaHoc.getText().equalsIgnoreCase("");
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

