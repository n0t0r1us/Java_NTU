package Phan_Nguyen_Dinh_Vu;

import java.util.Scanner;

public class Lab1Bai4 {
	
	public static void main(String[] args) {
		System.out.print("Nhap vao he so a, b ,c cua phuong trinh bac 2 theo thu tu: ");
		Scanner input = new Scanner(System.in);
		
	double a = input.nextDouble();
	double b = input.nextDouble();
	double c = input.nextDouble();
		
	double delta = Math.pow(b,2) - 4*a*c;
	
	if (delta < 0) {
		System.out.print("PT vo nghiem, ko co can delta");
	} else {
		System.out.print("Can delta la: " + Math.sqrt(delta));
	}
    }
}
