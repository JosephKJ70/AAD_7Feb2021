package com.exceldata;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class ReadWordDoc {
	public static ArrayList<String> answersList = new ArrayList<String>();
	public static ArrayList<String> questionList = new ArrayList<String>();
	 
	    
	    	        
	    public static void readWordDoc()
	    {
			
			try {
				int optionsCount = 0;
				String abcd="";
				FileInputStream fis = new FileInputStream("C:\\Users\\DoveMed\\Downloads\\Chronic Migraine.docx");   //./drivers/chrome.exe
				System.out.println("Testing1");
				XWPFDocument docx = new XWPFDocument(fis);
				System.out.println("Testing2");
				List<XWPFParagraph> paragraphs = docx.getParagraphs();
				//List<XWPFWordExtractor> we = new List<XWPFWordExtractor>
				System.out.println("Testing3"+paragraphs);
				String title = paragraphs.get(0).getText();
				System.out.println("The Article title is:"+title);
				System.out.println("Word Document has " + paragraphs.size() + " paragraphs");
				//for (int i = 1; i < paragraphs.size(); i++) {
	               // String sentence = paragraphs.get(i).getText();
	               // System.out.println(sentence);
	                //if (!(sentence.contains("?"))) {	
	                //	String answerSeparation = StringUtils.subStringBetween("What is it?", "Who gets it?");
	                		//answersList.add(sentence);
	                		//System.out.println("The answers are:"+sentence);
	             //   }
	                
			//	}
	               
				/*System.out.println("The answers are:"+answersList);
				for(int j=1;j<=1;j++) {
					String answerInformation=answersList.get(j).toString();
					System.out.println("The answer is :"+answerInformation);*/
				//}
				
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	public static void main(String[] args) throws IOException {
		readWordDoc();
		//rw.readWordDoc("C:\\Users\\DoveMed\\Downloads\\Chronic Migraine.docx");

	}


}

	
