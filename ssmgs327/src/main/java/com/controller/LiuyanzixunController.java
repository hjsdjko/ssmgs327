package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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

import com.entity.LiuyanzixunEntity;
import com.entity.view.LiuyanzixunView;

import com.service.LiuyanzixunService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 留言咨询
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-29 19:03:33
 */
@RestController
@RequestMapping("/liuyanzixun")
public class LiuyanzixunController {
    @Autowired
    private LiuyanzixunService liuyanzixunService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LiuyanzixunEntity liuyanzixun, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			liuyanzixun.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			liuyanzixun.setJiaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LiuyanzixunEntity> ew = new EntityWrapper<LiuyanzixunEntity>();
		PageUtils page = liuyanzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liuyanzixun), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LiuyanzixunEntity liuyanzixun, 
		HttpServletRequest request){
        EntityWrapper<LiuyanzixunEntity> ew = new EntityWrapper<LiuyanzixunEntity>();
		PageUtils page = liuyanzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liuyanzixun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LiuyanzixunEntity liuyanzixun){
       	EntityWrapper<LiuyanzixunEntity> ew = new EntityWrapper<LiuyanzixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( liuyanzixun, "liuyanzixun")); 
        return R.ok().put("data", liuyanzixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LiuyanzixunEntity liuyanzixun){
        EntityWrapper< LiuyanzixunEntity> ew = new EntityWrapper< LiuyanzixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( liuyanzixun, "liuyanzixun")); 
		LiuyanzixunView liuyanzixunView =  liuyanzixunService.selectView(ew);
		return R.ok("查询留言咨询成功").put("data", liuyanzixunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LiuyanzixunEntity liuyanzixun = liuyanzixunService.selectById(id);
        return R.ok().put("data", liuyanzixun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LiuyanzixunEntity liuyanzixun = liuyanzixunService.selectById(id);
        return R.ok().put("data", liuyanzixun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LiuyanzixunEntity liuyanzixun, HttpServletRequest request){
    	liuyanzixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(liuyanzixun);

        liuyanzixunService.insert(liuyanzixun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody LiuyanzixunEntity liuyanzixun, HttpServletRequest request){
    	liuyanzixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(liuyanzixun);

        liuyanzixunService.insert(liuyanzixun);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LiuyanzixunEntity liuyanzixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(liuyanzixun);
        liuyanzixunService.updateById(liuyanzixun);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        liuyanzixunService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<LiuyanzixunEntity> wrapper = new EntityWrapper<LiuyanzixunEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			wrapper.eq("jiaoshizhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = liuyanzixunService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
