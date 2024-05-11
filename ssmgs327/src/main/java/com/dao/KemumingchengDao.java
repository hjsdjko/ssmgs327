package com.dao;

import com.entity.KemumingchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KemumingchengVO;
import com.entity.view.KemumingchengView;


/**
 * 科目名称
 * 
 * @author 
 * @email 
 * @date 2022-04-29 19:03:33
 */
public interface KemumingchengDao extends BaseMapper<KemumingchengEntity> {
	
	List<KemumingchengVO> selectListVO(@Param("ew") Wrapper<KemumingchengEntity> wrapper);
	
	KemumingchengVO selectVO(@Param("ew") Wrapper<KemumingchengEntity> wrapper);
	
	List<KemumingchengView> selectListView(@Param("ew") Wrapper<KemumingchengEntity> wrapper);

	List<KemumingchengView> selectListView(Pagination page,@Param("ew") Wrapper<KemumingchengEntity> wrapper);
	
	KemumingchengView selectView(@Param("ew") Wrapper<KemumingchengEntity> wrapper);
	

}
