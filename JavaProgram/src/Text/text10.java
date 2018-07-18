//1、公司名称和公司电话通过键盘输入，以#键结束；2、公司名称为健，公司电话为值；
//3、键盘输入待查找的公司名称，程序输出该公司对应的电话号码；4、键盘输入待删除的公司名称，程序执行删除，并输入删除操作后的整个HashMap中的值。

package Text;

import java.util.*;
public class text10
{
  public static void main(String[] args)
  {
    HashMap<String,String> hm=new HashMap<String,String>();     //创建HashMap对象hm
    System.out.println("请输入公司名称、电话：");
    Scanner reader = new Scanner(System.in);
    while(true)
    {
    	String cphone = reader.next();
    	String cname = reader.next();
    	if(!((cphone.equals("#"))&&(cname.equals("#"))))
    	{
    		hm.put(cphone, cname);
    	}
    	else break;
    }
    
    //输出hm元素
    System.out.println("\n存储的公司信息如下\n"+hm+"\n");
    
    //键盘输入待查找的公司名称，程序输出该公司对应的电话号码
    System.out.println("请输入所需查找的公司的名称：");
    String find = reader.next();
    String cphone = hm.get(find);
    System.out.println("该公司的电话号码为："+cphone);
    
    //键盘输入待删除的公司名称，程序执行删除
    System.out.println("\n请输入需要删除的公司的名称");
    String del = reader.next();
    String dname=hm.remove(del);   //删除hm中键值为del的数据
    
    //输出更新之后的数据
    System.out.println("\n更新之后的公司信息如下：");
    Set keys=hm.keySet();
    Iterator ki=keys.iterator();
    while(ki.hasNext())
    {
      String phoneNum=(String)ki.next();
      String nextName=hm.get(phoneNum);
      System.out.println(phoneNum+":"+nextName);
    } 
  }
}
