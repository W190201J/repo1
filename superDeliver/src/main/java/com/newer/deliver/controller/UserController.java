package com.newer.deliver.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.newer.deliver.pojo.User;
import com.newer.deliver.service.UserService;
import com.newer.deliver.utils.JwtTokenUtil;
import com.newer.deliver.utils.MD5;
import com.newer.deliver.utils.VerifyCodeSimple;

@RestController
public class UserController {
	
	@Resource(name = "user")
	private UserService us;
	
	private static String verifyCode = "";
	
	@Resource(name = "token")
	private JwtTokenUtil jwtTokenUtil;
	
	@GetMapping("/img")
	public void img(OutputStream out) {
		// 生成随机字串
		verifyCode = VerifyCodeSimple.generateVerifyCode(4);
		VerifyCodeSimple.outputImage(150, 50, out, verifyCode);

	}
	

	
	
	@PostMapping("/login")
	public  ResponseEntity<?> login (User user, HttpServletRequest request) {
		String i = "0";
		String token = "";

		//查找数据库中的记录
		User _user = us.login(user.getPhone());
		
		//加密		
		String passWord = MD5.getInstance().getMD5ofStr(user.getPassword());
		
		if (user != null && passWord.equals(_user.getPassword()) 
				) {
			request.getSession().setAttribute("session_user", _user);
			i = "1";
			
			token = jwtTokenUtil.createJwt(user.getPhone());

		}
		System.out.println(token);
		List<String> list = new ArrayList<String>();
		list.add(i);
		list.add(token);
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(User user){
		int i = 0;
		if(us.login(user.getPhone())==null&& user.getVerify().toLowerCase().equals(verifyCode.toLowerCase())) {
			
			String password = MD5.getInstance().getMD5ofStr(user.getPassword());
			System.out.println("ooo"+password);
			user.setPassword(password);		
			i = us.register(user);
			verifyCode = "";
		}
		
		return new ResponseEntity<Integer>(i,HttpStatus.OK);
	}
	
}