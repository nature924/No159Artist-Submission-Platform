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

import com.entity.HuashizuopinEntity;
import com.entity.view.HuashizuopinView;

import com.service.HuashizuopinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 画师作品
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
@RestController
@RequestMapping("/huashizuopin")
public class HuashizuopinController {
    @Autowired
    private HuashizuopinService huashizuopinService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuashizuopinEntity huashizuopin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huashi")) {
			huashizuopin.setHuashizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuashizuopinEntity> ew = new EntityWrapper<HuashizuopinEntity>();

		PageUtils page = huashizuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huashizuopin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuashizuopinEntity huashizuopin, 
		HttpServletRequest request){
        EntityWrapper<HuashizuopinEntity> ew = new EntityWrapper<HuashizuopinEntity>();

		PageUtils page = huashizuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huashizuopin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuashizuopinEntity huashizuopin){
       	EntityWrapper<HuashizuopinEntity> ew = new EntityWrapper<HuashizuopinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huashizuopin, "huashizuopin")); 
        return R.ok().put("data", huashizuopinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuashizuopinEntity huashizuopin){
        EntityWrapper< HuashizuopinEntity> ew = new EntityWrapper< HuashizuopinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huashizuopin, "huashizuopin")); 
		HuashizuopinView huashizuopinView =  huashizuopinService.selectView(ew);
		return R.ok("查询画师作品成功").put("data", huashizuopinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuashizuopinEntity huashizuopin = huashizuopinService.selectById(id);
		huashizuopin.setClicknum(huashizuopin.getClicknum()+1);
		huashizuopin.setClicktime(new Date());
		huashizuopinService.updateById(huashizuopin);
        return R.ok().put("data", huashizuopin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuashizuopinEntity huashizuopin = huashizuopinService.selectById(id);
		huashizuopin.setClicknum(huashizuopin.getClicknum()+1);
		huashizuopin.setClicktime(new Date());
		huashizuopinService.updateById(huashizuopin);
        return R.ok().put("data", huashizuopin);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        HuashizuopinEntity huashizuopin = huashizuopinService.selectById(id);
        if(type.equals("1")) {
        	huashizuopin.setThumbsupnum(huashizuopin.getThumbsupnum()+1);
        } else {
        	huashizuopin.setCrazilynum(huashizuopin.getCrazilynum()+1);
        }
        huashizuopinService.updateById(huashizuopin);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuashizuopinEntity huashizuopin, HttpServletRequest request){
    	huashizuopin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huashizuopin);
        huashizuopinService.insert(huashizuopin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuashizuopinEntity huashizuopin, HttpServletRequest request){
    	huashizuopin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huashizuopin);
        huashizuopinService.insert(huashizuopin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuashizuopinEntity huashizuopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huashizuopin);
        huashizuopinService.updateById(huashizuopin);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huashizuopinService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<HuashizuopinEntity> wrapper = new EntityWrapper<HuashizuopinEntity>();
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

		int count = huashizuopinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,HuashizuopinEntity huashizuopin, HttpServletRequest request,String pre){
        EntityWrapper<HuashizuopinEntity> ew = new EntityWrapper<HuashizuopinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = huashizuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huashizuopin), params), params));
        return R.ok().put("data", page);
    }









}
