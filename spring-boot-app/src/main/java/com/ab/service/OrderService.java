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

import com.ab.entity.Order;
import com.ab.exception.OrderCreationException;
import com.ab.exception.OrderDeletionException;
import com.ab.exception.OrderLoadException;
import com.ab.model.OrderModel;

public interface OrderService {

	/**
	 * @param customer
	 * @throws OrderCreationException 
	 */
	void saveOrder(Order customer) throws OrderCreationException;

	/**
	 * @return
	 * @throws OrderLoadException 
	 */
	List<OrderModel> findAllOrders() throws OrderLoadException;

	/**
	 * @param customerId
	 * @throws OrderDeletionException 
	 */
	void deleteOrderById(String customerId) throws OrderDeletionException;

	OrderModel findOrderById(String orderId) throws OrderLoadException;

}
