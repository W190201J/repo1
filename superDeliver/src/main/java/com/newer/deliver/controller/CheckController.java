package com.newer.deliver.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.deliver.utils.JwtTokenUtil;

import io.jsonwebtoken.Claims;

/**
 * 检验Token
 * 
 * @author bilibili
 *
 */
@RestController
public class CheckController {

	private static final Logger log = LoggerFactory.getLogger(CheckController.class);

	// 请求头的属性名
	@Value("${auth.header}")
	private String authHeader;

	@Resource(name = "token")
	private JwtTokenUtil jwtTokenUtil;

	/**
	 * 检验Token
	 * 
	 * @param req
	 * @return
	 */
	@GetMapping("/chk")
	public String chk(HttpServletRequest req) {
		// 通过请求头获得token
		String token = req.getHeader(authHeader);

		if (token != null) {
			// 进行token检验
			try {
				Claims c = jwtTokenUtil.parseJWT(token);
				return  c.getIssuer();
			} catch (Exception e) {
				e.printStackTrace();
				return "fail";
			}
		}
		return "fail";

	}
}
