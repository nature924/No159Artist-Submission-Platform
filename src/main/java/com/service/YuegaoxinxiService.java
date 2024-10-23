package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuegaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuegaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuegaoxinxiView;


/**
 * 约稿信息
 *
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
public interface YuegaoxinxiService extends IService<YuegaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuegaoxinxiVO> selectListVO(Wrapper<YuegaoxinxiEntity> wrapper);
   	
   	YuegaoxinxiVO selectVO(@Param("ew") Wrapper<YuegaoxinxiEntity> wrapper);
   	
   	List<YuegaoxinxiView> selectListView(Wrapper<YuegaoxinxiEntity> wrapper);
   	
   	YuegaoxinxiView selectView(@Param("ew") Wrapper<YuegaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuegaoxinxiEntity> wrapper);
   	

}

