package Bai2;

public class Bai2Main {
 
    public static void main(String[] args) {
        
        Stream stream = new Stream();

        DataBinding data = new DataBinding(stream);
        data.dangKy();     
        
        stream.add(new MonHoc(1, "Lập trình Java", 2, 222000));
        stream.add(new MonHoc(2, "Lập trình Hướng đối tượng", 2, 222000));
        stream.add(new MonHoc(3, "Phat Trien Web", 2, 222000));
        
        System.out.println("---------Chỉnh sửa môn học---------");
        stream.update(new MonHoc(2, "Triết học Mác", 2, 220000));
		stream.update(new MonHoc(3, "Tư tưởng", 1, 120000));
		
    }
    
}