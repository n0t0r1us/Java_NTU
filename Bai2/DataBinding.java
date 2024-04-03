package Bai2;

import java.util.List;

public class DataBinding implements Stream.IConsumer{
    Stream stream;

    public DataBinding(Stream stream){
        this.stream = stream;
    }

    public void dangKy(){
        stream.dangKy(this);
    }

    public void huyDangKy(){
        stream.huyDangKy(this);
    }

    @Override
    public void update(List<MonHoc> chuoi) {
        for (MonHoc o : chuoi){
            System.out.println(o);
        } 
    }

}