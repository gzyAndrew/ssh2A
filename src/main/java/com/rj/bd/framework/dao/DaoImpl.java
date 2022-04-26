package com.rj.bd.framework.dao;

import java.io.Serializable;
import java.sql.Types;
import java.util.Collection;
import java.util.List;

import com.rj.bd.framework.page.BasicPage;
import com.rj.bd.framework.page.Param;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;


/**
 * @desc dao的实现类
 * @author WYH
 * @time 2019-04-17
 */
public class DaoImpl extends HibernateDaoSupport implements IDao {

	/**
	 * @desc  查询不分页
	 * @param hql
	 * @return
	 */
	@Override
	public List query(String hql) {

		return super.getHibernateTemplate().find(hql);
	}

	@Override
	public Object queryById(Class cla, Serializable id) {
		return this.getHibernateTemplate().load(cla, id);
	}

	@Override
    public void save(Object obj) {
		super.getHibernateTemplate().save(obj);
	}

	@Override
	public void update(Object obj) {
		super.getHibernateTemplate().update(obj);
	}

	@Override
	public void delete(Object obj) {
		super.getHibernateTemplate().delete(obj);
	}

	@Override
	public void delete(Collection c) {
		super.getHibernateTemplate().deleteAll(c);
	}

	@Override
	public void save(Collection c) {
		super.getHibernateTemplate().saveOrUpdate(c);
	}

	@Override
	public void clear(Object obj) {
		super.getHibernateTemplate().evict(obj);

	}

	@Override
	public void merge(Object obj) {
		super.getHibernateTemplate().merge(obj);

	}


	@Override
	public List<?> queryObjectsToPages(BasicPage page) {
		HibernateTemplate hibernatetemplate = super.getHibernateTemplate();
		return (List<?>) hibernatetemplate.execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(page.getHQLString());// 执行HQL语句
				List<?> list = page.getParamList();
				for (int i = 0; i < list.size(); i++)// 把参数逐个取出，然后给其设定上具体的值和数据类型
				{
					Param p = (Param) list.get(i);

					switch (p.getType()) {
					case Types.VARCHAR:
						query.setString(i, String.valueOf(p.getValue()));// 如果HQL语句中的参数是字符串类型，那么就调用query对象的setString()方法实现条件查询
						break; // 其实这个就是相当于我们之前给sql语句中的？设置类型和指
					case Types.INTEGER:
						query.setInteger(i, (Integer) p.getValue());
						break;
					case Types.FLOAT:
						query.setFloat(i, (Float) p.getValue());
						break;
					case Types.DOUBLE:
						query.setDouble(i, (Double) p.getValue());
						break;
					case Types.BOOLEAN:
						query.setBoolean(i, ((Boolean) p.getValue()).booleanValue());
						break;
					case Types.CHAR:
						query.setCharacter(i, ((Character) p.getValue()).charValue());
						break;
					case Types.DATE:
						query.setTimestamp(i, (java.util.Date) p.getValue());
						break;
					case Types.ARRAY:
						query.setParameterList("inParam0", (List) p.getValue());
						break;
					}
				}
				query.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
				query.setMaxResults(page.getPageSize());
				return query.list();// 最终获取分页的数据集合
			}
		});
	}

	@Override
	public int queryForInt(BasicPage page) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(this.getSessionFactory());
		return (int) hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(page.getHQLCountString());
				List<?> list = page.getParamList();

				for (int i = 0; i < list.size(); i++) {
					Param p = (Param) list.get(i);

					switch (p.getType()) {
					case Types.VARCHAR:
						query.setString(i, String.valueOf(p.getValue()));
						break;
					case Types.INTEGER:
						query.setInteger(i, (Integer) p.getValue());
						break;
					case Types.FLOAT:
						query.setFloat(i, (Float) p.getValue());
						break;
					case Types.DOUBLE:
						query.setDouble(i, (Double) p.getValue());
						break;
					case Types.BOOLEAN:
						query.setBoolean(i, ((Boolean) p.getValue()).booleanValue());
						break;
					case Types.CHAR:
						query.setCharacter(i, ((Character) p.getValue()).charValue());
						break;
					case Types.DATE:
						query.setTimestamp(i, (java.util.Date) p.getValue());
						break;
					case Types.ARRAY:
						query.setParameterList("inParam0", (List) p.getValue());
						break;
					}
				}
				List<?> list_query_count = query.list();
				int c = Integer.parseInt(list_query_count.get(0).toString());
				System.out.println("本次分页查询一共有：--------->" + c + "条数据");
				return c;
			}
		});
	}

}
