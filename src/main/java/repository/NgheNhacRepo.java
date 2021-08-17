package repository;

import moduls.NgheNhac;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class NgheNhacRepo implements INgheNhacRepo{
    @Autowired
    EntityManager entityManager;

    @Override
    public NgheNhac save(NgheNhac ngheNhac) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(ngheNhac);
        txn.commit();
        return ngheNhac;
    }
    @Override
    public void edit(NgheNhac ngheNhac) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(ngheNhac);
        txn.commit();
    }
    //show
    @Override
    public ArrayList<NgheNhac> findAll() {
        String queryStr = "SELECT c FROM NgheNhac AS c order by c.id asc ";
        TypedQuery<NgheNhac> query = entityManager.createQuery(queryStr, NgheNhac.class);
        return (ArrayList<NgheNhac>) query.getResultList();
    }

    @Override
    public void Delete(NgheNhac ngheNhac) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(ngheNhac);
        txn.commit();
    }


}
