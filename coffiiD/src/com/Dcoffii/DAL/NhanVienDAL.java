package com.Dcoffii.DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.Dcoffii.DTO.NhanVienDTO;

public class NhanVienDAL {
	Connection	connectDB = KetNoiDB.MoKetNoi("coffiid", "root", "");
	
	//Thêm mới nhân viên, và trả về giá trị True, nếu thêm thành công 
	public boolean insert(NhanVienDTO x) {
		String sqlThem  = "INSERT INTO nhanvien VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement cmd =  connectDB.prepareStatement(sqlThem);
			//
			cmd.setInt(1, x.getMaNV()   );     // 
			cmd.setString(2,x.getHoTenNV()   ); 
			cmd.setDate(3,x.getNamSinhNV()   ); 
			cmd.setString(4, x.getTenDN());
			cmd.setString(5,x.getMatKhau()   ); 
			cmd.setString(6,x.getQuyen()   ); 
			//
			boolean themDuoc =   cmd.execute();
			return themDuoc;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
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
		ArrayList<NhanVienDTO> dsNhanVien = new ArrayList<NhanVienDTO>();
		Statement stmt;
		try {
			stmt = connectDB.createStatement();
			String sqlSelectNhanVien ="SELECT * FROM nhanvien";
			ResultSet tblNhanVien = stmt.executeQuery(sqlSelectNhanVien);
			// Xử lý  tblNhanVien   --> dsNhanVien
			while (tblNhanVien.next())  // trong khi mà còn next được (còn dòng)
			{ // Xử lý mỗi dòng
				// Lấy dữ liệu từng cột
				int maNV           = tblNhanVien.getInt("MaNV"); // Cột số 0
					String hoTenNV = tblNhanVien.getString("HoTen"); // Cột số 1
					Date ngaySinh  = tblNhanVien.getDate("NgaySinh"); 
					String tenDN   = tblNhanVien.getString("TenDN");
					String matKhau = tblNhanVien.getString("MatKhau");
					String quyen   = tblNhanVien.getString("Quyen");
					NhanVienDTO nv = new NhanVienDTO(maNV, hoTenNV, ngaySinh, tenDN, matKhau, quyen) ;
					dsNhanVien.add(nv);
				}
				return dsNhanVien;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//-------------------------------------------------------------------
	public NhanVienDTO 	findByID(int MaNV) {
		NhanVienDTO nhanVien = new NhanVienDTO();
		
		return nhanVien;
	}
	//-------------------------------------------------------------------
	public ArrayList<NhanVienDTO> findByName(String tenNhanVien) 
	{	
		ArrayList<NhanVienDTO> dsNhanVien = new ArrayList<NhanVienDTO>();
		
		return dsNhanVien;
	}
	public boolean checkLogin(String tenDN, String matKhau) {
		
		String sqlCheck  = "select * from nhanvien where TenDN ='" + tenDN + "' and MatKhau='" + matKhau + "'"; 
		try {
			Statement cmd =  connectDB.createStatement(); 
			ResultSet rs=  cmd.executeQuery(sqlCheck);
			if (rs.next() )  return true;     // Login success
			else return false;   // login fail
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
}
