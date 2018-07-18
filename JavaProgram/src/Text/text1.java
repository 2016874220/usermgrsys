package Text;

import java.io.IOException;
import java.util.Scanner;

public class text1
{
	private static Scanner reader;
	public static void main(String[] args) throws IOException
	{
		int num= 0,max = Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		System.out.println("请输入多个数：");
		System.out.println("（输入“#”时结束程序）");
		reader = new Scanner(System.in);
		while(reader.hasNextInt())
		{
			num=reader.nextInt();
			max=max>num?max:num;
			min=min<num?min:num;
		}
		System.out.println("最大值是："+max);
		System.out.println("最小值是："+min);
	}
}