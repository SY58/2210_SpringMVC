package com.sy.boot07;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//ExceptionController에서 처리되지 않은 예외가 발생하면 여기로 실행 순서가 온다.
@Controller
public class ErrorHandler{
	//application.properties에 server.error.path=/error 설정때문에 호출되는 컨트롤러 메소드
	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		//에러의 코드값을 읽어온다. 404,500,403 등
		int code=(int)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);		
		if( code == HttpStatus.NOT_FOUND.value()) { //404
			return "error/404";
		}else if( code == HttpStatus.INTERNAL_SERVER_ERROR.value()){ //500
			return "error/500";
		}else {
			return "error/info";
		}		
	}
}
