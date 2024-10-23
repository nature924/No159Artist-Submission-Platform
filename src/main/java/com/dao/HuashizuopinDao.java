package com.dao;

import com.entity.HuashizuopinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuashizuopinVO;
import com.entity.view.HuashizuopinView;


/**
 * 画师作品
 * 
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
public interface HuashizuopinDao extends BaseMapper<HuashizuopinEntity> {
	
	List<HuashizuopinVO> selectListVO(@Param("ew") Wrapper<HuashizuopinEntity> wrapper);
	
	HuashizuopinVO selectVO(@Param("ew") Wrapper<HuashizuopinEntity> wrapper);
	
	List<HuashizuopinView> selectListView(@Param("ew") Wrapper<HuashizuopinEntity> wrapper);

	List<HuashizuopinView> selectListView(Pagination page,@Param("ew") Wrapper<HuashizuopinEntity> wrapper);
	
	HuashizuopinView selectView(@Param("ew") Wrapper<HuashizuopinEntity> wrapper);
	

}
