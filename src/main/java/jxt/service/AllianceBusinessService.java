

package jxt.service;

import java.util.List;

import jxt.mapper.AllianceBusinessMapper;
import jxt.pojo.AllianceBusinessPojo;
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
public class AllianceBusinessService {

	@Autowired
	private AllianceBusinessMapper allianceBusinessMapper;
	
	public void insert(AllianceBusinessPojo a){
		allianceBusinessMapper.insert(a);
	}
	
	public void delete(String id){
		allianceBusinessMapper.delete(id);
	}
	
	public void update(AllianceBusinessPojo a){
		allianceBusinessMapper.update(a);
	}
	

	
	public List<AllianceBusinessPojo>selectAllPage(Page<AllianceBusinessPojo> pageParam,String search){
		return allianceBusinessMapper.selectAllPage(pageParam,search);
	}
	
}
