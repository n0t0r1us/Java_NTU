package Phan_Nguyen_Dinh_Vu.SanPham;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.TextAreaPeer;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ChuongTrinhChinh {
	
	
	
	

	private JFrame frame;
	private JTextField textmaSP;
	private JTextField textTenSP;
	private JTextField textgiaSP;
	private JPanel panel;
	private JButton btnThemSP;
	private ArrayList<Product> dsSanPham;
	private JTextField txtmaSP_tk;
	private JTextField textxoa;
	private JTextField textsuama;
	private JTextField textsuaten;
	private JTextArea textdsSP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChuongTrinhChinh window = new ChuongTrinhChinh();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChuongTrinhChinh() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 620, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "S\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 330, 141);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textmaSP = new JTextField();
		textmaSP.setBounds(129, 28, 86, 20);
		panel.add(textmaSP);
		textmaSP.setColumns(10);
		
		textTenSP = new JTextField();
		textTenSP.setBounds(129, 62, 86, 20);
		panel.add(textTenSP);
		textTenSP.setColumns(10);
		
		textgiaSP = new JTextField();
		textgiaSP.setBounds(129, 93, 86, 20);
		panel.add(textgiaSP);
		textgiaSP.setColumns(10);
		
		btnThemSP = new JButton("Thêm");
		// Xin mới danh sách
		dsSanPham = new ArrayList<Product>();
		btnThemSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSanPham(dsSanPham);
				hienSanPham(dsSanPham);
		
			}
		});
		btnThemSP.setBounds(225, 46, 89, 52);
		panel.add(btnThemSP);
		
		JLabel lblNewLabel = new JLabel("Nhập mã sản phẩm:");
		lblNewLabel.setBounds(10, 31, 120, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập tên sản phẩm:");
		lblNewLabel_1.setBounds(10, 65, 120, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập giá sản phẩm:");
		lblNewLabel_2.setBounds(10, 96, 120, 14);
		panel.add(lblNewLabel_2);
		
		textdsSP = new JTextArea();
		textdsSP.setBounds(350, 11, 233, 144);
		frame.getContentPane().add(textdsSP);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "S\u1EEDa t\u00EAn s\u1EA3n ph\u1EA9m theo m\u00E3", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBackground(Color.LIGHT_GRAY);
		panel_1_2.setBounds(334, 210, 260, 83);
		frame.getContentPane().add(panel_1_2);
		panel_1_2.setLayout(null);
		
		textsuama = new JTextField();
		textsuama.setColumns(10);
		textsuama.setBounds(59, 22, 66, 20);
		panel_1_2.add(textsuama);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String xD ="Không sửa được sản phẩm!" ;
				for (int index = 0; index < dsSanPham.size();index++ ) {
					if (dsSanPham.get(index).getMaSP().equals(textsuama.getText())) {
						xD = "Đã sửa sản phẩm";
						dsSanPham.get(index).setTenSP(textsuaten.getText());
						hienSanPham(dsSanPham);
					}
						
					
				}
				JFrame frame = new JFrame("");
				JOptionPane.showMessageDialog(frame, xD,"THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
			}
				
		});
		btnSa.setBounds(101, 53, 66, 23);
		panel_1_2.add(btnSa);
		
		JLabel lblTnSp = new JLabel("Mã SP:");
		lblTnSp.setBounds(10, 25, 46, 14);
		panel_1_2.add(lblTnSp);
		
		JLabel lblMSp = new JLabel("Tên SP:");
		lblMSp.setBounds(134, 25, 46, 14);
		panel_1_2.add(lblMSp);
		
		textsuaten = new JTextField();
		textsuaten.setColumns(10);
		textsuaten.setBounds(184, 22, 66, 20);
		panel_1_2.add(textsuaten);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "X\u00F3a s\u1EA3n ph\u1EA9m theo m\u00E3", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2_1.setBackground(Color.LIGHT_GRAY);
		panel_1_2_1.setBounds(177, 210, 147, 83);
		frame.getContentPane().add(panel_1_2_1);
		panel_1_2_1.setLayout(null);
		
		textxoa = new JTextField();
		textxoa.setColumns(10);
		textxoa.setBounds(30, 23, 76, 20);
		panel_1_2_1.add(textxoa);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lmaoayy ="Không xóa được sản phẩm!" ;
				for (int index = 0; index < dsSanPham.size();index++ ) {
					if (dsSanPham.get(index).getMaSP().equals(textxoa.getText())) {
						dsSanPham.remove(index);
						lmaoayy = "Đã xóa";
						hienSanPham(dsSanPham);
					}
						
					
					
				}
				JFrame frame = new JFrame("");
				JOptionPane.showMessageDialog(frame, lmaoayy,"THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnXa.setBounds(30, 49, 76, 23);
		panel_1_2_1.add(btnXa);
		
		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setBackground(Color.LIGHT_GRAY);
		panel_1_2_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T\u00ECm s\u1EA3n ph\u1EA9m theo m\u00E3", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2_2.setBounds(10, 210, 157, 83);
		frame.getContentPane().add(panel_1_2_2);
		panel_1_2_2.setLayout(null);
		
		txtmaSP_tk = new JTextField();
		txtmaSP_tk.setBounds(33, 18, 100, 20);
		panel_1_2_2.add(txtmaSP_tk);
		txtmaSP_tk.setColumns(10);
		
		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ayylmao ="Không tìm thấy sản phẩm!" ;
				for (int index = 0; index < dsSanPham.size();index++ ) {
					if (dsSanPham.get(index).getMaSP().equals(txtmaSP_tk.getText()))
						ayylmao = "Đã tìm thấy sản phẩm";
					
					
				}
				JFrame frame = new JFrame("");
				JOptionPane.showMessageDialog(frame, ayylmao,"Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnTmKim.setBounds(33, 49, 100, 23);
		panel_1_2_2.add(btnTmKim);
		
	
	}// end init
	
	//
	void themSanPham(ArrayList<Product> dsSP) {
		String a = textmaSP.getText();
		boolean kt = true;
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		
		for (int i = 0; i < dsSP.size(); i++) 
			if (dsSP.get(i).getMaSP().equals(a))
			{ 
				kt=false;
				break;
			}
		
		if (kt == false) 
		{
			textmaSP.setText("");
			textTenSP.setText("");
			textgiaSP.setText("");
			JOptionPane.showMessageDialog(frame,
                "Mã SP đã tồn tại, vui lòng nhập lại!",
                "Kết quả xóa",
                JOptionPane.INFORMATION_MESSAGE);
		}
		else 
		{
			// Lấy các thông tin của sản phẩm từ các hộp văn bản
			String maSP=textmaSP.getText(), tenSP=textTenSP.getText();
			Double giaSP= Double.parseDouble(textgiaSP.getText());
			// Gói vào 1 biến kiểu SanPham
			Product sp = new Product(maSP, tenSP, giaSP);
			
			// Thêm vào danh sách
			dsSP.add(sp);
			
			
				}
		}

	
		
	
	void hienSanPham(ArrayList<Product> dsSP) {
		textdsSP.setText("");
		for (Product sp: dsSP) {
			String dongTrenTextArea = "";
			dongTrenTextArea = sp.getMaSP() + "---" + sp.getTenSP() + "---" + sp.getGiaSP() +"\n";
			// đưa lên TextArea
			textdsSP.append(dongTrenTextArea);
		}
	}
}
