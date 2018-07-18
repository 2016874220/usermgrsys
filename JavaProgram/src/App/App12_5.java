package App;
//filename：App12_5.java
class GeneralType<T>         //定义泛型类，T是类型参数
{
  T obj;                      //定义泛型类的成员变量
  public void setObj(T obj)      //定义泛型类的方法
  {
    this.obj=obj;
  }
  public T getObj()           //定义泛型类的方法
  {
    return obj;
  }
  //下面的方法接收的参数只能是String或String的子类
  public static void showObj(GeneralType<? extends String> o) 
  {
    System.out.println("给出的值是："+o.getObj());
  }
}
public class App12_5      //定义主类App12_5
{
  public static void main(String[] args)
  {
    GeneralType<String> n=new GeneralType<String>();
    
    GeneralType<?> g1=new GeneralType<Integer>();
    GeneralType<?> g2=new GeneralType<Double>();
    GeneralType<?> g3=null;
    g3=n;
    n=g3;
    g1.setObj("zhangsan");   //不能更改值
    g1.setObj(null);
    g1.getObj();
    n.setObj("陈  磊");
    
    GeneralType.showObj(n);        //用类名调用showObj()方法输出
    GeneralType<Double> num=new GeneralType<Double>();
    num.setObj(25.0);
//    GeneralType.showObj(num);    // just text
    System.out.println("数值型值："+num.getObj()); //不可调用方法showObj(num)输出
  }
}
