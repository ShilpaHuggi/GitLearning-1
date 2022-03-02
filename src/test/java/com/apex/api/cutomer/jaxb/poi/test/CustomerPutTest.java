package com.apex.api.cutomer.jaxb.poi.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apex.api.test.core.ApexHttpUtil;
import com.apex.api.test.core.ApexHttpValidator;
import com.apex.api.test.core.ApexJSONUtil;
import com.apex.customer.bean.CustomerPost;



public class CustomerPutTest extends ApexHttpUtil implements CustomerConstant {
	
		
		
		@Test(dataProvider ="dp3")
		public void putAPITest(String username,String job,String id) throws ClientProtocolException, IOException {
		//1.Create the post request 
		//2.Create and attach the header
		//3.Create and attach the payload/entity
		//4. Send the request
		
		//Response code --200
	    //Response phrase--Ok
	    
		    //Create header
			HashMap<String ,String> headerMap=new HashMap<String,String>();
			headerMap.put("Content-Type","application/json");
			//payload
			CustomerPost custmrPst=new CustomerPost(username, job);
		    String usersMsg=ApexJSONUtil.converObjectToJson(custmrPst);
			
			HttpResponse httpResponse =sendAndReceivePutMsg(BASE_USER_API_URL+"/"+id, usersMsg, headerMap);
			String response=getStringResponseMessage(httpResponse);
			System.out.println("HTTPResponse: "+response);
			//1.status code
			int statusCode=httpResponse.getStatusLine().getStatusCode();
			String statusMag=httpResponse.getStatusLine().getReasonPhrase();
			/*
			 * Assert.assertEquals(statusCode, HTTP_STATUS_CODE_200,"code not matched");
			 * Assert.assertEquals(statusMag,
			 * HTTP_STATUS_MESSAGE_OK,"statusmessage not ok");
			 */
			ApexHttpValidator.validateStatusCodeReasonPhrase(httpResponse,HTTP_STATUS_CODE_200,HTTP_STATUS_MESSAGE_OK);
			System.out.println("statuscode="+statusCode);
			System.out.println("The response from API is:"+statusMag);
			//Validate the header
			Header[] headerArray = httpResponse.getAllHeaders();
			for(Header hdr:headerArray)
				System.out.println("Header: "+hdr);
			HashMap<String, String> hederMap = new HashMap<String, String>();
			for (Header header : headerArray)
				hederMap.put(header.getName(), header.getValue());

			// Set<Entry<String,String>> entry = allHeaders.entrySet();
			// System.out.println("Header value "+allHeaders.get("Content-Type"));
			Assert.assertEquals(hederMap.get("Content-Type"), HEADER_CONTENT_TYPE_VALUE);
			
			
		}
		@DataProvider(name = "dp3")
		public Object[][] getDataForSuccess() throws Exception{
		
			Object[][] data=	ApexHttpUtil.getTableArray("BookPutData.xlsx","Sheet1");
			/*
			 * for(int i=0;i<data.length;i++) { for(int j=0;j<data[i].length;j++) {
			 * System.out.println("data is   "+data[i][j]); } }
			 */
			return data;
		}	
		
			
			
		
	@Test
	//Security testing
	//Validate exposed API endpoint 
	public void testPutForExposedEndpoint() {}
	public void testPutForMisingKey() {}
	//Validate api for rate limiting by sending repeated request with unauthenticated,
	//deactivated,bogus,or authenticate  credentials or as a bot,developer credentials 
	public void testPutForRateLimiting() {}
	//Validate range of the key
	public void  testPutForMaxRangeOfkey() {}
	public void  testPutForMinRangeOfkey() {}
	//Validate the presence of key in the response
	public void  testPutForKeyInJson() {}
	public void  testPutForKeyInXml() {}

	//Functionality testing
	//Validate schema for JSON/XML
	public void  testPutForJsonSchema() {}
	public void  testPutForXmlSchema() {}
	//Validate error code handler
	public void  testPutForErrorCodeHandler() {}

	//Validate Header,Status code,pay load,ResponseTime
	public void  testPutUsrWithHeader() {}
	public void  testPutUsrWithStatusCode() {}
	public void  testPutUsrWithResnPhrase() {}
	public void  testPutUsrWithPayload() {}
	public void testputUsrWithResponseTime() {}
	//Validate the empty update are handled properly
	public void testPutForBlankBody() {}
	//Validate Database Integrity
	public void testPutForDatabaseIntegrity() {}
	//Validate upload of different file formats
	public void testPutForFileUpload() {}
		
	}



