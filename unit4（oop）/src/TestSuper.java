//通过super关键字实现对父类构造方法与成员方法的访问
class Employee{
	private String name;
	private int salary;
	public Employee(String name,int salary){
		this.name=name;
		this.salary=salary;
	}
	public String getDetails(){
		return "name:"+name+"\nsalary:"+salary;
	}
}
//定义Employee的子类Manager
class Manager extends Employee{
	private String department;
	public Manager(String name,int salary,String department){
		super(name,salary);			//调用父类Emloyee的构造方法
		this.department=department;
	}
	public String getDetails(){
		//调用父类Employee的成员方法
		return super.getDetails()+"\nDepartment:"+ department;
	}
}
public class TestSuper {
	public static void main(String[] args){
		Manager m=new Manager("Tom",2000,"Finance");
		System.out.println(m.getDetails());
	}

}
