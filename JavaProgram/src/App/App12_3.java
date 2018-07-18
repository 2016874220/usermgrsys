package App;
//filename App12_3.java         //在泛型类中定义泛型方法

class GenMet<T extends Object>              //定义泛型类。 <T extends Object> 即为系统默认形式，即为<T>。
//class GenMet<T>
{
  private T t;                 //定义泛型变量
  public T getObj()            //定义泛型类的方法getObj()
  {
    return t;
  }
  public void setObj(T t)        //定义泛型类的方法setObj()
  {
    this.t=t;
  }
  public <U> void display(U u)    //定义泛型方法
  {
    System.out.println("泛型类的类型参数T："+t.getClass().getName());
    System.out.println("泛型方法的类型参数U："+u.getClass().getName());
  }
}

public class App12_3
{
  public static void main(String[] args)
  {
    GenMet<Integer> gen=new GenMet<Integer>();  //创建泛型对象
    gen.setObj(new Integer(5));
    System.out.println("第一次输出：");
    gen.display("我是文本");                     //用字符串调用泛型方法
    System.out.println("第二次输出：");
    gen.display(new Double(8.0));                 //用实数调用泛型方法
  }
}
