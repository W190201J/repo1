package com.newer.deliver.service;

import java.util.List;

import com.newer.deliver.pojo.Shop;

/**
 * 商家业务逻辑处理接口一
 * @author bilibili丶饭炒蛋
 *
 */
public interface ShopUserService {
	//按店名模糊查询
	public List<Shop> queryByShopName(String shop_name);
	
	//店铺点击量
	public int addView(Shop shop);
	
	//按点击量查询
	public List<Shop> queryByView();

}
