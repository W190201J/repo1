package com.newer.deliver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.deliver.mapper.ShopUserMapper;
import com.newer.deliver.pojo.Shop;
import com.newer.deliver.service.ShopUserService;

@Service("shopUser")
public class ShopUserServiceImpl implements ShopUserService {
	
	@Autowired
	private ShopUserMapper sumper;

	@Override
	public List<Shop> queryByShopName(String shop_name) {
		String _shop_name = "%" + shop_name +"%";
		return sumper.queryByShopName(shop_name);
	}

	@Override
	public int addView(Shop shop) {
		int view = Integer.parseInt(shop.getStandby1());
		view = view +1;
		shop.setStandby1(view+"");	
		return sumper.addView(shop);
	}

	@Override
	public List<Shop> queryByView() {
		return sumper.queryByView();
	}

}
