package Bai2;

public class MonHoc {

	int MaMH;
	String tenMH;
	int soTC;
	int hocPhi;
	
	public MonHoc(int maMH, String tenMH, int soTC, int hocPhi) {
		super();
		MaMH = maMH;
		this.tenMH = tenMH;
		this.soTC = soTC;
		this.hocPhi = hocPhi;
	}
	public int getMaMH() {
		return MaMH;
	}
	public void setMaMH(int maMH) {
		MaMH = maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public int getSoTC() {
		return soTC;
	}
	public void setSoTC(int soTC) {
		this.soTC = soTC;
	}
	public int getHocPhi() {
		return hocPhi;
	}
	public void setHocPhi(int hocPhi) {
		this.hocPhi = hocPhi;
	}
	
	@Override
	public String toString() {
		return "Mã môn học: " + MaMH + "\n" + 
				"Tên môn học: " + tenMH + "\n" +
				"Số tín chỉ: " +soTC +"\n"
				+"Học phí: " + hocPhi;
	}
}