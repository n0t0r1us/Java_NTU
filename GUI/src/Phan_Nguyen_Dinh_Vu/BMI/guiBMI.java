package Phan_Nguyen_Dinh_Vu.BMI;

import java.awt.event.*;
import javax.swing.*;

public class guiBMI extends javax.swing.JFrame {
 
    guiBMI() {
    	// Tạo Frame
        JFrame fr = new JFrame("Tính BMI");  
        JLabel lb1 = new JLabel("Chiều cao(m):");
        lb1.setBounds(20, 20, 100, 40);// Kích thước
        fr.add(lb1); // Thêm Label vào Frame
 
        JLabel lb2 = new JLabel("Cân nặng(Kg):");
        lb2.setBounds(20, 60, 100, 40);
        fr.add(lb2);
        
        JLabel lbKQ = new JLabel("Chỉ số BMI ");
        lbKQ.setBounds(20, 120, 300, 40);
        fr.add(lbKQ); 
        
        JTextField txtcc = new JTextField("");
        txtcc.setBounds(120, 20, 200, 40); // Kích thước
        fr.add(txtcc); // Thêm Textfield vào Frame
 
        JTextField txtcn = new JTextField("");
        txtcn.setBounds(120, 60, 200, 40);
        fr.add(txtcn); 
 
        JButton btn = new JButton("Tính chỉ số BMI");// Tạo nút tính  
        btn.setBounds(20, 200, 300, 40);
        
        // Thêm bộ lắng nghe và xử lý sự kiện cho nút tính
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                double CanNang=Double.parseDouble(txtcn.getText());
                double ChieuCao=Double.parseDouble(txtcc.getText());
                
                double bmi = CanNang / Math.pow(ChieuCao, 2);
               // Bạn quá gầy, Bạn nên có một chế độ ăn uống giàu dinh dưỡng - BMI : 
                 if (bmi < 18.5) {
                     lbKQ.setText("Bạn quá gầy, Bạn nên có một chế độ ăn uống giàu dinh dưỡng - BMI :" +bmi);
                 } else if (bmi < 25) {
                     lbKQ.setText("Bạn có một thân hình cân đối cứ thế mà phát huy - BMI : "+bmi);
                 } else if (bmi < 30) {
                     lbKQ.setText("Bạn bị béo phì cấp độ I, bạn nên có một chế độ ăn uống lành mạnh hơn - BMI : "+bmi);
                 } else {
                     lbKQ.setText("Bạn quá béo, bạn cần có chế độ ăn kiêng ngay và luôn - BMI : "+bmi);
                 }
            }
        });
        
        fr.add(btn);// Thêm nút cho Frame  
 
        fr.setSize(400, 300);
        fr.setLayout(null);
        fr.setVisible(true);
 
    }
 
    public static void main(String[] args) {
        new guiBMI();
    }
}