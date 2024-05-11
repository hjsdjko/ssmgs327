package com.dao;

import com.entity.JiaoxueshipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaoxueshipinVO;
import com.entity.view.JiaoxueshipinView;


/**
 * 教学视频
 * 
 * @author 
 * @email 
 * @date 2022-04-29 19:03:33
 */
public interface JiaoxueshipinDao extends BaseMapper<JiaoxueshipinEntity> {
	
	List<JiaoxueshipinVO> selectListVO(@Param("ew") Wrapper<JiaoxueshipinEntity> wrapper);
	
	JiaoxueshipinVO selectVO(@Param("ew") Wrapper<JiaoxueshipinEntity> wrapper);
	
	List<JiaoxueshipinView> selectListView(@Param("ew") Wrapper<JiaoxueshipinEntity> wrapper);

	List<JiaoxueshipinView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoxueshipinEntity> wrapper);
	
	JiaoxueshipinView selectView(@Param("ew") Wrapper<JiaoxueshipinEntity> wrapper);
	

}
