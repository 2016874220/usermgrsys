package cn.edu.lingnan.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

//xml解析器
public class XmlParser {
//	public static boolean parser(String xmlPath)
	public static HashMap<String,String> parser(String xmlPath)
	{
//		boolean flag = false;
		HashMap<String,String>hm=new HashMap<String,String>();
		String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		 xmlPath=basePath+xmlPath;
		try {
		//实例化一个SAXParserFactory对象
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//通过factory获得一个SAXParser对象，即SAX解析器
		SAXParser saxParser=factory.newSAXParser(); 
		//saxParser对象调用parse方法解析XML文件；
		File f=new File(xmlPath);//事件源
		XmlHandler xh=new XmlHandler();//事件处理器
		saxParser.parse(f, xh);
		hm=xh.getHashMap();
//		flag = true;
//		System.out.println("----"+hm.get("user"));
//		System.out.println("----"+hm.get("driver"));
		} 
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
//		return flag;
		return hm;
	}
	
//	public static void main(String[] args) {
//		String xmlPath="database.conf.xml";
//		System.out.println(XmlParser.parser(xmlPath));
//	}

}
