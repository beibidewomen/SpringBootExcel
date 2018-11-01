package com.wyjt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyjt.dao.GetInfoDao;
import com.wyjt.entity.InfoResultMap;

@Service
public class GetInfoService {
	
	@Autowired
	public GetInfoDao getInfoDao;
	
	/**
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @return
	 */
	public List<InfoResultMap> getInfo(Map<String,String> map) {
		List<InfoResultMap> info = getInfoDao.getInfo(map);
		return info;
	}
}
