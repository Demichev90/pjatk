package pl.pjatk.hibernate_mds.services;

import pl.pjatk.hibernate_mds.dao.EtlVariableDaoImpl;
import pl.pjatk.hibernate_mds.models.EtlVariableModel;
import pl.pjatk.utils.databases.HibernateUtil;

import java.util.List;

/**
 * Created by 169785 on 2017-07-19.
 */
@SuppressWarnings("ALL")
public class EtlVariableService {

    private static EtlVariableDaoImpl variableDao;

    public EtlVariableService() {
        variableDao = new EtlVariableDaoImpl();
    }

    public void persist(EtlVariableModel entity) {
        try {
            variableDao.openCurrentSessionWithTransaction();
            variableDao.persist(entity);
            variableDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void update(EtlVariableModel entity) {
        try {
            variableDao.openCurrentSessionWithTransaction();
            variableDao.update(entity);
            variableDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public EtlVariableModel findById(Long id) {
        EtlVariableModel processModel = null;
        try {
            variableDao.openCurrentSession();
            processModel = variableDao.findById(id);
            variableDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return processModel;
    }


    public void delete(Long id) {
        try {
            variableDao.openCurrentSessionWithTransaction();
            EtlVariableModel processListModel = variableDao.findById(id);
            variableDao.delete(processListModel);
            variableDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List<EtlVariableModel> findAll() {
        List<EtlVariableModel> etlVariableModels = null;
        try {
            variableDao.openCurrentSession();
            etlVariableModels = variableDao.findAll();
            variableDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return etlVariableModels;
    }

    public List<EtlVariableModel> findByProcess(Long id) {
        List<EtlVariableModel> etlVariableModels = null;
        try {
            variableDao.openCurrentSession();
            etlVariableModels = variableDao.findByProcess(id);
            variableDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return etlVariableModels;
    }


    public List<EtlVariableModel> findAllGlobal() {
        List<EtlVariableModel> etlVariableModels = null;
        try {
            variableDao.openCurrentSession();
            etlVariableModels = variableDao.findAllGlobal();
            variableDao.closeCurrentSession();
        } finally {
            HibernateUtil.closeSession();
        }
        return etlVariableModels;
    }


    public void deleteAll() {
        try {
            variableDao.openCurrentSessionWithTransaction();
            variableDao.deleteAll();
            variableDao.closeCurrentSessionWithTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public EtlVariableDaoImpl variableDao() {
        return variableDao;
    }

}
