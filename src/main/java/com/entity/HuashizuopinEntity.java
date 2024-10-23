package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 画师作品
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
@TableName("huashizuopin")
public class HuashizuopinEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HuashizuopinEntity() {
		
	}
	
	public HuashizuopinEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 作品编号
	 */
					
	private String zuopinbianhao;
	
	/**
	 * 作品名称
	 */
					
	private String zuopinmingcheng;
	
	/**
	 * 作品类型
	 */
					
	private String zuopinleixing;
	
	/**
	 * 代表作
	 */
					
	private String daibiaozuo;
	
	/**
	 * 画师账号
	 */
					
	private String huashizhanghao;
	
	/**
	 * 画师姓名
	 */
					
	private String huashixingming;
	
	/**
	 * 作品内容
	 */
					
	private String zuopinneirong;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：作品编号
	 */
	public void setZuopinbianhao(String zuopinbianhao) {
		this.zuopinbianhao = zuopinbianhao;
	}
	/**
	 * 获取：作品编号
	 */
	public String getZuopinbianhao() {
		return zuopinbianhao;
	}
	/**
	 * 设置：作品名称
	 */
	public void setZuopinmingcheng(String zuopinmingcheng) {
		this.zuopinmingcheng = zuopinmingcheng;
	}
	/**
	 * 获取：作品名称
	 */
	public String getZuopinmingcheng() {
		return zuopinmingcheng;
	}
	/**
	 * 设置：作品类型
	 */
	public void setZuopinleixing(String zuopinleixing) {
		this.zuopinleixing = zuopinleixing;
	}
	/**
	 * 获取：作品类型
	 */
	public String getZuopinleixing() {
		return zuopinleixing;
	}
	/**
	 * 设置：代表作
	 */
	public void setDaibiaozuo(String daibiaozuo) {
		this.daibiaozuo = daibiaozuo;
	}
	/**
	 * 获取：代表作
	 */
	public String getDaibiaozuo() {
		return daibiaozuo;
	}
	/**
	 * 设置：画师账号
	 */
	public void setHuashizhanghao(String huashizhanghao) {
		this.huashizhanghao = huashizhanghao;
	}
	/**
	 * 获取：画师账号
	 */
	public String getHuashizhanghao() {
		return huashizhanghao;
	}
	/**
	 * 设置：画师姓名
	 */
	public void setHuashixingming(String huashixingming) {
		this.huashixingming = huashixingming;
	}
	/**
	 * 获取：画师姓名
	 */
	public String getHuashixingming() {
		return huashixingming;
	}
	/**
	 * 设置：作品内容
	 */
	public void setZuopinneirong(String zuopinneirong) {
		this.zuopinneirong = zuopinneirong;
	}
	/**
	 * 获取：作品内容
	 */
	public String getZuopinneirong() {
		return zuopinneirong;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}

}
