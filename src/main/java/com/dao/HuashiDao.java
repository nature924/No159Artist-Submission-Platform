package com.dao;

import com.entity.HuashiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuashiVO;
import com.entity.view.HuashiView;


/**
 * 画师
 * 
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
public interface HuashiDao extends BaseMapper<HuashiEntity> {
	
	List<HuashiVO> selectListVO(@Param("ew") Wrapper<HuashiEntity> wrapper);
	
	HuashiVO selectVO(@Param("ew") Wrapper<HuashiEntity> wrapper);
	
	List<HuashiView> selectListView(@Param("ew") Wrapper<HuashiEntity> wrapper);

	List<HuashiView> selectListView(Pagination page,@Param("ew") Wrapper<HuashiEntity> wrapper);
	
	HuashiView selectView(@Param("ew") Wrapper<HuashiEntity> wrapper);
	

}
