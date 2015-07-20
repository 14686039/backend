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

package jxt.util.properties;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;


/**
 * 常量
 * @author tangshun
 * 2014年12月15日下午2:52:58
 * Ver 1.0
 */
public class Constants implements ConstantConfigurer {
	/**
	 * 当前版本
	 */
	public static final String VERSION = "1.0.0";
	
	public static final String PASSWORDRETRYCACHE="passwordRetryCache";
	public static final String AUTHORIZATIONCACHE="authorizationCache";
	public static final String AUTHENTICATIONCACHE="authenticationCache";
	public static final String SHIROACTIVESESSIONCACHE="shiro-activeSessionCache";
	

	public static final String STATUS = "status";
	public static final String MESSAGE = "message";
	public static final String OPERATION_SUCCESS = "operationSuccess";
	public static final String OPERATION_FAILURE = "operationFailure";
	public static final String SAVE_SUCCESS = "saveSuccess";
	public static final String DELETE_SUCCESS = "deleteSuccess";

	public static final String USER_ANGENT = "Mozilla/5.0";

	public static final Boolean SESSION_FORCE_LOGOUT_KEY = false;

	public static String LOGIN_URL = "/login";
	public static String TEMPLATE_STORE_PATH = "/template";
	public static String TEMPLATE_DISPLAY_PATH = "/template";
	public static String STATIC_DISPLAY_PATH = "/static";
	public static String OPENOFFICE_HOST = null;
	public static int OPENOFFICE_PORT = -1;
	public static boolean IS_ROOT_ALL_PERMS = false;

	public static String BACK_SUCCESS_URL = "/index";
	public static String BACK_LOGIN_URL = "/login";
	public static String DEF_USERNAME = "";
	public static String DEF_PASSWORD = "";
	
	public static String IMAGES_URL="/upload";
	
	public static String SELECT_EXCEPTION="数据库操作发生查询异常：";
	public static String INSERT_EXCEPTION="数据库操作发生新增异常：";
	public static String UPDATE_EXCEPTION="数据库操作发生更新异常：";
	public static String DELETE_EXCEPTION="数据库操作发生删除异常：";
	
	/**
	 * memcache开关（true:开，false:关）
	 */
	public static boolean MEMCACHE_SWITCH=true;

	/**
	 * 每页显示条数
	 */
	public static int PAGE_SHOW=10;
	
	/**
	 * 有图片每页显示条数
	 */
	public static int PAGE_IMGSHOW=8;

	/**
	 *  用户类型（user:电商用户，staff:员工，doctor:医生）
	 * @author Administrator
	 */
	public static enum USERSTYLE{
		user("01"),staff("02"),doctor("03");
	     //构造器默认只能是private, 保证构造函数只能在内部使用
		private final String value;
		USERSTYLE(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
	}

	/**
	 * 日志类型（login:登陆，register:注册，password:密码，active:激活，baseinfo:基本信息，address:地址）
	 * @author liqian
	 */
	public static enum EVENTTYPE{
		login("01"),register("02"),password("03"),active("04"),baseinfo("05"),address("06");
		
		private final String value;
		EVENTTYPE(String value){
			this.value = value;
		}
		
		public String getValue() {
	        return value;
	    }
	}

	/**
	 * 状态（normal:正常，logout:注销）
	 * @author liqian
	 */
	public static enum AVAILABLE{
		normal("1"),logout("0");
		
		private final String value;
		AVAILABLE(String value){
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 地址类型（delivery:送货地址，live:家庭地址，supply:供应商地址）
	 * @author liqian
	 */
	public static enum ADDRTYPE{
		delivery("1"),live("0"),supply("2");
		
		private final String value;
		ADDRTYPE(String value){
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 正则匹配(username:用户名，password:密码，telephone:手机，email:邮箱)
	 */
	public static enum REGEXMATCH{
		username("^((?![0-9]{20})[a-zA-Z0-9\\-\\_\u4e00-\u9fa5]{4,20})$"),
		password("^[\\x21-\\x7E]{6,20}$"),
		telephone("^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$"),
		email("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$"),
		number("^[0-9]*$");
		
		private final String value;
		REGEXMATCH(String value){
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	public void loadProperties(Properties properties) {
		if (properties == null) {
			return;
		}
		String loginUrl = properties.getProperty("loginUrl");
		if (loginUrl != null) {
			LOGIN_URL = loginUrl;
		}
		String templateStorePath = properties.getProperty("templateStorePath");
		if (templateStorePath != null) {
			TEMPLATE_STORE_PATH = templateStorePath;
		}
		String templateDisplayPath = properties
				.getProperty("templateDisplayPath");
		if (templateDisplayPath != null) {
			TEMPLATE_DISPLAY_PATH = templateDisplayPath;
		}
		String staticDisplayPath = properties.getProperty("staticDisplayPath");
		if (staticDisplayPath != null) {
			STATIC_DISPLAY_PATH = staticDisplayPath;
		}
		String openofficeHost = properties.getProperty("openofficeHost");
		if (openofficeHost != null) {
			OPENOFFICE_HOST = openofficeHost;
		}
		String openofficePort = properties.getProperty("openofficePort");
		if (StringUtils.isNotBlank(openofficePort)) {
			OPENOFFICE_PORT = Integer.valueOf(openofficePort);
		}
	
		String isRootAllPerms = properties.getProperty("isRootAllPerms");
		if ("true".equals(isRootAllPerms)) {
			IS_ROOT_ALL_PERMS = true;
		}

		String backSuccessUrl = properties.getProperty("backSuccessUrl");
		if (backSuccessUrl != null) {
			BACK_SUCCESS_URL = backSuccessUrl;
		}
		String backLoginUrl = properties.getProperty("backLoginUrl");
		if (backLoginUrl != null) {
			BACK_LOGIN_URL = backLoginUrl;
		}
		String defUsername = properties.getProperty("defUsername");
		if (defUsername != null) {
			DEF_USERNAME = defUsername;
		}
		String defPassword = properties.getProperty("defPassword");
		if (defPassword != null) {
			DEF_PASSWORD = defPassword;
		}
		String images_url=properties.getProperty("imagebase.path");
		if(images_url!=null){
			IMAGES_URL=images_url;
		}
		
		//是否开启memcache缓存
		Boolean memcacheSwitch=Boolean.parseBoolean(properties.getProperty("switchFlag"));
		if(memcacheSwitch!=null){
			MEMCACHE_SWITCH=memcacheSwitch;
		}
		
		//每页显示数据条数
		if (!StringUtils.isBlank(properties.getProperty("pageShow"))) {
			int pageShow = Integer.parseInt(properties.getProperty("pageShow"));
			if (pageShow > 0) {
				PAGE_SHOW=pageShow;
			}
		}
		if (!StringUtils.isBlank(properties.getProperty("imgPageShow"))) {
			int pageShow = Integer.parseInt(properties.getProperty("imgPageShow"));
			if (pageShow > 0) {
				PAGE_IMGSHOW=pageShow;
			}
		}

	}

	
}

