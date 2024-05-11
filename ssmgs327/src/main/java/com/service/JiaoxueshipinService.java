package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaoxueshipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaoxueshipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoxueshipinView;


/**
 * 教学视频
 *
 * @author 
 * @email 
 * @date 2022-04-29 19:03:33
 */
public interface JiaoxueshipinService extends IService<JiaoxueshipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaoxueshipinVO> selectListVO(Wrapper<JiaoxueshipinEntity> wrapper);
   	
   	JiaoxueshipinVO selectVO(@Param("ew") Wrapper<JiaoxueshipinEntity> wrapper);
   	
   	List<JiaoxueshipinView> selectListView(Wrapper<JiaoxueshipinEntity> wrapper);
   	
   	JiaoxueshipinView selectView(@Param("ew") Wrapper<JiaoxueshipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaoxueshipinEntity> wrapper);
   	

}

