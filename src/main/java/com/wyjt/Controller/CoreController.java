package com.wyjt.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;
import com.wyjt.entity.InfoResultMap;
import com.wyjt.service.GetInfoService;

@Controller
public class CoreController{
	
	@Autowired
	private GetInfoService getInfoService;
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

}
