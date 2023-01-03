package com.sy.boot07.users.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sy.boot07.users.dto.UsersDto;
import com.sy.boot07.users.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService service;
		
	/*
	 * GET 방식 /users/signup_form 요청을 처리할 메소드
	 * - 요청방식이 다르면 실행되지 않는다.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/users/signup_form")
	public String signupform() {
		
		return "users/signup_form";
	}
	//회원가입 요청 처리
	@RequestMapping(method = RequestMethod.POST, value = "/users/signup")
	public ModelAndView signup(ModelAndView mView, UsersDto dto) {
		service.addUser(dto);
		mView.setViewName("users/signup");		
		return mView;
	}
	//로그인 폼 요청 처리
	@RequestMapping(method = RequestMethod.GET, value="/users/loginform")
	public String loginForm() {
		
		return "users/loginform";
	}	
	//로그인 요청 처리
	@RequestMapping("/users/login")
	public ModelAndView login(ModelAndView mView, UsersDto dto, String url, HttpSession session) {
		/*
		 * 서비스에서 비즈니스 로직을 처리할 때 필요로 하는 객체를 컨트롤러에서 직접 전달해주어야 한다.
		 * 주로, HttpServletRequest, HttpServletResponse, HttpSession, ModelAndView
		 * 등등의 객체이다.
		 */
		service.loginProcess(dto, session);
		
		//로그인 후에 가야할 목적지 정보를 
		String encodedUrl=URLEncoder.encode(url);
		mView.addObject("url", url);
		mView.addObject("encodedUrl", encodedUrl);
		mView.setViewName("users/login");
		return mView;
	}
	
	//로그아웃 요청 처리
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {		
		//세션에서 id라는 키값으로 저장된 값 삭제
		session.removeAttribute("id");
		return "users/logout";
	}
	//개인정보 보기 요청 처리
	@RequestMapping("/users/info")
	public ModelAndView info(HttpSession session, ModelAndView mView) {
		
		service.getInfo(session, mView);
		
		mView.setViewName("users/info");
		return mView;		
	}	
	//비밀번호 수정 폼 요청 처리
	@RequestMapping("/users/pwd_updateform")
	public String pwdUpdateForm() {
		
		return "users/pwd_updateform";
	}
	//비밀번호 수정 폼 요청 처리
	@RequestMapping("users/pwd_update")
	public ModelAndView pwdUpdate(UsersDto dto, ModelAndView mView, HttpSession session) {
		//서비스에 필요한 객체의 참조값을 전달해서 비밀번호 수정 로직을 처리한다.
		service.updateUserPwd(session, dto, mView);
		//view page로 forward 이동해서 작업결과를 응답한다.
		mView.setViewName("users/pwd_update");
		return mView;
	}	
	//회원 탈퇴 요청 처리
	@RequestMapping("/users/delete")
	public ModelAndView delete(HttpSession session, ModelAndView mView) {
		
		service.deleteUser(session, mView);
		
		mView.setViewName("users/delete");
		return mView;
	}
	
	//회원정보 수정 폼 요청 처리
	@RequestMapping("/users/updateform")
	public ModelAndView updateForm(HttpSession session, ModelAndView mView) {
		service.getInfo(session, mView);		
		mView.setViewName("users/updateform");
		return mView;
	}
	
	//회원정보 수정 반영 요청 처리
	@RequestMapping(value="/users/update", method = RequestMethod.POST)
	public ModelAndView update(UsersDto dto, HttpSession session, ModelAndView mView,
			HttpServletRequest request) {
		//서비스를 이용해서 개인정보를 수정하고
		service.updateUser(dto, session);
		//개인정보 보기로 리다이렉트 이동시킨다.
		mView.setViewName("redirect:/users/info");		
		return mView;
	}
	
	//ajax 프로필 사진 업로드 요청 처리	
	@RequestMapping(value = "/users/profile_upload", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> profileUpload(HttpServletRequest request, MultipartFile image){
		//서비스를 이용해서 이미지를 upload 폴더에 저장하고 리턴되는 Map을 리턴해서 json 문자열 응답하기
		return service.saveProfileImage(request, image);		
	}
}
