//遍历二维数组

package checkout;

public class text 
{
	public static void main(String[] args) 
	{
//		int i,j;
		int[][] b={{1,2,3},{4,5,6},{7,8,9}};
		
//		转换成foreach语句
//		for(i=0;i<b.length;i++)
//			for(j=0;j<b[i].length;j++)
//				System.out.println(b[i][j]);
		for(int[] c1:b)                   //从二维数组（数组的数组）b里取一维数组c1
			for(int c2:c1)                //从一维数组c1中取元素c2
				System.out.println(c2);
	}
}