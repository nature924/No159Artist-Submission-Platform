package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YuegaoxinxiEntity;
import com.entity.view.YuegaoxinxiView;

import com.service.YuegaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 约稿信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
@RestController
@RequestMapping("/yuegaoxinxi")
public class YuegaoxinxiController {
    @Autowired
    private YuegaoxinxiService yuegaoxinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuegaoxinxiEntity yuegaoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huashi")) {
			yuegaoxinxi.setHuashizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			yuegaoxinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuegaoxinxiEntity> ew = new EntityWrapper<YuegaoxinxiEntity>();

		PageUtils page = yuegaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuegaoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuegaoxinxiEntity yuegaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<YuegaoxinxiEntity> ew = new EntityWrapper<YuegaoxinxiEntity>();

		PageUtils page = yuegaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuegaoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuegaoxinxiEntity yuegaoxinxi){
       	EntityWrapper<YuegaoxinxiEntity> ew = new EntityWrapper<YuegaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuegaoxinxi, "yuegaoxinxi")); 
        return R.ok().put("data", yuegaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuegaoxinxiEntity yuegaoxinxi){
        EntityWrapper< YuegaoxinxiEntity> ew = new EntityWrapper< YuegaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuegaoxinxi, "yuegaoxinxi")); 
		YuegaoxinxiView yuegaoxinxiView =  yuegaoxinxiService.selectView(ew);
		return R.ok("查询约稿信息成功").put("data", yuegaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuegaoxinxiEntity yuegaoxinxi = yuegaoxinxiService.selectById(id);
        return R.ok().put("data", yuegaoxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuegaoxinxiEntity yuegaoxinxi = yuegaoxinxiService.selectById(id);
        return R.ok().put("data", yuegaoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuegaoxinxiEntity yuegaoxinxi, HttpServletRequest request){
    	yuegaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuegaoxinxi);
        yuegaoxinxiService.insert(yuegaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuegaoxinxiEntity yuegaoxinxi, HttpServletRequest request){
    	yuegaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuegaoxinxi);
        yuegaoxinxiService.insert(yuegaoxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuegaoxinxiEntity yuegaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuegaoxinxi);
        yuegaoxinxiService.updateById(yuegaoxinxi);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuegaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YuegaoxinxiEntity> wrapper = new EntityWrapper<YuegaoxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huashi")) {
			wrapper.eq("huashizhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = yuegaoxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
