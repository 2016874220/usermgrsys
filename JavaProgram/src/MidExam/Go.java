package MidExam;

/**
 *以Action接口来实现Go类
 */
public class Go implements Action{
	
	/**
	 * 声明属性go
	 */
	public String go;

	/**
	 * 定义方法返回go值
	 */
	public String getName() {
		return go;
	}

	/**
	 * 定义方法
	 */
	public void setName(String _go) {
		
		/**
		 * 用this访问成员变量go，并给其赋值
		 */
		this.go = _go;
	}

	/**
	 * 实现接口中的act()方法
	 */
	@Override public void act(Address ad) {
		// TODO Auto-generated method stub
		
	}
		
}