package Text;

class Person{
	//定义3个私有属性name、department和age
	private String name;
	private String department;
	private int age;
	static String action = "上大学";
	//三个重载的构造方法
	public Person(String _name)
	{
		this.name = _name;
	}
	
	public Person(String _name,int _age)
	{
		this.name = _name;
		if(_age>=0)
			this.age = _age;
		else
			System.out.println("输入不合法！");
	}
	
	public Person(String _name,int _age,String _department)
	{
		this.name = _name;
		if(_age>=0)
			this.age = _age;
		else
			System.out.println("输入不合法！");
		this.department = _department;
	}
	 //其他方法，其中一个为静态方法
	 public void setName(String _name) 
	 {
		 this.name = _name;
	 }
	 
	 public String getName() 
	 {
		 return this.name; 
	 } 
	 
	 public void setAge() 
	 {
		 this.age = age; 
	 } 
	 
	 public int getAge() 
	 {
		 return this.age; 
	 } 
	 
	 public void setDepartment() 
	 {
	     this.department = department; 
	 } 
	 
	 public String getDepartment() 
	 { 
	     return this.department;
     }
	 
	 public static void show(){
		 
	 }
}

public class text8
{
	public static void main(String[] args)
	{
		Person p = new Person("本人",20,"湛江");
		p.show();
		System.out.print("介绍：\n"+p.getName()+"今年"+p.getAge()+"岁"+","+"在"+p.getDepartment()+p.action);
	}
}

