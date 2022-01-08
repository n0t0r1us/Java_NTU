/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.dal;

import com.qlhv.model.KhoaHoc;
import java.util.List;

/**
 *
 * @author n0t0r1us
 */
public interface KhoaHocDAL {
    public List<KhoaHoc> getList();

    public int createOrUpdate(KhoaHoc khoaHoc);
}
