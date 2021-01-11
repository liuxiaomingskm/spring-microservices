package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<?,?> 第一个参数说明管理的entity是哪个 第二个说明id的类型
public interface ExchangeValueRepository extends 
		JpaRepository<ExchangeValue, Long>{
	// 没有默认方法，只能自建，这里find“From”And“To”和entity的字段对应 而不是column对应
	ExchangeValue findByFromAndTo(String from, String to);
}
