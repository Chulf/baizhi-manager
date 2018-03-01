package com.jeecg.entity.baizhimanager;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 页面
 * @author zhangdaihao
 * @date 2018-02-01 18:29:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "baizhi_page", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PageEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**页面名称*/
	private java.lang.String pagename;
	/**英语字段*/
	private java.lang.String english;
	/**中文字段*/
	private java.lang.String chinese;
	/**german*/
	private java.lang.String german;
	/**状态码*/
	private java.lang.String status;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=255)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  页面名称
	 */
	@Column(name ="PAGENAME",nullable=true,length=255)
	public java.lang.String getPagename(){
		return this.pagename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  页面名称
	 */
	public void setPagename(java.lang.String pagename){
		this.pagename = pagename;
	}
	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  英语字段
	 */
	@Column(name ="ENGLISH",nullable=true,length=65535)
	public java.lang.String getEnglish(){
		return this.english;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  英语字段
	 */
	public void setEnglish(java.lang.String english){
		this.english = english;
	}
	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  中文字段
	 */
	@Column(name ="CHINESE",nullable=true,length=65535)
	public java.lang.String getChinese(){
		return this.chinese;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  中文字段
	 */
	public void setChinese(java.lang.String chinese){
		this.chinese = chinese;
	}
	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  german
	 */
	@Column(name ="GERMAN",nullable=true,length=65535)
	public java.lang.String getGerman(){
		return this.german;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  german
	 */
	public void setGerman(java.lang.String german){
		this.german = german;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态码
	 */
	@Column(name ="STATUS",nullable=true,length=255)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态码
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
}
