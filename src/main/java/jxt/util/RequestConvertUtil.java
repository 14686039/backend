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

package jxt.util;

import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tangshun
 * 2015年7月20日
 * Ver 1.0
 */
public class RequestConvertUtil {
	
	/**
	 * 从http请求构造对象
	 * 不针对上传文件
	 * @param request
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T request2ObjectByCamel(HttpServletRequest request,Class<T> clazz) {
		T result=null;
		try{
			result=clazz.newInstance();
			Field[] fields=clazz.getDeclaredFields();
			
			for(Field field:fields){
				field.setAccessible(true);
				String fieldName=fieldName2ColumnName(field.getName());
				Object value = request.getParameter(fieldName);
				 if(String.class.equals((field.getType()))){
					field.set(result,(null==value)?"":value.toString());
				}else if(Integer.class.equals((field.getType()))||"int".equals(field.getType().toString())){
					field.set(result, Integer.parseInt(value.toString()));
				}else if (Float.class.equals((field.getType()))||"float".equals(field.getType().toString())) {
					field.set(result, Float.parseFloat(value.toString()));
				}else if (Double.class.equals((field.getType()))||"double".equals(field.getType().toString())) {
					field.set(result, Double.parseDouble(value.toString()));
				}else if(Long.class.equals((field.getType()))||"long".equals(field.getType().toString())){
					field.set(result, Long.parseLong(value.toString()));
				}else if(Character.class.equals((field.getType()))){
					Character charValue = (null==value||"".equals(value))?null:value.toString().charAt(0);
					field.set(result, charValue);						
				}else{
					field.set(result, value);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	/**
	 * 属性转数据库列名
	 * @param str 属性名
	 * @return
	 */
	public static String fieldName2ColumnName(String str){
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			 return str;
		}
		StringBuffer buffer = new StringBuffer(strLen);

		char ch = 0;
		for (int i = 0; i < strLen; i++) {
			ch = str.charAt(i);
			if (Character.isUpperCase(ch)) {
				ch = Character.toLowerCase(ch);
				buffer.append("_");
			}
			if(Character.isDigit(ch)){//数字
				buffer.append("_");
			}
			buffer.append(ch);
		}
		return buffer.toString();
	}
}
