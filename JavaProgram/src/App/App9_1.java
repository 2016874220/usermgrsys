package App;
//捕获数组下标越界异常和除数为0异常

public class App9_1 {
	public static void main(String[] args) {
		int i;
		int[] a = {1,2,3,4};
//		try{
		for (i = 0; i < 5; i++) {
			System.out.println("   a["+i+"]="+a[i]);
		}
//		}
//		catch(ArrayIndexOutOfBoundsException e){
//			e.getStackTrace();
//		}
		System.out.println("5/0"+(5/0));    //第一个异常出现即终止程序，不运行该行（除非作特殊处理）
	}
}