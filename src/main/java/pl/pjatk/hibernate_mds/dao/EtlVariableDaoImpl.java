package pl.pjatk.hibernate_mds.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pjatk.hibernate_mds.models.EtlVariableModel;
import pl.pjatk.utils.databases.HibernateUtil;

import java.util.List;

public class EtlVariableDaoImpl  implements InterfaceDao<EtlVariableModel, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public EtlVariableDaoImpl() {
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
    public void persist(EtlVariableModel entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(EtlVariableModel entity) {
        getCurrentSession().update(entity);
    }


    public EtlVariableModel findById(Long id) {
        return (EtlVariableModel) getCurrentSession().get(EtlVariableModel.class, id);
    }

    @Override
    public void delete(EtlVariableModel entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<EtlVariableModel> findAll() {
        return (List<EtlVariableModel>) getCurrentSession().createQuery("from EtlVariableModel").list();
    }

    public List<EtlVariableModel> findByProcess(Long id) {
        return (List<EtlVariableModel>) getCurrentSession().createQuery("from EtlVariableModel where PROCESS_ID = " + id).list();
    }


    @SuppressWarnings("unchecked")
    public List<EtlVariableModel> findAllGlobal() {
        return (List<EtlVariableModel>) getCurrentSession().createQuery("from EtlVariableModel where etl_precess is null and etl_item is null").list();
    }


    @Override
    public void deleteAll() {
        List<EtlVariableModel> entityList = findAll();
        for (EtlVariableModel entity : entityList) {
            delete(entity);
        }
    }


}
