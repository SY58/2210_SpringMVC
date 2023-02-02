package com.sy.boot07.api;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.boot07.api.TodoDao;

@Controller
public class AndroidController {
	
	@Autowired
	private TodoDao dao;
	
	/*
	 * JSON 문자열 
	 * 1. @ResponseBody 어노테이션
     * 2. Map 혹은 List 혹은 Dto 를 리턴하면 자동으로 JSON 문자열로 변환 되어서 응답된다.
	 */
	@RequestMapping("/api/send")
	@ResponseBody
	public Map<String, Object> send(String msg){
		
		System.out.println(msg);
		Map<String, Object> map=new HashMap<>();
		map.put("isSuccess", true);
		map.put("response", "hello client!");
		map.put("num", 1);
		
		return map;
	}
	
	@RequestMapping("/api/list")
	@ResponseBody
	public List<String> list(int pageNum){
		List<String> names=new ArrayList<>();
		names.add("바나나");
		names.add("딸기");
		names.add("복숭아");
		return names;
	}
		
}
