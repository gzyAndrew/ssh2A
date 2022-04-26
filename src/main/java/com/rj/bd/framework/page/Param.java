package com.rj.bd.framework.page;
/**********************************************
 * @desc   抽象出一个实体类，将HQL语句中的参数的类型和参数的具体的值看成是一个参数类
 * @time   2021-1-13
 **********************************************/
public class Param {

	private int type ; //HQL语句中参数的类型
	private Object value;//HQL语句中参数的具体的值
	
	
	
	public Param() {
		
	}
	public Param(int type, Object value) {
		this.type = type;
		this.value = value;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
	
}
