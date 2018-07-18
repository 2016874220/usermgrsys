package MidExam;

/**
 *声明主类
 */
public class Text {

	public static void main(String[] args) {
		
		/**
		 * 创建per对象
		 */
		Teach per=new Teach("我");
		
		/**
		 * 创建ac_doit对象
		 */
		Doit ac_doit=new Doit();
		/**
		 * 调用setName()方法
		 */
		ac_doit.setName("上大学");
		/**
		 * 创建ad_doit对象
		 */
		Address ad_doit=new Address();
		/**
		 * 调用setName()方法
		 */
		ad_doit.setName("湛江");
		
		/**
		 * 调用doSomething()方法
		 */
		per.doSomthing(ad_doit,ac_doit);
		
	}
}
