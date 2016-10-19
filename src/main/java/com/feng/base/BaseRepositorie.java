package com.feng.base;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseRepositorie<T> extends PagingAndSortingRepository<T,Long>,JpaSpecificationExecutor<T>{

}
