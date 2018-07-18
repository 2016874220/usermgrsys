package checkout;

import java.util.Scanner;

public class scanner {
	public static void main(String[] args) {
		System.out.println("请输入一个数：");
		
		//两者等价
		//Scanner reader = new Scanner(System.in);
		//int num = reader.nextInt();
		Scanner input= new Scanner(System.in);
		int num = input.nextInt();
		
		int sum=num++;
		System.out.println("num="+num+";"+"sum="+sum);
	}
}
