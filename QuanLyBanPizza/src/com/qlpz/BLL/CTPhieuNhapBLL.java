package com.qlpz.BLL;

import com.qlpz.DAL.CTPhieuNhapDAL;
import com.qlpz.DTO.CTPhieuNhap;
import java.util.ArrayList;

public class CTPhieuNhapBLL {

    private ArrayList<CTPhieuNhap> listPhieuNhap = null;
    private CTPhieuNhapDAL ctPhieuNhapDAO = new CTPhieuNhapDAL();

    public CTPhieuNhapBLL() {
        docDanhSach();
    }

    public void docDanhSach() {
        this.listPhieuNhap = ctPhieuNhapDAO.getListCTPhieuNhap();
    }

    public ArrayList<CTPhieuNhap> getListPhieuNhap() {
        if (listPhieuNhap == null) {
            docDanhSach();
        }
        return listPhieuNhap;
    }
    
    public ArrayList<CTPhieuNhap> getListPhieuNhap(String maPN) {
        ArrayList<CTPhieuNhap> dsct = new ArrayList<>();
        int ma = Integer.parseInt(maPN);
        
        for(CTPhieuNhap ct: listPhieuNhap) {
            if(ct.getMaPN() == ma) {
                dsct.add(ct);
            }
        }
        
        return dsct;
    }

    public boolean luuCTPhieuNhap(CTPhieuNhap ctpn) {
        return ctPhieuNhapDAO.addCTPhieuNhap(ctpn);
    }
}
