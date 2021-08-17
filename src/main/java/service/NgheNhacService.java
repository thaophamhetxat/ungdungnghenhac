package service;

import moduls.NgheNhac;
import org.springframework.beans.factory.annotation.Autowired;
import repository.INgheNhacRepo;

import java.util.ArrayList;
import java.util.Locale;

public class NgheNhacService {
    @Autowired
    INgheNhacRepo iNgheNhacRepo;

    public ArrayList<NgheNhac> list = new ArrayList<>();


    public void save(NgheNhac ngheNhac) {
        iNgheNhacRepo.save(ngheNhac);
    }

    public void findAll() {
        list = iNgheNhacRepo.findAll();
    }

    public void edit(NgheNhac ngheNhac) {
        iNgheNhacRepo.edit(ngheNhac);
    }

    public void delete(int index) {
        iNgheNhacRepo.Delete(list.get(index));
        list.remove(index);
    }

//    public NgheNhac findByName(String name) {
//        for (ngheNhac p : list) {
//            if (p.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
//                return p;
//            }
//        }
//        return null;
//    }
}
