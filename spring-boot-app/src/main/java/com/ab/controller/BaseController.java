/**
 * 
 * Copyright of Accurate Background 
 * 
 * Author: Shaik Fareed
 * 
 * Team : Microservices
 */
package com.ab.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController /*implements ErrorController*/{

	@Value(value = "${error.500}")
	private String ERROR_500;
	
	@Value(value = "${error.404}")
	private String ERROR_404;
	
	@Value(value = "${error.403}")
	private String ERROR_403;
	
	@Value(value = "${error.custom}")
	private String ERROR_CUSTOM;
	
	@RequestMapping("/errorCustom")
	public String errorPageNotFound(HttpServletRequest req,HttpServletResponse resp,Map<String,Object> model){
		model.put("msg", ERROR_CUSTOM);
		return "error";
	}

	@RequestMapping("/errors_404")
	public String errorPageN(HttpServletRequest req,HttpServletResponse resp,Map<String,Object> model){
		model.put("msg", ERROR_404);
		return "error";
	}
	
	@RequestMapping("/errors_403")
	public String errorForbidden(HttpServletRequest req,HttpServletResponse resp,Map<String,Object> model){
		model.put("msg", ERROR_403);
		return "error";
	}
	
	@RequestMapping("/errors_500")
	public String errorInternalServer(HttpServletRequest req,HttpServletResponse resp,Map<String,Object> model){
		model.put("msg", ERROR_500);
		return "error";
	}
	
	/*@Override
	public String getErrorPath() {
		return "/error";
	}*/
	
}
