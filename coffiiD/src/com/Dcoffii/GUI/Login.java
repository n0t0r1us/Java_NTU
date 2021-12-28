package com.Dcoffii.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.Dcoffii.BLL.NhanVienBLL;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmHThngQun;
	private JTextField txtTenDN;
	private JPasswordField txtMK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmHThngQun.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHThngQun = new JFrame();
		frmHThngQun.setTitle("HỆ THỐNG QUẢN LÝ COFFIID");
		frmHThngQun.setBounds(100, 100, 620, 299);
		frmHThngQun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHThngQun.getContentPane().setLayout(null);
		
		txtTenDN = new JTextField();
		txtTenDN.setBounds(213, 68, 172, 20);
		frmHThngQun.getContentPane().add(txtTenDN);
		txtTenDN.setColumns(10);
		
		txtMK = new JPasswordField();
		txtMK.setBounds(213, 120, 172, 20);
		frmHThngQun.getContentPane().add(txtMK);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				NhanVienBLL bllNV = new NhanVienBLL();
				boolean kq= bllNV.checkLogin(txtTenDN.getText(), txtMK.getText());
				if (kq == true) {
					CuaSoChinh cs = new CuaSoChinh();
					cs.setVisible(true);
					frmHThngQun.setVisible(false);
					
					
 				}
				else {
					JOptionPane.showMessageDialog(frmHThngQun, "Đăng nhập sai", "Thông báo", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnDangNhap.setBounds(241, 170, 109, 23);
		frmHThngQun.getContentPane().add(btnDangNhap);
	}

}
