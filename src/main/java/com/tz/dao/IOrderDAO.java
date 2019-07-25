package com.tz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tz.bean.Order;

/**
 * @author xnn
 * @date 2019-07-09
 */
public interface IOrderDAO {
	
	public List<Order> findOrderByCondition(Order order);
	
//	@Param("onsList") ：orderNumbersList的别名
	public List<Order> findOrderByOrderNumber(@Param("onsList")List<String> orderNumbersList);

}






