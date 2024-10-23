package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusshuashiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusshuashiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusshuashiView;


/**
 * 画师评论表
 *
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
public interface DiscusshuashiService extends IService<DiscusshuashiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusshuashiVO> selectListVO(Wrapper<DiscusshuashiEntity> wrapper);
   	
   	DiscusshuashiVO selectVO(@Param("ew") Wrapper<DiscusshuashiEntity> wrapper);
   	
   	List<DiscusshuashiView> selectListView(Wrapper<DiscusshuashiEntity> wrapper);
   	
   	DiscusshuashiView selectView(@Param("ew") Wrapper<DiscusshuashiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusshuashiEntity> wrapper);
   	

}

