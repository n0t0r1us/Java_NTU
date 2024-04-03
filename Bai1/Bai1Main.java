package Bai1;

public class Bai1Main {
	
	public static void main(String[] args) {
		IEdu khoa = new Edu("Khóa");
		IEdu nam2021 = new Edu("Năm 2021");
		IEdu nam2022 = new Edu("Năm 2022");
		IEdu hocKi1 = new Edu("Học kì I");
		IEdu hocKi2 = new Edu("Học kì II");
		IEdu hocKiHe = new Edu("Học kì hè");
		
		khoa.add(nam2021);
		khoa.add(nam2022);
		nam2021.add(hocKi1);
		nam2021.add(hocKi2);
		nam2022.add(hocKiHe);
		
		IEdu monHoc1 = new MonHoc("C/C++", 2, 100);
		IEdu monHoc2 = new MonHoc("C#", 3, 250);
		
		IEdu monHoc3 = new MonHoc("SQL", 3, 100);
		IEdu monHoc4 = new MonHoc("Java", 2, 200);
		
		IEdu monHoc5 = new MonHoc("Python", 4, 150);
		IEdu monHoc6 = new MonHoc("Pascal", 2, 100);
		
		hocKi1.add(monHoc6);
		hocKi1.add(monHoc5);
		
		hocKi2.add(monHoc1);
		hocKi2.add(monHoc2);
		
		hocKiHe.add(monHoc3);
		hocKiHe.add(monHoc4);
		
//		nam2021.display("");
		hocKi2.display("");
//		khoa.display("");
	}
}
