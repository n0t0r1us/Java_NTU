/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.bll;

import com.qlhv.bean.KhoaHocBean;
import com.qlhv.bean.LopHocBean;

import com.qlhv.dal.ThongKeDAL;
import com.qlhv.dal.ThongKeDALImpl;
import java.util.List;  

public class ThongKeBLLImpl implements ThongKeBLL {
     private ThongKeDAL thongKeDAL = null;

    public ThongKeBLLImpl() {
         thongKeDAL = new ThongKeDALImpl();
    }

    @Override
    public List<LopHocBean> getListByLopHoc() {
       return thongKeDAL.getListByLopHoc();
    }

    @Override
    public List<KhoaHocBean> getListByKhoaHoc() {
        return thongKeDAL.getListByKhoaHoc();
    }

   

}