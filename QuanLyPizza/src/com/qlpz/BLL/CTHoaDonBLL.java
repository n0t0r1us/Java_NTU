package com.qlpz.BLL;

import com.qlpz.DAL.CTHoaDonDAL;
import com.qlpz.DTO.CTHoaDon;
import com.qlpz.DTO.HoaDon;

import java.util.ArrayList;

public class CTHoaDonBLL {

    private ArrayList<CTHoaDon> listCTHoaDon;
    private CTHoaDonDAL ctHDDAL = new CTHoaDonDAL();
    private HoaDonBLL hdBUS = new HoaDonBLL();

    public CTHoaDonBLL() {
        docListCTHoaDon();
    }

    public void docListCTHoaDon() {
        this.listCTHoaDon = ctHDDAL.getListCTHoaDon();
    }

    public ArrayList<CTHoaDon> getListCTHoaDon() {
        return listCTHoaDon;
    }

    public ArrayList<CTHoaDon> getListCTHoaDonTheoMaHD(String maHD) {
        int ma = Integer.parseInt(maHD);
        ArrayList<CTHoaDon> dsct = new ArrayList<>();

        for (CTHoaDon cthd : listCTHoaDon) {
            if (cthd.getMaHD() == ma)
                dsct.add(cthd);
        }

        return dsct;
    }

    public void addCTHoaDon(String maSP, String soLuong, String donGia, String thanhTien) {
        int ma = hdBUS.getMaHoaDonMoiNhat();

        donGia = donGia.replace(",","");
        thanhTien = thanhTien.replace(",", "");

        CTHoaDon cthd = new CTHoaDon();

        cthd.setMaHD(ma);
        cthd.setMaSP(Integer.parseInt(maSP));
        cthd.setDonGia(Integer.parseInt(donGia));
        cthd.setSoLuong(Integer.parseInt(soLuong));
        cthd.setThanhTien(Integer.parseInt(thanhTien));

        ctHDDAL.addCTHoaDon(cthd);
    }
}
