/**
*
*
* Author : Shaik Fareed
* 
*
**/ 
package com.ab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ab.entity.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {

}
