package Bai1;

public class MonHoc implements IEdu {
	
	String subName;
	int cred, fee;
	
	public MonHoc(String itemName, int cred, int fee) {
//		super();
		this.subName = itemName;
		this.cred = cred;
		this.fee = fee;
	}

	@Override
	public void add(IEdu e) {
		System.out.println("Không thể thêm");
	}

	@Override
	public void remove(IEdu e) {
		System.out.println("Không thể xóa");
	}

	@Override
	public void display(String prefix) {
		System.out.println(prefix + subName + " - " + cred + " tín chỉ - Học phí: " + fee);
		System.out.println("");
	}

}
