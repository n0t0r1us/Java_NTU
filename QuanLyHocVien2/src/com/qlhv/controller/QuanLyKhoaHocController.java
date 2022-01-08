/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.controller;


import com.qlhv.GUI.KhoaHocJFrame;
import com.qlhv.bll.KhoaHocBLL;
import com.qlhv.bll.KhoaHocBLLImpl;
import com.qlhv.model.HocVien;
import com.qlhv.model.KhoaHoc;
import com.qlhv.utility.ClassTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author n0t0r1us
 */
public class QuanLyKhoaHocController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField txtSearch;
    private KhoaHocBLL khoaHocBLL = null;
    private String[] listColumn = {"Mã khóa học","STT", "Tên Khóa Học","Mô Tả", "Ngày bắt đầu", "Ngày kết thúc"};
     private ClassTableModel classTableModel = null;

    private TableRowSorter<TableModel> rowSorter = null;
    

    public QuanLyKhoaHocController(JPanel jpnView, JButton btnAdd, JTextField txtSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.txtSearch = txtSearch;
        this.khoaHocBLL = new KhoaHocBLLImpl();
        this.classTableModel = new ClassTableModel();

        this.khoaHocBLL = new KhoaHocBLLImpl();
    }
    public void setDateToTable() {
        List<KhoaHoc> listItem = khoaHocBLL.getList();
        DefaultTableModel model = new ClassTableModel().setTableKhoaHoc(listItem, listColumn);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        table.getColumnModel().getColumn(1).setMaxWidth(0);
        table.getColumnModel().getColumn(1).setMinWidth(0);
        table.getColumnModel().getColumn(1).setPreferredWidth(0);
        
         table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
        table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
             if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    System.out.println(selectedRowIndex);

                    KhoaHoc khoaHoc = new KhoaHoc();
                    khoaHoc.setMa_khoa_hoc((int) model.getValueAt(selectedRowIndex, 0));
                    khoaHoc.setTen_khoa_hoc(model.getValueAt(selectedRowIndex, 2).toString());
                    khoaHoc.setMo_ta(model.getValueAt(selectedRowIndex, 3).toString());
                    khoaHoc.setNgay_bat_dau((Date) model.getValueAt(selectedRowIndex, 4));
                    khoaHoc.setNgay_ket_thuc((Date) model.getValueAt(selectedRowIndex, 5));
                    
                    khoaHoc.setTinh_trang((boolean) model.getValueAt(selectedRowIndex, 6));

                    KhoaHocJFrame frame = new KhoaHocJFrame(khoaHoc);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setTitle("Thông tin khóa học");
                    frame.setVisible(true);
             }
      }

});

        // design
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1300, 400));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
            KhoaHocJFrame frame =  new KhoaHocJFrame (new KhoaHoc());
            frame.setTitle("Thông tin khóa học");
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
               frame.setVisible(true);
                
               
            }
    @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100, 221, 23));
            }
        });
    }
    
    
}
