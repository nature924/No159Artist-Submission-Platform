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


import com.dao.HuashiDao;
import com.entity.HuashiEntity;
import com.service.HuashiService;
import com.entity.vo.HuashiVO;
import com.entity.view.HuashiView;

@Service("huashiService")
public class HuashiServiceImpl extends ServiceImpl<HuashiDao, HuashiEntity> implements HuashiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuashiEntity> page = this.selectPage(
                new Query<HuashiEntity>(params).getPage(),
                new EntityWrapper<HuashiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuashiEntity> wrapper) {
		  Page<HuashiView> page =new Query<HuashiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuashiVO> selectListVO(Wrapper<HuashiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuashiVO selectVO(Wrapper<HuashiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuashiView> selectListView(Wrapper<HuashiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuashiView selectView(Wrapper<HuashiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
