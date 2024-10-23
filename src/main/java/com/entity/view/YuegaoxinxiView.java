package com.entity.view;

import com.entity.YuegaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 约稿信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
@TableName("yuegaoxinxi")
public class YuegaoxinxiView  extends YuegaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuegaoxinxiView(){
	}
 
 	public YuegaoxinxiView(YuegaoxinxiEntity yuegaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, yuegaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
