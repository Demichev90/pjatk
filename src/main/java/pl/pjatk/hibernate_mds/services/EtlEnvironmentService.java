package pl.pjatk.hibernate_mds.services;

import pl.pjatk.hibernate_mds.dao.EtlEnvironmentDaoImpl;
import pl.pjatk.hibernate_mds.models.EtlEnvironmentModel;
import pl.pjatk.utils.databases.HibernateUtil;

import java.util.List;

/**
 * Created by 169785 on 2017-07-19.
 */
public class EtlEnvironmentService {

    private static EtlEnvironmentDaoImpl etlEnvironmentDao;

    public EtlEnvironmentService() {
        etlEnvironmentDao = new EtlEnvironmentDaoImpl();
    }

    public void persist(EtlEnvironmentModel entity) {
        try {
            etlEnvironmentDao.openCurrentSessionWithTransaction();
            etlEnvironmentDao.persist(entity);
            etlEnvironmentDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void update(EtlEnvironmentModel entity) {
        try {
            etlEnvironmentDao.openCurrentSessionWithTransaction();
            etlEnvironmentDao.update(entity);
            etlEnvironmentDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public EtlEnvironmentModel findById(String id) {
        EtlEnvironmentModel processModel = null;
        try {
            etlEnvironmentDao.openCurrentSession();
            processModel = etlEnvironmentDao.findById(id);
            etlEnvironmentDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return processModel;
    }

    public void delete(String id) {
        try {
            etlEnvironmentDao.openCurrentSessionWithTransaction();
            EtlEnvironmentModel processListModel = etlEnvironmentDao.findById(id);
            etlEnvironmentDao.delete(processListModel);
            etlEnvironmentDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List<EtlEnvironmentModel> findAll() {
        List<EtlEnvironmentModel> etlEnvironmentModels = null;
        try {
            etlEnvironmentDao.openCurrentSession();
            etlEnvironmentModels = etlEnvironmentDao.findAll();
            etlEnvironmentDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return etlEnvironmentModels;
    }

    public void deleteAll() {
        try {
            etlEnvironmentDao.openCurrentSessionWithTransaction();
            etlEnvironmentDao.deleteAll();
            etlEnvironmentDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public EtlEnvironmentDaoImpl etlEnvironmentDao() {
        return etlEnvironmentDao;
    }
    
}
