package App;
//filename：App12_4.java
class GeneralTypes<T extends Number>     //类型参数T必须是Number类或是其子类
{
  T obj;
  public GeneralTypes(T obj)  //定义泛型类的构造方法
  {
    this.obj=obj;
  }
  public T getObj()         //定义泛型类的方法
  {
    return obj;
  }
}
public class App12_4      //定义主类App12_4
{
  public static void main(String[] args)
  {
    GeneralTypes<Integer> num=new GeneralTypes<Integer>(5);    //创建泛型对象num
    System.out.println("给出的参数是："+num. getObj());
    //下面的语句是非法的，因为实际参数String不是Number或Number的子类
    //GeneralTypes<String> s=new GeneralTypes<String>("Hello"); 
  }
}
