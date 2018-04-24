/**
*
*
 
*
* Author : Shaik Fareed
*
* 
*
**/ 
package com.ab.service;

import java.util.List;

import com.ab.model.ProductModel;

public interface ProductService {

	List<ProductModel> findAllProducts();

	ProductModel findProductById(String productId);
	
}
