package MidExam;

/**
 * 
 * 定义一个抽象类Person，里面包括一些人的属性，如姓名name
 *
 */
public abstract class Person {
	
	/**
	 * Person的属性之一——姓名name
	 */
	private String name;
	
	/**
	 * 定义无参数的构造方法Person
	 */
	public Person(){
		
	}
	
	/**
	 * 构造方法的重载
	 */
	public Person(String _name){
		
		/**
		 * this以引用该类的成员变量
		 */
		this.name = _name;
	}

	/**
	 * 定义方法
	 */
	public void setName(String _name) {
		
		/**
		 * 用this访问成员变量name，并给其赋值
		 */
		this.name = _name;
	}
	
	/**
	 * 定义方法返回name值
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 声明抽象方法
	 */
	public abstract void doSomthing(Address ad,Action ac);

}