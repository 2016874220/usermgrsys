package App;
class Cylinda{
	double radius;
	int height;
	double pi=3.14;
	
	//double area=pi*radius*radius;
	double area(){
		return pi*radius*radius;
	}
	//double volume=area*height;
	double volume(){
		return area()*height;
	}
}

public class App6_3 {
	public static void main(String[] args) {
		Cylinda volu=new Cylinda();        //创建新的对象
		volu.radius=2.8;
		volu.height=5;
		System.out.println("底圆半径="+volu.radius);
		System.out.println("圆柱高="+volu.height);
		System.out.println("圆柱底面积="+volu.area());
		System.out.println("圆柱体体积="+volu.volume());
	}
}

//运行结果：
//底圆半径=2.8
//圆柱高=5
//圆柱底面积=0.0
//圆柱体体积=0.0