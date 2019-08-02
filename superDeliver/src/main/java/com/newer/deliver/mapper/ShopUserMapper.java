package com.newer.deliver.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.newer.deliver.pojo.Shop;
/**
 * 商店数据操作
 * @author bilibili丶饭炒蛋
 *
 */
@Repository
public interface ShopUserMapper {
	//按店名模糊查询
	public List<Shop> queryByShopName(String shop_name);
	
	//店铺点击量
	public int addView(Shop shop);
	
	//按点击量查询
	public List<Shop> queryByView();
}
