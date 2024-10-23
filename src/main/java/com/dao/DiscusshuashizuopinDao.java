package com.dao;

import com.entity.DiscusshuashizuopinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusshuashizuopinVO;
import com.entity.view.DiscusshuashizuopinView;


/**
 * 画师作品评论表
 * 
 * @author 
 * @email 
 * @date 2023-02-24 12:24:30
 */
public interface DiscusshuashizuopinDao extends BaseMapper<DiscusshuashizuopinEntity> {
	
	List<DiscusshuashizuopinVO> selectListVO(@Param("ew") Wrapper<DiscusshuashizuopinEntity> wrapper);
	
	DiscusshuashizuopinVO selectVO(@Param("ew") Wrapper<DiscusshuashizuopinEntity> wrapper);
	
	List<DiscusshuashizuopinView> selectListView(@Param("ew") Wrapper<DiscusshuashizuopinEntity> wrapper);

	List<DiscusshuashizuopinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusshuashizuopinEntity> wrapper);
	
	DiscusshuashizuopinView selectView(@Param("ew") Wrapper<DiscusshuashizuopinEntity> wrapper);
	

}
