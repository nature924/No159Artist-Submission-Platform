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


import com.dao.DiscusshuashizuopinDao;
import com.entity.DiscusshuashizuopinEntity;
import com.service.DiscusshuashizuopinService;
import com.entity.vo.DiscusshuashizuopinVO;
import com.entity.view.DiscusshuashizuopinView;

@Service("discusshuashizuopinService")
public class DiscusshuashizuopinServiceImpl extends ServiceImpl<DiscusshuashizuopinDao, DiscusshuashizuopinEntity> implements DiscusshuashizuopinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusshuashizuopinEntity> page = this.selectPage(
                new Query<DiscusshuashizuopinEntity>(params).getPage(),
                new EntityWrapper<DiscusshuashizuopinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusshuashizuopinEntity> wrapper) {
		  Page<DiscusshuashizuopinView> page =new Query<DiscusshuashizuopinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusshuashizuopinVO> selectListVO(Wrapper<DiscusshuashizuopinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusshuashizuopinVO selectVO(Wrapper<DiscusshuashizuopinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusshuashizuopinView> selectListView(Wrapper<DiscusshuashizuopinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusshuashizuopinView selectView(Wrapper<DiscusshuashizuopinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
