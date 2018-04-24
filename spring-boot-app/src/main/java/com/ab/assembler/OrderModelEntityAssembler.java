/**
*
*
 
*
* Author : Shaik Fareed
*
* 
*
**/ 
package com.ab.assembler;

import java.util.ArrayList;
import java.util.List;

import com.ab.entity.Order;
import com.ab.entity.Product;
import com.ab.model.OrderModel;
import com.ab.model.ProductModel;

public class OrderModelEntityAssembler {

	/**
	 * @param orderModel
	 * @return
	 */
	public static Order populateEntityFromModel(OrderModel orderModel) {
		Order order = new Order();
		
		if(orderModel!=null){
			List<Product> cart = new ArrayList<>();
			if(orderModel.getCart()!=null){
				orderModel.getCart().forEach(productModel -> {
					cart.add(ProductModelEntitAssembler.populateEntityFromModel(productModel));
				});
			}
			order.setCart(cart);
			order.setTotalCost(orderModel.getTotalCost());
			order.setTotalQuantity(orderModel.getTotalQuantity());
		}
		
		return order;
	}

	/**
	 * @param order
	 * @return
	 */
	public static OrderModel populateModelFromEntity(Order order) {
		OrderModel orderModel = new OrderModel();
		
		if(order!=null){
			List<ProductModel> cart = new ArrayList<>();
			if(order.getCart()!=null){
				order.getCart().forEach(product -> {
					cart.add(ProductModelEntitAssembler.populateModelFromEntity(product));
				});
			}
			orderModel.setId(order.getOrderId());
			orderModel.setCart(cart);
			orderModel.setTotalCost(order.getTotalCost());
			orderModel.setTotalQuantity(order.getTotalQuantity());
		}
		
		return orderModel;		
	}

	
	
}
