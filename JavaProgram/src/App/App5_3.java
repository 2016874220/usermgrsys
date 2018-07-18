package App;
import java.util.Scanner;

//约瑟夫环：求出圈顺序
public class App5_3 {
	public static void main(String[] args) {
		int N,S,M;
		Scanner reader = new Scanner(System.in);
		System.out.println("请输入总人数：");
		N = reader.nextInt();  //N：总人数
		System.out.println("请规定从第几个人开始报数：");
		S = reader.nextInt();  //S、M：从第S个人开始从1到M报数，报数到第M的人出圈
		System.out.println("请规定报数到第几的人出圈：");
		M = reader.nextInt();
		//给所有人编号
		int[] a=new int[N];
		for (int i = 1; i <= N; i++) {
			a[i-1]=i;          //可否从a[1]开始？
		}
		//求出圈人下标
		System.out.print("出圈的顺序为：");
		for (int i = 0; i < N; i++) {
			int sub,k=N;
			do {      //用do...whlie（而非while/if）不需提前对sub赋值(赋值语句在判断语句之前)
				sub=S-1+M;
			}
			while (sub<=(N-1));
			do {
				sub=S-1+M-N;
			}
			while (sub>(N-1));
			System.out.print(" "+(sub+1));
			for (int j = sub; j < k-1; j++) {
				a[j]=a[j+1];
			}
				k=k-1;
		}
	}
}
