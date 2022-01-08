/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.dal;

import com.qlhv.bean.KhoaHocBean;
import com.qlhv.bean.LopHocBean;
import com.qlhv.dal.KetNoiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDALImpl implements ThongKeDAL {
    

    @Override
    public List<LopHocBean> getListByLopHoc() {
        try{
        Connection cons = KetNoiDB.getConnection();
       
        String sql = "SELECT ngay_dang_ky, COUNT(*) AS so_luong FROM lop_hoc GROUP BY ngay_dang_ky;";
        List<LopHocBean> list = new ArrayList<>();
        
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LopHocBean lopHocBean = new LopHocBean();
                lopHocBean.setNgayDangKy(rs.getString("ngay_dang_ky"));
                lopHocBean.setSoLuongHocVien(rs.getInt("so_luong"));
                list.add(lopHocBean);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<KhoaHocBean> getListByKhoaHoc() {
       try{
        Connection cons = KetNoiDB.getConnection();
        String sql = "SELECT ten_khoa_hoc, ngay_bat_dau, ngay_ket_thuc FROM khoa_hoc WHERE tinh_trang = TRUE ";
        List<KhoaHocBean> list = new ArrayList<>();
        
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhoaHocBean khoaHocBean = new KhoaHocBean();
                khoaHocBean.setTenKhoaHoc(rs.getString("ten_khoa_hoc"));
                khoaHocBean.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                khoaHocBean.setNgayKetThuc( rs.getDate("ngay_ket_thuc"));
                list.add(khoaHocBean);
            }
          ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
        