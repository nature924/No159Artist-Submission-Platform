package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZuopinleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZuopinleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuopinleixingView;


/**
 * 作品类型
 *
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
public interface ZuopinleixingService extends IService<ZuopinleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuopinleixingVO> selectListVO(Wrapper<ZuopinleixingEntity> wrapper);
   	
   	ZuopinleixingVO selectVO(@Param("ew") Wrapper<ZuopinleixingEntity> wrapper);
   	
   	List<ZuopinleixingView> selectListView(Wrapper<ZuopinleixingEntity> wrapper);
   	
   	ZuopinleixingView selectView(@Param("ew") Wrapper<ZuopinleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuopinleixingEntity> wrapper);
   	

}

