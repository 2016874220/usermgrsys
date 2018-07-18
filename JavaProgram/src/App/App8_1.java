package App;
class person{
	static String name = "XXX";
	private int age;
	public void Preson(){
	System.out.println("AAAAAAAAAAAAAA");
	}
	public void Person(String _name){
		name = _name;
		System.out.println("EEEEEEEEEEEEEEE");
	}
	public void Preson(String _name, int _age){
		name = _name;
		age = _age;
		System.out.println("CCCCCCCCCCCCCCCCCC");
	}
	public void show(){
		System.out.println("name="+name+"  age=  "+age);
	}
	public void setName(String _name){
		name = _name;
	}
	public String getName(){
		return(name);
	}
}

class Student extends person{
	private String age;
	public String str;
	private String department;
	public Student(){
		System.out.println("BBBBBBBBBBBBBBBB");
	}
	public Student(String _department){
		department = _department;
		System.out.println("FFFFFFFFFFFFFFFF");
	}
	public Student(String _name,int _age,String _department){
		super();
		department = _department;
		age = "DDD";
		department = _department;
		System.out.println("DDDDDDDDDDDDDDDDDD    "+age+"   "+department);
	}
	public void setDepartment(String _department){
		department = _department;
		System.out.println(department);
		System.out.println(this.getName());
	}
	public void show(){
		super.show();
		System.out.println("name= "+name+"  age=  "+age+"department= "+department);
	}
	public void sshow(){
		System.out.println("department= "+department);
	}
}

public class App8_1 {
	public static void main(String[] args) {
		person s = new Student("ZZZ",8,"AAA");
		Student ss = (Student)s;
		//s.show();
	}
}
