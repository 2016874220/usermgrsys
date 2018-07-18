package MidExam;

/**
 * 定义Address类，Address代表输出语句中的地点状语
 */
public class Address {

	/**
	 * 封装私有变量name
	 */
	private String name;

	/**
	 * 定义方法返回name值
	 */
	public String getName() {
		return name;
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
	
}
