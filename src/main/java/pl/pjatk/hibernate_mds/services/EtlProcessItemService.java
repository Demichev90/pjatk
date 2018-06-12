package pl.pjatk.hibernate_mds.services;

import pl.pjatk.hibernate_mds.dao.EtlProcessItemDaoImpl;
import pl.pjatk.hibernate_mds.models.EtlProcItemModel;
import pl.pjatk.utils.databases.HibernateUtil;

import java.util.List;

/**
 * Created by 169785 on 2017-07-19.
 */
@SuppressWarnings("Duplicates")
public class EtlProcessItemService {

    private static EtlProcessItemDaoImpl processItemDao;

    public EtlProcessItemService() {
        processItemDao = new EtlProcessItemDaoImpl();
    }

    public void persist(EtlProcItemModel entity) {
        try {
            processItemDao.openCurrentSessionWithTransaction();
            processItemDao.persist(entity);
            processItemDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void update(EtlProcItemModel entity) {
        try {
            processItemDao.openCurrentSessionWithTransaction();
            processItemDao.update(entity);
            processItemDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public EtlProcItemModel findById(Long id) {
        EtlProcItemModel processModel = null;
        try {
            processItemDao.openCurrentSession();
            processModel = processItemDao.findById(id);
            processItemDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return processModel;
    }

    public void delete(Long id) {
        try {
            processItemDao.openCurrentSessionWithTransaction();
            EtlProcItemModel processListModel = processItemDao.findById(id);
            processItemDao.delete(processListModel);
            processItemDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List<EtlProcItemModel> findAll() {
        List<EtlProcItemModel> etlProcItemModels = null;
        try {
            processItemDao.openCurrentSession();
            etlProcItemModels = processItemDao.findAll();
            processItemDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return etlProcItemModels;
    }

    public List<EtlProcItemModel> findbyProcess(Long id) {
        List<EtlProcItemModel> etlProcItemModels = null;
        try {
            processItemDao.openCurrentSession();
            etlProcItemModels = processItemDao.findByProcess(id);
            processItemDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return etlProcItemModels;
    }

    public void deleteAll() {
        try {
            processItemDao.openCurrentSessionWithTransaction();
            processItemDao.deleteAll();
            processItemDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public EtlProcessItemDaoImpl processItemDao() {
        return processItemDao;
    }

}
