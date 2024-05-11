package com.entity.view;

import com.entity.KemumingchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 科目名称
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-29 19:03:33
 */
@TableName("kemumingcheng")
public class KemumingchengView  extends KemumingchengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KemumingchengView(){
	}
 
 	public KemumingchengView(KemumingchengEntity kemumingchengEntity){
 	try {
			BeanUtils.copyProperties(this, kemumingchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
