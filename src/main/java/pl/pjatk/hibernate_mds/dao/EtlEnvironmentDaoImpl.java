package pl.pjatk.hibernate_mds.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pjatk.hibernate_mds.models.EtlEnvironmentModel;
import pl.pjatk.utils.databases.HibernateUtil;

import java.util.List;

/**
 * Created by 169785 on 2017-07-19.
 */
public class EtlEnvironmentDaoImpl  implements InterfaceDao<EtlEnvironmentModel, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public EtlEnvironmentDaoImpl() {
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
    public void persist(EtlEnvironmentModel entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(EtlEnvironmentModel entity) {
        getCurrentSession().update(entity);
    }


    public EtlEnvironmentModel findById(String id) {
        return (EtlEnvironmentModel) getCurrentSession().get(EtlEnvironmentModel.class, id);
    }

    @Override
    public void delete(EtlEnvironmentModel entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<EtlEnvironmentModel> findAll() {
        return (List<EtlEnvironmentModel>) getCurrentSession().createQuery("from EtlEnvironmentModel").list();
    }

    @Override
    public void deleteAll() {
        List<EtlEnvironmentModel> entityList = findAll();
        for (EtlEnvironmentModel entity : entityList) {
            delete(entity);
        }
    }
}
