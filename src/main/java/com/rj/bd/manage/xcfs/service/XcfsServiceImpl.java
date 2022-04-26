package com.rj.bd.manage.xcfs.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.rj.bd.entity.YxglXuanchuangfangshi;
import com.rj.bd.framework.service.BasicSercvice;
import org.springframework.stereotype.Component;

@Component
public class XcfsServiceImpl extends BasicSercvice {

	@Override
	public YxglXuanchuangfangshi queryById(String id) throws ClassNotFoundException, SQLException {
		return (YxglXuanchuangfangshi)dao.queryById(YxglXuanchuangfangshi.class,id);
	}

	@Override
	public void delete(String[] ids) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		List list=new ArrayList();

		for (String id:ids) {
			System.out.println("id"+id);
			YxglXuanchuangfangshi fs=new YxglXuanchuangfangshi();
			fs.setXcfsId(id);
			list.add(fs);
		}
		dao.delete(list);
	}

	@Override
	public void save(Object obj) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		YxglXuanchuangfangshi entity = (YxglXuanchuangfangshi) obj;
		entity.setXcfsInDate(new Timestamp(new Date().getTime()));
		entity.setXcfsId(UUID.randomUUID().toString());
		dao.save(entity);
	}

	@Override
	public void update(Object obj) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		YxglXuanchuangfangshi entity = (YxglXuanchuangfangshi) obj;
		entity.setXcfsInDate(new Timestamp(new Date().getTime()));
		dao.update(entity);
	}



}
