package com.rj.bd.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * YxglXuanchuangfangshi entity. @author MyEclipse Persistence Tools
 */
@Component
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class YxglXuanchuangfangshi implements java.io.Serializable {

	// Fields
	private String xcfsId;
	private String xcfsName;
	private String xcfsInfo;
	private String xcfsXiaoguo;
	private String xcfsLxr;
	private String xcfsPhone;
	private Timestamp xcfsInDate;
	private Long xcfsJiage;
	@JsonIgnore
	private Set yxglXuanchuangjilus = new HashSet(0);

	// Constructors

	/** default constructor */
	public YxglXuanchuangfangshi() {
	}

	/** minimal constructor */
	public YxglXuanchuangfangshi(String xcfsId) {
		this.xcfsId = xcfsId;
	}

	/** full constructor */
	public YxglXuanchuangfangshi(String xcfsId, String xcfsName,
			String xcfsInfo, String xcfsXiaoguo, String xcfsLxr,
			String xcfsPhone, Timestamp xcfsInDate, Long xcfsJiage,
			Set yxglXuanchuangjilus) {
		this.xcfsId = xcfsId;
		this.xcfsName = xcfsName;
		this.xcfsInfo = xcfsInfo;
		this.xcfsXiaoguo = xcfsXiaoguo;
		this.xcfsLxr = xcfsLxr;
		this.xcfsPhone = xcfsPhone;
		this.xcfsInDate = xcfsInDate;
		this.xcfsJiage = xcfsJiage;
		this.yxglXuanchuangjilus = yxglXuanchuangjilus;
	}

	// Property accessors

	public String getXcfsId() {
		return this.xcfsId;
	}

	public void setXcfsId(String xcfsId) {
		this.xcfsId = xcfsId;
	}

	public String getXcfsName() {
		return this.xcfsName;
	}

	public void setXcfsName(String xcfsName) {
		this.xcfsName = xcfsName;
	}

	public String getXcfsInfo() {
		return this.xcfsInfo;
	}

	public void setXcfsInfo(String xcfsInfo) {
		this.xcfsInfo = xcfsInfo;
	}

	public String getXcfsXiaoguo() {
		return this.xcfsXiaoguo;
	}

	public void setXcfsXiaoguo(String xcfsXiaoguo) {
		this.xcfsXiaoguo = xcfsXiaoguo;
	}

	public String getXcfsLxr() {
		return this.xcfsLxr;
	}

	public void setXcfsLxr(String xcfsLxr) {
		this.xcfsLxr = xcfsLxr;
	}

	public String getXcfsPhone() {
		return this.xcfsPhone;
	}

	public void setXcfsPhone(String xcfsPhone) {
		this.xcfsPhone = xcfsPhone;
	}

	public Timestamp getXcfsInDate() {
		return this.xcfsInDate;
	}

	public void setXcfsInDate(Timestamp xcfsInDate) {
		this.xcfsInDate = xcfsInDate;
	}

	public Long getXcfsJiage() {
		return this.xcfsJiage;
	}

	public void setXcfsJiage(Long xcfsJiage) {
		this.xcfsJiage = xcfsJiage;
	}


	public Set getYxglXuanchuangjilus() {
		return this.yxglXuanchuangjilus;
	}

	public void setYxglXuanchuangjilus(Set yxglXuanchuangjilus) {
		this.yxglXuanchuangjilus = yxglXuanchuangjilus;
	}

}