package checkout;

public class Arrays {
	public static void main(String[] args) 
	{
		int[] a=new int [5];
		for(int i = 0;i<5;i++) 
//if"i<6",则出现“ java.lang.ArrayIndexOutOfBoundsException”：数组下标越界
		{
			a[i]=i;
			System.out.println(a[i]);
		}
	}
}