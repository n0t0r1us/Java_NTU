package Phan_Nguyen_Dinh_Vu.LAB1;

import java.util.Scanner;
import java.math.*;
public class Lab1Bai2 {
	
	public static void main(String[] args) {
		
	Scanner input = new Scanner(System.in);
        System.out.println("Nhap chieu dai HCN: ");
	int chieuDai = input.nextInt();
	System.out.println("Nhap chieu rong HCN: ");
	int chieuRong = input.nextInt();
	
	int chuVi = (chieuDai + chieuRong) * 2;
	
	int dienTich = chieuDai * chieuRong;
	
	int min = Math.min(chieuDai, chieuRong);

        System.out.printf("Chu vi HCN: %d \n ", chuVi);
	System.out.printf("Dien tich HCN: %d \n ", dienTich);
	System.out.printf("Canh nho nhat cua HCN: %d", min);
    }
}
	
