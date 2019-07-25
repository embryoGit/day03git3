package com.tz.dao;

import java.util.List;

import com.tz.bean.OrderDetail;

public interface IOrderDetailDAO {

	public List<OrderDetail> findOrdetailProductInfo();
	
	public List<OrderDetail> findOrderDetailInfo();//
}
