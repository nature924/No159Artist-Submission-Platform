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

import com.entity.HuashiEntity;
import com.entity.view.HuashiView;

import com.service.HuashiService;
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
 * 画师
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-24 12:24:29
 */
@RestController
@RequestMapping("/huashi")
public class HuashiController {
    @Autowired
    private HuashiService huashiService;

    @Autowired
    private StoreupService storeupService;

    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		HuashiEntity u = huashiService.selectOne(new EntityWrapper<HuashiEntity>().eq("huashizhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"huashi",  "画师" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody HuashiEntity huashi){
    	//ValidatorUtils.validateEntity(huashi);
    	HuashiEntity u = huashiService.selectOne(new EntityWrapper<HuashiEntity>().eq("huashizhanghao", huashi.getHuashizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		huashi.setId(uId);
        huashiService.insert(huashi);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        HuashiEntity u = huashiService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	HuashiEntity u = huashiService.selectOne(new EntityWrapper<HuashiEntity>().eq("huashizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        huashiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuashiEntity huashi,
		HttpServletRequest request){
        EntityWrapper<HuashiEntity> ew = new EntityWrapper<HuashiEntity>();

		PageUtils page = huashiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huashi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuashiEntity huashi, 
		HttpServletRequest request){
        EntityWrapper<HuashiEntity> ew = new EntityWrapper<HuashiEntity>();

		PageUtils page = huashiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huashi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuashiEntity huashi){
       	EntityWrapper<HuashiEntity> ew = new EntityWrapper<HuashiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huashi, "huashi")); 
        return R.ok().put("data", huashiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuashiEntity huashi){
        EntityWrapper< HuashiEntity> ew = new EntityWrapper< HuashiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huashi, "huashi")); 
		HuashiView huashiView =  huashiService.selectView(ew);
		return R.ok("查询画师成功").put("data", huashiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuashiEntity huashi = huashiService.selectById(id);
		huashi.setClicknum(huashi.getClicknum()+1);
		huashi.setClicktime(new Date());
		huashiService.updateById(huashi);
        return R.ok().put("data", huashi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuashiEntity huashi = huashiService.selectById(id);
		huashi.setClicknum(huashi.getClicknum()+1);
		huashi.setClicktime(new Date());
		huashiService.updateById(huashi);
        return R.ok().put("data", huashi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        HuashiEntity huashi = huashiService.selectById(id);
        if(type.equals("1")) {
        	huashi.setThumbsupnum(huashi.getThumbsupnum()+1);
        } else {
        	huashi.setCrazilynum(huashi.getCrazilynum()+1);
        }
        huashiService.updateById(huashi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuashiEntity huashi, HttpServletRequest request){
    	huashi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huashi);
    	HuashiEntity u = huashiService.selectOne(new EntityWrapper<HuashiEntity>().eq("huashizhanghao", huashi.getHuashizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		huashi.setId(new Date().getTime());
        huashiService.insert(huashi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuashiEntity huashi, HttpServletRequest request){
    	huashi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huashi);
    	HuashiEntity u = huashiService.selectOne(new EntityWrapper<HuashiEntity>().eq("huashizhanghao", huashi.getHuashizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		huashi.setId(new Date().getTime());
        huashiService.insert(huashi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuashiEntity huashi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huashi);
        huashiService.updateById(huashi);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huashiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<HuashiEntity> wrapper = new EntityWrapper<HuashiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = huashiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,HuashiEntity huashi, HttpServletRequest request,String pre){
        EntityWrapper<HuashiEntity> ew = new EntityWrapper<HuashiEntity>();
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
		PageUtils page = huashiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huashi), params), params));
        return R.ok().put("data", page);
    }









}
