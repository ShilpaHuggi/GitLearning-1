package com.apex.customer.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public  class Customer {
	
	
	//
	HashMap<String,String> data=new HashMap<String,String>();

	//Single user
	HashMap<String,String> support=new HashMap<>();
	
	public HashMap<String, String> getData() {
		return data;
	}

	public void setData(HashMap<String, String> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Customer [data=" + data + ", support=" + support + "]";
	}

	public HashMap<String, String> getSupport() {
		return support;
	}
	public void setSupport(HashMap<String, String> support) {
		this.support = support;
	}
	
	

}
