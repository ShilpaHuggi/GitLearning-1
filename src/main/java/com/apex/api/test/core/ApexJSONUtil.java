package com.apex.api.test.core;

import com.apex.customer.bean.Customer;
import com.apex.customer.bean.CustomerList;
import com.apex.customer.bean.CustomerPost;
import com.google.gson.Gson;

public class ApexJSONUtil {
	public static String converObjectToJson(Customer customer) {
		Gson gson=new Gson();
		//JAVA obj to JSON obj
		String jsnString=gson.toJson(customer);
		System.out.println(jsnString);
		return jsnString;
	} 
	public static String converObjectToJson(CustomerPost customerPost) {
		Gson gson=new Gson();
		//JAVA obj to JSON obj
		String jsnString=gson.toJson(customerPost);
		System.out.println("Json string "+jsnString);
		return jsnString;
	} 
	public static CustomerList convertJsonToObjectList(String jsonMessage) {
		Gson gson=new Gson();
		//
		CustomerList customer=gson.fromJson(jsonMessage, CustomerList.class);
		System.out.println(customer.toString());
		return customer;
	}
	public static Customer convertJsonToObject(String jsonMessage) {
		Gson gson=new Gson();
		//
		Customer customer=gson.fromJson(jsonMessage, Customer.class);
		System.out.println(customer.toString());
		return customer;
	}
	public static CustomerPost convertJsonToObjectPst(String jsonMessage) {
		Gson gson=new Gson();
		//
		CustomerPost customerPst=gson.fromJson(jsonMessage, CustomerPost.class);
		System.out.println(customerPst.toString());
		return customerPst;
	}

}
