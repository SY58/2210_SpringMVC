package com.sy.boot07.api;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.sy.boot07.gallery.dao.GalleryDao;
import com.sy.boot07.gallery.dto.GalleryDto;

@Controller
public class AndroidController {
	
	
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
	
	//로그인 여부를 json으로 응답하는 메소드
	   @RequestMapping("/api/logincheck")
	   @ResponseBody
	   public Map<String, Object> logincheck(HttpSession session){
		  //테스트로 session의 아이디를 출력해보기
	      System.out.println("세션 아이디:"+session.getId());
	      Map<String, Object> map=new HashMap<>();
	      //세션 영역에 id라는 키값으로 저장된 값이 있는지 읽어와 본다.
	      String id=(String)session.getAttribute("id");
	      //만일 로그인을 하지 않았다면
	      if(id == null) {
	         map.put("isLogin", false);
	         System.out.println("로그인중이 아님요");
	      }else {
	         map.put("isLogin", true);
	         map.put("id", id);
	         System.out.println(id+" 로그인중...");
	      }
	      return map;
	   }
	   @RequestMapping("/api/login")
	   @ResponseBody
	   public Map<String, Object> login(String id, String pwd, HttpSession session){
	      //session.setMaxInactiveInterval(60*60*24); //로그인 유지시간
	      System.out.println(id+"|"+pwd);
	      Map<String, Object> map=new HashMap<>();
	      if(id.equals("gura") && pwd.equals("1234")) {
	         map.put("isSuccess", true);
	         map.put("id", id);
	         session.setAttribute("id", id);
	      }else {
	         map.put("isSuccess", false);
	      }
	      return map;
	   }
	   @RequestMapping("/api/logout")
	   @ResponseBody
	   public Map<String, Object> logout(HttpSession session){
	      session.invalidate();
	      Map<String, Object> map=new HashMap<>();
	      map.put("isSuccess", true);
	      return map;
	   }
	   
	   @Autowired GalleryDao dao;
	   
	   @RequestMapping("/api/gallery/list")
	   @ResponseBody
	   public List<GalleryDto> galleryList(){
		   //최신 갤러리 데이터 10개만 가져오기
		   GalleryDto dto=new GalleryDto();
		   dto.setStartRowNum(1);
		   dto.setEndRowNum(10);
		   
		   return dao.getList(dto);
	   }
}