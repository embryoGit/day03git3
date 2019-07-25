package com.tz.mybatis07;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tz.bean.Order;
import com.tz.bean.OrderDetail;
import com.tz.dao.IOrderDAO;
import com.tz.dao.IOrderDetailDAO;

/**这个类是用来测试缓存的
 *一个SqlSession(又叫一级缓存)对应一个缓存，
 *	在commit或close后放入SqlSessionFactory(又叫二级缓存)中
 */
public class AppTestCache {

	public static void main(String[] args) throws IOException {
		//获取解析全局配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		//通过sqlSessionFactory加载文件流，解析成我们所需要的连接信息
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		//创建Sql Session会话对象
		SqlSession session = sessionFactory.openSession();
		
		IOrderDAO orderDAO =session.getMapper(IOrderDAO.class);

		
		/*
		 * 相同的session只查询一次，然后从缓存中取；不同的session查询多次
		 * 二级缓存的false的时候，三条session语句查询三次;为true时只查询一次，然后从缓存中取。
		 */
		
//		缓存
		IOrderDetailDAO detailDAO = session.getMapper(IOrderDetailDAO.class);
		List<OrderDetail> lstDetail = detailDAO.findOrderDetailInfo();//Total: 82
		System.out.println("111111111111111111111");
//		//从缓存中取 :
		detailDAO.findOrderDetailInfo();//Cache Hit Ratio [com.tz.dao.IOrderDetailDAO]: 0.0
		detailDAO.findOrderDetailInfo();//Cache Hit Ratio [com.tz.dao.IOrderDetailDAO]: 0.0
		detailDAO.findOrderDetailInfo();//Cache Hit Ratio [com.tz.dao.IOrderDetailDAO]: 0.0
//		测试延迟加载
//		for (OrderDetail od : lstDetail) {//先执行主表的82条数据，以后每执行一次查询一次
//			System.out.println("222222222222222222222222");
//			od.toString();
//		}
		System.out.println("333333333333333333333");
		session.close();
		
		System.out.println("缓存1-------------------------------------------------------------------");

		//		缓存
		SqlSession session2 = sessionFactory.openSession();
		IOrderDetailDAO detailDAO2 = session2.getMapper(IOrderDetailDAO.class);
		List<OrderDetail> lstDetail2 = detailDAO2.findOrderDetailInfo();
		session2.close();
		
		System.out.println("缓存2-------------------------------------------------------------------");

		//		缓存
		SqlSession session3 = sessionFactory.openSession();
		IOrderDetailDAO detailDAO3 = session3.getMapper(IOrderDetailDAO.class);
		List<OrderDetail> lstDetail3 = detailDAO3.findOrderDetailInfo();
		session3.close();
	}
	
	/*Cache Hit Ratio缓存命中率,数据越高性能越好
	 * 终端用户访问加速节点时，如果该节点有缓存住了要被访问的数据时就叫做命中，
	 * 如果没有的话需要回原服务器取，就是没有命中
	 */
}
/*

[DEBUG] [2019-07-11 21:49:35] org.apache.ibatis.transaction.jdbc.JdbcTransaction.resetAutoCommit(122) | Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@63753b6d]
[DEBUG] [2019-07-11 21:49:35] org.apache.ibatis.transaction.jdbc.JdbcTransaction.close(90) | Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@63753b6d]
[DEBUG] [2019-07-11 21:49:35] org.apache.ibatis.datasource.pooled.PooledDataSource.pushConnection(344) | Returned connection 1668627309 to pool.
缓存1-------------------------------------------------------------------
[DEBUG] [2019-07-11 21:49:35] org.apache.ibatis.cache.decorators.LoggingCache.getObject(62) | Cache Hit Ratio [com.tz.dao.IOrderDetailDAO]: 0.011494252873563218
缓存2-------------------------------------------------------------------
[DEBUG] [2019-07-11 21:49:35] org.apache.ibatis.cache.decorators.LoggingCache.getObject(62) | Cache Hit Ratio [com.tz.dao.IOrderDetailDAO]: 0.022727272727272728
 
 */
 
 
