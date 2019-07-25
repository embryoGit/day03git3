package com.tz.bean;

import java.io.Serializable;

public class OrderDetail implements Serializable{
	
	private static final long serialVersionUID = -2610686279650319664L;

	private int id;
	
	private String detailStatus;
	private String productId;
	private ProductInfo productInfo;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetailStatus() {
		return detailStatus;
	}

	public void setDetailStatus(String detailStatus) {
		this.detailStatus = detailStatus;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", detailStatus=" + detailStatus + ", productId=" + productId
				+ ", productInfo=" + productInfo + "]";
	}

	public OrderDetail(String detailStatus) {
		super();
		this.detailStatus = detailStatus;
	}

	public OrderDetail() {
		super();
	}

	public OrderDetail(int id, String detailStatus, String productId, ProductInfo productInfo) {
		super();
		this.id = id;
		this.detailStatus = detailStatus;
		this.productId = productId;
		this.productInfo = productInfo;
	}
	
	
}
