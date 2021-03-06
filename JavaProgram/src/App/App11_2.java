package App;
//利用Runnable接口来创建线程

class MyThread implements Runnable     //由Runnable接口实现MyThread类
{
	private String who;
	public MyThread(String str)
	{
		who = str;
	}
	public void run()
	{
		for (int i = 0; i < 5; i++) 
		{
			try
			{
				Thread.sleep((int)(1000*Math.random()));
			}
			catch (InterruptedException e)
			{
				System.out.println(e.toString());
			}
			System.out.println(who+"正在运行！！");
		}
	}
}


public class App11_2
{
	public static void main(String[] args) {
		MyThread you = new MyThread("你");
		MyThread she = new MyThread("她");
		Thread t1 = new Thread(you);  //产生Thread类的对象t1、t2
		Thread t2 = new Thread(she);
		t1.start();                  //用t1、t2激活线程
		t2.start();
	}
}