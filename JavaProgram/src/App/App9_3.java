package App;
//使用throw语句在方法内抛出异常，并在同一方法内进行相应的异常处理

public class App9_3
{
	public static void main(String[] args)
	{
		int a = 5,b = 0;
		try
		{
			if(b == 0)
			{
				throw new ArithmeticException(); 
//throw抛出由异常产生的对象，也就是第19行语句中e所接收的对象（抛出系统定义的运行时异常没用太大意义）
			}
			else
			{
				System.out.println(a+"/"+b+"="+a/b);
			}
		}
			catch(ArithmeticException e)
			{
				System.out.println("异常："+e+"被抛出了！\n");
				e.printStackTrace();   //输出当前异常对象的堆栈使用轨迹
			}
	}
}
