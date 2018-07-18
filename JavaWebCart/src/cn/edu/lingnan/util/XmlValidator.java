package cn.edu.lingnan.util;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

//验证xml文件是否符合xsd文件

public class XmlValidator
{
	public static boolean validator(String xmlPath,String xsdPath)
	 {
		 boolean flag=false;
		 //当前线程的类加载器的当前资源的当前路径
		 String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
//		 System.out.println("---------"+basePath);
		 //组合路径
		 xmlPath=basePath+xmlPath;
		 xsdPath=basePath+xsdPath;
		 try
		 {
		 //创建模式工厂
		 SchemaFactory sf=SchemaFactory.newInstance
				 ("http://www.w3.org/2001/XMLSchema");
		 //创建模式
		 File f=new File(xsdPath);
		 Schema s=sf.newSchema(f);
		 Validator v=s.newValidator();
		 Source xs=new StreamSource(xmlPath);
			v.validate(xs);
			flag=true;
		}
		 catch (SAXException e)
		 {
			e.printStackTrace();
		 }
		 catch (IOException e)
		 {
				System.out.println("XML文件验证失败.......");
				e.printStackTrace();
		 }
		 
		 return flag;
	 }
	
//	public static void main(String[] args)
//	{
//		String xmlPath="database.conf.xml";
//		String xsdPath="database.conf.xsd";
//		System.out.println(XmlValidator.validator(xmlPath,xsdPath));	
//	}

}

