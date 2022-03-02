package com.apex.customer.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public  class CustomerList {
	
	
	//
	HashMap<String,String> support=new HashMap<String,String>();
 List<HashMap<String,String>> data=new ArrayList<HashMap<String,String>>();
public HashMap<String, String> getSupport() {
	return support;
}
public void setSupport(HashMap<String, String> support) {
	this.support = support;
}
public List<HashMap<String, String>> getData() {
	return data;
}
public void setData(List<HashMap<String, String>> data) {
	this.data = data;
}
@Override
public String toString() {
	return "CustomerList [support=" + support + ", data=" + data + "]";
}
 
	
	

}
