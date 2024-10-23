package com.dao;

import com.entity.YuegaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuegaoxinxiVO;
import com.entity.view.YuegaoxinxiView;


/**
 * 约稿信息
 * 
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
public interface YuegaoxinxiDao extends BaseMapper<YuegaoxinxiEntity> {
	
	List<YuegaoxinxiVO> selectListVO(@Param("ew") Wrapper<YuegaoxinxiEntity> wrapper);
	
	YuegaoxinxiVO selectVO(@Param("ew") Wrapper<YuegaoxinxiEntity> wrapper);
	
	List<YuegaoxinxiView> selectListView(@Param("ew") Wrapper<YuegaoxinxiEntity> wrapper);

	List<YuegaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YuegaoxinxiEntity> wrapper);
	
	YuegaoxinxiView selectView(@Param("ew") Wrapper<YuegaoxinxiEntity> wrapper);
	

}
