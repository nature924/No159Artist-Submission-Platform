package com.entity.view;

import com.entity.DiscusshuashizuopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 画师作品评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-24 12:24:30
 */
@TableName("discusshuashizuopin")
public class DiscusshuashizuopinView  extends DiscusshuashizuopinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusshuashizuopinView(){
	}
 
 	public DiscusshuashizuopinView(DiscusshuashizuopinEntity discusshuashizuopinEntity){
 	try {
			BeanUtils.copyProperties(this, discusshuashizuopinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
