package com.apex.api.test.core;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApexHttpUtil {
	public static HttpResponse sendAndReceiveGetMsg(String url) throws IOException, ClientProtocolException {
		// Create an object of HTTP client
		HttpClient client = HttpClientBuilder.create().build();

		// Create a Http get request message
		HttpGet reqMsg = new HttpGet(url);

		// Send request message
		HttpResponse response = client.execute(reqMsg);
		return response;
	}

	public static HttpResponse sendAndReceivePostMsg(String url, String msg, HashMap<String, String> headerMap)
			throws IOException, ClientProtocolException {
		// Create an object of HTTP client
		HttpClient client = HttpClientBuilder.create().build();

		// Create a HTTP put request message
		HttpPost reqMsg = new HttpPost(url);
		// Create String entity payload
		StringEntity entity = new StringEntity(msg);
		if (entity != null)
			reqMsg.setEntity(entity);
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			reqMsg.addHeader(entry.getKey(), entry.getValue());
		}
		// Send request message
		HttpResponse response = client.execute(reqMsg);
		return response;
	}

	public static HttpResponse sendAndReceivePutMsg(String url, String msg, HashMap<String, String> headerMap)
			throws IOException, ClientProtocolException {
		// Create an object of HTTP client
		HttpClient client = HttpClientBuilder.create().build();

		// Create a request message
		StringEntity entity = new StringEntity(msg);
		HttpPut reqMsg = new HttpPut(url);
		if (entity != null)
			reqMsg.setEntity(entity);

		// Send request message
		HttpResponse response = client.execute(reqMsg);
		return response;
	}

	public static HttpResponse sendAndReceiveDeleteMsg(String url) throws IOException, ClientProtocolException {
		// Create an object of HTTP client
		HttpClient client = HttpClientBuilder.create().build();

		// Create a request message
		HttpDelete reqMsg = new HttpDelete(url);

		// Send request message
		HttpResponse response = client.execute(reqMsg);
		return response;
	}

	public static String getStringResponseMessage(HttpResponse response) throws ParseException, IOException {
		/*
		 * HttpEntity entity = response.getEntity(); String strMsg = null; if (entity !=
		 * null) { strMsg = entity.toString(); } return strMsg;
		 */
		String entity = EntityUtils.toString(response.getEntity(), "UTF-8");
		if (entity != null)
			return entity;
		else
			return "";
	}

	// Data driven testing using apache poi library
	// XSSF object can read xlsx file
	public static String[][] getTableArray(String xlFilePath, String sheetName) throws Exception {
		String[][] tabArray = null;

		// get the excel sheet file location
		FileInputStream fis = new FileInputStream(xlFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		// XSSFSheet sheet = workbook.getSheetAt(0);
		int rowTotal=0;
		int colTotal = 0;
		int ci = 0;
		int cj = 0;
		rowTotal = sheet.getPhysicalNumberOfRows();
		System.out.println("rowTotal=" + rowTotal);
		if (rowTotal != 0) {
			colTotal = sheet.getRow(0).getLastCellNum();
			// colTotal=colTotal-1;
			System.out.println("colTotal=" + colTotal);

		}
		
		tabArray = new String[rowTotal - 1][colTotal];
		//Read the data from XSSF workbook into tabArray
		for (int i = 1; i < rowTotal; i++) {
			XSSFRow row = sheet.getRow(i);

			cj = 0;

			for (int j = 0; j < colTotal; j++) {
				XSSFCell cell = row.getCell(j);
				 System.out.println("ci="+ci+"cj= "+cj);
				tabArray[ci][cj] = cell.toString();
				if (cj < colTotal - 1) {
					cj = cj + 1;
					// System.out.println("cj= "+cj);

				}

			}
			if (ci < rowTotal - 2) {
				ci = ci + 1;
				// System.out.println("ci= "+ci);
			}
		}
		/*
		 * System.out.println("rows in tabArray= "+tabArray.length);
		 * System.out.println("cols in tabArray= "+tabArray[0].length);
		 * 
		 * for(int i=0;i<tabArray.length;i++) { for(int j=0;j<tabArray[i].length;j++) {
		 * System.out.println("tabArray is   "+tabArray[i][j]); } }
		 */

		return (tabArray);
	}
	/*
	 * Data driven using JXL library public static String[][] getTableArray(String
	 * xlFilePath, String sheetName, String tableName){ String[][] tabArray=null;
	 * try{ Workbook workbook = Workbook.getWorkbook(new File(xlFilePath)); Sheet
	 * sheet = workbook.getSheet(sheetName); int startRow,startCol, endRow,
	 * endCol,ci,cj; Cell tableStart=sheet.findCell(tableName);
	 * startRow=tableStart.getRow(); startCol=tableStart.getColumn();
	 * 
	 * Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,
	 * false);
	 * 
	 * endRow=tableEnd.getRow(); endCol=tableEnd.getColumn();
	 * System.out.println("startRow="+startRow+", endRow="+endRow+", " +
	 * "startCol="+startCol+", endCol="+endCol); tabArray=new
	 * String[endRow-startRow-1][endCol-startCol-1]; ci=0;
	 * 
	 * for (int i=startRow+1;i<endRow;i++,ci++){ cj=0; for (int
	 * j=startCol+1;j<endCol;j++,cj++){
	 * tabArray[ci][cj]=sheet.getCell(j,i).getContents(); } } } catch (Exception e)
	 * { System.out.println("error in getTableArray()"); }
	 * 
	 * return(tabArray); }
	 */
}



