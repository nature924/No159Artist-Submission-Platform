package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuashizuopinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuashizuopinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuashizuopinView;


/**
 * 画师作品
 *
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
public interface HuashizuopinService extends IService<HuashizuopinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuashizuopinVO> selectListVO(Wrapper<HuashizuopinEntity> wrapper);
   	
   	HuashizuopinVO selectVO(@Param("ew") Wrapper<HuashizuopinEntity> wrapper);
   	
   	List<HuashizuopinView> selectListView(Wrapper<HuashizuopinEntity> wrapper);
   	
   	HuashizuopinView selectView(@Param("ew") Wrapper<HuashizuopinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuashizuopinEntity> wrapper);
   	

}

