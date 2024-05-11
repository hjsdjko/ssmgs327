package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LiuyanzixunEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LiuyanzixunVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LiuyanzixunView;


/**
 * 留言咨询
 *
 * @author 
 * @email 
 * @date 2022-04-29 19:03:33
 */
public interface LiuyanzixunService extends IService<LiuyanzixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LiuyanzixunVO> selectListVO(Wrapper<LiuyanzixunEntity> wrapper);
   	
   	LiuyanzixunVO selectVO(@Param("ew") Wrapper<LiuyanzixunEntity> wrapper);
   	
   	List<LiuyanzixunView> selectListView(Wrapper<LiuyanzixunEntity> wrapper);
   	
   	LiuyanzixunView selectView(@Param("ew") Wrapper<LiuyanzixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LiuyanzixunEntity> wrapper);
   	

}

