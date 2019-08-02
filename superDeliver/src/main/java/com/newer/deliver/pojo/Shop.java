package com.newer.deliver.pojo;

import java.io.Serializable;

public class Shop implements Serializable {

	/**
	 * 商店实体类
	 */
	private static final long serialVersionUID = 1L;
	private Integer shop_id;
	private String shop_name;
	private Area area;
	private String address_detail;
	private String pictrue_url;
	private String business_hours;
	private String shop_description;
	private Double limit_price;
	private Classify classify;
	
	//点击量
	private String standby1;
	private String standby2;

	public Shop(Integer shop_id, String shop_name, Area area, String address_detail, String pictrue_url,
			String business_hours, String shop_description, Double limit_price, Classify classify, String standby1,
			String standby2) {
		super();
		this.shop_id = shop_id;
		this.shop_name = shop_name;
		this.area = area;
		this.address_detail = address_detail;
		this.pictrue_url = pictrue_url;
		this.business_hours = business_hours;
		this.shop_description = shop_description;
		this.limit_price = limit_price;
		this.classify = classify;
		this.standby1 = standby1;
		this.standby2 = standby2;
	}

	public Shop() {
		super();
	}

	@Override
	public String toString() {
		return "Shop [shop_id=" + shop_id + ", shop_name=" + shop_name + ", area=" + area + ", address_detail="
				+ address_detail + ", pictrue_url=" + pictrue_url + ", business_hours=" + business_hours
				+ ", shop_description=" + shop_description + ", limit_price=" + limit_price + ", classify=" + classify
				+ ", standby1=" + standby1 + ", standby2=" + standby2 + "]";
	}

	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public String getPictrue_url() {
		return pictrue_url;
	}

	public void setPictrue_url(String pictrue_url) {
		this.pictrue_url = pictrue_url;
	}

	public String getBusiness_hours() {
		return business_hours;
	}

	public void setBusiness_hours(String business_hours) {
		this.business_hours = business_hours;
	}

	public String getShop_description() {
		return shop_description;
	}

	public void setShop_description(String shop_description) {
		this.shop_description = shop_description;
	}

	public Double getLimit_price() {
		return limit_price;
	}

	public void setLimit_price(Double limit_price) {
		this.limit_price = limit_price;
	}

	public Classify getClassify() {
		return classify;
	}

	public void setClassify(Classify classify) {
		this.classify = classify;
	}

	public String getStandby1() {
		return standby1;
	}

	public void setStandby1(String standby1) {
		this.standby1 = standby1;
	}

	public String getStandby2() {
		return standby2;
	}

	public void setStandby2(String standby2) {
		this.standby2 = standby2;
	}

}
