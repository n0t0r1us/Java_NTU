/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.bean;

/**
 *
 * @author n0t0r1us
 */
public class LopHocBean {

    private String ngayDangKy;
    private int soLuongHocVien;

    public LopHocBean() {
    }

    public LopHocBean(String ngayDangKy, int soLuongHocVien) {
        this.ngayDangKy = ngayDangKy;
        this.soLuongHocVien = soLuongHocVien;
    }

    public String getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(String ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public int getSoLuongHocVien() {
        return soLuongHocVien;
    }

    public void setSoLuongHocVien(int soLuongHocVien) {
        this.soLuongHocVien = soLuongHocVien;
    }
    
    
}    


