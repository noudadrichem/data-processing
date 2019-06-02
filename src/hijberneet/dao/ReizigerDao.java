package hijberneet.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

import hijberneet.HibernateUtil;
import hijberneet.Reiziger;

public class ReizigerDao {

    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Reiziger entity) {
        getCurrentSession().save(entity);
    }

    public void update(Reiziger entity) {
        getCurrentSession().update(entity);
    }

    public Reiziger findById(int id) {
        return getCurrentSession().get(Reiziger.class, id);
    }

    public void delete(Reiziger entity) {
        getCurrentSession().delete(entity);
    }

    public ArrayList<Reiziger> findAll() {
        return (ArrayList<Reiziger>) getCurrentSession().createQuery("from Reiziger").list();
    }

    public void deleteAll() {
        ArrayList<Reiziger> entityList = findAll();
        for (Reiziger entity : entityList) {
            delete(entity);
        }
    }

}
