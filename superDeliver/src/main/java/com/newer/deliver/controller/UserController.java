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
import org.springframework.web.bind.annotation.PutMapping;
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

	// 退出
	@PostMapping("/out")
	public ResponseEntity<?> out(User user, HttpServletRequest request) {
		request.getSession().removeAttribute("session_user");
		return new ResponseEntity<String>("退出成功", HttpStatus.OK);
	}

	// 登录
	@PostMapping("/login")
	public ResponseEntity<?> login(User user, HttpServletRequest request) {
		String i = "0";
		String token = "";

		// 查找数据库中的记录
		User _user = us.login(user.getPhone());

		// 加密
		String passWord = MD5.getInstance().getMD5ofStr(user.getPassword());

		if (user != null && passWord.equals(_user.getPassword())) {
			request.getSession().setAttribute("session_user", _user);
			i = "1";

			token = jwtTokenUtil.createJwt(user.getPhone(), _user.getRole());

		}
		System.out.println(token);
		List<String> list = new ArrayList<String>();
		list.add(i);
		list.add(token);
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);

	}

	// 注册
	@PostMapping("/register")
	public ResponseEntity<?> register(User user) {
		int i = 0;
		if (us.login(user.getPhone()) == null && user.getVerify().toLowerCase().equals(verifyCode.toLowerCase())) {
			String password = MD5.getInstance().getMD5ofStr(user.getPassword());

			user.setPassword(password);
			i = us.register(user);
			verifyCode = "";
		}
		return new ResponseEntity<Integer>(i, HttpStatus.OK);
	}

	// 修改密码或者忘记密码
	@PutMapping("/changPass")
	public ResponseEntity<?> changPassword(User user) {
		int i = 0;

		String password = MD5.getInstance().getMD5ofStr(user.getPassword());
		user.setPassword(password);
		i = us.changPass(user);
		return new ResponseEntity<Integer>(i, HttpStatus.OK);

	}

	// 检测用户是否存在
	@PostMapping("/checkPhone")
	public ResponseEntity<?> checkExeist(User user) {
		int i = 0;
		
		//验证码错误
		if(!user.getVerify().toLowerCase().equals(verifyCode.toLowerCase())) {
			i = 2;
		}
		if (us.login(user.getPhone()) != null && user.getVerify().toLowerCase().equals(verifyCode.toLowerCase())) {

			User user_ = us.checkPhone(user);
			if (user_ != null) {
				i = 1;
			}
			verifyCode = "";
		}
		return new ResponseEntity<Integer>(i, HttpStatus.OK);
	}

}
