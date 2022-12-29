package com.sy.spring01.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.spring01.member.dto.MemberDto;

//component scan 을 통해서 bean이 될 수 있도록 어노테이션을 붙인다.
@Controller
public class MemberController {
	
	@RequestMapping("/member/insertform")
	public String insertform() {
		
		// WEB-INF/view/member/insertform.jsp로 forward이동해서 응답
		return "member/insertform";
		
	}
	
	@ResponseBody //리턴하는 문자열을 클라이언트에게 직접 출력하기
	@RequestMapping("/member/insert")
	public String insert(HttpServletRequest request) {
		/*
		 * [ 요청 파라미터 추출하는 방법1 ] 
		 * 
		 * HttpServletReqest 객체를 Controller메소드로 전달받아서 추출
		 */
		int num=Integer.parseInt(request.getParameter("num"));
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		System.out.println(num+" | "+name+" | "+addr);
		
		return "ok1";		
	}
	@ResponseBody
	@RequestMapping("/member/insert2")
	public String insert2(int num, String name, String addr) {
		/*
		 * [ 요청 파라미터 추출하는 방법2 ]
		 * 
		 *  파라미터명과 동일하게 메소드의 매개변수를 선언해 놓으면 자동으로 추출해서 넣어준다.
		 *  <input name="num"> 이면 int num or String num
		 *  <input name="email"> 이면 String email 이런식으로 선언하면 된다.
		 *  
		 *  insert2(@RequestParam int num,@RequestParam String name,@RequestParam String addr)
		 *  에서 @RequestParam 어노테이션이 생략된 형태이다.
		 */
		System.out.println(num+" | "+name+" | "+addr);
		
		return "ok2";		
	}
	@ResponseBody
	@RequestMapping("/member/insert3")
	public String insert3(MemberDto dto) {
		/*
		 * [ 요청 파라미터 추출하는 방법3 ]
		 * 
		 * 파라미터명과 동일한 필드명을 가지고 있는 dto 클래스 type을 메소드의 매개변수로 선언해 놓으면
		 * 자동으로 추출해서 dto에 추출한 값을 setter메소드를 이용해서 넣은 다음 해당 dto 객체의
		 * 참조값에 전달한다.
		 * 
		 * pubilc class MemberDto{
		 * 	 private int num; => <input name="num">
		 * 	 private String name; => <input name="name">
		 *   private String addr; => <input name="addr">
		 *   
		 *   insert(@ModelAttribute MemberDto dto)에서 @ModelAtrribute가 생략된 형태이다.
		 */
		System.out.println(dto.getNum()+" | "+dto.getName()+" | "+dto.getAddr());
		return "ok3";
	}
}
