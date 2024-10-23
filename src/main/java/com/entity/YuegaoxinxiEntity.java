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
 * 约稿信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
@TableName("yuegaoxinxi")
public class YuegaoxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YuegaoxinxiEntity() {
		
	}
	
	public YuegaoxinxiEntity(T t) {
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
	 * 作品名称
	 */
					
	private String zuopinmingcheng;
	
	/**
	 * 薪酬
	 */
					
	private String xinchou;
	
	/**
	 * 画师账号
	 */
					
	private String huashizhanghao;
	
	/**
	 * 画师姓名
	 */
					
	private String huashixingming;
	
	/**
	 * 用户名
	 */
					
	private String yonghuming;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 约稿时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date yuegaoshijian;
	
	/**
	 * 约稿要求
	 */
					
	private String yuegaoyaoqiu;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
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
	 * 设置：薪酬
	 */
	public void setXinchou(String xinchou) {
		this.xinchou = xinchou;
	}
	/**
	 * 获取：薪酬
	 */
	public String getXinchou() {
		return xinchou;
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
	 * 设置：用户名
	 */
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：约稿时间
	 */
	public void setYuegaoshijian(Date yuegaoshijian) {
		this.yuegaoshijian = yuegaoshijian;
	}
	/**
	 * 获取：约稿时间
	 */
	public Date getYuegaoshijian() {
		return yuegaoshijian;
	}
	/**
	 * 设置：约稿要求
	 */
	public void setYuegaoyaoqiu(String yuegaoyaoqiu) {
		this.yuegaoyaoqiu = yuegaoyaoqiu;
	}
	/**
	 * 获取：约稿要求
	 */
	public String getYuegaoyaoqiu() {
		return yuegaoyaoqiu;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
