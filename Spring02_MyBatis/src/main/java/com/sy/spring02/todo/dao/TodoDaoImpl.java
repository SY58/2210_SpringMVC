package com.sy.spring02.todo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.spring02.todo.dto.TodoDto;

@Repository
public class TodoDaoImpl implements TodoDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(TodoDto dto) {
		session.insert("todo.insert", dto);		
	}

	@Override
	public void update(TodoDto dto) {
		session.update("todo.update", dto);		
	}

	@Override
	public void delete(int num) {
		session.delete("todo.delete", num);		
	}

	@Override
	public TodoDto getData(int num) {
	  /*
       * mapper's namespace => todo
       * sql's id => getData
       * parameterType => int
       * 
       * - selectOne() 메소드를 호출하면 mapper xml의 resultType이 바로 메소드의 return type이 된다.
       * resultType => TodoDto
       * return Type => TodoDto
       */
		TodoDto dto=session.selectOne("todo.getData", num);
		return dto;
	}

	@Override
	public List<TodoDto> getList() {
		List<TodoDto> list=session.selectList("todo.getlist");
		return list;
	}

}
