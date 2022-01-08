/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.bll;

/**
 *
 * @author n0t0r1us
 */
import com.qlhv.dal.TaiKhoanDAL;
import com.qlhv.dal.TaiKhoanDALImpl;
import com.qlhv.model.TaiKhoan;

public class TaiKhoanBLLImpl implements TaiKhoanBLL {
    private TaiKhoanDAL taiKhoanDAL = null;

    public TaiKhoanBLLImpl() {
        taiKhoanDAL = new TaiKhoanDALImpl();
    }
    
    
    
    @Override
    public TaiKhoan login(String tdn, String mk) {
        return taiKhoanDAL.login(tdn, mk);
    }

  }