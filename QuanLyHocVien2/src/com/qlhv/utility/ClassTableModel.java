/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.utility;

/**
 *
 * @author n0t0r1us
 */
import com.qlhv.model.HocVien;
import com.qlhv.model.KhoaHoc;
import com.qlhv.model.LopHoc;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClassTableModel {

    public DefaultTableModel setTableHocVien(List<HocVien> listItem, String[] listColumn) {
        
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int row = listItem.size();
        if(row >0){
            for (int i = 0; i < row; i++) {
             HocVien hocVien = listItem.get(i);
              obj = new Object[columns];
            obj[0] = hocVien.getMa_hoc_vien();
            obj[1] = (i + 1);
            obj[2] = hocVien.getHo_ten();
            obj[3] = hocVien.getNgay_sinh();
            obj[4] = hocVien.isGioi_tinh() == true ? "Nam" : "Nữ";
            obj[5] = hocVien.getSo_dien_thoai();
            obj[6] = hocVien.getDia_chi();
            obj[7] = hocVien.isTinh_trang();
            dtm.addRow(obj);
        }
        HocVien hocVien = null;
       
            
           
        }
        return dtm;
    }
    public DefaultTableModel setTableKhoaHoc(List<KhoaHoc> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 6 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int row = listItem.size();
        if(row >0){
            for (int i = 0; i < row; i++) {
             KhoaHoc khoaHoc = listItem.get(i);
              obj = new Object[columns];
            obj[0] = khoaHoc.getMa_khoa_hoc();
            obj[1] = (i + 1);
            obj[2] = khoaHoc.getTen_khoa_hoc();
            obj[3] = khoaHoc.getMo_ta();
            obj[4] = khoaHoc.getNgay_bat_dau();
            obj[5] = khoaHoc.getNgay_ket_thuc();
            dtm.addRow(obj);
        }
        KhoaHoc khoaHoc = null;
       
            
           
        }
        return dtm;
    }

  }


