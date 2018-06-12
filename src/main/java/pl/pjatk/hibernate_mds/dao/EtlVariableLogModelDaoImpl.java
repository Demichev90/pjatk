package pl.pjatk.hibernate_mds.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pjatk.hibernate_mds.models.EtlVariableLogModel;
import pl.pjatk.utils.databases.HibernateUtil;

import java.util.List;

/**
 * Created by 169785 on 2018-03-07.
 */
public class EtlVariableLogModelDaoImpl implements InterfaceDao<EtlVariableLogModel, String> {
    private Session currentSession;
    private Transaction currentTransaction;

    public EtlVariableLogModelDaoImpl()   {
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

    public EtlVariableLogModel findById(Long id) {
        return getCurrentSession().get(EtlVariableLogModel.class, id);
    }


    public List<EtlVariableLogModel> findByProcess(Long id) {
        return (List<EtlVariableLogModel>) getCurrentSession().createQuery("from EtlVariableLogModel where PROCESS_ID = " + id).list();
    }

    @Override
    public void persist(EtlVariableLogModel entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(EtlVariableLogModel entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(EtlVariableLogModel entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<EtlVariableLogModel> findAll() {
        return (List<EtlVariableLogModel>) getCurrentSession().createQuery("from EtlVariableLogModel").list();
    }

    @Override
    public void deleteAll() {
        List<EtlVariableLogModel> entityList = findAll();
        for (EtlVariableLogModel entity : entityList) {
            delete(entity);
        }
    }
}
