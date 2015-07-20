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

/**
 * @author tangshun
 * 2015年7月20日
 * Ver 1.0
 */
public class StringConvertUtil {
	/**
	 * 数据库列名转属性
	 * @param columnName 数据库列名
	 * @return
	 */
	public static String columnName2FieldName(String columnName){
		String result = columnName.toLowerCase();
		boolean upcaseFlag = false;
		char[] charArr = result.toCharArray();
		result = "";
		for(char ch :charArr){
			if(ch=='_'){
				upcaseFlag = true;
				continue;
			}else if(upcaseFlag){
				result += (""+ch).toUpperCase();
				upcaseFlag = false;
			}else{
				result += ch;
				upcaseFlag = false;
			}
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
