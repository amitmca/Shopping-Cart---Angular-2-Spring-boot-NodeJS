/**
 *
 *

 *
 * Author : Shaik Fareed
 *
 * 
 *
 **/ 
package com.ab.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ab.assembler.OrderModelEntityAssembler;
import com.ab.entity.Order;
import com.ab.exception.OrderCreationException;
import com.ab.exception.OrderDeletionException;
import com.ab.exception.OrderLoadException;
import com.ab.model.OrderModel;
import com.ab.model.ProductModel;
import com.ab.service.OrderService;
import com.ab.service.ProductService;

@RestController
public class WebController {

	Logger logger = LoggerFactory.getLogger(WebController.class);


	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;


	@RequestMapping(value="/orders",method=RequestMethod.GET)
	public List<OrderModel> orders() throws OrderLoadException{
		List<OrderModel> list = orderService.findAllOrders();
		return list;
	}


	@RequestMapping(value="/saveOrder",method=RequestMethod.POST)
	public ResponseEntity<OrderModel> saveOrder(@RequestBody OrderModel orderModel) throws OrderDeletionException, OrderCreationException, OrderLoadException{


		Order order = OrderModelEntityAssembler.populateEntityFromModel(orderModel);

		logger.info("Saving Order Details...");

		if(orderModel.getTotalQuantity()!=null && Integer.parseInt(orderModel.getTotalQuantity())!=0){
			orderService.saveOrder(order);
		}else{
			throw new OrderCreationException();
		}
		return new ResponseEntity<>(orderModel,HttpStatus.OK);
	}

	@RequestMapping(value="/productList",method=RequestMethod.GET)
	public List<ProductModel> productList() throws OrderLoadException{

		logger.info("Fethcing the List of products......");

		List<ProductModel> list =  productService.findAllProducts();

		return list;
	}

	@RequestMapping(value="/product/{productId}",method=RequestMethod.GET)
	public ProductModel getProductById(@PathVariable("productId")String productId) throws OrderLoadException{

		logger.info("Fethcing product by id......");

		ProductModel productModel =  productService.findProductById(productId);

		return productModel;
	}

	@RequestMapping(value="/deleteOrder",method=RequestMethod.GET)
	public String deleteOrder(@RequestParam("orderId")String productId,Map<String,Object> model) throws OrderDeletionException, OrderLoadException{

		logger.info("Deleting the product......"+productId);

		orderService.deleteOrderById(productId);

		model.put("productList", orderService.findAllOrders());

		return "productId";
	}

	@RequestMapping(value="/editOrder",method=RequestMethod.GET)
	public OrderModel editOrder(@RequestParam("orderId")String orderId,Map<String,Object> model) throws OrderLoadException{

		logger.info("Fetching order details for......"+orderId);

		OrderModel orderModel =orderService.findOrderById(orderId);

		return orderModel;
	}

	@ExceptionHandler(OrderCreationException.class)
	public ResponseEntity handleException(OrderCreationException e,Map<String,Object> model){
		logger.error(e.getMessage(), e);
		model.put("msg", e.getMessage());
		return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(OrderLoadException.class)
	public ResponseEntity handleException(OrderLoadException e,Map<String,Object> model){
		logger.error(e.getMessage(), e);
		model.put("msg", e.getMessage());
		return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(OrderDeletionException.class)
	public ResponseEntity handleException(OrderDeletionException e,Map<String,Object> model){
		logger.error(e.getMessage(), e);
		model.put("msg", e.getMessage());
		return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
