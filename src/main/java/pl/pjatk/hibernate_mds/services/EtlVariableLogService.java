package pl.pjatk.hibernate_mds.services;

import pl.pjatk.hibernate_mds.dao.EtlVariableLogModelDaoImpl;
import pl.pjatk.hibernate_mds.models.EtlVariableLogModel;
import pl.pjatk.utils.databases.HibernateUtil;

import java.util.List;

/**
 * Created by 169785 on 2018-03-07.
 */
@SuppressWarnings("ALL")
public class EtlVariableLogService {
    private static EtlVariableLogModelDaoImpl etlVariableLogModelDao;

    public EtlVariableLogService() {
        etlVariableLogModelDao = new EtlVariableLogModelDaoImpl();
    }

    public void persist(EtlVariableLogModel entity) {
        try {
            etlVariableLogModelDao.openCurrentSessionWithTransaction();
            etlVariableLogModelDao.persist(entity);
            etlVariableLogModelDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void update(EtlVariableLogModel entity) {
        try {
            etlVariableLogModelDao.openCurrentSessionWithTransaction();
            etlVariableLogModelDao.update(entity);
            etlVariableLogModelDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public EtlVariableLogModel findById(Long id) {
        EtlVariableLogModel processModel = null;
        try {
            etlVariableLogModelDao.openCurrentSession();
            processModel = etlVariableLogModelDao.findById(id);
            etlVariableLogModelDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return processModel;
    }




    public void delete(Long id) {
        try {
            etlVariableLogModelDao.openCurrentSessionWithTransaction();
            EtlVariableLogModel variableLogModel = etlVariableLogModelDao.findById(id);
            etlVariableLogModelDao.delete(variableLogModel);
            etlVariableLogModelDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List<EtlVariableLogModel> findAll() {
        List<EtlVariableLogModel> etlVariableLogModels = null;
        try {
            etlVariableLogModelDao.openCurrentSession();
            etlVariableLogModels = etlVariableLogModelDao.findAll();
            etlVariableLogModelDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return etlVariableLogModels;
    }

    public List<EtlVariableLogModel> findByProcess(Long id) {
        List<EtlVariableLogModel> etlVariableLogModels = null;
        try {
            etlVariableLogModelDao.openCurrentSession();
            etlVariableLogModels = etlVariableLogModelDao.findByProcess(id);
            etlVariableLogModelDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return etlVariableLogModels;
    }

    public void deleteAll() {
        try {
            etlVariableLogModelDao.openCurrentSessionWithTransaction();
            etlVariableLogModelDao.deleteAll();
            etlVariableLogModelDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public static EtlVariableLogModelDaoImpl getVariableLogModelDao() {
        return etlVariableLogModelDao;
    }
}
