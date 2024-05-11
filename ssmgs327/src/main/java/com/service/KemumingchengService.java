package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KemumingchengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KemumingchengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KemumingchengView;


/**
 * 科目名称
 *
 * @author 
 * @email 
 * @date 2022-04-29 19:03:33
 */
public interface KemumingchengService extends IService<KemumingchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KemumingchengVO> selectListVO(Wrapper<KemumingchengEntity> wrapper);
   	
   	KemumingchengVO selectVO(@Param("ew") Wrapper<KemumingchengEntity> wrapper);
   	
   	List<KemumingchengView> selectListView(Wrapper<KemumingchengEntity> wrapper);
   	
   	KemumingchengView selectView(@Param("ew") Wrapper<KemumingchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KemumingchengEntity> wrapper);
   	

}

