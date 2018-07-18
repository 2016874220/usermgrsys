package Text;

import java.util.Scanner;

class IPAddress{
	public static boolean isRightIP(String str){
		String temp="";
		int tag=0;
		if(str.charAt(0)=='.'||str.charAt(str.length()-1)=='.')
			return false;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='.'){
				tag++;
				if(Integer.parseInt(temp)>255) 
					return false;
				temp="";
				continue;
			}
			if(str.charAt(i)<'0'||str.charAt(i)>'9') 
				return false;
			temp+=String.valueOf(str.charAt(i));	
		}
		if(tag!=3)
			return false;
		return true;
	} 
}

public class text5 {
	public static void main(String[] args) {
		System.out.println("请输入需要验证的IP地址：");
		String s=new String();
		Scanner reader = new Scanner(System.in);
		s=reader.next();
		System.out.println("判断该IP地址格式的结果为：");
		System.out.println(IPAddress.isRightIP(s));
	}
}