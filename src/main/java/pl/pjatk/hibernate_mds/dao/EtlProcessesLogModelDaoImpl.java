package pl.pjatk.hibernate_mds.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pjatk.hibernate_mds.models.EtlProcessLogModel;
import pl.pjatk.utils.databases.HibernateUtil;

import java.util.List;

/**
 * Created by 169785 on 2017-08-21.
 */
public class EtlProcessesLogModelDaoImpl implements InterfaceDao<EtlProcessLogModel, String> {
    private Session currentSession;
    private Transaction currentTransaction;

    public EtlProcessesLogModelDaoImpl() {
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

    public EtlProcessLogModel findById(Long id) {
        return getCurrentSession().get(EtlProcessLogModel.class, id);
    }


    @Override
    public void persist(EtlProcessLogModel entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(EtlProcessLogModel entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(EtlProcessLogModel entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<EtlProcessLogModel> findAll() {
        return (List<EtlProcessLogModel>) getCurrentSession().createQuery("from EtlProcessLogModel").list();
    }

    public List<EtlProcessLogModel> findByDate(String today) {
        return (List<EtlProcessLogModel>) getCurrentSession().createQuery("from EtlProcessLogModel where START_TM LIKE" + "'" + today + "%" + "'" ).list();
    }


    @Override
    public void deleteAll() {
        List<EtlProcessLogModel> entityList = findAll();
        for (EtlProcessLogModel entity : entityList) {
            delete(entity);
        }
    }
}
