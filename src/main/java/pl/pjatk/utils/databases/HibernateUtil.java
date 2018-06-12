package pl.pjatk.utils.databases;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import pl.pjatk.exceptions.UtilException;

import java.io.File;

public class HibernateUtil {

    private static ServiceRegistry serviceRegistry;
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private static SessionFactory sessionFactory;
    private final static Logger logger = Logger.getLogger(HibernateUtil.class);


    private static SessionFactory configureSessionFactory() throws UtilException {
        try {
            Configuration configuration = new Configuration();
            File conFile = new File("hibernate.cfg.xml");
            sessionFactory = configuration.configure(conFile).buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            throw new UtilException("Error while configuring Hibernate session.", e);
        }
    }

    static {
        try {
            sessionFactory = configureSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            System.exit(1);
        }
    }

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() throws HibernateException {
        Session session = threadLocal.get();

        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession()
                    : null;
            threadLocal.set(session);
        }

        return session;


    }


    private static void rebuildSessionFactory() {
        try {
            sessionFactory = configureSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}