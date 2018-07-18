package App;
//filename：App12_9.java
import java.util.*;
public class App12_9
{
  public static void main(String[] args)
  {
    HashSet<String> hs=new HashSet<String>(); //创建哈希集合对象hs，初始容量为16
    for(String a:args)
      if(!hs.add(a))          //向哈希集合hs添加元素，但重复的元素不添加
        System.out.println("元素"+a+"重复");        //输出重复的元素
    System.out.println("集合的容量为："+hs.size()+"，各元素为：");
    
    Iterator it=hs.iterator();             //创建哈希集合hs的迭代器it。*遍历器。
    while(it.hasNext())                //判断集合中是否还有后续元素
      System.out.print(it.next()+"  ");   //输出哈希集合中的元素
  }
}
