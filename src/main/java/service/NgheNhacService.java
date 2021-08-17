package service;

import moduls.NgheNhac;

import java.util.ArrayList;

public class NgheNhacService {
    public ArrayList<NgheNhac> list = new ArrayList<>();
    public NgheNhacService(){
        list.add(new NgheNhac("1","1","1","/music/tiengcuoibadao.mp3"));
        list.add(new NgheNhac("1","1","1","/music/Roi-Toi-Luon-Cover-Ut-Nhi-Mino.mp3"));

    }
    public void save(NgheNhac ngheNhac){
        list.add(ngheNhac);
    }
    public void play(NgheNhac ngheNhac,int index){
        list.set(index,ngheNhac);
    }
}
