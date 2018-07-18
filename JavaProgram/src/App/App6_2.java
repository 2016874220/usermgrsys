package App;
//filename App6_2.java 
class Cylindaa{
	double radius;
	int height;
	double pi=3.14;
	int area(){
		System.out.println("圆柱底面积="+pi*radius*radius);
		return height;
	}
	double volume(){
		return (pi*radius*radius)*height;
	}
}

//void setCylinda(double _radius,int _height,double _pi){ //1、"_"代码美学 2、以变量为参数
//		this.radius=_radius;     //this：对象的引用，特指成员变量，不指向参数里的radius
//	}

public class App6_2 {             //测试类
	public static void main(String[] args) {
		Cylindaa volu1=new Cylindaa();
		Cylindaa volu2=new Cylindaa();
		volu1.radius=volu2.radius=2.5;
		volu2.pi=3;
		System.out.println("修改前：");
		System.out.println("圆柱pi值="+volu1.pi);
		System.out.println("圆柱底半径="+volu1.radius);
		volu1.area();
		System.out.println("修改后：");
		System.out.println("圆柱pi值="+volu2.pi);
		System.out.println("圆柱底半径="+volu2.radius);
		volu2.area();
	}
}
