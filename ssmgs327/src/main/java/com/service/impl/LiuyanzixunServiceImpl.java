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


import com.dao.LiuyanzixunDao;
import com.entity.LiuyanzixunEntity;
import com.service.LiuyanzixunService;
import com.entity.vo.LiuyanzixunVO;
import com.entity.view.LiuyanzixunView;

@Service("liuyanzixunService")
public class LiuyanzixunServiceImpl extends ServiceImpl<LiuyanzixunDao, LiuyanzixunEntity> implements LiuyanzixunService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LiuyanzixunEntity> page = this.selectPage(
                new Query<LiuyanzixunEntity>(params).getPage(),
                new EntityWrapper<LiuyanzixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LiuyanzixunEntity> wrapper) {
		  Page<LiuyanzixunView> page =new Query<LiuyanzixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LiuyanzixunVO> selectListVO(Wrapper<LiuyanzixunEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LiuyanzixunVO selectVO(Wrapper<LiuyanzixunEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LiuyanzixunView> selectListView(Wrapper<LiuyanzixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LiuyanzixunView selectView(Wrapper<LiuyanzixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
