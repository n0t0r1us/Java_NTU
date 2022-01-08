/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.dal;

import com.qlhv.bean.KhoaHocBean;
import com.qlhv.bean.LopHocBean;


import java.util.List;

public interface ThongKeDAL {
    
    public List<LopHocBean> getListByLopHoc();
    
    public List<KhoaHocBean> getListByKhoaHoc();
    
}