package com.tz.mybatis07;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tz.bean.Order;
import com.tz.dao.IOrderDAO;

/**
 * 这个类是讲述mybatis的DAO的两种传参方式
 * @author xnn
 * @date 2019-07-08
 */
public class AppTestDAO {
	
	public static void main(String[] args) throws IOException {
//		获取解析全局配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
//		通过SqlSessionFactory加载文件流,解析成我们所需要的连接信息
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
//		创建sessionFactor会话对象
		SqlSession session = sessionFactory.openSession();
		
//		testOrderDAO(session);
		
		testListDAO(session);

	}

	/**
	 * @param session
	 */
	private static void testListDAO(SqlSession session) {
		IOrderDAO orderDAO = session.getMapper(IOrderDAO.class);
		List<String> list = new ArrayList<String>();
		list.add("D2019033114252838877779340742959");
		list.add("D2019033114571210677779406178800");
		System.out.println(orderDAO.findOrderByOrderNumber(list));//Total: 2
		session.close();
//		Preparing: SELECT id,orderNumber,orderStatus,address FROM tb_order 
//			WHERE 1=1 AND orderNumber IN( ? , ? ) 
//		Parameters: D2019033114252838877779340742959(String), 
//			D2019033114571210677779406178800(String)
	}
	

	/**
	 * @param session
	 */
	private static void testOrderDAO(SqlSession session) {
		Order order = new Order();
		order.setOrderStatuss("已付款");
		order.setOrderNumbers("D2019033115032746777779541229334");
		
		IOrderDAO orderDAO = session.getMapper(IOrderDAO.class);
		
		List<Order> list = orderDAO.findOrderByCondition(order);
		System.out.println(list.toString());//Total: 1
		session.close();
		
//		Preparing: SELECT id,orderNumber,orderStatus,address FROM tb_order 
//			WHERE 1=1 AND orderStatus = ? AND orderNumber = ? 
	}
}


