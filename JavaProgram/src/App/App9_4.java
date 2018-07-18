package App;
//求命令行方式中输入的整数n的阶乘n！，并捕获可能出现的异常

public class App9_4
{
	public static double multi(int n) {
		if(n<0)
		{
			throw new IllegalArgumentException("求负数阶乘异常");
		}
		double s = 1;
		for(int i = 1;i <=n;i ++)
		{
			s = s*i;
		}
		return s;
	}
	public static void main(String[] args){
		try
		{
			int m = Integer.parseInt(args[0]);
			System.out.println(m+"!="+multi(m));
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("命令行中没有提供参数！");
		}
		catch(NumberFormatException e)
		{
			System.out.println("应输入一个【整数】！");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("出现的异常是："+e.toString());
		}
		finally
		{
			System.out.println("程序运行结束！！");
		}
	}
}