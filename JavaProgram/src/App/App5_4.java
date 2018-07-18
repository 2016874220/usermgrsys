package App;

public class App5_4 {
	public static void main(String[] args) {
		int level=7;
		int[][] iayong=new int[level][];       //声明7行二维数组，存放杨辉三角的各数
		System.out.println("杨辉三角");
		for (int i = 0; i < iayong.length; i++) {
			iayong[i]=new int[i+1];           //定义第i行有i+1列；
		}
			iayong[0][0]=1;
		for (int i= 1; i < iayong.length; i++) {
			iayong[i][0]=1;
			for (int j = 1; j < iayong[i].length-1; j++) {
				iayong[i][j]=iayong[i-1][j-1]+iayong[i-1][j];
			}
			iayong[i][iayong[i].length-1]=1;
		}
		for (int[] row : iayong) {
			for (int col : row) {
				System.out.print(col+"  ");
			}
			System.out.println();
		}
	}
}