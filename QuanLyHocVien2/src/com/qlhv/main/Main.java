    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.main;

import com.qlhv.GUI.DangNhapJDialog;
import com.qlhv.GUI.MainJFrame;

/**
 *
 * @author n0t0r1us
 */
public class Main {
    public static void main(String[] args) {
//        new MainJFrame().setVisible(true);
    DangNhapJDialog dialog = new DangNhapJDialog(null, true);
    dialog.setTitle("Đăng Nhập Hệ Thống");
    dialog.setResizable(false);
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
    }
    
}
