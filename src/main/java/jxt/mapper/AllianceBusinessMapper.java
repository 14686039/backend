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

package jxt.mapper;

import java.util.List;

import jxt.orm.SQLMapper;
import jxt.pojo.AllianceBusinessPojo;
import jxt.util.page.Page;

import org.apache.ibatis.annotations.Param;

/**
 * @author tangshun
 * 2015年7月30日
 * Ver 1.0
 */
public interface AllianceBusinessMapper extends SQLMapper {

	public void insert(AllianceBusinessPojo a);
	public void update(AllianceBusinessPojo a);
	public void delete(String  id);
	public List<AllianceBusinessPojo>selectAllPage(@Param("page")Page<AllianceBusinessPojo> pageParam,@Param("search")String search);
	
}
