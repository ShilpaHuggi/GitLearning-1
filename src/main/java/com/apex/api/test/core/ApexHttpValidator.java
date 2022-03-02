package com.apex.api.test.core;

import org.apache.http.HttpResponse;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apex.customer.bean.Customer;
import com.apex.customer.bean.CustomerList;
import com.apex.customer.bean.CustomerPost;




public class ApexHttpValidator {
	public static void validateStatusCodeReasonPhrase(HttpResponse response,int code,String resnPhrase) {
		Assert.assertEquals(response.getStatusLine().getStatusCode(),code ,"status code not matched");
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(),resnPhrase ,"Status message not matched");
	}
	//Blw code for single usr
	public static void validtorTagValSinglUsr(Customer custmr,String tag,String val) {
		Assert.assertTrue(custmr.getData().containsKey(tag));
		Assert.assertTrue(custmr.getData().containsValue(val));
	}
	
	//This code is for array of users
	public  static void validatorJsonKyValUsrsArray(String value, CustomerList  custmrLst,String key) {
			
			for(int i=0;i< custmrLst.getData().size();i++) {
				if( custmrLst.getData().get(i).get(key).equals(value)) {
					Assert.assertTrue( custmrLst.getData().get(i).get(key).equals(value));
				    break;
		    	
				}
			}
		}

}
