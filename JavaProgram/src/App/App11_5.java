package App;
//filename：App11_5.java
class ThreadSale implements Runnable  //implements是一个类，实现一个接口用的关键字，它是用来实现接口中定义的抽象方法。
//实现一个接口，必须实现接口中的所有方法。创建Runnable接口类，模拟航班售票窗口。
{
  private int tickets=10;
  public void run()
  {
    while(true)
    {
      if(tickets>0)
        System.out.println(Thread.currentThread().getName()+"售机票第"+tickets--+"号");   //若使用Runnable接口，
      //要在此类中获得当前线程，必须使用Thread.currentThread()
      else
        System.exit(0);
    }
  }
}
public class App11_5
{
  public static void main(String[] args)
  {
    ThreadSale t=new ThreadSale();
    Thread t1=new Thread(t, "第1售票窗口");
    Thread t2=new Thread(t, "第2售票窗口");
    Thread t3=new Thread(t, "第3售票窗口");
    t1.start();
    t2.start();
    t3.start();         //每次运行结果可能不一样，因为输出延迟
  }
}
