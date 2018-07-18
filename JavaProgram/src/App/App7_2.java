package App;
//创建圆柱体类Cylinder的公共成员方法，来访问类内的私有成员变量

class Cylinderr{
	private double radius;                               //声明私有数据成员
	private int height;
	private double pi=3.14;
	public void setCylinder(double r,int h){            //通过该公共方法访问私有成员radius和height
		if(r>0&&h>0){
			radius=r;
			height=h;
		}
		else
			System.out.println("您的数据有错误！！");
	}
	double area(){
		return pi*radius*radius;                       //类内可访问私有成员
	}
	double volume(){
		return area()*height;
	}
}

public class App7_2 {                                        //定义公共主类
	public static void main(String[] args) {
		Cylinderr volu = new Cylinderr();
		volu.setCylinder(2.5, -5);
		System.out.println("圆柱体底面积="+volu.area());        //访问私有数据
		System.out.println("圆柱体体积="+volu.volume());
	}
}