package com.feng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feng.base.BaseComponent;
import com.feng.entity.ModelEntity;
import com.feng.service.ModelService;
import com.feng.util.exception.ExceptionCode;
import com.feng.util.exception.ValidateUtils;
import com.feng.util.redis.JedisClient;

@RestController
@RequestMapping("/api/model")
public class ModelController extends BaseComponent{

	@Autowired
	private ModelService modelService;
	
	@Autowired
	private JedisClient jedisClient;
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<ModelEntity> sayHello(@RequestParam(name="name",required=false) String name,
			Pageable page){
		
		loger.info("hello!!!!!!!!!!!!!!!Info");
		
		jedisClient.hset("key1", "fielf1", "fengshuaiju");
		
		String hget = jedisClient.hget("key1", "fielf1");
		
		System.out.println(hget);
		
		Long hdel = jedisClient.hdel("key1","fielf1");
		
		System.out.println(hdel);
        
		
		String hget1 = jedisClient.hget("key1", "fielf1");
		
        System.out.println(hget1);
        
		ValidateUtils.isTrue(true, ExceptionCode.UNKNOWN);
		Page<ModelEntity> pageList = modelService.findAll(name,page);
		return pageList;
	}
	
	@RequestMapping(value="/{modelId}",method=RequestMethod.GET)
	private ModelEntity getById(@PathVariable Long modelId){
		modelId = 1l;
		ModelEntity modelEntity = modelService.findById(modelId);
		return modelEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	private ModelEntity create(@RequestBody ModelEntity entity){
		entity = modelService.create(entity);
		return entity;
	}
	
	@RequestMapping(value="/{modelId}",method=RequestMethod.PUT)
	private ModelEntity update(@PathVariable Long modelId){
		ModelEntity modelEntity = modelService.update(modelId);
		return modelEntity;
	}
	
	@RequestMapping(value="/{modelId}",method=RequestMethod.DELETE)
	private String delete(@PathVariable Long modelId){
		modelService.delete(modelId);
		return "success";
	}
}