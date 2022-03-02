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
import com.apex.api.test.core.ApexXMLUtil;
import com.apex.customer.bean.Customer;
import com.apex.customer.bean.CustomerPost;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;



public class CustomerPostTest extends ApexHttpUtil implements CustomerConstant {

		@Test(dataProvider ="dp2")
		public void postAPITest(String username,String job) throws ClientProtocolException, IOException, JAXBException {
		
		//1.Create the http post request
		//2.Attach the header
		//3.Attach the payload/entity 
		//4.Send the request
		//5. Validate the response
		
		//Response code --201
		//Response phrase--Created

		//System.out.println("username="+username+"job="+job);
		    //Create header
			HashMap<String ,String> headerMap=new HashMap<String,String>();
			headerMap.put("Content-Type","application/xml");
			JAXBContext jaxbContext=JAXBContext.newInstance(CustomerPost.class);
			//create the  payload
			String xmlFilePath=	"C:\\Users\\veera\\Documents\\AdvJava\\EclipseEE\\eclipse\\Customer-api-jaxbPoi-test-fm\\CustomerPost.xml";
			
			CustomerPost custmrPst=new CustomerPost(username, job);
			ApexXMLUtil.marshller(custmrPst,xmlFilePath, jaxbContext );
		 
		/*	
		//    System.out.println("After Marshalling==="+usersMsg);
			HttpResponse httpResponse =ApexHttpUtil.sendAndReceivePostMsg(BASE_USER_API_URL, usersMsg, headerMap);
			String response=getStringResponseMessage(httpResponse);
			System.out.println("HTTPResponse: "+response);
			//1.status code
			int statusCode=httpResponse.getStatusLine().getStatusCode();
			String statusMag=httpResponse.getStatusLine().getReasonPhrase();
		
			ApexHttpValidator.validateStatusCodeReasonPhrase(httpResponse,HTTP_STATUS_CODE_201,HTTP_STATUS_MESSAGE_CREATED);
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
			//asserting tag
			//check for the name
			CustomerPost custmrPstUnmrshl=ApexJSONUtil.convertJsonToObjectPst(response);
			System.out.println("Unmarshld customerPost obj"+custmrPstUnmrshl);
			Assert.assertEquals(custmrPst.getName(),username);
			Assert.assertEquals(custmrPst.getJob(),job);*/
					
		}
		
		
	

	private String converObjectToJson(CustomerPost custmrPst) {
			// TODO Auto-generated method stub
			return null;
		}

	@DataProvider(name = "dp2")
	public Object[][] getDataForSuccess() throws Exception{
		Object[][] data=	ApexHttpUtil.getTableArray("PostDat.xlsx","Sheet1");
		/*
		 * for(int i=0;i<data.length;i++) { for(int j=0;j<data[i].length;j++) {
		 * System.out.println("data is   "+data[i][j]); } }
		 */
		return data;
	}
	

	@Test
	//Security testing
	//Validate exposed API endpoint 
	public void testPostForExposedEndpoint() {}
	//Validate the api for crosssite scripting
	public void testPostForXSSVulnerable() {}
	//Validate api for rate limiting by sending repeated request with unauthenticated,
	//deactivated,bogus,or authenticate  credentials or as a bot,developer credentials 
	public void testPostForRateLimiting() {}
	//Validate the missing key
	public void testPostForMisingKey() {}
	//Validate range of the key
	public void  testPostForMaxRangeOfkey() {}
	public void  testPostForMinRangeOfkey() {}
	//Validate the presence of key in the response
	public void  testPostForKeyInJson() {}
	public void  testPostForKeyInXml() {}

	//Functional testing
	//Validate schema for JSON/XML
	public void  testPostForJsonSchema() {}
	public void  testPostForXmlSchema() {}
	//Validate error code handler
	public void  testPostForErrorCodeHandler() {}

	//Validate Header,Status code,pay load,ReasonPhrase,ResponseTime
	public void  testPostUsrWithHeader() {}
	public void  testPostUsrWithStatusCode() {}
	public void  testPostUsrWithResnPhrase() {}
	public void  testPostUsrWithPayload() {}
	public void testPostUsrWithResponseTime() {}
	//Validate the empty post are handled properly
	public void testPostForBlankBody() {}

	//Validate Database Integrity
	public void testPostForDatabaseIntegrity() {}
	//Validate upload of different file formats
	public void testPostForFileUpload() {}

		
	}


