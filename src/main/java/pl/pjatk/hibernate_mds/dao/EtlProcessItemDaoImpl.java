package pl.pjatk.hibernate_mds.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pjatk.hibernate_mds.models.EtlProcItemModel;
import pl.pjatk.utils.databases.HibernateUtil;

import java.util.List;

/**
 * Created by 169785 on 2017-07-19.
 */
public class EtlProcessItemDaoImpl implements InterfaceDao<EtlProcItemModel, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public EtlProcessItemDaoImpl() {
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
    public void persist(EtlProcItemModel entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(EtlProcItemModel entity) {
        getCurrentSession().update(entity);
    }

    public EtlProcItemModel findById(Long id) {
        return (EtlProcItemModel) getCurrentSession().get(EtlProcItemModel.class, id);
    }

    @Override
    public void delete(EtlProcItemModel entity) {
        getCurrentSession().delete(entity);
    }


    @Override
    public List<EtlProcItemModel> findAll() {
        return (List<EtlProcItemModel>) getCurrentSession().createQuery("from EtlProcItemModel order by itemId").list();
    }

    public List<EtlProcItemModel> findAllOrderBy(String str) {
        return (List<EtlProcItemModel>) getCurrentSession().createQuery("from EtlProcItemModel order by " + str).list();
    }

    public List<EtlProcItemModel> findByProcess(long id) {
        return (List<EtlProcItemModel>) getCurrentSession().createQuery("from EtlProcItemModel where PROCESS_ID = " + id).list();
    }


    @Override
    public void deleteAll() {
        List<EtlProcItemModel> entityList = findAll();
        for (EtlProcItemModel entity : entityList) {
            delete(entity);
        }
    }
}
