package com.sy.spring02.todo.service;

import org.springframework.web.servlet.ModelAndView;

import com.sy.spring02.todo.dto.TodoDto;

public interface TodoService {
	//회원정보를 추가해주는 메소드
	public void addTodo(TodoDto dto);
	//회원정보를 수정해주는 메소드
	public void updateTodo(TodoDto dto);
	//회원정보를 삭제해주는 메소드
	public void deleteTodo(int num);
	//회원 한명의 정보를 인자로 전달한 ModelAndView 객체에 담아주는 메소드
	public void getTodo(int num, ModelAndView mView);
	//회원 전체의 정보를 인자로 전달한 ModelAndView 객체에 담아주는 메소드
	public void getListTodo(ModelAndView mView);
}
