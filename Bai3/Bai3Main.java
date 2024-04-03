package Bai3;

public class Bai3Main {
	
	public static void main(String[] args) {
		ITinhTien bac1 = new TinhTien(50,1678);
		ITinhTien bac2 = new TinhTien(100,1734); 
		ITinhTien bac3 = new TinhTien(200,2014); 
		ITinhTien bac4 = new TinhTien(300,2536);
		ITinhTien bac5 = new TinhTien(400,2834); 
		ITinhTien bac6 = new TinhTien(0,2927); 
		
		ITinhTien bacGiaBanLe = new TinhTien(0,2461);
		
		bac1.setSuccessor(bac2).setSuccessor(bac3).setSuccessor(bac4).setSuccessor(bac5).setSuccessor(bac6);
		
		System.out.println("Giá bán lẻ điện sinh hoạt");
		System.out.println("   500 kWh điện" + ": " + bac1.tinhTien(0,500,0)+"VNĐ");
		System.out.println("   200 kWh điện" + ": " + bac1.tinhTien(0,200,0)+"VNĐ");
		System.out.println("Giá bán lẻ điện sinh hoạt dùng công tơ thẻ trả trước");
		System.out.println("   100 kWh điện" + ": " + bacGiaBanLe.tinhTien(0,50,0)+"VNĐ");

	}

}