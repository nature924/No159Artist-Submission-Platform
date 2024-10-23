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


import com.dao.DiscusshuashiDao;
import com.entity.DiscusshuashiEntity;
import com.service.DiscusshuashiService;
import com.entity.vo.DiscusshuashiVO;
import com.entity.view.DiscusshuashiView;

@Service("discusshuashiService")
public class DiscusshuashiServiceImpl extends ServiceImpl<DiscusshuashiDao, DiscusshuashiEntity> implements DiscusshuashiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusshuashiEntity> page = this.selectPage(
                new Query<DiscusshuashiEntity>(params).getPage(),
                new EntityWrapper<DiscusshuashiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusshuashiEntity> wrapper) {
		  Page<DiscusshuashiView> page =new Query<DiscusshuashiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusshuashiVO> selectListVO(Wrapper<DiscusshuashiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusshuashiVO selectVO(Wrapper<DiscusshuashiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusshuashiView> selectListView(Wrapper<DiscusshuashiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusshuashiView selectView(Wrapper<DiscusshuashiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
