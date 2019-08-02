package com.newer.deliver.pojo;

import java.io.Serializable;

public class Classify implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer classify_id;
	private String classify_name;

	public Classify(Integer classify_id, String classify_name) {
		super();
		this.classify_id = classify_id;
		this.classify_name = classify_name;
	}

	public Classify() {
		super();
	}

	@Override
	public String toString() {
		return "Classify [classify_id=" + classify_id + ", classify_name=" + classify_name + "]";
	}

	public Integer getClassify_id() {
		return classify_id;
	}

	public void setClassify_id(Integer classify_id) {
		this.classify_id = classify_id;
	}

	public String getClassify_name() {
		return classify_name;
	}

	public void setClassify_name(String classify_name) {
		this.classify_name = classify_name;
	}

}
