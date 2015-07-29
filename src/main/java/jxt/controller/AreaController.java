/*
 * Copyright (c) 2014 Nanjing Sesan Medical Technology Co.,Ltd.
 * All Rights Reserved
 * The software and information contained herein are proprietary to, and
 * comprise valuable trade secrets of, Nanjing Sesan Medical Technology Co.,Ltd., 
 * which intends to preserve as trade secrets such software and information.
 * This software is an unpublished copyright of Nanjing Sesan Medical Technology Co.,Ltd.. 
 * and may not be used, copied, transmitted, or stored in any manner. 
 * This software and information or any other copies thereof may
 * not be provided or otherwise made available to any other person.
 */

package jxt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jxt.pojo.AreaPojo;
import jxt.service.AreaService;
import jxt.util.RequestConvertUtil;
import jxt.util.page.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tangshun
 * 2015年7月26日
 * Ver 1.0
 */
@Controller
@RequestMapping("area")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@RequestMapping("/query")
	@ResponseBody
	public Page<AreaPojo> getAreaAll(@RequestParam(required=false) String search,@RequestParam(required=false) String currentPage){
		System.out.println(search+":"+currentPage);
		if(currentPage==null||"".equals(currentPage)){
			currentPage="1";
		}
		List<AreaPojo> areas=areaService.selectAll();
		Page<AreaPojo> page=new Page<AreaPojo>();
		page.setResult(areas);
		page.setNowPage(Integer.parseInt(currentPage));
		page.setPageShow(10);
		page.setTotalCount(95);
		page.setTotalPage(10);
		System.out.println(page);
		return page;
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String editTable(HttpServletRequest request){
		
//		Enumeration<String> names = request.getParameterNames();
//		while(names.hasMoreElements()){
//			String name=names.nextElement();
//			System.out.println(name+":"+request.getParameter(name));
//		}
		
		AreaPojo pojo = RequestConvertUtil.request2ObjectByCamel(request, AreaPojo.class);
		
		
		String action=request.getParameter("action");//动作，决定执行CRUD
		System.out.println(action);
		System.out.println(pojo);
		//System.out.println(pojo.getId()+"-"+pojo.getAddr()+"-"+pojo.getName()+"-"+pojo.getOp()+"-"+action);
		
		return "{\"result\":\"ok\"}";
	}
	
}
