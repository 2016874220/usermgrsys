package App;
public class App5_1 {
	public static void main(String[] args) {
		int[] a=new int[5];
		for (int i = 0; i < a.length ; i++) {
			a[i]=i;
		}
		for (int i = a.length - 1 ; i >= 0 ; i--) {
			System.out.println(a[i]);
		}
	}
}
