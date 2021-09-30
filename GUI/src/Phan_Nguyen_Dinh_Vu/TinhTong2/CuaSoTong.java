package Phan_Nguyen_Dinh_Vu.TinhTong2;
import java.awt.*;
import java.awt.event.*;
public class CuaSoTong extends Frame{
	TextField txtA, txtB, txtKQ;
	Label lblA, lblB, lblKQ;
	Button btnCong;
	public CuaSoTong() {
		FlowLayout fL = new FlowLayout();
		setLayout(fL);
		setBounds(0, 0, 400, 200);
		lblA = new Label("A=");
		lblB = new Label("B=");
		lblKQ = new Label("KQ=");
		txtA = new TextField();
		txtB = new TextField();
		txtKQ = new TextField();
		btnCong = new Button("Tinh Tong");
		add(lblA);	add(txtA);
		add(lblB);	add(txtB);
		add(btnCong);
		add(lblKQ);	add(txtKQ);					
		setTitle("Chương trình tính tổng 2 số");
		setVisible(true);
		btnCong.addActionListener(new BoLangNghe_XL_Cong());	
		addWindowListener(new BoLangNghe_XL_CuaSo());
	}
	class BoLangNghe_XL_Cong implements ActionListener{			
			
	
			public void actionPerformed(ActionEvent e) {
	
				String strA = txtA.getText();
				String strB = txtB.getText();
			
				int a = Integer.parseInt(strA);
				int b = Integer.parseInt(strB);
	
				int c = a+b;
				
				txtKQ.setText(String.valueOf(c));
				}
								
			}
		};
			
	class BoLangNghe_XL_CuaSo implements WindowListener{

		
		public void windowOpened(WindowEvent e) {
			
			
		}
		
		
		public void windowClosing(WindowEvent e) {
			System.exit(0);
			
		}

		
		public void windowClosed(WindowEvent e) {
			
			
		}

		
		public void windowIconified(WindowEvent e) {
			
			
		}

		
		public void windowDeiconified(WindowEvent e) {
			
			
		}

		
		public void windowActivated(WindowEvent e) {
			
			
		}

		
		public void windowDeactivated(WindowEvent e) {
		
			
		}
			
		};