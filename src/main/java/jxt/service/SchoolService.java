

package jxt.service;

import java.util.List;

import jxt.mapper.SchoolMapper;
import jxt.pojo.SchoolPojo;
import jxt.util.page.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tangshun
 * 2015年7月26日
 * Ver 1.0
 */
@Service
@Transactional
public class SchoolService {

	@Autowired
	private SchoolMapper schoolMapper;
	
	public void insert(SchoolPojo a){
		schoolMapper.insert(a);
	}
	
	public void delete(String id){
		schoolMapper.delete(id);
	}
	
	public void update(SchoolPojo a){
		schoolMapper.update(a);
	}
	

	
	public List<SchoolPojo>selectAllPage(Page<SchoolPojo> pageParam,String search){
		return schoolMapper.selectAllPage(pageParam,search);
	}
	
}
