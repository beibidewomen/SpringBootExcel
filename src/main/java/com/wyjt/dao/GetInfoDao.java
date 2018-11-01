package com.wyjt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wyjt.entity.InfoResultMap;

@Repository
public interface GetInfoDao {
	
	/**
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @return
	 */
	List<InfoResultMap> getInfo(Map<String,String> map);//获取信息
}
