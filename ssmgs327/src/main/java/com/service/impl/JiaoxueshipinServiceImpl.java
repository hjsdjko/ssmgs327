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


import com.dao.JiaoxueshipinDao;
import com.entity.JiaoxueshipinEntity;
import com.service.JiaoxueshipinService;
import com.entity.vo.JiaoxueshipinVO;
import com.entity.view.JiaoxueshipinView;

@Service("jiaoxueshipinService")
public class JiaoxueshipinServiceImpl extends ServiceImpl<JiaoxueshipinDao, JiaoxueshipinEntity> implements JiaoxueshipinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaoxueshipinEntity> page = this.selectPage(
                new Query<JiaoxueshipinEntity>(params).getPage(),
                new EntityWrapper<JiaoxueshipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaoxueshipinEntity> wrapper) {
		  Page<JiaoxueshipinView> page =new Query<JiaoxueshipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiaoxueshipinVO> selectListVO(Wrapper<JiaoxueshipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaoxueshipinVO selectVO(Wrapper<JiaoxueshipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaoxueshipinView> selectListView(Wrapper<JiaoxueshipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaoxueshipinView selectView(Wrapper<JiaoxueshipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
