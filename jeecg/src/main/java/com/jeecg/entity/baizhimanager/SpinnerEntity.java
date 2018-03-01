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
 * @Description: 微调
 * @author zhangdaihao
 * @date 2018-02-01 18:31:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "baizhi_spinner", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SpinnerEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**source*/
	private java.lang.String source;
	/**options*/
	private java.lang.String options;
	/**price*/
	private java.lang.String price;
	/**sequence*/
	private java.lang.String sequence;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  source
	 */
	@Column(name ="SOURCE",nullable=true,length=255)
	public java.lang.String getSource(){
		return this.source;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  source
	 */
	public void setSource(java.lang.String source){
		this.source = source;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  options
	 */
	@Column(name ="OPTIONS",nullable=true,length=255)
	public java.lang.String getOptions(){
		return this.options;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  options
	 */
	public void setOptions(java.lang.String options){
		this.options = options;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  price
	 */
	@Column(name ="PRICE",nullable=true,length=255)
	public java.lang.String getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  price
	 */
	public void setPrice(java.lang.String price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sequence
	 */
	@Column(name ="SEQUENCE",nullable=true,length=255)
	public java.lang.String getSequence(){
		return this.sequence;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sequence
	 */
	public void setSequence(java.lang.String sequence){
		this.sequence = sequence;
	}
}
