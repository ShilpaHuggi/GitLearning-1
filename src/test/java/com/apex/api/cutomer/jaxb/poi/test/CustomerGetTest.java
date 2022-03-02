package com.apex.api.cutomer.jaxb.poi.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apex.api.test.core.ApexBaseAPITest;
import com.apex.api.test.core.ApexHttpUtil;
import com.apex.api.test.core.ApexHttpValidator;
import com.apex.api.test.core.ApexJSONUtil;
import com.apex.customer.bean.Customer;




public class CustomerGetTest extends ApexBaseAPITest implements CustomerConstant {

		
		

		//1.Create Http get request
		//2.Send request
		//3.Validate the body 
		
		//Response code --200
		//Response phrase--OK
	
	@DataProvider(name = "dp1")
		public Object[][] getDataForSuccess() throws Exception{
			//For few values we can use this to pass test data, but for multiple values we need to read test data from xls file
			//for that we need library jxl that enables java cde to read excel file
			//  String[][] data= { {"1","john"},{"2","jack"} };
			//Object[][] data=	getTableArray("user_ids.xls","Sheet1","UserSuccessIds");
			Object[][] data=	ApexHttpUtil.getTableArray("BookGtData.xlsx","Sheet1");
			return data;
		}
	@Test(dataProvider ="dp1")

	public void testGetUserWithSuccessData(String id,String name,String email) throws ClientProtocolException, IOException {
		HttpResponse response = (HttpResponse) ApexHttpUtil.sendAndReceiveGetMsg(BASE_USER_API_URL + "/"+id);
	
		int statusCode=response.getStatusLine().getStatusCode();
		System.out.println("Id= "+id+"--StatusCode :"+statusCode);
		String msg=response.getStatusLine().getReasonPhrase();
		System.out.println("ReasonPhrase :"+msg);
		String respString = ApexHttpUtil.getStringResponseMessage(response);
		System.out.println("Response json string:  "+respString);
		
		ApexHttpValidator.validateStatusCodeReasonPhrase(response,HTTP_STATUS_CODE_200,HTTP_STATUS_MESSAGE_OK);
        
		//check for the name
		Customer custmr=ApexJSONUtil.convertJsonToObject(respString);
		
		ApexHttpValidator.validtorTagValSinglUsr(custmr,"first_name",name);
		ApexHttpValidator.validtorTagValSinglUsr(custmr,"id",id);
		ApexHttpValidator.validtorTagValSinglUsr(custmr,"email",email);		
	}
	


 
	@Test
	public void testGetUserWithNonNumber() throws ClientProtocolException, IOException {
		HttpResponse response = ApexHttpUtil.sendAndReceiveGetMsg("https://gorest.co.in/public/v1/users/aaa");
		int statusCode=response.getStatusLine().getStatusCode();
		System.out.println("StatusCode for NonNumber:"+statusCode);
		String msg=response.getStatusLine().getReasonPhrase();
		System.out.println("ReasonPhrase for NonNumber:"+msg);
		ApexHttpValidator.validateStatusCodeReasonPhrase(response,HTTP_STATUS_CODE_404, HTTP_STATUS_MSG_NOT_FOUND);

	}


	@Test
	public void testGetUserWithBlank() {
	}
	@Test
	//Security testing
	//Validate exposed API endpoint 
	public void testGetForExposedEndpoint() {}
	//Validate the api for crosssite scripting
	public void testGetForXSSVulnerable() {}
	//Validate api for rate limiting by sending repeated request with unauthenticated,
	//deactivated,bogus,or authenticate  credentials or as a bot,developer credentials 
	public void testGetForRateLimiting() {}
	//Validate for missing key
	public void testGetForMisingKey() {}
	//Validate range of the key
	public void  testGetForMaxRangeOfkey() {}
	public void  testGetForMinRangeOfkey() {}
	//Validate the presence of key in the response
	public void  testGetForKeyInJson() {}
	public void  testGetForKeyInXml() {}
	//Validate the api for the scope of http methods,Some api restricts some http requests and will send
	//crazy response if the developer has not written  logic to parse some type of http requests.
	public void testApiForHttpRestrctns() {}
	//3rd party api abuse happens when target api calls 3rd party api to achieve goal,
	//There might be some unexpected error occur in target api due to not handling the input from 3rd party api.


	//Functionality testing
	//Validate schema for JSON/XML
	public void  testGetForJsonSchema() {}
	public void  testGetForXmlSchema() {}
	//Validate error code handler
	public void  testGetForErrorCodeHandler() {}
	//Validate Header,Status code,pay load,ReasonPhrase,Response time
	public void  testGetUsrWithHeader() {}
	public void  testGetUsrWithStatusCode() {}
	public void  testGetUsrWithResnPhrase() {}
	public void  testGetUsrWithPayload() {}
	public void testGetUsrWithResponseTime() {}

	//Validate Database Integrity
	public void testGetForDatabaseIntegrity() {}

	//Belongs to entire flow
	//Test for chained  request 
	public void testForChainedrequest() {}
	//Test end to end CRUD flows
	//public void testEndToEndCrudFlow() {}
	}



