package App;
import java.util.Scanner;

//判断回文字符串

public class App5_6 {
	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner reader = new Scanner(System.in);
		String str = reader.next();
		String str1=new String();
		int N=str.length(),S;
		if(N%2==0)
		{
			S=N/2;
			for(int i=0,j=N-1;i<S;i++,j--)
			{
				if(str.substring(i)!=str.substring(j))
				{
					System.out.println("不属于回文字符串 ");
					break;
				}
				if(i<S)
				{
					System.out.println("属于回文字符串");
					break;
				}
			}
		}
		else
		{
			S=(N-1)/2;
			for(int i=0,j=N-1;i<S;i++,j--)
			{
				if(str.substring(i)!=str.substring(j))  //字符串不能这样比较
				{
					System.out.println("不属于回文字符串");
					break;
				}
				if(i<S)
				{
					System.out.println("属于回文字符串");
					break;
				}
			}
		}
	}
}
