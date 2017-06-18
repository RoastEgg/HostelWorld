package dao;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public interface BaseDao {
    public Object persist(Object bean);

    public void delete(Object bean);

    public void update(Object bean);

    @SuppressWarnings("rawtypes")
	public Object findById(int i, Class clazz);

    @SuppressWarnings("rawtypes")
	public List findByHql(String hql);

    @SuppressWarnings("rawtypes")
	public List findAll(String tableName);

    @SuppressWarnings("rawtypes")
	public List findByProperties(String tableName, String[] name, Object[] values);

    @SuppressWarnings("rawtypes")
	public List findByPage(String tableName, int page, int pageSize);

    @SuppressWarnings("rawtypes")
	public List findByPropertiesAndPages(String tableName, String[] name, Object[] values, int page, int pageSize);

    public void clean(String tableName);
}
