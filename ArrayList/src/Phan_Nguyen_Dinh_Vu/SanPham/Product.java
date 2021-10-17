package Phan_Nguyen_Dinh_Vu.SanPham;

public class Product {
	// Các thuộc tính
	private String maSanPham;
	private String tenSanPham;
	private Double giaSanPham;
	// Xây hàm khởi tạo (được gọi khi ta khai báo 1 đối tượng của lớp SanPham, từ khóa new)
	public Product() {
		this.maSanPham ="";
		this.tenSanPham ="";
		this.giaSanPham = 0.0;
	}
	public Product (String _maSP, String _tenSP, Double _giaSP) {
		this.maSanPham =_maSP;
		this.tenSanPham =_tenSP;
		this.giaSanPham =_giaSP;
	}
		
	// Các Getter (để lấy giá trị các thuộc tính)
	public String getMaSP( ) {return maSanPham;}
	public String getTenSP( ) {return tenSanPham;}
	public Double getGiaSP() {return giaSanPham;}
	
	// Các Setter (để gán giá trị cho các thuộc tính)
	public void setMaSP(String _maSanPham)
	{
		maSanPham = _maSanPham;
	}
	public void setTenSP(String _tenSanPham)
	{
		tenSanPham = _tenSanPham;
	}
	public void setGiaSP(Double _giaSanPham)
	{
		giaSanPham = _giaSanPham;
	}
}
	