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
 * @Description: 文件表
 * @author zhangdaihao
 * @date 2018-02-01 18:27:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "baizhi_file", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class FileEntity implements java.io.Serializable {
	/**文件名称*/
	private java.lang.String filename;
	/**上传时间*/
	private java.util.Date uploadtime;
	/**文件描述*/
	private java.lang.String text;
	/**用户外键*/
	private java.lang.String userid;
	/**主键*/
	private java.lang.String id;
	/**文件保存地址*/
	private java.lang.String fileurl;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件名称
	 */
	@Column(name ="FILENAME",nullable=true,length=255)
	public java.lang.String getFilename(){
		return this.filename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件名称
	 */
	public void setFilename(java.lang.String filename){
		this.filename = filename;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  上传时间
	 */
	@Column(name ="UPLOADTIME",nullable=true)
	public java.util.Date getUploadtime(){
		return this.uploadtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  上传时间
	 */
	public void setUploadtime(java.util.Date uploadtime){
		this.uploadtime = uploadtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件描述
	 */
	@Column(name ="TEXT",nullable=true,length=255)
	public java.lang.String getText(){
		return this.text;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件描述
	 */
	public void setText(java.lang.String text){
		this.text = text;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户外键
	 */
	@Column(name ="USERID",nullable=true,length=255)
	public java.lang.String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户外键
	 */
	public void setUserid(java.lang.String userid){
		this.userid = userid;
	}
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
	 *@return: java.lang.String  文件保存地址
	 */
	@Column(name ="FILEURL",nullable=true,length=255)
	public java.lang.String getFileurl(){
		return this.fileurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件保存地址
	 */
	public void setFileurl(java.lang.String fileurl){
		this.fileurl = fileurl;
	}
}
