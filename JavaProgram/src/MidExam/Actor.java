package MidExam;

/**
 *定义继承自Person的子类Actor，Actor代表输出语句中的主语——“我”
 */
public class Actor extends Person {
	
	/**
	 * 定义无参数的构造方法Actor
	 */
	public Actor(){
		
	}
	
	/**
	 * 构造方法的重载
	 */
	public Actor(String name){
		
		/**
		 * super用于调用父类的构造方法
		 */
		super(name);
	}
	
	/**
	 * 实现抽象类中的doSomething()方法
	 */
	public void doSomthing( Address ad,Action ac) {
		System.out.print(this.getName());
		ac.act(ad);
	}

}
