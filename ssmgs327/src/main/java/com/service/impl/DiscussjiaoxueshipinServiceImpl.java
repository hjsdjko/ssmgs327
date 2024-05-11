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


import com.dao.DiscussjiaoxueshipinDao;
import com.entity.DiscussjiaoxueshipinEntity;
import com.service.DiscussjiaoxueshipinService;
import com.entity.vo.DiscussjiaoxueshipinVO;
import com.entity.view.DiscussjiaoxueshipinView;

@Service("discussjiaoxueshipinService")
public class DiscussjiaoxueshipinServiceImpl extends ServiceImpl<DiscussjiaoxueshipinDao, DiscussjiaoxueshipinEntity> implements DiscussjiaoxueshipinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiaoxueshipinEntity> page = this.selectPage(
                new Query<DiscussjiaoxueshipinEntity>(params).getPage(),
                new EntityWrapper<DiscussjiaoxueshipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiaoxueshipinEntity> wrapper) {
		  Page<DiscussjiaoxueshipinView> page =new Query<DiscussjiaoxueshipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussjiaoxueshipinVO> selectListVO(Wrapper<DiscussjiaoxueshipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjiaoxueshipinVO selectVO(Wrapper<DiscussjiaoxueshipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjiaoxueshipinView> selectListView(Wrapper<DiscussjiaoxueshipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiaoxueshipinView selectView(Wrapper<DiscussjiaoxueshipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
