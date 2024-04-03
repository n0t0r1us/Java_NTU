package Bai2;

import java.util.ArrayList;
import java.util.List;

public class Stream {
	
    List<MonHoc> dsChuoi = new ArrayList<>();
    
    List<IConsumer> listeners = new ArrayList<>();

    public void dangKy(IConsumer o){
        if(!listeners.contains(o)){
            listeners.add(o);
        }
    }
    public void huyDangKy(IConsumer o){
        listeners.remove(o);
    }
    public void thongBaoCapNhat(){
        for(IConsumer o : listeners){
            o.update(dsChuoi);
        }
    }
    
    public void add(MonHoc mh){
    	MonHoc ma = TimMaMH(mh.getMaMH());
		if(ma == null)
		{
			System.out.println("Thêm: ");
			dsChuoi.add(mh);
			thongBaoCapNhat();

		}
		else {
			System.out.println("Môn học đã tồn tại");
		}
    }
    
    public void update(MonHoc mh){
    	MonHoc ma = TimMaMH(mh.getMaMH());
		if(ma != null)
		{
			System.out.println("Cập nhật: ");
			int index = dsChuoi.indexOf(ma);
			dsChuoi.set(index, mh);
			thongBaoCapNhat();

		}
		else {
			System.out.println("Môn học không tồn tại");
		}
		
    }
	public MonHoc TimMaMH(int id) {
		for(MonHoc mh : dsChuoi) 
			if(mh.getMaMH() == id) 
				return mh;
			
		return null;
	}
    public interface IConsumer {
        void update(List<MonHoc> monhoc);   
    }
}