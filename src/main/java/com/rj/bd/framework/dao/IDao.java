package com.rj.bd.framework.dao;

import com.rj.bd.framework.page.BasicPage;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


public interface IDao {
	/**
	 * 查询列表（不分页）
	 * @param
	 * @return list
	 */
	public List query( String hql );
	
	/**
	 * 查询列表：条件查询（将查询条件装入到了一个list中了）
	 * @param hql
	 * @param paramList
	 * @return
	 */
	//public List query(final String  hql,final List  paramList);
	
	/**
	 * 查询一条
	 * @param cla Class类
	 * @param id  主键
	 * @return
	 */
	public Object queryById( Class cla , Serializable id);
	/**
	 * 保存一条数据
	 * @param obj 对象
	 * @return
	 */
	public void save( Object obj );
	/**
	 * 保存一条数据
	 * @return
	 */
	public void save(  Collection c );
	/**
	 * 修改一条数据
	 * @param obj 对象
	 * @return
	 */
	public void update( Object obj );
	/**
	 * 删除一条数据
	 * @param obj 对象
	 * @return
	 */
	public void delete( Object obj );
	
	/**
	 * 删除多条数据
	 * @return
	 */
	public void delete( Collection c);
	/**
	 * 清空session中的特定实体
	 */
	public void clear(Object obj);
	/**
	 * 修改一条数据
	 * @param obj 对象
	 * @return
	 */
	public void merge(Object obj);
	
	
	/**
	 * @desc  分页＋条件查询
	 */
	public List queryObjectsToPages(final BasicPage page);
	
	
	/**
	 * @desc  查询一共有多少条
	 * @param page
	 * @return
	 */
	public int queryForInt(final BasicPage page);

}
