package temp01;

public class Person {

	public String name;
	public String sex;
	
	public String getName(){
		return name;
	}
	
	public void setName(String _name){
		this.name = _name;
	}
	
	public String getSex(){
		return sex;
	}
	
	public void setSex(String _sex){
		this.sex = _sex;
	}
	
	public Person(String _name, String _sex){
		name =  _name;
		sex = _sex;
	}
	
}