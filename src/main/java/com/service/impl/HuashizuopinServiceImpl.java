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


import com.dao.HuashizuopinDao;
import com.entity.HuashizuopinEntity;
import com.service.HuashizuopinService;
import com.entity.vo.HuashizuopinVO;
import com.entity.view.HuashizuopinView;

@Service("huashizuopinService")
public class HuashizuopinServiceImpl extends ServiceImpl<HuashizuopinDao, HuashizuopinEntity> implements HuashizuopinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuashizuopinEntity> page = this.selectPage(
                new Query<HuashizuopinEntity>(params).getPage(),
                new EntityWrapper<HuashizuopinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuashizuopinEntity> wrapper) {
		  Page<HuashizuopinView> page =new Query<HuashizuopinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuashizuopinVO> selectListVO(Wrapper<HuashizuopinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuashizuopinVO selectVO(Wrapper<HuashizuopinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuashizuopinView> selectListView(Wrapper<HuashizuopinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuashizuopinView selectView(Wrapper<HuashizuopinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
