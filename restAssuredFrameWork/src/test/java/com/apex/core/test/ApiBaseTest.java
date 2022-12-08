package com.apex.core.test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ApiBaseTest {

	public void assertResponseStatus(HttpResponse resp, int code, String msg) {
		Assert.assertEquals(resp.getStatusLine().getStatusCode(), code);
		Assert.assertEquals(resp.getStatusLine().getReasonPhrase(), msg);
	}
	
	public void setRequestBody(HttpPost postReq, String strReq) throws UnsupportedEncodingException {
		StringEntity strEntity = new StringEntity(strReq);
		postReq.setEntity(strEntity);
	}
	public void setRequestBody(HttpPut putReq,String strReq)throws UnsupportedEncodingException {
		StringEntity strEntity = new StringEntity(strReq);
		
		putReq.setEntity(strEntity);
	
		
	}
	
	public String getResponseBody(HttpResponse resp) throws ParseException, IOException {
		HttpEntity entity = resp.getEntity();
		String strResponse = null;
		
		if(entity != null) {
			strResponse = EntityUtils.toString(entity);
		}
		
		return strResponse;
	}
	
	public static String[][] getTableArray(String xlFilePath, String sheetName, String tableName) throws Exception {

		String[][] tabArray = null;

		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		int startRow, startCol, endRow, endCol, ci, cj;
		Cell tableStart = sheet.findCell(tableName);
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();

		Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 100, 64000, false);

		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();
		System.out.println(
				"startRow=" + startRow + ", endRow=" + endRow + ", " + "startCol=" + startCol + ", endCol=" + endCol);
		tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
		ci = 0;

		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}

		return (tabArray);
	}
}
