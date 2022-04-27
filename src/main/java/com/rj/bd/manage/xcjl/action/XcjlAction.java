package com.rj.bd.manage.xcjl.action;

import com.rj.bd.framework.action.BasicAction;
import com.rj.bd.framework.page.BasicPage;
import com.rj.bd.framework.service.BasicSercvice;
import com.rj.bd.manage.xcjl.service.XcjlServiceImpl;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParentPackage(value = "struts-default")
@Namespace(value = "/xcjl")
public class XcjlAction extends BasicAction{
	@Autowired
	@Qualifier("xcjlPage")
	public BasicPage page;
	@Autowired
	@Qualifier("xcjlServiceImpl")
	public BasicSercvice service;
	@Autowired
	@Qualifier("yxglXuanchuangjilu")
	public Object entity;

	@Action(value = "query")
	public void query() throws Exception {
		System.out.println("query()--->");
		super.query(page);
	}

	@Action(value = "addpage")
	public void addpage() throws Exception {
		 super.addpage();
		List list = ((XcjlServiceImpl) service).queryXcfs();
		output(list);
	}

	@Action(value = "add")
	public void add() throws Exception {
		 super.add(service, entity);
	}

	@Action(value = "editpage")
	public void editpage() throws Exception {
		entity=super.editpage(service);
		List list = ((XcjlServiceImpl) service).queryXcfs();
		Map map=new HashMap();
		map.put("data", entity);
		map.put("list", list);
		map.put("msg", "查询成功");
		map.put("code", 200);
		output(map);
	}

	@Action(value = "edit")
	public void edit() throws Exception {
		 super.edit(service, entity);
	}

	@Action(value = "delete")
	public void delete() throws Exception {
		 super.delete(service);
	}

	
//以下是get  set
	public BasicPage getPage() {
		return page;
	}

	public void setPage(BasicPage page) {
		this.page = page;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public BasicSercvice getService() {
		return service;
	}

	public void setService(BasicSercvice service) {
		this.service = service;
	}
	
}
