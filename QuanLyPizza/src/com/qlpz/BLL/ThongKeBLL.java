/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlpz.BLL;

import com.qlpz.DAL.ThongKeDAL;
import com.qlpz.DTO.ThongKe;

import java.util.ArrayList;

/**
 * @author User
 */
public class ThongKeBLL {

    public ThongKeDAL thongKeDAL = new ThongKeDAL();
    private ArrayList<Double> doanhThuThang;

    public ThongKe thongKe(int nam) {
        return thongKeDAL.getThongKe(nam);
    }

    public double getDoanhThuThang(int thang, int nam) {
        return thongKeDAL.getDoanhThuThang(thang, nam);
    }
}
