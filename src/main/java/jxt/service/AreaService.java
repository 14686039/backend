

package jxt.service;

import java.awt.geom.Area;
import java.util.List;

import jxt.mapper.AreaMapper;

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
	
	public void insert(Area a){
		areaMapper.insert(a);
	}
	
	public void delete(String areaId){
		areaMapper.delete(areaId);
	}
	
	public void update(Area a){
		areaMapper.update(a);
	}
	
	public List<Area> selectAll(){
		return areaMapper.selectAll();
	}
	
}
