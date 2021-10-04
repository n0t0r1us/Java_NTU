package Phan_Nguyen_Dinh_Vu.BMISwing;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class BMISwing {

	private JFrame frmChngTrnhTnh;
	private JTextField txtCao;
	private JTextField txtNang;
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
		
		txtCao = new JTextField();
		txtCao.setBounds(152, 64, 68, 19);
		frmChngTrnhTnh.getContentPane().add(txtCao);
		txtCao.setColumns(10);
		
		JLabel lblNhapNang = new JLabel("Cân nặng (kg) : ");
		lblNhapNang.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNhapNang.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhapNang.setBounds(20, 97, 139, 25);
		frmChngTrnhTnh.getContentPane().add(lblNhapNang);
		
		txtNang = new JTextField();
		txtNang.setBounds(152, 99, 68, 19);
		frmChngTrnhTnh.getContentPane().add(txtNang);
		txtNang.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Khu v\u1EF1c", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(148, 0, 211)));
		panel.setBounds(45, 130, 232, 48);
		frmChngTrnhTnh.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton radA = new JRadioButton("Asian");
		buttonGroup.add(radA);
		radA.setBounds(39, 16, 58, 21);
		panel.add(radA);
		
		JRadioButton radNonA = new JRadioButton("Non-Asian");
		buttonGroup.add(radNonA);
		radNonA.setBounds(125, 16, 90, 21);
		panel.add(radNonA);
		
		JLabel lblWelc = new JLabel("CHÀO MỪNG CÁC BẠN ĐẾN VỚI CHƯƠNG TRÌNH TÍNH CHỈ SỐ BMI");
		lblWelc.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblWelc.setForeground(new Color(148, 0, 211));
		lblWelc.setBounds(10, 10, 642, 40);
		frmChngTrnhTnh.getContentPane().add(lblWelc);
		
		JLabel lblKq = new JLabel("");
		lblKq.setToolTipText("");
		lblKq.setBounds(45, 235, 341, 20);
		frmChngTrnhTnh.getContentPane().add(lblKq);
		
		JLabel lblAv = new JLabel("");
		lblAv.setBounds(45, 257, 630, 20);
		frmChngTrnhTnh.getContentPane().add(lblAv);
		
		JButton btnTinhBMI = new JButton("Tính BMI");
		btnTinhBMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strChieuCao = txtCao.getText();
				String strCanNang = txtNang.getText();
				
				double a = Double.parseDouble(strCanNang);
				double b = Double.parseDouble(strChieuCao);
				
				double kq = a/(b*b);
				
				kq = Math.ceil(kq*100)/100;
				
				String av1 = "Bạn quá gầy! Bạn nên có một chế độ ăn uống giàu dinh dưỡng!";
				String av2 = "Bạn có một thân hình cân đối! Cứ thế mà phát huy";
				String av3 = "Bạn bị thừa cân. Bạn nên có chế độ ăn hợp lý và tập luyện thể dục thường xuyên!";
				String av4 = "Bạn bị tiền béo phì. Bạn bên tìm gặp bác sĩ để được tư vấn về chế độ ăn kiêng cùng với các bài tập thể dục!";
				String av5 = "Bạn bị béo phì. Bạn bên tìm gặp bác sĩ để được tư vấn về chế độ ăn kiêng cùng với các bài tập thể dục!";
				String av6 = "Bạn bị béo phì cấp độ I. Bạn nên có một chế độ ăn uống lành mạnh hơn!";
				String av7 = "Bạn bị béo phì độ II. Bạn bên tìm gặp bác sĩ để được tư vấn về chế độ ăn kiêng cùng với các bài tập thể dục!";
				String av8 = "Bạn bị béo phì độ III. Bạn quá béo, bạn cần có chế độ ăn kiêng ngay và luôn!";
				
				String temp;
				temp= "Chỉ số BMI của bạn là "+ String.valueOf(kq);
				
				if (radA.isSelected() == true) {
					if (kq<18.5) 
						lblAv.setText(av1);
					else 
						if (kq>=18.5 && kq <25)
							lblAv.setText(av2);
						else
							if (kq>=25 && kq <30)
								lblAv.setText(av3);
							else
								if (kq>=29.9 && kq <=30)
									lblAv.setText(av5);
								else
									if (kq>30 && kq <40)
										lblAv.setText(av6);
									else
										if (kq>=40 && kq <50)
											lblAv.setText(av7);
										else
											lblAv.setText(av8);
				} else if (radNonA.isSelected() == true) {
					if (kq<18.5) 
						lblAv.setText(av1);
					else 
						if (kq>=18.5 && kq <23)
							lblAv.setText(av2);
						else
							if (kq>=23 && kq <25)
								lblAv.setText(av3);
							else
								if (kq>=25 && kq <29.9)
									lblAv.setText(av4);
								else
									if (kq>=29.9 && kq <=30)
										lblAv.setText(av5);
									else
										if (kq>30 && kq <40)
											lblAv.setText(av6);
										else
											if (kq>=40 && kq <50)
												lblAv.setText(av7);
											else
												lblAv.setText(av8);	
						} else lblAv.setText("Bạn chưa chọn khu vực");
				
				lblKq.setText(temp);
			}
		});
		btnTinhBMI.setBounds(131, 199, 89, 25);
		frmChngTrnhTnh.getContentPane().add(btnTinhBMI);
		
		
	}
}