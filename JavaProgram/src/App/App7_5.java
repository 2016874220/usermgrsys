package App;
//使用构造方法的重载

class Cylinderrrrr{                        //定义类Cylinder
	private double radius;
	private int height;
	private double pi = 3.14;
	private String color;
	public Cylinderrrrr(){                //定义无参数的构造方法，来对变量进行赋值
		radius = 1;
		height = 2;
		color = "green";
	}
	public Cylinderrrrr(double r,int h,String str){          //定义有三个参数的构造方法，来访问私有成员变量
		radius = r;
		height = h;
		color = str;
	}
	public void setColor(){
		System.out.println("该圆柱体颜色为："+color);
	}
	double area(){
		return pi*radius*radius;
	}
	double volume(){
		return area()*height;
	}
}

public class App7_5 {
	public static void main(String[] args) {
		Cylinderrrrr volu1 = new Cylinderrrrr();                  //第一个Cylinder表示类，第二个为构造方法名
		System.out.println("圆柱体1底面积="+volu1.area());
		System.out.println("圆柱体体积="+volu1.volume());
		volu1.setColor();
		Cylinderrrrr volu2 = new Cylinderrrrr(1,2,"green");
		System.out.println("圆柱体2底面积="+volu2.area());
		System.out.println("圆柱体2体积="+volu2.volume());
		volu2.setColor();
	}
}
