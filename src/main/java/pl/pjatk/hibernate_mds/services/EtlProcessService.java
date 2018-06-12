package pl.pjatk.hibernate_mds.services;

import pl.pjatk.hibernate_mds.dao.EtlProcessDaoImpl;
import pl.pjatk.hibernate_mds.models.EtlProcessModel;
import pl.pjatk.utils.databases.HibernateUtil;

import java.util.List;

/**
 * Created by 169785 on 2017-07-19.
 */
@SuppressWarnings("ALL")
public class EtlProcessService {

    private static EtlProcessDaoImpl processDao;

    public EtlProcessService() {
        processDao = new EtlProcessDaoImpl();
    }

    public void persist(EtlProcessModel entity) {
        try {
            processDao.openCurrentSessionWithTransaction();
            processDao.persist(entity);
            processDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void update(EtlProcessModel entity) {
        try {
            processDao.openCurrentSessionWithTransaction();
            processDao.update(entity);
            processDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public EtlProcessModel findById(Long id) {
        EtlProcessModel processModel = null;
        try {
            processDao.openCurrentSession();
            processModel = processDao.findById(id);
            processDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return processModel;
    }

    public void delete(long id) {
        try {
            processDao.openCurrentSessionWithTransaction();
            EtlProcessModel processListModel = processDao.findById(id);
            processDao.delete(processListModel);
            processDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List<EtlProcessModel> findAll() {
        List<EtlProcessModel> etlProcessModels = null;
        try {
            processDao.openCurrentSession();
            etlProcessModels = processDao.findAll();
            processDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return etlProcessModels;
    }

    public void deleteAll() {
        try {
            processDao.openCurrentSessionWithTransaction();
            processDao.deleteAll();
            processDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public EtlProcessDaoImpl processDao() {
        return processDao;
    }

    public List<EtlProcessModel> findAllActive() {
        List<EtlProcessModel> etlProcessModels = null;
        try {
            processDao.openCurrentSession();
            etlProcessModels = processDao.findAllActive();
            processDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return etlProcessModels;
    }
}
