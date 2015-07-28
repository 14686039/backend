package jxt.util;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
				String fieldName=(field.getName());
				Object value = request.getParameter(fieldName);
				if(value==null){
					continue;
				}
				 if(String.class.equals((field.getType()))){
					field.set(result,(null==value)?"":value.toString());
				}else if(Integer.class.equals((field.getType()))||"int".equals(field.getType().toString())){
					if(!"".equals(value.toString().trim()))
						field.set(result, Integer.parseInt(value.toString()));
				}else if (Float.class.equals((field.getType()))||"float".equals(field.getType().toString())) {
					if(!"".equals(value.toString().trim()))
						field.set(result, Float.parseFloat(value.toString()));
				}else if (Double.class.equals((field.getType()))||"double".equals(field.getType().toString())) {
					if(!"".equals(value.toString().trim()))
						field.set(result, Double.parseDouble(value.toString()));
				}else if(Long.class.equals((field.getType()))||"long".equals(field.getType().toString())){
					if(!"".equals(value.toString().trim()))
						field.set(result, Long.parseLong(value.toString()));
				}else if(Character.class.equals((field.getType()))){
					Character charValue = (null==value||"".equals(value))?null:value.toString().charAt(0);
					field.set(result, charValue);						
				}else if(Date.class.equals((field.getType()))){
					if(!"".equals(value.toString().trim())){
						DateFormat fmt1 =new SimpleDateFormat("yyyy-MM-dd");
						DateFormat fmt2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date date =null;
						try {
							date = fmt1.parse(value.toString());
							date = fmt2.parse(value.toString());
							field.set(result, date);
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("前端传参，日期格式错误");
						}
					}
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
