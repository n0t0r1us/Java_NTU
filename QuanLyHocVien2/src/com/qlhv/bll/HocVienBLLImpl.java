/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.bll;

/**
 *
 * @author n0t0r1us
 */
import com.qlhv.dal.HocVienDAL;
import com.qlhv.dal.HocVienDALImpl;
import com.qlhv.model.HocVien;
import java.util.List;

public class HocVienBLLImpl implements HocVienBLL {

    private HocVienDAL hocVienDAL = null;

    public HocVienBLLImpl() {
        hocVienDAL = new HocVienDALImpl();
    }

    @Override
    public List<HocVien> getList() {
        return hocVienDAL.getList();
    }

    @Override
    public int createOrUpdate(HocVien hocVien) {
        return hocVienDAL.createOrUpdate(hocVien);
       
    }

}
