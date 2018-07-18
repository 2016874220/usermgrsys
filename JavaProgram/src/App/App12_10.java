package App;
//filename：App12_10.java
import java.util.*;
public class App12_10
{
  public static void main(String[] args)
  {
//    Set<String> hs=new HashSet<String>();   //创建哈希集合对象hs
    Set<Integer> hs=new HashSet<Integer>();
//    hs.add("唐  僧");        //向哈希集合的对象hs添加元素
//    hs.add("孙悟空");
//    hs.add("猪八戒");
//    hs.add("沙和尚");
//    hs.add("白龙马");
    hs.add(123);
    hs.add(98);
    hs.add(465);
    hs.add(456);
    hs.add(567);
    
//    Iterator it=hs.iterator();
//    while(it.hasNext())
//    	System.out.println("----------------------------");
    
    TreeSet<Integer> ts=new TreeSet<Integer>(hs);  //利用hs创建树集合对象ts
//    System.out.println("树集合："+ts);          //输出树集合
//    System.out.println("树集合的第一个元素："+ts.first());  
//    System.out.println("树集合最后一个元素："+ts.last());
//    System.out.println("haedSet(孙悟空)的元素："+ts.headSet("孙悟空"));
//    System.out.println("tailSet(孙悟空)的元素："+ts.tailSet("孙悟空"));
//    System.out.println("ceiling (沙)的元素："+ts.ceiling ("沙"));
    
    Iterator<Integer> itt=ts.iterator();
    while(itt.hasNext())
    	System.out.print(itt.next()+" ");
    
  }
}
