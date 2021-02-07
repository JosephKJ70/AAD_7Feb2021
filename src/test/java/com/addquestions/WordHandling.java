package com.addquestions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class WordHandling {
	public static String filepath;
	public static List<XWPFParagraph> paragraphlist;
	public static HWPFDocument doc;
	public static FileInputStream fis;
	public static File src;
	public static String title;
	ArrayList<String> questionList = new ArrayList<String>();
	public static void readWordFile(String filepath) {
		try {
		filepath = "C:\\Users\\DoveMed\\Downloads\\Chronic Migraine.doc";
		src = new File(filepath);
		//fis = new FileInputStream(src);
		fis = new FileInputStream(src);
		HWPFDocument doc = new HWPFDocument(fis);
		WordExtractor we = new WordExtractor(doc);
		String[] paragraphs = we.getParagraphText();
		title=paragraphs[0].toString();
		System.out.println(title);
		String[] paragraphs1 = we.getParagraphText();
		System.out.println("Word Document has " + paragraphs.length + " paragraphs");
		//docx = new XWPFDocument(fis);
		//paragraphlist = docx.getParagraphs();
		// Iterate
		//for(XWPFParagraph paragraph:paragraphlist) {
			//System.out.println(paragraph.getText());
			
		//}
		
		
		
		
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		readWordFile(filepath);
	}

}
