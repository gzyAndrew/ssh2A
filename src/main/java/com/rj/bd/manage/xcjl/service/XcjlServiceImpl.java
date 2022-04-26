package com.rj.bd.manage.xcjl.service;

import com.rj.bd.entity.YxglXuanchuangjilu;
import com.rj.bd.framework.service.BasicSercvice;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class XcjlServiceImpl extends BasicSercvice {

	@Override
	public YxglXuanchuangjilu queryById(String id) throws ClassNotFoundException, SQLException {
		return (YxglXuanchuangjilu)dao.queryById(YxglXuanchuangjilu.class,id);
	}

	@Override
	public void delete(String[] ids) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		List list=new ArrayList();

		for (String id:ids) {
			System.out.println("id"+id);
			YxglXuanchuangjilu jl=new YxglXuanchuangjilu();
			jl.setXcjlId(id);
			list.add(jl);
		}
		dao.delete(list);
	}

	@Override
	public void save(Object obj) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		YxglXuanchuangjilu entity = (YxglXuanchuangjilu) obj;
		entity.setXcjlDate(new Timestamp(new Date().getTime()));
		entity.setXcjlId(UUID.randomUUID().toString());
		dao.save(entity);
	}

	@Override
	public void update(Object obj) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		YxglXuanchuangjilu entity = (YxglXuanchuangjilu) obj;
		entity.setXcjlDate(new Timestamp(new Date().getTime()));
		System.out.println(entity);
		dao.update(entity);
	}


	public List queryXcfs() throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		return dao.query("from com.rj.bd.entity.YxglXuanchuangfangshi");
	}

}
