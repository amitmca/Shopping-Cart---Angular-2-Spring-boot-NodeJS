/**
*
*
 
*
* Author : Shaik Fareed
*
* 
*
**/ 
package com.ab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ab.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {

}