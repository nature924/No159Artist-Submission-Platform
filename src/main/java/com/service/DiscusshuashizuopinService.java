package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusshuashizuopinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusshuashizuopinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusshuashizuopinView;


/**
 * 画师作品评论表
 *
 * @author 
 * @email 
 * @date 2023-02-24 12:24:30
 */
public interface DiscusshuashizuopinService extends IService<DiscusshuashizuopinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusshuashizuopinVO> selectListVO(Wrapper<DiscusshuashizuopinEntity> wrapper);
   	
   	DiscusshuashizuopinVO selectVO(@Param("ew") Wrapper<DiscusshuashizuopinEntity> wrapper);
   	
   	List<DiscusshuashizuopinView> selectListView(Wrapper<DiscusshuashizuopinEntity> wrapper);
   	
   	DiscusshuashizuopinView selectView(@Param("ew") Wrapper<DiscusshuashizuopinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusshuashizuopinEntity> wrapper);
   	

}

