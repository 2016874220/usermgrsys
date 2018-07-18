package App;
//App9_5.java          使用throws语句在方法之中抛出异常
public class App9_5
{
  static void check(String str1) throws NullPointerException  //方法头抛出空指针异常
  {
    if(str1.length()>2)     //如果字符串参数str的字符长度大于2
    {
      str1=null;            //则字符串参数赋值为空
      System.out.println(str1.length());     //试图输出空串的长度会抛出空指针异常
    }
    char ch;
    for (int i=0;i<str1.length();i++)
    {
      ch=str1.charAt(i);
      if(!Character.isDigit(ch))                 //判断参数中字符是否为数字
        throw new NumberFormatException();       //方法中抛出数值格式异常
    }
  }
  public static void main(String[] args) throws Exception  //抛出异常给系统处理
  {
    int num;
    try
    {
      check(args[0]);
      num=Integer.parseInt(args[0]);
      if (num>60)
        System.out.println("成绩为："+num+"  及格");
      else 
        System.out.println("成绩为："+num+"  不及格");
    }
    catch(NullPointerException e)
    {
      System.out.println("空指针异常："+e.toString());
    }    	
    catch (NumberFormatException ex)
    {
      System.out.println("输入的参数不是数值类型");
    }
    catch (Exception e)
    {
      System.out.println("命令行中没有提供参数");        //命令行参数？？？？？？？？？？？？
    }
  }
}