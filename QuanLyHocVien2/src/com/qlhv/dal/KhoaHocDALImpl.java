/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.dal;

import com.qlhv.model.KhoaHoc;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author n0t0r1us
 */
public class KhoaHocDALImpl implements KhoaHocDAL{

    @Override
    public List<KhoaHoc> getList() {
        try{
        Connection cons = KetNoiDB.getConnection();
        String sql = "SELECT * FROM khoa_hoc";
        List<KhoaHoc> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhoaHoc khoaHoc = new KhoaHoc();
                khoaHoc.setMa_khoa_hoc(rs.getInt("ma_khoa_hoc"));
                khoaHoc.setTen_khoa_hoc(rs.getString("ten_khoa_hoc"));
                 khoaHoc.setMo_ta(rs.getString("mo_ta"));
                khoaHoc.setNgay_bat_dau(rs.getDate("ngay_bat_dau"));
                khoaHoc.setNgay_ket_thuc(rs.getDate("ngay_ket_thuc"));
               
               
                khoaHoc.setTinh_trang(rs.getBoolean("tinh_trang"));
                list.add(khoaHoc);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    


    public static void main(String[] args) {
        KhoaHocDAL khoaHocDAL = new KhoaHocDALImpl();
        System.out.println(khoaHocDAL.getList());

}

    @Override
    public int createOrUpdate(KhoaHoc khoaHoc) {
        try {
            Connection cons = KetNoiDB.getConnection();
            String sql = "INSERT INTO khoa_hoc(ma_khoa_hoc, ten_khoa_hoc, mo_ta, ngay_bat_dau, ngay_ket_thuc, tinh_trang) VALUES(?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE ten_khoa_hoc = VALUES(ten_khoa_hoc), ngay_bat_dau = VALUES(ngay_bat_dau), ngay_ket_thuc = VALUES(ngay_ket_thuc) , tinh_trang = VALUES(tinh_trang);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, khoaHoc.getMa_khoa_hoc());
            ps.setString(2, khoaHoc.getTen_khoa_hoc());
            ps.setString(3, khoaHoc.getMo_ta());
            ps.setDate(4, new Date(khoaHoc.getNgay_bat_dau().getTime()));
            ps.setDate(5, new Date(khoaHoc.getNgay_ket_thuc().getTime()));
          
            ps.setBoolean(6, khoaHoc.isTinh_trang());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;}
    }
    
    
