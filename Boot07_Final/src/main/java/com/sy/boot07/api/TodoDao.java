package com.sy.boot07.api;

import java.util.List;

import com.sy.boot07.api.TodoDto;

public interface TodoDao {	
	//추가
	public void insert(TodoDto dto);
	//리스트
	public List<TodoDto> getList();
	//삭제
	public void delete(int num);
}
