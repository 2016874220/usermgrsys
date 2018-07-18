package App;
//filename App12_2.java
public class App12_2             //定义一般类，即非泛型类
{
  public static void main(String[] args)
  {
    Integer[] num={1,2,3,4,5};                     //定义数组
    String[] str={"红","橙","黄","绿","青","蓝","紫"};
    App12_2.<Integer>display(num);    //调用泛型方法
    App12_2.<String>display(str);
    App12_2.<String>show("zhangsan");
  }
  
  public static <T> void display(T[] list)  //定义泛型方法，E为类型参数。第一个<E>只是定义
  {
    for(int i=0;i<list.length;i++)
      System.out.print(list[i]+ "  ");
    System.out.println();
  }
  
  public static <S> S show(S S)
  {
	  return S;
  }
  
}