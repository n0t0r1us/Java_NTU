/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.controller;

import com.qlhv.GUI.MainJFrame;
import com.qlhv.bll.TaiKhoanBLL;
import com.qlhv.bll.TaiKhoanBLLImpl;
import com.qlhv.model.TaiKhoan;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author n0t0r1us
 */
public class TaiKhoanController {
    
    private JDialog dialog;
    private JButton btnSubmit;
    private JTextField txtTenDangNhap;
    private JPasswordField txtMatKhau;
    private JLabel jlbMsg;
    
    private TaiKhoanBLL taiKhoanBLL = null;

    public TaiKhoanController(JDialog dialog, JButton btnSubmit, JTextField txtTenDangNhap, JPasswordField txtMatKhau, JLabel jlbMsg) {
        this.dialog = dialog;
        this.btnSubmit = btnSubmit;
        this.txtTenDangNhap = txtTenDangNhap;
        this.txtMatKhau = txtMatKhau;
        this.jlbMsg = jlbMsg;
        
        taiKhoanBLL = new TaiKhoanBLLImpl();
        
       
    }
    
    public void setEvent(){
         btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtTenDangNhap.getText().length() == 0 || txtMatKhau.getText().length() == 0){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                    }else{
                    TaiKhoan taiKhoan = taiKhoanBLL.login(txtTenDangNhap.getText(), txtMatKhau.getText());
                    if(taiKhoan ==null){
                        jlbMsg.setText("Tên đăng nhập và mật khẩu không đúng!");
                    }else{
                        if(!taiKhoan.isTinh_trang()){
                            jlbMsg.setText("Tài khoản của bạn đang bị tạm khóa!");
                        }else{
                            dialog.dispose();
                            MainJFrame frame = new MainJFrame();
                            frame.setTitle("Quản Lý Học Viên");
                            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            frame.setVisible(true);
                            
                        }
                    }
               
                  }
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
    
}
