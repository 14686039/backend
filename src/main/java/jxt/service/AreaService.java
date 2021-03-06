

package jxt.service;

import java.util.List;

import jxt.mapper.AreaMapper;
import jxt.pojo.AreaPojo;
import jxt.pojo.BasePojo;
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
public class AreaService {

	@Autowired
	private AreaMapper areaMapper;
	
	public void insert(AreaPojo a){
		areaMapper.insert(a);
	}
	
	public void delete(String areaId){
		areaMapper.delete(areaId);
	}
	
	public void update(AreaPojo a){
		areaMapper.update(a);
	}
	
	public List<AreaPojo> selectAll(){
		return areaMapper.selectAll();
	}
	
	public List<AreaPojo>selectAllPage(Page<AreaPojo> pageParam,String search){
		return areaMapper.selectAllPage(pageParam,search);
	}
	
}
