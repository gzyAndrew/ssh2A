package com.rj.bd.framework.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rj.bd.framework.page.BasicPage;
import com.rj.bd.framework.service.BasicSercvice;

public class BasicAction {

	
	private String ids;
	private String id;
	String json;
	ObjectMapper mapper;
	//-----上面是属性--------------------------------------------------------------------
	/**
	 * 分页查询
	 * @param page
	 */
	public void query(BasicPage page) throws Exception {
		@SuppressWarnings("rawtypes")
		List list = page.queryObjectsToPages();
		System.out.println(list);
		Map map=new HashMap();
		map.put("data", list);
		map.put("pageCount", page.getPageCount());
		map.put("pageNo", page.getPageNo());
		output(map);
	}
	/**
	 * 进入添加页面
	 */
	public void addpage() throws Exception{
	}
	/**
	 * 保存数据
	 * @param service 
	 * @param entity 
	 */
	public void add(BasicSercvice service, Object entity) throws Exception{
		//调用模型保存
		service.save(entity);
		Map map=new HashMap();
		map.put("msg", "添加成功");
		map.put("code", 200);
		output(map);
	}
	
	/**
	 * 进入修改页面
	 * @param service
	 * @return
	 */
	public Object editpage(BasicSercvice service) throws Exception{
		System.out.println("修改---->"+id);
		return service.queryById(id);
	}
	/**
	 * 修改数据
	 * @param service 
	 * @param entity 
	 */
	public void edit(BasicSercvice service, Object entity) throws Exception{
		service.update(entity);
		Map map=new HashMap();
		map.put("msg", "修改成功");
		map.put("code", 200);
		output(map);
	}
	/**
	 * 删除数据
	 * @param service 
	 */
	public void delete(BasicSercvice service) throws Exception{
		String[] idss = ids.split(",");
		service.delete(idss);
		Map map=new HashMap();
		map.put("msg", "删除成功");
		map.put("code", 200);
		output(map);
	}
	
	/**
	 * @desc 返回数据
	 * @throws IOException
	 */
	protected void output(Object obj) throws IOException {
		System.out.println("obj ---->"+obj);
		mapper=new ObjectMapper();
		json = mapper.writeValueAsString(obj);
		System.out.println("json ---->"+json);
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter writer = resp.getWriter();
		writer.write(json);
		writer.flush();
		writer.close();
	}
	
	//-----下方是set  get  方法--------------------------------------------------------------------


	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
