

package jxt.controller;

import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jxt.pojo.AreaPojo;
import jxt.util.Pojo;
import jxt.util.RequestConvertUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tangshun
 * 2015年7月19日
 * Ver 1.0
 */
@Controller
@RequestMapping("")
public class NavMenuController {

	@RequestMapping(value = "/navmenu", method = RequestMethod.POST)
	@ResponseBody
	public String getSlideNavMenu(HttpServletRequest request){
		
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name=names.nextElement();
			System.out.println(name+":"+request.getParameter(name));
		}
		
		AreaPojo pojo = RequestConvertUtil.request2ObjectByCamel(request, AreaPojo.class);
		
		
		String action=request.getParameter("action");//动作，决定执行CRUD
		System.out.println(action);
		System.out.println(pojo);
		//System.out.println(pojo.getId()+"-"+pojo.getAddr()+"-"+pojo.getName()+"-"+pojo.getOp()+"-"+action);
		
		return "{\"menu\":\"<a>这是一个内容</a>\"}";
	}
	
	
}
