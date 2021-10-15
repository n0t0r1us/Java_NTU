package Phan_Nguyen_Dinh_Vu.SanPham;

public class Product {
	private String code;
	private String name;
	private String price;
	/**
	 * 
	 */
	public Product() {
		super();
	}
	/**
	 * @param code
	 * @param name
	 * @param price
	 */
	public Product(String code, String name, String price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
