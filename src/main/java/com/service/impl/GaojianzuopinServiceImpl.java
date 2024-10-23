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


import com.dao.GaojianzuopinDao;
import com.entity.GaojianzuopinEntity;
import com.service.GaojianzuopinService;
import com.entity.vo.GaojianzuopinVO;
import com.entity.view.GaojianzuopinView;

@Service("gaojianzuopinService")
public class GaojianzuopinServiceImpl extends ServiceImpl<GaojianzuopinDao, GaojianzuopinEntity> implements GaojianzuopinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GaojianzuopinEntity> page = this.selectPage(
                new Query<GaojianzuopinEntity>(params).getPage(),
                new EntityWrapper<GaojianzuopinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GaojianzuopinEntity> wrapper) {
		  Page<GaojianzuopinView> page =new Query<GaojianzuopinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GaojianzuopinVO> selectListVO(Wrapper<GaojianzuopinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GaojianzuopinVO selectVO(Wrapper<GaojianzuopinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GaojianzuopinView> selectListView(Wrapper<GaojianzuopinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GaojianzuopinView selectView(Wrapper<GaojianzuopinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
