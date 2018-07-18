package temp01;

public class Teacher extends Person {

	public Teacher(String _name, String _sex){
		super(_name,_sex);
	}
	
	public void doSomething(Action ac, Address _addr){
		System.out.print(this.name);
		ac.act(_addr);
	}
	
}
