package Text;

import java.util.Scanner;

/*输入有限个整数，然后输出，输入“#”终止程序。*/

public class text2 {
	public static void main(String[] args) {
		int a=0;
		/*
		float b=0F;
		double c=0D;
		String s="";
		*/
		Scanner reader = new Scanner(System.in);
		/*
	    System.out.println("从键盘输入一串字符：");
		s = reader.nextLine();
		System.out.println("你输入的字符串是"+s);
		System.out.println("从键盘输入一个单精度浮点数：");
		b = reader.nextFloat();
		System.out.println("你输入的是单精度浮点数是"+b);
		System.out.println("从键盘输入一个双精度浮点数：");
		c = reader.nextDouble();
		System.out.println("你输入的双精度浮点数是"+c);
		*/
		System.out.println("从键盘输入一个整数：");
		System.out.println("（输入“#”时结束程序）");
		while(reader.hasNextInt()){
			a = reader.nextInt();
			System.out.println("你输入的整数是"+a);
			System.out.println("从键盘输入一个整数：");
		}
	}
}
