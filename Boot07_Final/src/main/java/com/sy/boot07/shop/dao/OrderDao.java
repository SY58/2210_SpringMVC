package com.sy.boot07.shop.dao;

import com.sy.boot07.shop.dto.OrderDto;

public interface OrderDao {
	//배송정보를 추가하는 메소드
	public void addOrder(OrderDto dto);
}
