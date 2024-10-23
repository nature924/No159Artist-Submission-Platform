package com.entity.view;

import com.entity.HuashizuopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 画师作品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
@TableName("huashizuopin")
public class HuashizuopinView  extends HuashizuopinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuashizuopinView(){
	}
 
 	public HuashizuopinView(HuashizuopinEntity huashizuopinEntity){
 	try {
			BeanUtils.copyProperties(this, huashizuopinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
