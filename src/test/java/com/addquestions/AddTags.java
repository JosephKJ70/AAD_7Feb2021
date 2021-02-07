package com.addquestions;

import java.util.ArrayList;
import java.util.HashMap;

import com.askTodoctor.AskADoctor_Main;
import com.askTodoctor.AskADrLogin;
import com.exceldata.ReadExcel;

public class AddTags extends ReadExcel {
	public static String[] strDCTags;
	public static String tagValue;
	public static String[] innerTags=null;
	public static int i,innerValue;
	public static HashMap<Integer, ArrayList<String>> tagsmap = new HashMap<Integer, ArrayList<String>>();
	public static ArrayList<String> tagList = new ArrayList<String>();

	public static void addtheTags() throws Exception {
		ReadExcel.readExcelData();
		strDCTags = ReadExcel.Sheet1.getRow(AskADoctor_Main.un).getCell(3).getStringCellValue().split(",");
		for (i = 0; i < strDCTags.length; i++) {
			System.out.println(strDCTags.length);
			System.out.println(strDCTags[i].toString());
			innerTags=strDCTags[i].split(";");
			System.out.println("Inner tags lengh:"+innerTags.length);
			for(innerValue=0;innerValue<=innerTags.length-1;innerValue++) {
				tagValue = innerTags[innerValue];
				System.out.println("The Value:"+tagValue);
			}
			//System.out.println(innerTags.toString());
			//tagList.add(strDCTags[i].toString());
			Thread.sleep(3000);

		}
		//System.out.println("The List is:"+tagList);
	}

	public static void main(String[] args) {
		AddTags at = new AddTags();
		try {
			at.addtheTags();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
