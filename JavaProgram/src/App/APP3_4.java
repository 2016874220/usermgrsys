package App;
//从键盘中输入数字，然后将其转换成数值型数据。

import java.io.*;
public class APP3_4 {
	public static void main(String[] args) throws IOException {
		float num;
		String str;
		BufferedReader buf;
		buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入一个实数：");
		str = buf.readLine();
		num=Float.parseFloat(str);
		System.out.println("您输入的数为："+num);
	}
}