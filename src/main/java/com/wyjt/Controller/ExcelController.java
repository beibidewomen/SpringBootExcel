package com.wyjt.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.wyjt.entity.InfoResultMap;
import com.wyjt.enums.DataEnum;
import com.wyjt.service.GetInfoService;


@RestController
public class ExcelController {
	
	@Autowired
	private GetInfoService getInfoService;
	
	
    @RequestMapping(value = "/excel", method = RequestMethod.GET)
    public void excel(HttpServletResponse response,String startTime,String endTime) throws Exception {
    	
    	System.out.println("startTime:"+startTime);
    	System.out.println("endTime:"+endTime);
    	
    	Map<String,String> dataMap = new HashMap<String,String>();
    	dataMap.put("startTime", startTime);//开始时间
    	dataMap.put("endTime", endTime);    //结束时间
    	
    	List<InfoResultMap> info = getInfoService.getInfo(dataMap);
    	
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList();
        for (DataEnum dataEnum : DataEnum.values()) {
        	titles.add(dataEnum.name());
		}
//        titles.add("a1");
//        titles.add("a2");
//        titles.add("a3");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList();
        
//        row.add("11111111111");
//        row.add("22222222222");
//        row.add("3333333333");
        for (Object inf : info) {
        	List<Object> row = new ArrayList();
        	InfoResultMap map = (InfoResultMap)inf;
        	row.add(map.getId());
        	row.add(map.getUsername());
        	row.add(map.getAge());
        	row.add(map.getPassword());
        	rows.add(row);
		}
        data.setRows(rows);
        //生成本地
        /*File f = new File("c:/test.xlsx");
        FileOutputStream out = new FileOutputStream(f);
        ExportExcelUtils.exportExcel(data, out);
        out.close();*/
        ExportExcelUtils.exportExcel(response,"hello.xlsx",data);
    }
    
    @RequestMapping(value="/data1.json",method=RequestMethod.GET)
    public String getJSonData(String startTime,String endTime) {
    	System.out.println("startTime:"+startTime);
    	System.out.println("endTime:"+endTime);
    	
    	Map<String,String> dataMap = new HashMap<String,String>();
    	dataMap.put("startTime", startTime);//开始时间
    	dataMap.put("endTime", endTime);    //结束时间
		List<InfoResultMap> info = getInfoService.getInfo(dataMap);
		
		JSONArray arr = new JSONArray();
		for (Object inf : info) {
			Map<String,Object> map = new HashMap<String,Object>();
        	InfoResultMap rsMap = (InfoResultMap)inf;
        	map.put("id",rsMap.getId());
        	map.put("username",rsMap.getUsername());
        	map.put("age",rsMap.getAge());
        	map.put("password",rsMap.getPassword());
        	arr.add(map);
		}
    	return JSON.toJSONString(arr);
    }
}
