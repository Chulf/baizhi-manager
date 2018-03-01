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
 * @Description: 订单
 * @author zhangdaihao
 * @date 2018-02-26 19:20:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "baizhi_order", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class OrderEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户外键*/
	private java.lang.String userid;
	/**产品类型*/
	private java.lang.String type;
	/**需求书*/
	private java.lang.String demand;
	/**页面数*/
	private java.lang.String number;
	/**价格*/
	private BigDecimal price;
	/**订单状态*/
	private java.lang.String state;
	/**下单时间*/
	private java.util.Date time;
	/**关于项目的简单描述*/
	private java.lang.String description;
	
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
	 *@return: java.lang.String  产品类型
	 */
	@Column(name ="TYPE",nullable=true,length=255)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  需求书
	 */
	@Column(name ="DEMAND",nullable=true,length=255)
	public java.lang.String getDemand(){
		return this.demand;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  需求书
	 */
	public void setDemand(java.lang.String demand){
		this.demand = demand;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  页面数
	 */
	@Column(name ="NUMBER",nullable=true,length=255)
	public java.lang.String getNumber(){
		return this.number;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  页面数
	 */
	public void setNumber(java.lang.String number){
		this.number = number;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  价格
	 */
	@Column(name ="PRICE",nullable=true,precision=10,scale=0)
	public BigDecimal getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  价格
	 */
	public void setPrice(BigDecimal price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单状态
	 */
	@Column(name ="STATE",nullable=true,length=255)
	public java.lang.String getState(){
		return this.state;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单状态
	 */
	public void setState(java.lang.String state){
		this.state = state;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  下单时间
	 */
	@Column(name ="TIME",nullable=true)
	public java.util.Date getTime(){
		return this.time;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  下单时间
	 */
	public void setTime(java.util.Date time){
		this.time = time;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关于项目的简单描述
	 */
	@Column(name ="DESCRIPTION",nullable=true,length=255)
	public java.lang.String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关于项目的简单描述
	 */
	public void setDescription(java.lang.String description){
		this.description = description;
	}
}
