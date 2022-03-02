package com.apex.api.cutomer.jaxb.poi.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apex.api.test.core.ApexHttpUtil;
import com.apex.api.test.core.ApexHttpValidator;

public class CustomerDeleteTest extends ApexHttpUtil implements CustomerConstant {
	

		//1.Create  DELETE request
		//2.Send request
		//3.Validate the body 
		
		//Response code --204
		//Response phrase--No Content


		@Test(dataProvider="dp4")
		public void testGetUserWithSuccessData(String id) throws ClientProtocolException, IOException {
			HttpResponse response = (HttpResponse) ApexHttpUtil.sendAndReceiveDeleteMsg(BASE_USER_API_URL + "/"+id);
			//String respString = ApexHttpClientUtil.getStringResponseMessage(response);
			//	System.out.println(respString);
			int statusCode=response.getStatusLine().getStatusCode();
			System.out.println(statusCode);
			String reasonPhrase=response.getStatusLine().getReasonPhrase();
			System.out.println(reasonPhrase);
			//validation: status code, status message, tag repeations, tag present, not present, data, response item
			/*
			 * Assert.assertEquals(statusCode, HTTP_STATUS_CODE_204);
			 * Assert.assertEquals(reasonPhrase, HTTP_STATUS_MESSAGE_NO_CONTENT);
			 */
			ApexHttpValidator.validateStatusCodeReasonPhrase(response,HTTP_STATUS_CODE_204,HTTP_STATUS_MESSAGE_NO_CONTENT);
			
			
		}
		@DataProvider(name = "dp4")
		public Object[][] getDataForSuccess() throws Exception{
			//For few values we can use this to pass test data, but for multiple values we need to read test data from xls file
			//for that we need library jxl that enables java cde to read excel file
			//  String[][] data= { {"1","john"},{"2","jack"} };
			//Object[][] data=	getTableArray("user_ids.xls","Sheet1","UserSuccessIds");
			Object[][] data=	ApexHttpUtil.getTableArray("BookDeleteData.xlsx","Sheet1");
			/*
			 * for(int i=0;i<data.length;i++) { for(int j=0;j<data[i].length;j++) {
			 * System.out.println("data is   "+data[i][j]); } }
			 */
			return data;
		}
		@Test
		//Security testing
		//Validate exposed API endpoint 
		public void testDeleteForExposedEndpoint() {}
		//Validate for missing key
		public void testPutForMisingKey() {}
		//Validate api for rate limiting by sending repeated request with unauthenticated,
		//deactivated,bogus,or authenticate  credentials or as a bot,developer credentials 
		public void testPutForRateLimiting() {}
		//Validate range of the key
		public void  testPutForMaxRangeOfkey() {}
		public void  testPutForMinRangeOfkey() {}
		
		
		//Functionality testing 
		public void  testPostForErrorCodeHandler() {}

		//Validate Status code,Reason phrase,ResponseTime
		
		public void  testPostUsrWithStatusCode() {}
		public void  testDeleteUsrWithResnPhrase() {}
		//Validate Database Integrity
		public void testPostForDatabaseIntegrity() {}
		public void testputUsrWithResponseTime() {}
	}

