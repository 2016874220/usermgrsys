package App;
//利用方法的重载来设置成员变量

class Cylinderrr{
	private double radius;
	private int height;
	private double pi = 3.14;
	private String color;
	public double setCylinder(double r,int h){         //重载方法
		radius = r;
		height = h;
		return r + h;
	}
	public void setCylinder(String str){              //重载方法
		color = str;
	}
	public void show(){
		System.out.println("圆柱体的颜色："+color);
	}
	double area(){
		return pi*radius*radius;
	}
	double volume(){
		return area()*height;
	}
}

public class App7_3 {
	public static void main(String[] args) {
		Cylinderrr volu = new Cylinderrr();
		//System.out.println(volu.setCylinder(2.5, 3));
		double sum = volu.setCylinder(2.5, 3);           //为了输出“圆柱体半径和高之和=”，定义了sum
		System.out.println("圆柱体半径和高之和="+sum);
		volu.setCylinder("gray");                        //输入颜色
		volu.show();                                     //输出颜色
		System.out.println("圆柱体面积="+volu.area());
		System.out.println("圆柱体积="+volu.volume());
	}
}