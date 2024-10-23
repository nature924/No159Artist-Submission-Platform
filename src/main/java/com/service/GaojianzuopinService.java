package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GaojianzuopinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GaojianzuopinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GaojianzuopinView;


/**
 * 稿件作品
 *
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
public interface GaojianzuopinService extends IService<GaojianzuopinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GaojianzuopinVO> selectListVO(Wrapper<GaojianzuopinEntity> wrapper);
   	
   	GaojianzuopinVO selectVO(@Param("ew") Wrapper<GaojianzuopinEntity> wrapper);
   	
   	List<GaojianzuopinView> selectListView(Wrapper<GaojianzuopinEntity> wrapper);
   	
   	GaojianzuopinView selectView(@Param("ew") Wrapper<GaojianzuopinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GaojianzuopinEntity> wrapper);
   	

}

