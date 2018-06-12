package pl.pjatk.hibernate_mds.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pjatk.hibernate_mds.models.EtlProcessModel;
import pl.pjatk.utils.databases.HibernateUtil;

import java.util.List;

public class EtlProcessDaoImpl implements InterfaceDao<EtlProcessModel, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public EtlProcessDaoImpl() {
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = HibernateUtil.getSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        HibernateUtil.closeSession();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        HibernateUtil.closeSession();
    }


    @Override
    public void persist(EtlProcessModel entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(EtlProcessModel entity) {
        getCurrentSession().update(entity);
    }


    public EtlProcessModel findById(Long id) {
        return getCurrentSession().get(EtlProcessModel.class, id);
    }

    @Override
    public void delete(EtlProcessModel entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<EtlProcessModel> findAll() {
        return (List<EtlProcessModel>) getCurrentSession().createQuery("from EtlProcessModel").list();
    }

    @Override
    public void deleteAll() {
        List<EtlProcessModel> entityList = findAll();
        for (EtlProcessModel entity : entityList) {
            delete(entity);
        }
    }

    public List<EtlProcessModel> findAllActive() {
        return (List<EtlProcessModel>) getCurrentSession().createQuery("from EtlProcessModel where active = :active").setParameter("active", "T").list();
    }
}
