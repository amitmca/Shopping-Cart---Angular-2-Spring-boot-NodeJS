/**
 * 
 * Copyright of Accurate Background 
 * 
 * Author: Shaik Fareed
 * 
 * Team : Microservices
 */
package com.ab.exception;

public class OrderLoadException extends Exception {


	/**
	 * This exception is thrown when there is problem fetching customer
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public OrderLoadException(){
		super("Could not fetch order list:");
	}

	/**
	 * @param msg
	 */
	public OrderLoadException(String msg){
		super(msg);
	}
	
	/**
	 * @param msg
	 * @param t
	 */
	public OrderLoadException(String msg,Throwable t){
		super(msg,t);
	}

}
