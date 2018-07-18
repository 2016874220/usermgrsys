package temp01;

public class Test {
	
	public static void main(String[] args) {
		
		Student stu = new Student("我","女");
		Teacher tea = new Teacher("张立敏老师","男");
		
		Study sdy = new Study();
		Teach tch = new Teach();
		Address addr1 = new Address();
		Address addr2 = new Address();
		
		addr1.setName("湛江");
		addr2.setName("岭师");
		
		stu.doSomething(sdy, addr1);
		System.out.println();
		tea.doSomething(tch, addr2);
	}
	
}
