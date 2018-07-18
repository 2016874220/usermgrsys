package cn.edu.lingnan.util;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//事件处理器（给别人调用），开始、清空、把读到的内容存进去、结束时存入hashmap
public class XmlHandler extends DefaultHandler 
{
	//定义可变字符串
	private StringBuffer sb=new StringBuffer();
	private HashMap<String,String>hm=new HashMap<String,String>();
	public void startElement (String uri, String localName,
					    String qName, Attributes attributes)
					    		throws SAXException
	{
		//清空一个可变字符串
		sb.delete(0, sb.length());
	}
					
     public void endElement (String uri, String localName, String qName)
		 throws SAXException
     {
    	 //将可变字符串的内容存入某个介质当中
    	 hm.put(qName.toLowerCase(), sb.toString().trim());
     }
     
     public void characters (char ch[], int start, int length)
    		 throws SAXException
     {
    	 //把读到的ch字符数组中的内容存入可变字符串
    	 sb.append(ch,start,length);
     }
     
     public HashMap<String,String> getHashMap()
     {
    	 return hm;
     }
     
}
