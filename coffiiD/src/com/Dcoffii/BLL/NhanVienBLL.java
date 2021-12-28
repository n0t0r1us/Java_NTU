package com.Dcoffii.BLL;
import java.util.ArrayList;
import com.Dcoffii.DAL.NhanVienDAL;
import com.Dcoffii.DTO.NhanVienDTO;

public class NhanVienBLL {
	NhanVienDAL dalNhanVien = new NhanVienDAL();
	
	public boolean insert(NhanVienDTO x) {
		return dalNhanVien.insert(x);
	}
	//-------------------------------------------------------------------
	public boolean update(NhanVienDTO x) {
		
		return false;
	}
	//-------------------------------------------------------------------
	public boolean delete(int MaNV) {
		
		return false;
		
	}
	//------------------------------------------------------------------- 
	public ArrayList<NhanVienDTO> selectAll() 
	{	
		return dalNhanVien.selectAll();
	}
	//-------------------------------------------------------------------
	public NhanVienDTO 	findByID(int MaNV) {
		NhanVienDTO nhanVien = new NhanVienDTO();
		
		return nhanVien;
	}
	//-------------------------------------------------------------------
	public ArrayList<NhanVienDTO> findByName(String tenNhanVien) 
	{	
		return null;
	}
	// kiểm tra đăng nhập
	public boolean checkLogin(String tenDN, String matKhau) {
		
		boolean kq = dalNhanVien.checkLogin(tenDN, matKhau);
		return  kq;
		
	}
}
