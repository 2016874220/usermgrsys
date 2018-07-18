package App;
//filename：App12_8.java
import java.util.*;
public class App12_8
{
  public static void main(String[] args)
  {
    List<Integer> al=new ArrayList<Integer>();  //创建数组列表对象al
    for(int i=1;i<5;i++)
      al.add(new Integer(i));                 //向数组列表al中添加元素
    System.out.println("数组列表的原始数据"+al);   //*important
    ListIterator<Integer> listIter=al.listIterator();  //创建数组列表al的迭代器listIter
    listIter.add(new Integer(0));                //在序号为0的元素前添加一个元素
    System.out.println("添加数据后数组列表"+al);
    if(listIter.hasNext())
    {
      int i=listIter.nextIndex();    //执行该语句时i的值是1
      listIter.next();             //返回序号为1的元素
      listIter.set(new Integer(9));  //修改数组列表al中序号为1的元素
      System.out.println("修改数据后数组列表"+al);
    }
    listIter=al.listIterator(al.size());   //重新创建从al最后位置开始的迭代器listIter
    System.out.print("反向遍历数组列表：");    //反向遍历数组列表
    while(listIter.hasPrevious())
      System.out.print(listIter.previous()+"  ");    //反向遍历数组列表
  }
}
