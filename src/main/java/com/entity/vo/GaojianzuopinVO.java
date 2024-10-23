package com.entity.vo;

import com.entity.GaojianzuopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 稿件作品
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
public class GaojianzuopinVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 交稿时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jiaogaoshijian;
		
	/**
	 * 效果图
	 */
	
	private String xiaoguotu;
		
	/**
	 * 附件
	 */
	
	private String fujian;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
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
	 * 设置：交稿时间
	 */
	 
	public void setJiaogaoshijian(Date jiaogaoshijian) {
		this.jiaogaoshijian = jiaogaoshijian;
	}
	
	/**
	 * 获取：交稿时间
	 */
	public Date getJiaogaoshijian() {
		return jiaogaoshijian;
	}
				
	
	/**
	 * 设置：效果图
	 */
	 
	public void setXiaoguotu(String xiaoguotu) {
		this.xiaoguotu = xiaoguotu;
	}
	
	/**
	 * 获取：效果图
	 */
	public String getXiaoguotu() {
		return xiaoguotu;
	}
				
	
	/**
	 * 设置：附件
	 */
	 
	public void setFujian(String fujian) {
		this.fujian = fujian;
	}
	
	/**
	 * 获取：附件
	 */
	public String getFujian() {
		return fujian;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
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
			
}
