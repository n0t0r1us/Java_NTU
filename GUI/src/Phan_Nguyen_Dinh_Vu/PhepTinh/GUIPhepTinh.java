package Phan_Nguyen_Dinh_Vu.PhepTinh;

import javax.swing.*;
import java.awt .event. *;
import java.awt.*; 

public class GUIPhepTinh extends JFrame implements ActionListener { 
	// Dùng để biểu diễn 4 nút của 4 phép toán +, -, *, / *;
	 JButton btC, btT, btN, btCh;
	// Dùng để chứa 2 số và 1 kết quả
	 JTextField txtA, txtB, txtKQ;
	// Dùng để nhận tầng ContentPane của JFrame
	 Container cont;
	// Dùng để nhóm các thành phần trên giao diện
	 JPanel panel1, panel2;
	public static void main(String args[])
	{
		// Tạo giao diện chương trình
		GUIPhepTinh mt = new GUIPhepTinh("GUIPhepTinh");
		// Thiết lập kích thước hiển thị
		mt.setBounds(0, 0, 300, 100);
		mt.setVisible(true);
	}
	


	// Hàm khởi tạo
	public GUIPhepTinh(String s)
	{ 
		super(s);
		// Lấy lớp ContentPane để đặt các đối tượng hiển thị
		cont = getContentPane(); 
		
		// Tạo các thành phần trên giao diện
		JLabel lblA = new JLabel("A = ");
		txtA = new JTextField();
		JLabel lblB = new JLabel("B = ");
		txtB = new JTextField();
		JLabel lblKQ = new JLabel("KetQua: ");
		txtKQ = new JTextField();
		// Textfield chứa kết quả không được phép nhập dữ liệu
		txtKQ.setEditable(false);
		
		// Panel1 chứa 3 Textfield
		panel1 = new JPanel(); 
		// Thiết lập Layout gồm 3 hàng 2 cột
		panel1.setLayout(new GridLayout(3,2));
		// Đặt các thành phần vào panel 1
		panel1.add(lblA); 
		panel1.add(txtA); 
		panel1.add(lblB); 
		panel1.add(txtB);
		panel1.add(lblKQ);
		panel1.add(txtKQ);
		// Tạo 4 nút biểu diễn 4 phép toán
		btC = new JButton("+");
		btT = new JButton("-");
		btN = new JButton("*");
		btCh = new JButton("/");
		// Panel2 chứa 4 nút tính
		panel2 = new JPanel();
		panel2.add(btC);
		panel2.add(btT);
		panel2.add(btN);
		panel2.add(btCh);
		
		// Đặt 2 panel vào ContentPane
		cont.add(panel1); 
		cont.add(panel2,"East"); 
		
		btC.addActionListener(this);
		btT.addActionListener(this); 
		btN.addActionListener(this); 
		btCh.addActionListener(this);

	}

	// Phép Cộng
	public void PhepCong() 
	{ 
		String strA = txtA.getText();
		String strB = txtB.getText();
	
		int a = Integer.parseInt(strA);
		int b = Integer.parseInt(strB);

		int c = a+b;
		
		txtKQ.setText(String.valueOf(c));
	}
	// Phép trừ
	public void PhepTru() 
	{ 
		String strA = txtA.getText();
		String strB = txtB.getText();
	
		int a = Integer.parseInt(strA);
		int b = Integer.parseInt(strB);

		int c = a-b;
		
		txtKQ.setText(String.valueOf(c));
	}
	//Phép nhân
	public void PhepNhan() 
	{
		String strA = txtA.getText();
		String strB = txtB.getText();
	
		int a = Integer.parseInt(strA);
		int b = Integer.parseInt(strB);

		int c = a*b;
		
		txtKQ.setText(String.valueOf(c)); 
	}
	// Phép chia
	public void PhepChia()
	{
		String strA = txtA.getText();
		String strB = txtB.getText();
	
		int a = Integer.parseInt(strA);
		int b = Integer.parseInt(strB);

		int c = a/b;
		
		txtKQ.setText(String.valueOf(c));
	} 
	
	// Tạo hàm xử lý khi người dùng ấn các nút phép toán*
	public void actionPerformed(ActionEvent e) 
	{ 
		if (e.getActionCommand()=="+")
		PhepCong();
		if (e.getActionCommand()=="-")
		PhepTru();
		if (e.getActionCommand()=="*")
		PhepNhan();
		if (e.getActionCommand()=="/")
		PhepChia();
	
	}
	
	
}