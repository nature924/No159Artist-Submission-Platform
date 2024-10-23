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


import com.dao.YuegaoxinxiDao;
import com.entity.YuegaoxinxiEntity;
import com.service.YuegaoxinxiService;
import com.entity.vo.YuegaoxinxiVO;
import com.entity.view.YuegaoxinxiView;

@Service("yuegaoxinxiService")
public class YuegaoxinxiServiceImpl extends ServiceImpl<YuegaoxinxiDao, YuegaoxinxiEntity> implements YuegaoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuegaoxinxiEntity> page = this.selectPage(
                new Query<YuegaoxinxiEntity>(params).getPage(),
                new EntityWrapper<YuegaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuegaoxinxiEntity> wrapper) {
		  Page<YuegaoxinxiView> page =new Query<YuegaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuegaoxinxiVO> selectListVO(Wrapper<YuegaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuegaoxinxiVO selectVO(Wrapper<YuegaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuegaoxinxiView> selectListView(Wrapper<YuegaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuegaoxinxiView selectView(Wrapper<YuegaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
