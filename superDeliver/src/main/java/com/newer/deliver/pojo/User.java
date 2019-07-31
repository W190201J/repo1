package com.newer.deliver.pojo;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * user实体类
	 */
	private static final long serialVersionUID = 1L;
	private Integer u_id;
	private String phone;
	private String password;
	private String role;
	private String verify;
	
	public String getVerify() {
		return verify;
	}
	public void setVerify(String verify) {
		this.verify = verify;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
