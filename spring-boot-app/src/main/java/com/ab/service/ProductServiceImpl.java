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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.assembler.ProductModelEntitAssembler;
import com.ab.entity.Product;
import com.ab.model.ProductModel;
import com.ab.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<ProductModel> findAllProducts() {
		
		List<Product> list = productRepo.findAll();
		
		List<ProductModel> productModelList = new ArrayList<>();
		
		if(list!=null){
			list.forEach(product -> {
				productModelList.add(ProductModelEntitAssembler.populateModelFromEntity(product));
			});
		}
		
		return productModelList;
	}

	@Override
	public ProductModel findProductById(String productId) {
		return ProductModelEntitAssembler.populateModelFromEntity(productRepo.findOne(Integer.parseInt(productId)));
	}
	
}
