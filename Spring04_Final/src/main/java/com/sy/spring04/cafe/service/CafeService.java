package com.sy.spring04.cafe.service;

import javax.servlet.http.HttpServletRequest;

import com.sy.spring04.cafe.dto.CafeDto;

public interface CafeService {
	public void getList(HttpServletRequest request); //목록불러오기
	public void getDetail(HttpServletRequest request);
	public void saveContent(CafeDto dto); //글 저장
	public void updateContent(CafeDto dto);
	public void deleteContent(int num, HttpServletRequest request);
	public void getData(HttpServletRequest request); //글 수정하기 위해 정보 불러오는 기능
	
}
