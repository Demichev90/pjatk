package pl.pjatk.hibernate_mds.dao;

/**
 * Created by 169785 on 2017-07-19.
 */
import java.io.Serializable;
import java.util.List;

public interface InterfaceDao<T, Id extends Serializable> {

    public void persist(T entity);

    public void update(T entity);

    public void delete(T entity);

    public List<T> findAll();

    public void deleteAll();


}


