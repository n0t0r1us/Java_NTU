package Phan_Nguyen_Dinh_Vu.LAB1;

import java.util.Scanner;

public class Lab1Bai1 {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Nhap ho va ten: ");
		
		String hoTen = input.nextLine();
		
		System.out.print("Nhap diem TB: ");
		
		float diemTB = input.nextFloat();
		String s_diemTB = String.format("%.2f", diemTB);
		
		System.out.printf("%s %s diem",hoTen, s_diemTB);
	}
}