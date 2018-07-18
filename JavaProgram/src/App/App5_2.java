package App;
//设数组中有n个互不相同的数，不用排序求出其中的最大值和次大值
public class App5_2 
{
	public static void main(String[] args) 
	{
		int max,sec;
		int[] a={54,44,24,98,44,64,21,69,10};
		//输出数组元素
		System.out.print("数组各元素为：");
		for (int i = 0; i < a.length; i++) 
		{
			System.out.print(" "+a[i]);       //println:默认输出后换行；print不换行！！！
		}
		//给max、sec赋初值
		if(a[0]>a[1])
		{
			max=a[0];
			sec=a[1];
		}
		else
		{
			max=a[1];
			sec=a[0];
		}
		//*******求max、sec********
		for (int i = 2; i < a.length; i++) 
		{
			if (a[i]>max) 
			{
				sec=max;
				max=a[i];
			}
			else
				if(a[i]>sec)
				{
					sec=a[i];
				}
		}
		System.out.println("\n其中最大值为："+max);
		System.out.println("次大值为："+sec);
	}
}
