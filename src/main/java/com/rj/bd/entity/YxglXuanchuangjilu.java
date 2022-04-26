package com.rj.bd.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

/**
 * YxglXuanchuangjilu entity. @author MyEclipse Persistence Tools
 */
@Component
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class YxglXuanchuangjilu implements java.io.Serializable {

	// Fields

	private String xcjlId;
	private YxglXuanchuangfangshi yxglXuanchuangfangshi;
	private Integer xcjlNum;
	private Timestamp xcjlDate;
	private Long xcjlTotal;
	private Integer xcjlLen;
	private String xcjlInfo;

	// Constructors

	/** default constructor */
	public YxglXuanchuangjilu() {
	}

	/** minimal constructor */
	public YxglXuanchuangjilu(String xcjlId) {
		this.xcjlId = xcjlId;
	}

	/** full constructor */
	public YxglXuanchuangjilu(String xcjlId,
			YxglXuanchuangfangshi yxglXuanchuangfangshi, Integer xcjlNum,
			Timestamp xcjlDate, Long xcjlTotal, Integer xcjlLen, String xcjlInfo) {
		this.xcjlId = xcjlId;
		this.yxglXuanchuangfangshi = yxglXuanchuangfangshi;
		this.xcjlNum = xcjlNum;
		this.xcjlDate = xcjlDate;
		this.xcjlTotal = xcjlTotal;
		this.xcjlLen = xcjlLen;
		this.xcjlInfo = xcjlInfo;
	}

	// Property accessors

	public String getXcjlId() {
		return this.xcjlId;
	}

	public void setXcjlId(String xcjlId) {
		this.xcjlId = xcjlId;
	}
//	@ManyToOne(fetch= FetchType.LAZY) // 第一种@ManyToOne(fetch=FetchType.EAGE)
//	@JoinColumn(name="yxglXuanchuangjilus")
//	@JsonIgnore
	public YxglXuanchuangfangshi getYxglXuanchuangfangshi() {
		return this.yxglXuanchuangfangshi;
	}

	public void setYxglXuanchuangfangshi(
			YxglXuanchuangfangshi yxglXuanchuangfangshi) {
		this.yxglXuanchuangfangshi = yxglXuanchuangfangshi;
	}

	public Integer getXcjlNum() {
		return this.xcjlNum;
	}

	public void setXcjlNum(Integer xcjlNum) {
		this.xcjlNum = xcjlNum;
	}

	public Timestamp getXcjlDate() {
		return this.xcjlDate;
	}

	public void setXcjlDate(Timestamp xcjlDate) {
		this.xcjlDate = xcjlDate;
	}

	public Long getXcjlTotal() {
		return this.xcjlTotal;
	}

	public void setXcjlTotal(Long xcjlTotal) {
		this.xcjlTotal = xcjlTotal;
	}

	public Integer getXcjlLen() {
		return this.xcjlLen;
	}

	public void setXcjlLen(Integer xcjlLen) {
		this.xcjlLen = xcjlLen;
	}

	public String getXcjlInfo() {
		return this.xcjlInfo;
	}

	public void setXcjlInfo(String xcjlInfo) {
		this.xcjlInfo = xcjlInfo;
	}

}