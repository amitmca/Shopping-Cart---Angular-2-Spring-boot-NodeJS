/**
*
*
 
*
* Author : Shaik Fareed
*
* 
*
**/ 
package com.ab.exception;

/*
 *   
 *  
 *  
 * 
*/
public class OrderCreationException extends Exception {

	/**
	 * This exception is thrown when there is problem saving customer
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public OrderCreationException(){
		super("Order could not be saved:");
	}

	/**
	 * @param msg
	 */
	public OrderCreationException(String msg){
		super(msg);
	}
	
	/**
	 * @param msg
	 * @param t
	 */
	public OrderCreationException(String msg,Throwable t){
		super(msg,t);
	}
}
