package com.rj.bd.framework.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.rj.bd.framework.dao.IDao;


/**
 * @desc   
 * @author Administrator
 *
 */

@Transactional
public abstract class BasicSercvice {
	@Autowired
	protected IDao dao;
	
	/**
	 * 查询一条
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public abstract Object queryById( String id ) throws ClassNotFoundException, SQLException ;
	/**
	 * 保存
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public abstract void save( Object obj ) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException ;
	/**
	 * 修改
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public abstract void update( Object obj ) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException ;
	/**
	 * 删除
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public abstract void delete( String[] ids ) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException ;
	
	
	//get set 
	public IDao getDao() {
		return dao;
	}
	public void setDao(IDao dao) {
		this.dao = dao;
	}

	
}
