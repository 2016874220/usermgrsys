package checkout;

public class Cylinda {
	public static void main(String[] args) {   //static：通过类名直接访问
		car c=new car();             //括号里可加参数（前提定义了函数，目前不能加）
		c.color="gray";
		//c.name="Cariol";
		//System.out.println(c.name);
		System.out.println(c.getName());  //通过另一种方式获取名字
	}
}

class car{
	private String name;            //私有访问控制符
	//String name;
	static String color;            //静态修饰符
	//final static String color="black";    //最终静态修饰符
	String date;
	String getName(){
		return name;
	}
	void setName(String _name){
		name=_name;
	}
}

abstract class BBB{
	abstract void aaa();
}