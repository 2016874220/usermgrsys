package App;
//利用构造方法来初始化圆柱体的成员变量

class Cylinderrrr{                           //定义类
	private double radius;
	private int height;
	private double pi = 3.14;
	public Cylinderrrr(double r,int h){     //定义有参数的构造方法
		radius = r;
		height = h;
	}
	double area(){
		return pi*radius*radius;
	}
	double volume(){
		return area()*height;
	}
}

public class App7_4 {
	public static void main(String[] args) {
		Cylinderrrr volu = new Cylinderrrr(3.5,8);        //调用有参构造方法创建对象
		System.out.println("圆柱体面积="+volu.area());
		System.out.println("圆柱体积="+volu.volume());
	}
}
