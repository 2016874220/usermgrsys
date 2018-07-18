package MidExam;

/**
 *以Action接口来实现Doit类，Doit用以输出句子的谓语和状语
 */
public class Doit implements Action{
	
	/**
	 * 声明一个抽象类的属性doit，代表输出语句中的动作——“上大学”
	 */
	private String doit;

	/**
	 * 定义方法返回doit值
	 */
	public String getName() {
		return doit;
	}

	/**
	 * 定义方法
	 */
	public void setName(String _doit) {
		
		/**
		 * 用this访问成员变量doit，并给其赋值
		 */
		this.doit = _doit;
	}
	
	/**
	 * 定义无参数的构造方法Doit
	 */
	public Doit(){
		
	}
	
	/**
	 * 构造方法的重载
	 */
	public Doit(String _doit){
		
		/**
		 * this以引用该类的成员变量
		 */
		this.doit= _doit;
	}

	/**
	 * 实现接口中的act()方法
	 */
	@Override public void act(Address ad) {
		
		System.out.println("在"+ad.getName()+doit);
		
	}

}
