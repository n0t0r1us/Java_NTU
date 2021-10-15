package Phan_Nguyen_Dinh_Vu.SanPham;

public class SanPham {
	// Các thuộc tính
	private String maSanPham;
	private String tenSanPham;
	private Double giaSanPham;
	// Xây hàm khởi tạo (được gọi khi ta khai báo 1 đối tượng của lớp SanPham, từ khóa new)
	public SanPham() {
		this.maSanPham ="";
		this.tenSanPham ="";
		this.giaSanPham = 0.0;
	}
	public SanPham (String _maSP, String _tenSP, Double _giaSP) {
		this.maSanPham =_maSP;
		this.tenSanPham =_tenSP;
		this.giaSanPham =_giaSP;
	}
		
	// Các Getter (để lấy giá trị các thuộc tính)
	public String getMaSP( ) {return maSanPham;}
	public String getTenSP( ) {return tenSanPham;}
	public Double getGiaSP() {return 
		
	}
		
	}
	}

