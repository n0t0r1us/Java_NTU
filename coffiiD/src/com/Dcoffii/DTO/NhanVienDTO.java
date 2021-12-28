package com.Dcoffii.DTO;

import java.sql.Date;

public class NhanVienDTO {
	//
	private int MaNV;
	private String hoTenNV;
	private Date namSinhNV;
	private String tenDN;
	private String matKhau;
	private String quyen;
	
	
	
	public NhanVienDTO(int maNV, String hoTenNV, Date namSinhNV, String tenDN, String matKhau, String quyen) {
		super();
		MaNV = maNV;
		this.hoTenNV = hoTenNV;
		this.namSinhNV = namSinhNV;
		this.tenDN = tenDN;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}
	public NhanVienDTO() {
		super();
	}
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public String getHoTenNV() {
		return hoTenNV;
	}
	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
	}
	public Date getNamSinhNV() {
		return namSinhNV;
	}
	public void setNamSinhNV(Date namSinhNV) {
		this.namSinhNV = namSinhNV;
	}
	public String getTenDN() {
		return tenDN;
	}
	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getQuyen() {
		return quyen;
	}
	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}
	

}
