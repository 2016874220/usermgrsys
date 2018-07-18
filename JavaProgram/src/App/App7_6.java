package App;
//从一个构造方法调用另一个构造方法（this关键字的运用）

class Cylinderrrrrr{
	private double radius;
	private int height;
	private double pi = 3.14;
	private String color;
	public Cylinderrrrrr(){
		this(2.2,5,"brown");                               //用this关键字来调用另一构造方法
		System.out.println("无参构造方法被调用了");
	}
	public Cylinderrrrrr(double _r,int _h,String _str){
		System.out.println("有参构造方法被调用了");
		radius = _r;
		height = _h;
		color = _str;
	}
	public void show(){
		System.out.println("圆柱体半径：" + radius);
		System.out.println("圆柱体高：" + height);
		System.out.println("圆柱体颜色：" + color);
	}
	double area(){
		return pi*radius*radius;
	}
	double volume(){
		return area()*height;
	}
}

public class App7_6 {
	public static void main(String[] args) {
		Cylinderrrrrr volu=new Cylinderrrrrr();               //运行这一行时，搜索Cylinder类中的Cylinder构造方法
		System.out.println("圆柱体面积="+volu.area());
		System.out.println("圆柱体积="+volu.volume());
		volu.show();
	}
}
