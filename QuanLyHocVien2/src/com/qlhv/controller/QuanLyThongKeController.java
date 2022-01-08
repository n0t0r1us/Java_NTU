/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlhv.controller;

import com.qlhv.bean.KhoaHocBean;
import com.qlhv.bean.LopHocBean;
import com.qlhv.bll.ThongKeBLL;
import com.qlhv.bll.ThongKeBLLImpl;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

/**
 *
 * @author n0t0r1us
 */
public class QuanLyThongKeController {
    
    private ThongKeBLL thongKeBLL = null;
    
    public QuanLyThongKeController(){
        thongKeBLL = new ThongKeBLLImpl();
    }
    public void setDataToChart1(JPanel jpnItem){
        List<LopHocBean> listItem = thongKeBLL.getListByLopHoc();
        if(listItem != null ){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(LopHocBean item : listItem){
            dataset.addValue(item.getSoLuongHocVien(), "Học Viên", item.getNgayDangKy());
        }
        
            JFreeChart chart = ChartFactory.createBarChart("THỐNG KÊ SỐ LƯỢNG HỌC VIÊN ĐĂNG KÝ",
                    "Thời gian", "Số lượng", dataset, PlotOrientation.HORIZONTAL, true, true, true);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
            
             jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
            
}
     public void setDataToChart2(JPanel jpnItem){
        List<KhoaHocBean> listItem = thongKeBLL.getListByKhoaHoc();
        if(listItem != null ){
            TaskSeriesCollection ds = new TaskSeriesCollection();
            
            TaskSeries taskSeries;
            Task task ;
            for(KhoaHocBean item : listItem){
                taskSeries = new TaskSeries(item.getTenKhoaHoc());
                task = new Task(item.getTenKhoaHoc(), item.getNgayBatDau(), item.getNgayKetThuc());
                taskSeries.add(task);
                ds.add(taskSeries);
            }
            
            JFreeChart chart = ChartFactory.createGanttChart("THỐNG KÊ TÌNH TRẠNG KHÓA HỌC",
                    "Khóa học", "Thời gian", ds, true, true, true);
            
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(),300));
            
              jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
}
     }