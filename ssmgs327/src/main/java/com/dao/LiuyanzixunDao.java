package com.dao;

import com.entity.LiuyanzixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LiuyanzixunVO;
import com.entity.view.LiuyanzixunView;


/**
 * 留言咨询
 * 
 * @author 
 * @email 
 * @date 2022-04-29 19:03:33
 */
public interface LiuyanzixunDao extends BaseMapper<LiuyanzixunEntity> {
	
	List<LiuyanzixunVO> selectListVO(@Param("ew") Wrapper<LiuyanzixunEntity> wrapper);
	
	LiuyanzixunVO selectVO(@Param("ew") Wrapper<LiuyanzixunEntity> wrapper);
	
	List<LiuyanzixunView> selectListView(@Param("ew") Wrapper<LiuyanzixunEntity> wrapper);

	List<LiuyanzixunView> selectListView(Pagination page,@Param("ew") Wrapper<LiuyanzixunEntity> wrapper);
	
	LiuyanzixunView selectView(@Param("ew") Wrapper<LiuyanzixunEntity> wrapper);
	

}
