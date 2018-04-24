/**
 * 
 * Copyright of Accurate Background 
 * 
 * Author: Shaik Fareed
 * 
 * Team : Microservices
 */
package com.ab.exception;

public class OrderDeletionException extends Exception {
	/**
	 * This exception is thrown when there is problem fetching customer
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public OrderDeletionException(){
		super("Could not delete order");
	}

	/**
	 * @param msg
	 */
	public OrderDeletionException(String msg){
		super(msg);
	}
	
	/**
	 * @param msg
	 * @param t
	 */
	public OrderDeletionException(String msg,Throwable t){
		super(msg,t);
	}

}
