package com.ab.assembler;

import com.ab.entity.Product;
import com.ab.model.ProductModel;

public class ProductModelEntitAssembler {

	public static ProductModel populateModelFromEntity(Product product) {
		
		ProductModel productModel = new ProductModel();
		
		if(product!=null){
			productModel.setId(product.getId());
			productModel.setName(product.getName());
			productModel.setInfo(product.getInfo());
			productModel.setPrice(product.getPrice());
			productModel.setSrc(product.getSrc());
		}
		
		return productModel;		
	}
	
	public static Product populateEntityFromModel(ProductModel productModel) {
		
		Product product = new Product();
		
		if(productModel!=null){
			product.setId(productModel.getId());
			product.setName(productModel.getName());
			product.setInfo(productModel.getInfo());
			product.setPrice(productModel.getPrice());
			product.setSrc(productModel.getSrc());
		}
		
		return product;		
	}
	
}
