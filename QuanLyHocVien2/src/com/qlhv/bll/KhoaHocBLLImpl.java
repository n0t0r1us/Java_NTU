/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.bll;

import com.qlhv.dal.KhoaHocDAL;
import com.qlhv.dal.KhoaHocDALImpl;
import com.qlhv.model.KhoaHoc;
import java.util.List;

/**
 *
 * @author n0t0r1us
 */
public class KhoaHocBLLImpl implements KhoaHocBLL{
    private KhoaHocDAL khoaHocDAL = null;

    public KhoaHocBLLImpl() {
        khoaHocDAL = new KhoaHocDALImpl();
    }
    
    

    @Override
    public List<KhoaHoc> getList() {
        return khoaHocDAL.getList();
        
    }

    @Override
    public int createOrUpdate(KhoaHoc khoaHoc) {
        return khoaHocDAL.createOrUpdate(khoaHoc);
    }
    
}
