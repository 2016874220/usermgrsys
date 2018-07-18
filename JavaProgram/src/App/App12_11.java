package App;
//filename：App12_11.java
//HashSet和HashMap的区别？？？

import java.util.*;
public class App12_11
{
  public static void main(String[] args)
  {
    Map<String,String> hm=new HashMap<String,String>();   //创建HashMap对象hm
    hm.put("006","唐  僧");    //将元素添加到映射hm中。***书上例子出错，无法输出预想结果。
//    hm.put("008","孙悟空");
//    hm.put("009","猪八戒");
    hm.put("108","孙悟空");
    hm.put("059","猪八戒");
    hm.put("007","沙和尚");
    hm.put("010","白龙马");
    System.out.println("哈希映射中的内容如下：\n"+hm);   //输出hm中的元素
    String str=(String)hm.remove("010");   //在hm中删除键值为“010”的元素
    Set keys=hm.keySet();     //获取哈希映射hm的键对象集合
    Iterator it=keys.iterator();   //获取键对象集合keys的迭代器
    System.out.println("HashMap类实现的Map映射，无序：");
    while(it.hasNext())        //判断是否还有后续元素
    {
      String xh=(String)it.next();        //返回键值
      String name=(String)hm.get(xh);   //返回键值所对应的值
      System.out.println(xh+"  "+ name);
    }
    TreeMap<String,String> tm=new TreeMap<String,String>(); //创建TreeMap对象tm
    tm.putAll(hm);                  //向树映射对象tm添加元素。**
    Iterator iter=tm.keySet().iterator();  //获取迭代器
    System.out.println("TreeMap类实现的Map映射，键值升序：");
    while(iter.hasNext())                //判断是否还有后续元素
    {
      String xh=(String)iter.next();       //返回键值
      String name=(String)hm.get(xh);    //返回键值所对应的值
      System.out.println(xh+"  "+ name);
    }
  }
}
