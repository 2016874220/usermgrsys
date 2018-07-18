package App;
//filename:App12_1.java          泛型类的应用

public class App12_1<T,S>         //定义泛型类，T是类型参数
{
  private T obj;            //定义泛型类的成员变量
  public T getObj()         //定义泛型类的方法getObj()
  {
    return obj;
  }
  public void setObj(T obj)   //定义泛型类的方法setObj()
  {
    this.obj=obj;
  }
  
  private S obj1;            //定义泛型类的成员变量
  public S getObj1()         //定义泛型类的方法getObj()
  {
    return obj1;
  }
  public void setObj1(S obj1)   //定义泛型类的方法setObj()
  {
    this.obj1=obj1;
  }
  
  public static void main(String[] args)
  {
    App12_1<String,Integer> name=new App12_1<String,Integer>();  //创建App12_1<String>型对象。String于Integer有顺序。
    App12_1<Integer,String> age=new App12_1<Integer,String>();  //创建App12_1<Integer>型对象
    name.setObj("张小华"); 
    String newName=name.getObj();
    System.out.println("姓名："+newName);
    name.setObj1(45);
    Integer newName1=name.getObj1();
    System.out.println("姓名："+newName1+"(纯属测试，切勿当真！)");
    age.setObj(25);                //Java自动将25包装为new Integer(25)
    int newAge=age.getObj();       //Java将Integer类型自动解包成int类型
    System.out.println("年龄："+newAge);
  }
}
