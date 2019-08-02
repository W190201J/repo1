package com.newer.deliver.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.deliver.pojo.Shop;
import com.newer.deliver.service.ShopUserService;

@RestController
public class ShopUserController {

	@Resource(name = "shopUser")
	private ShopUserService sus;
	
	
	
	@GetMapping("/shopListTop")
	public ResponseEntity<?> queryByView(){	
		List<Shop> shops = sus.queryByView();		
		return new ResponseEntity<List<Shop>>(shops, HttpStatus.OK);
	}
	
	@GetMapping("/shopByName")
	public ResponseEntity<?> queryByName(String shop_name){	
		List<Shop> shops = sus.queryByShopName(shop_name);		
		return new ResponseEntity<List<Shop>>(shops, HttpStatus.OK);
	}
	
	@PutMapping("/view")
	public ResponseEntity<?> addView(Shop shop){
		int i = 0;
		i = sus.addView(shop);
		return new ResponseEntity<Integer>(i, HttpStatus.OK);
	}
	
}
