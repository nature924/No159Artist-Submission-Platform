package com.dao;

import com.entity.DiscusshuashiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusshuashiVO;
import com.entity.view.DiscusshuashiView;


/**
 * 画师评论表
 * 
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
public interface DiscusshuashiDao extends BaseMapper<DiscusshuashiEntity> {
	
	List<DiscusshuashiVO> selectListVO(@Param("ew") Wrapper<DiscusshuashiEntity> wrapper);
	
	DiscusshuashiVO selectVO(@Param("ew") Wrapper<DiscusshuashiEntity> wrapper);
	
	List<DiscusshuashiView> selectListView(@Param("ew") Wrapper<DiscusshuashiEntity> wrapper);

	List<DiscusshuashiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusshuashiEntity> wrapper);
	
	DiscusshuashiView selectView(@Param("ew") Wrapper<DiscusshuashiEntity> wrapper);
	

}
