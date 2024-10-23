package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZuopinleixingDao;
import com.entity.ZuopinleixingEntity;
import com.service.ZuopinleixingService;
import com.entity.vo.ZuopinleixingVO;
import com.entity.view.ZuopinleixingView;

@Service("zuopinleixingService")
public class ZuopinleixingServiceImpl extends ServiceImpl<ZuopinleixingDao, ZuopinleixingEntity> implements ZuopinleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuopinleixingEntity> page = this.selectPage(
                new Query<ZuopinleixingEntity>(params).getPage(),
                new EntityWrapper<ZuopinleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuopinleixingEntity> wrapper) {
		  Page<ZuopinleixingView> page =new Query<ZuopinleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZuopinleixingVO> selectListVO(Wrapper<ZuopinleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuopinleixingVO selectVO(Wrapper<ZuopinleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuopinleixingView> selectListView(Wrapper<ZuopinleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuopinleixingView selectView(Wrapper<ZuopinleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
