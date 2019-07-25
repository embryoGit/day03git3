package com.tz.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductInfo implements Serializable{

	private static final long serialVersionUID = 7896073255743704607L;

	private int id;
	
	private String infoNumber;
	private String infoName;
	private BigDecimal infoCost;
	private BigDecimal infoPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfoNumber() {
		return infoNumber;
	}

	public void setInfoNumber(String infoNumber) {
		this.infoNumber = infoNumber;
	}

	public String getInfoName() {
		return infoName;
	}

	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}

	public BigDecimal getInfoCost() {
		return infoCost;
	}

	public void setInfoCost(BigDecimal infoCost) {
		this.infoCost = infoCost;
	}

	public BigDecimal getInfoPrice() {
		return infoPrice;
	}

	public void setInfoPrice(BigDecimal infoPrice) {
		this.infoPrice = infoPrice;
	}

	@Override
	public String toString() {
		return "ProductInfo [id=" + id + ", infoNumber=" + infoNumber + ", infoName=" + infoName + ", infoCost="
				+ infoCost + ", infoPrice=" + infoPrice + "]";
	}

	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
