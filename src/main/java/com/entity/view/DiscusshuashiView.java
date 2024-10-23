package com.entity.view;

import com.entity.DiscusshuashiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 画师评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
@TableName("discusshuashi")
public class DiscusshuashiView  extends DiscusshuashiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusshuashiView(){
	}
 
 	public DiscusshuashiView(DiscusshuashiEntity discusshuashiEntity){
 	try {
			BeanUtils.copyProperties(this, discusshuashiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
