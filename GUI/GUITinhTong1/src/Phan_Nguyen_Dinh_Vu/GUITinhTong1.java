package Phan_Nguyen_Dinh_Vu;
import java.awt.*;
import java.awt.event.*;
public class GUITinhTong1 {	
	public static  void main(String[] args) {
		
		Frame fr = new Frame("Tong 2 so A B");	
		fr.setBounds(0, 0, 600, 400);
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();  
		fr.setLayout(layout);	
		constraints.insets= new Insets(2,2,2,2);
		fr.setVisible(true);
		
		
		Label lblA = new Label("A=");
		Label lblB = new Label("B=");
		Label lblKQ = new Label("KQ=");
		
		
		TextField txtA = new TextField();
		TextField txtB = new TextField();
		TextField txtKQ = new TextField();
		
		Button btnCong = new Button("Tinh Tong");
		
		fr.add(lblA); 	fr.add(txtA);
		fr.add(lblB); 	fr.add(txtB);
		fr.add(lblKQ); 	fr.add(txtKQ);
		fr.add(btnCong);
			
			ActionListener bolangnghe = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String strA = txtA.getText();
					String strB = txtB.getText();
					int a = Integer.parseInt(strA);
					int b = Integer.parseInt(strB); 
					int c = a+b;
					txtKQ.setText(String.valueOf(c) );
					
				}
			};
			
		btnCong.addActionListener(bolangnghe);
		
		fr.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}
			

