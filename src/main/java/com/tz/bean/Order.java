/**
 * 
 */
package com.tz.bean;

import java.io.Serializable;

/**
 * @author xnn
 * @date 2019-07-08
 */
//映射要序列号
public class Order implements Serializable{

	private static final long serialVersionUID = 3670789696125361786L;
	
	private int id;
	
	private String orderNumbers;
	private String orderStatuss;
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNumbers() {
		return orderNumbers;
	}
	public void setOrderNumbers(String orderNumbers) {
		this.orderNumbers = orderNumbers;
	}
	public String getOrderStatuss() {
		return orderStatuss;
	}
	public void setOrderStatuss(String orderStatuss) {
		this.orderStatuss = orderStatuss;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Order2 [id=" + id + ", orderNumbers=" + orderNumbers + ", orderStatuss=" + orderStatuss + ", address="
				+ address + "]";
	}
	/**
	 * @param orderNumbers
	 * @param orderStatuss
	 * @param address
	 */
	public Order(String orderNumbers, String orderStatuss, String address) {
		super();
		this.orderNumbers = orderNumbers;
		this.orderStatuss = orderStatuss;
		this.address = address;
	}
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}




