package com.entity.view;

import com.entity.GaojianzuopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 稿件作品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
@TableName("gaojianzuopin")
public class GaojianzuopinView  extends GaojianzuopinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GaojianzuopinView(){
	}
 
 	public GaojianzuopinView(GaojianzuopinEntity gaojianzuopinEntity){
 	try {
			BeanUtils.copyProperties(this, gaojianzuopinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
