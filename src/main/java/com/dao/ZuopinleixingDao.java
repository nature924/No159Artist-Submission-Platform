package com.dao;

import com.entity.ZuopinleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuopinleixingVO;
import com.entity.view.ZuopinleixingView;


/**
 * 作品类型
 * 
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
public interface ZuopinleixingDao extends BaseMapper<ZuopinleixingEntity> {
	
	List<ZuopinleixingVO> selectListVO(@Param("ew") Wrapper<ZuopinleixingEntity> wrapper);
	
	ZuopinleixingVO selectVO(@Param("ew") Wrapper<ZuopinleixingEntity> wrapper);
	
	List<ZuopinleixingView> selectListView(@Param("ew") Wrapper<ZuopinleixingEntity> wrapper);

	List<ZuopinleixingView> selectListView(Pagination page,@Param("ew") Wrapper<ZuopinleixingEntity> wrapper);
	
	ZuopinleixingView selectView(@Param("ew") Wrapper<ZuopinleixingEntity> wrapper);
	

}
