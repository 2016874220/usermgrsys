package App;
//三维数组

public class App5_5{
	public static void main(String[] args) {
		int sum = 0;
		int[][][] a={{{1,2,5},{3,4}},{{5,6,1},{7,8}}};
		for (int[][] is : a) {
			for (int[] is2 : is) {
				for (int i : is2) {
					System.out.print(i+" ");
				}
			}
		}
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) { //注意是a[i].length！！表示第i行的列数
				for (int k = 0; k < a[i][j].length; k++) { //注意是a[i][j].length！！
					sum=sum+a[i][j][k];
				}
			}
		}
		System.out.println("sum="+sum);
	}
}
