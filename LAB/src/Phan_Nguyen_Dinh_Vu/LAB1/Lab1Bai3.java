package Phan_Nguyen_Dinh_Vu.LAB1;

import java.util.Scanner;
public class Lab1Bai3 {
	
	public static void main(String[] args) {
        System.out.println("Nhap vao do dai cua canh: ");
        Scanner input = new Scanner(System.in);
	double edge = input.nextDouble();

	System.out.println("The tich cua hinh la: " + Math.pow(edge, 3));
   }	
}
