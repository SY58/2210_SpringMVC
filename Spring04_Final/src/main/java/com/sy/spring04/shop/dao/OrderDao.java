package com.sy.spring04.shop.dao;

import com.sy.spring04.shop.dto.OrderDto;

public interface OrderDao {
	//배송정보를 추가하는 메소드
	public void addOrder(OrderDto dto);
}
