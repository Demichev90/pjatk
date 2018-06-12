package pl.pjatk.hibernate_mds.services;

import pl.pjatk.hibernate_mds.dao.EtlProcessesLogModelDaoImpl;
import pl.pjatk.hibernate_mds.models.EtlProcessLogModel;
import pl.pjatk.utils.databases.HibernateUtil;

import java.util.List;

/**
 * Created by 169785 on 2017-08-21.
 */
@SuppressWarnings("ALL")
public class EtlProcessesLogModelService {

    private static EtlProcessesLogModelDaoImpl etlProcessesLogModelDao;

    public EtlProcessesLogModelService() {
        etlProcessesLogModelDao = new EtlProcessesLogModelDaoImpl();
    }

    public void persist(EtlProcessLogModel entity) {
        try {
            etlProcessesLogModelDao.openCurrentSessionWithTransaction();
            etlProcessesLogModelDao.persist(entity);
            etlProcessesLogModelDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void update(EtlProcessLogModel entity) {
        try {
            etlProcessesLogModelDao.openCurrentSessionWithTransaction();
            etlProcessesLogModelDao.update(entity);
            etlProcessesLogModelDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public EtlProcessLogModel findById(Long id) {
        EtlProcessLogModel processModel = null;
        try {
            etlProcessesLogModelDao.openCurrentSession();
            processModel = etlProcessesLogModelDao.findById(id);
            etlProcessesLogModelDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return processModel;
    }

    public void delete(Long id) {
        try {
            etlProcessesLogModelDao.openCurrentSessionWithTransaction();
            EtlProcessLogModel processListModel = etlProcessesLogModelDao.findById(id);
            etlProcessesLogModelDao.delete(processListModel);
            etlProcessesLogModelDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List<EtlProcessLogModel> findAll() {
        List<EtlProcessLogModel> etlProcessItemsModels = null;
        try {
            etlProcessesLogModelDao.openCurrentSession();
            etlProcessItemsModels = etlProcessesLogModelDao.findAll();
            etlProcessesLogModelDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return etlProcessItemsModels;
    }

    public List<EtlProcessLogModel> findByDate(String today) {
        List<EtlProcessLogModel> etlProcessItemsModels = null;
        try {
            etlProcessesLogModelDao.openCurrentSession();
            etlProcessItemsModels = etlProcessesLogModelDao.findByDate(today);
            etlProcessesLogModelDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return etlProcessItemsModels;
    }




    public void deleteAll() {
        try {
            etlProcessesLogModelDao.openCurrentSessionWithTransaction();
            etlProcessesLogModelDao.deleteAll();
            etlProcessesLogModelDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public static EtlProcessesLogModelDaoImpl getEtlProcessesLogModelDao() {
        return etlProcessesLogModelDao;
    }
}
