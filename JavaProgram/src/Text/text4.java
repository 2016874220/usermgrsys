package Text;

import java.util.Scanner;

public class text4
{
	public static void main(String[] args) 
	{
		int[][] a={{1,2,3},{4,5,6},{7,8,9}};
		int[][] b={{2,1,0},{2,1,0},{2,1,0}};
		int[][] c=new int[3][3];
		int[][] d={{2,0,2},{1,0,1},{0,0,1}};
		int[][] e={{2,1,0},{0,1,0},{2,1,0}};
		int[][] f=new int[3][3];
//加法公式
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				c[i][j]=a[i][j]+b[i][j];
			}
		}
//乘法公式
		for(int m=0;m<3;m++)
		{
			for(int n=0;n<3;n++)
			{
				f[m][n]=d[m][0]*e[0][n]+d[m][1]*e[1][n]+d[m][2]*e[2][n];
			}
		}
//输出矩阵加法运算结果
		System.out.println("矩阵加法：");
		for(int i=0,j=0;j<3;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.print("   ");
			for(int i=0,j=0;j<3;j++)
			{
				System.out.print(b[i][j]+" ");
			}
			System.out.print("   ");
			for(int i=0,j=0;j<3;j++)
			{
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
			
			for(int i=1,j=0;j<3;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.print(" + ");
			for(int i=1,j=0;j<3;j++)
			{
				System.out.print(b[i][j]+" ");
			}
			System.out.print(" = ");
			for(int i=1,j=0;j<3;j++)
			{
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		
			for(int i=2,j=0;j<3;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.print("   ");
			for(int i=2,j=0;j<3;j++)
			{
				System.out.print(b[i][j]+" ");
			}
			System.out.print("   ");
			for(int i=2,j=0;j<3;j++)
			{
				System.out.print(c[i][j]+" ");
			}
			System.out.println("\n");
						
//输出矩阵乘法运算结果
			System.out.println("矩阵乘法：");
			for(int i=0,j=0;j<3;j++)
			{
				System.out.print(d[i][j]+" ");
			}
			System.out.print("   ");
			for(int i=0,j=0;j<3;j++)
			{
				System.out.print(e[i][j]+" ");
			}
			System.out.print("   ");
			for(int i=0,j=0;j<3;j++)
			{
				System.out.print(f[i][j]+" ");
			}
			System.out.println();
			for(int i=1,j=0;j<3;j++)
			{
				System.out.print(d[i][j]+" ");
			}
			System.out.print(" * ");
			for(int i=1,j=0;j<3;j++)
			{
				System.out.print(e[i][j]+" ");
			}
			System.out.print(" = ");
			for(int i=1,j=0;j<3;j++)
			{
				System.out.print(f[i][j]+" ");
			}
			System.out.println();
			
			for(int i=2,j=0;j<3;j++)
			{
				System.out.print(d[i][j]+" ");
			}
			System.out.print("   ");
			for(int i=2,j=0;j<3;j++)
			{
				System.out.print(e[i][j]+" ");
			}
			System.out.print("   ");
			for(int i=2,j=0;j<3;j++)
			{
				System.out.print(f[i][j]+" ");
			}
			System.out.println();
	}
}