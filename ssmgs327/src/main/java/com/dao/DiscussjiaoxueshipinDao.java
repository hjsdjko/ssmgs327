package com.dao;

import com.entity.DiscussjiaoxueshipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjiaoxueshipinVO;
import com.entity.view.DiscussjiaoxueshipinView;


/**
 * 教学视频评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-29 19:03:33
 */
public interface DiscussjiaoxueshipinDao extends BaseMapper<DiscussjiaoxueshipinEntity> {
	
	List<DiscussjiaoxueshipinVO> selectListVO(@Param("ew") Wrapper<DiscussjiaoxueshipinEntity> wrapper);
	
	DiscussjiaoxueshipinVO selectVO(@Param("ew") Wrapper<DiscussjiaoxueshipinEntity> wrapper);
	
	List<DiscussjiaoxueshipinView> selectListView(@Param("ew") Wrapper<DiscussjiaoxueshipinEntity> wrapper);

	List<DiscussjiaoxueshipinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiaoxueshipinEntity> wrapper);
	
	DiscussjiaoxueshipinView selectView(@Param("ew") Wrapper<DiscussjiaoxueshipinEntity> wrapper);
	

}
