package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuashiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuashiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuashiView;


/**
 * 画师
 *
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
public interface HuashiService extends IService<HuashiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuashiVO> selectListVO(Wrapper<HuashiEntity> wrapper);
   	
   	HuashiVO selectVO(@Param("ew") Wrapper<HuashiEntity> wrapper);
   	
   	List<HuashiView> selectListView(Wrapper<HuashiEntity> wrapper);
   	
   	HuashiView selectView(@Param("ew") Wrapper<HuashiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuashiEntity> wrapper);
   	

}

