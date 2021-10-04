package Phan_Nguyen_Dinh_Vu.BMISwing;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class BMISwing {

	private JFrame frmChngTrnhTnh;
	private JTextField txtCC;
	private JTextField txtCN;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMISwing window = new BMISwing();
					window.frmChngTrnhTnh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BMISwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChngTrnhTnh = new JFrame();
		frmChngTrnhTnh.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
		frmChngTrnhTnh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmChngTrnhTnh.setTitle("Chương trình tính chỉ số BMI");
		frmChngTrnhTnh.setBounds(100, 100, 678, 339);
		frmChngTrnhTnh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChngTrnhTnh.getContentPane().setLayout(null);
		
		JLabel lblNhapCao = new JLabel("Chiều cao (m) : ");
		lblNhapCao.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNhapCao.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhapCao.setBounds(18, 62, 139, 25);
		frmChngTrnhTnh.getContentPane().add(lblNhapCao);
		
		txtCC = new JTextField();
		txtCC.setBounds(152, 64, 68, 19);
		frmChngTrnhTnh.getContentPane().add(txtCC);
		txtCC.setColumns(10);
		
		JLabel lblNhapNang = new JLabel("Cân nặng (kg) : ");
		lblNhapNang.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNhapNang.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhapNang.setBounds(20, 97, 139, 25);
		frmChngTrnhTnh.getContentPane().add(lblNhapNang);
		
		txtCN = new JTextField();
		txtCN.setBounds(152, 99, 68, 19);
		frmChngTrnhTnh.getContentPane().add(txtCN);
		txtCN.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Khu v\u1EF1c", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(148, 0, 211)));
		panel.setBounds(45, 130, 232, 48);
		frmChngTrnhTnh.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton radA = new JRadioButton("Asian");
		radA.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		buttonGroup.add(radA);
		radA.setBounds(39, 16, 58, 21);
		panel.add(radA);
		
		JRadioButton radNonA = new JRadioButton("Non-Asian");
		radNonA.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		buttonGroup.add(radNonA);
		radNonA.setBounds(125, 16, 90, 21);
		panel.add(radNonA);
		
		JLabel lblW = new JLabel("CHÀO MỪNG CÁC BẠN ĐẾN VỚI CHƯƠNG TRÌNH TÍNH CHỈ SỐ BMI");
		lblW.setHorizontalAlignment(SwingConstants.CENTER);
		lblW.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblW.setForeground(new Color(148, 0, 211));
		lblW.setBounds(10, 10, 642, 40);
		frmChngTrnhTnh.getContentPane().add(lblW);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lbl1.setToolTipText("");
		lbl1.setBounds(45, 235, 341, 20);
		frmChngTrnhTnh.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lbl2.setBounds(45, 257, 630, 20);
		frmChngTrnhTnh.getContentPane().add(lbl2);
		
		JButton btnTinhBMI = new JButton("Tính BMI");
		btnTinhBMI.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnTinhBMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strCC = txtCC.getText();
				String strCN = txtCN.getText();
				
				double a = Double.parseDouble(strCN);
				double b = Double.parseDouble(strCC);
				
				double c = a/(b*b);
				
				c = Math.ceil(c*100)/100;
				
				String lk1 = "Bạn quá gầy! Bạn nên có một chế độ ăn uống giàu dinh dưỡng!";
				String lk2 = "Bạn có một thân hình cân đối! Cứ thế mà phát huy";
				String lk3 = "Bạn bị thừa cân. Bạn nên có chế độ ăn hợp lý và tập luyện thể dục thường xuyên!";
				String lk4 = "Bạn sắp bị béo phì. Bạn nên có chế độ ăn kiêng phù hợp cùng với các bài tập thể dục!";
				String lk5 = "Bạn bị béo phì. Bạn cần có một chế độ ăn uống lành mạnh hơn!";
				String lk6 = "Bạn bị béo phì cấp độ I. Bạn cần giảm khẩu phần ăn và tăng cường luyện tập thể dục hơn nữa!";
				String lk7 = "Bạn bị béo phì độ II. Bạn bên tìm gặp bác sĩ để được tư vấn về chế độ ăn kiêng cùng với các bài tập thể dục!";
				String lk8 = "Bạn bị béo phì độ III. Bạn quá béo, bạn cần có chế độ ăn kiêng ngay và luôn!";
				
				String chisoBMI;
				chisoBMI= "Chỉ số BMI của bạn là "+ String.valueOf(c) ;
				
				if (radA.isSelected() == true) {
				if (c<18.5) 
					lbl2.setText(lk1);
				else 
				if (c>=18.5 && c <25)
					lbl2.setText(lk2);
				else
				if (c>=25 && c <30)
					lbl2.setText(lk3);
				else
				if (c>=29.9 && c <=30)
					lbl2.setText(lk5);
				else
				if (c>30 && c <40)
					lbl2.setText(lk6);
				else
				if (c>=40 && c <50)
					lbl2.setText(lk7);
				else
					lbl2.setText(lk8);
				} else 
				if (radNonA.isSelected() == true) {
				if (c<18.5) 
					lbl2.setText(lk1);
				else
				if (c>=18.5 && c <23)
					lbl2.setText(lk2);
				else
				if (c>=23 && c <25)
					lbl2.setText(lk3);
				else
				if (c>=25 && c <29.9)
					lbl2.setText(lk4);
				else
				if (c>=29.9 && c <=30)
					lbl2.setText(lk5);
				else
				if (c>30 && c <40)
					lbl2.setText(lk6);
				else
				if (c>=40 && c <50)
					lbl2.setText(lk7);
				else
					lbl2.setText(lk8);	
				} else lbl2.setText("Bạn chưa chọn khu vực");
				
				lbl1.setText(chisoBMI);
			}
		});
		btnTinhBMI.setBounds(131, 199, 89, 25);
		frmChngTrnhTnh.getContentPane().add(btnTinhBMI);
		
		
	}
}