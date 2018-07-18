package checkout;

import java.util.*;

public class compare 
{
	public static void main(String[] args)
	  {
	    Map<String,String> hm=new HashMap<String,String>();   //创建HashMap对象hm
	    Scanner in=new Scanner(System.in);
	    String a;
	    String b;
	    System.out.println("请输入公司名称和电话号码");
	    while(true)
	    {
	    	a=in.next();
	    	b=in.next();
	    	if(!(a.equals("#")&&(b.equals("#"))))
	    	{
	    		hm.put(a, b);
	    	}
	    	else
	    		break;
	    }
	    System.out.println("哈希映射中的内容如下：\n"+hm);   //输出hm中的元素
	    //查找元素
	    String f;
	    String g;
	    System.out.print("请输入你要查找的公司名称：");
	    f=in.next();
	    g=(String)hm.get(f);
	    System.out.println("你要查找的公司的电话号码如下：");
	    System.out.println(g);
	   //删除元素
	    System.out.println("请输入你要删除的公司名称");
	    String del;
	    del=in.next();
	    String str=(String)hm.remove(del);   //在hm中删除键值为del的元素
	    System.out.println("保留的公司如下：");
	    Set keys=hm.keySet();     //获取哈希映射hm的键对象集合
	    Iterator it=keys.iterator();   //获取键对象集合keys的迭代器
	    while(it.hasNext())
		 {
			 String company=(String)it.next();
			 String number=(String)hm.get(company);
			 System.out.print(company +"  "+ number+"   ");
		 } 
	  }

}