package repository;

import moduls.NgheNhac;

import java.util.ArrayList;

public interface INgheNhacRepo {
     NgheNhac save(NgheNhac ngheNhac);
     ArrayList<NgheNhac> findAll();
     void Delete(NgheNhac ngheNhac);
     void edit(NgheNhac ngheNhac);
}
