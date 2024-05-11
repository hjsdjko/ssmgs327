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


import com.dao.KemumingchengDao;
import com.entity.KemumingchengEntity;
import com.service.KemumingchengService;
import com.entity.vo.KemumingchengVO;
import com.entity.view.KemumingchengView;

@Service("kemumingchengService")
public class KemumingchengServiceImpl extends ServiceImpl<KemumingchengDao, KemumingchengEntity> implements KemumingchengService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KemumingchengEntity> page = this.selectPage(
                new Query<KemumingchengEntity>(params).getPage(),
                new EntityWrapper<KemumingchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KemumingchengEntity> wrapper) {
		  Page<KemumingchengView> page =new Query<KemumingchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KemumingchengVO> selectListVO(Wrapper<KemumingchengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KemumingchengVO selectVO(Wrapper<KemumingchengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KemumingchengView> selectListView(Wrapper<KemumingchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KemumingchengView selectView(Wrapper<KemumingchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
