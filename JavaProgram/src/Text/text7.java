package Text;

import java.util.Scanner;

class MaxNum{
	int num1,num2,num3;
	int getMax(){
		int max = num1>num2?num1:num2;
		return max=max>num3?max:num3;
	}
}

public class text7 {
	public static void main(String[] args) {
		MaxNum max=new MaxNum();
		max.getMax();
		System.out.println("请输入三个数：");
		Scanner reader = new Scanner(System.in);
		int num1 = reader.nextInt();
		int num2 = reader.nextInt();
		int num3 = reader.nextInt();		
		System.out.println("最大值是："+max.getMax());
	}
}
