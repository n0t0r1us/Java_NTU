package Phan_Nguyen_Dinh_Vu.Demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class Demo1 {
	// Khai báo danh sách ở đây
	ArrayList<String> dsTen;
	// Khai Báo các đi�?u khiển
	private JFrame frameMain;
	private JTextField txtHoVaTen;
	private	JLabel lblHoVaTen;
	private JButton btnThemTen;
	private JButton btnHienDanhSach;
	private JTextArea textAreaDanhSachTen;
	private JLabel lblTrangThai;
	private JButton btnTm;
	private JTextArea textAreaDanhSachTen_1;
	private JTextField txtHoTenTK;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo1 window = new Demo1();
					window.frameMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Demo1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMain = new JFrame();
		frameMain.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frameMain.getContentPane().setBackground(SystemColor.windowBorder);
		frameMain.setTitle("Demo ArrayList");
		frameMain.setBounds(100, 100, 585, 331);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);
		
		lblHoVaTen = new JLabel("M\u1EDDi nh\u1EADp h\u1ECD v\u00E0 t\u00EAn:");
		lblHoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblHoVaTen.setBounds(24, 24, 138, 30);
		frameMain.getContentPane().add(lblHoVaTen);
		
		txtHoVaTen = new JTextField();
		txtHoVaTen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblTrangThai.setText("Tôi đang đợi bạn...");
			}
		});
		txtHoVaTen.setBounds(172, 29, 187, 20);
		frameMain.getContentPane().add(txtHoVaTen);
		txtHoVaTen.setColumns(10);
		
		btnThemTen = new JButton("Th\u00EAm");
		btnThemTen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		dsTen = new ArrayList<String>();
		btnThemTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// sử dụng ArrayList là biến toàn cục
				themVaoDanhSach(dsTen);		// �? định: void themVaoDanhSach(ArrayList<String> a)
			}
		});
		btnThemTen.setBounds(369, 28, 89, 23);
		frameMain.getContentPane().add(btnThemTen);
		
		btnHienDanhSach = new JButton("Hi\u1EC7n Danh S\u00E1ch");
		btnHienDanhSach.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnHienDanhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienDanhSach(dsTen);		// �? định: void hienDanhSach(ArrayList<String> a)
			}
		});
		btnHienDanhSach.setBounds(65, 92, 139, 23);
		frameMain.getContentPane().add(btnHienDanhSach);
		
		textAreaDanhSachTen = new JTextArea();
		textAreaDanhSachTen.setBounds(24, 126, 258, 126);
		frameMain.getContentPane().add(textAreaDanhSachTen);
		
		lblTrangThai = new JLabel("Hi\u1EC7n tr\u1EA1ng th\u00E1i \u0111\u00E3 th\u00EAm");
		lblTrangThai.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		lblTrangThai.setForeground(new Color(128, 0, 128));
		lblTrangThai.setBounds(224, 48, 179, 14);
		frameMain.getContentPane().add(lblTrangThai);
		
		btnTm = new JButton("Tìm");
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String HoTenTK = txtHoTenTK.getText();
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				String temp = "Bạn chưa nhập bất cứ tên nào";
				int listLength = dsTen.size();

					txtHoTenTK.setText("");
				
				for (int i = 0; i < listLength; i++) 
					if (dsTen.get(i).contains(HoTenTK))
					{ 
						temp = "Tìm thấy tên ở vị trí thứ " + String.valueOf(i+1) + " trong danh sách !";
						break;
					}
					else 
						temp = "Không tìm thấy tên bạn muốn trong danh sách";
				
		        JOptionPane.showMessageDialog(frame,
		                temp,
		                "Kết quả tìm kiếm",
		                JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnTm.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnTm.setBounds(461, 62, 89, 23);
		frameMain.getContentPane().add(btnTm);
		
		textAreaDanhSachTen_1 = new JTextArea();
		textAreaDanhSachTen_1.setBounds(292, 126, 258, 126);
		frameMain.getContentPane().add(textAreaDanhSachTen_1);
		
		txtHoTenTK = new JTextField();
		txtHoTenTK.setBounds(272, 63, 179, 20);
		frameMain.getContentPane().add(txtHoTenTK);
		txtHoTenTK.setColumns(10);
	}	// end of Initialize
	
	 void themVaoDanhSach(ArrayList<String> a) {
		 // Lấy dữ liệu từ đi�?u khiển
		 String hoten = txtHoVaTen.getText();
		 // Thêm vào danh a
		 a.add(hoten);
		 // Xóa nội dung trên đi�?u khiển đi, để cho việc thêm sao được dễ
		 txtHoVaTen.setText("");
		 // Cập nhật trạng thái
		 lblTrangThai.setText("Đã thêm xong vào danh sách");
		 
		 textAreaDanhSachTen_1.setText("");
		 for (String sTen: a) {
			textAreaDanhSachTen_1.append(sTen +"\n");
		 }
		 
}
	 void hienDanhSach(ArrayList<String> a) {
		 // Sử dụng duyệt theo chỉ số
		 for (int index =0; index<a.size(); index++) {
			 // Lấy giá trị ở vị trí index; cất vào biến sTen
			 String sTen = a.get(index);
			 // Nạp vào đi�?u khiển hiển thị TextArea
			 textAreaDanhSachTen.append(sTen +"\n");
		 }
		 // Cách 2
//		 for (String sTen: a) {
//		
//			 textAreaDanhSachTen.append(sTen);
//	 }
	 }
}
