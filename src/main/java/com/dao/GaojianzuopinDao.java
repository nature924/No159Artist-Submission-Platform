package com.dao;

import com.entity.GaojianzuopinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GaojianzuopinVO;
import com.entity.view.GaojianzuopinView;


/**
 * 稿件作品
 * 
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
public interface GaojianzuopinDao extends BaseMapper<GaojianzuopinEntity> {
	
	List<GaojianzuopinVO> selectListVO(@Param("ew") Wrapper<GaojianzuopinEntity> wrapper);
	
	GaojianzuopinVO selectVO(@Param("ew") Wrapper<GaojianzuopinEntity> wrapper);
	
	List<GaojianzuopinView> selectListView(@Param("ew") Wrapper<GaojianzuopinEntity> wrapper);

	List<GaojianzuopinView> selectListView(Pagination page,@Param("ew") Wrapper<GaojianzuopinEntity> wrapper);
	
	GaojianzuopinView selectView(@Param("ew") Wrapper<GaojianzuopinEntity> wrapper);
	

}
