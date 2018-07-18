package MidExam;

/**
 *定义继承自Person的子类Teach
 */
public class Teach extends Person{

	/**
	 * 定义无参数的构造方法Teach
	 */
	public Teach() {
		
		/**
		 * super用于调用父类的构造方法
		 */
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造方法的重载
	 */
	public Teach(String name) {
		
		/**
		 * super用于调用父类的构造方法
		 */
		super(name);
	}
	
	/**
	 * 实现抽象类中的doSomething()方法
	 */
	@Override public void doSomthing(Address ad, Action ac) {
		// TODO Auto-generated method stub
		System.out.print(this.getName());
		ac.act(ad);
	}

}
