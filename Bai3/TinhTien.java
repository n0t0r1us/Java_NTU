package Bai3;

public class TinhTien implements ITinhTien {
	ITinhTien successor;
	int soDienMax;
	double giaDien;

	
	public TinhTien(int soDienMax,double giaDien) {
		this.soDienMax = soDienMax;
		this.giaDien = giaDien;
	}

	@Override
	public ITinhTien setSuccessor(ITinhTien tinhTien) {
		this.successor = tinhTien;
		return tinhTien;
	}

	@Override                
	public double tinhTien(int soDienMaxBacTruoc, double soDien, double tongTien) {
		double soDienBac;// Biến tính số điện trong bậc hiện tại
		
		//Nếu số điện nhập vào lớn hơn bậc đang xét (Ví dụ:100 kw điện sẽ vượt qua bậc 1 vì bậc 1 từ 0 ->50)
		if (soDien < (soDienMax-soDienMaxBacTruoc)) {
			
			soDienBac = soDien; 	
			soDien = 0;  
		//Ngược lại, số điện không vượt qua khỏi bậc đang xét (ví dụ: 30 kw điện sẽ không vượt bậc 1	
		} else  {
			
			soDienBac = soDienMax-soDienMaxBacTruoc;
			soDien -= soDienBac; 
				
			} 
		//Nếu đây không phải là bậc cuối và số điện khác 0
		if ((successor != null) && (soDien !=0 )) {
				                      
			return successor.tinhTien(soDienMax,soDien,soDienBac*giaDien+tongTien);
					
			} else return (soDien+soDienBac)*giaDien+tongTien;
		
	}	
}