/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.dal;

/**
 *
 * @author n0t0r1us
 */
import com.qlhv.model.HocVien;
import java.util.List;

public interface HocVienDAL {

    public List<HocVien> getList();
    public int createOrUpdate(HocVien hocVien);

}
