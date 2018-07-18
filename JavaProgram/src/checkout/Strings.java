package checkout;

public class Strings {                             //不能使用“String”为文件命名！
	public static void main(String[] args) {
		int[] a=new int[5];
		int b=0;
		String str1=new String("Hello Java!");
		String str="Hello Java!  ";
		
		System.out.println(str1.length());
		System.out.println(str1.equals(str));
		System.out.println(str1.trim().equals(str.trim()));//自动去掉字符串的空格之后再作比较
		System.out.println(str1.substring(5));
		System.out.println(str1.substring(3,7));
		System.out.println(str1.charAt(5));
		System.out.println(str1.indexOf("Java"));
		System.out.println(str1.compareTo(str));
		System.out.println(str1.replace('H','h'));
		System.out.println(str1.toLowerCase());
		System.out.println(str1.toUpperCase());
	}
}
