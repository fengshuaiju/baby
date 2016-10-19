package com.feng.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.feng.entity.ModelEntity;

public interface ModelService {
	public Page<ModelEntity> findAll(String name, Pageable page);

	public ModelEntity findById(Long modelId);

	public ModelEntity create(ModelEntity modelEntity);

	public ModelEntity update(Long modelId);

	public void delete(Long modelId);
}
