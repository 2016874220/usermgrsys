package App;
//从键盘输入数据

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;*/

import java.io.*;//包含所有类

public class APP3_3 {
	public static void main(String[] args) throws IOException {
		String str;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入字符串：");
		str=buf.readLine();
		System.out.println("您输入的字符串是：\n"+str);
	}
}