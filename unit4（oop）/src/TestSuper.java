//ͨ��super�ؼ���ʵ�ֶԸ��๹�췽�����Ա�����ķ���
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
//����Employee������Manager
class Manager extends Employee{
	private String department;
	public Manager(String name,int salary,String department){
		super(name,salary);			//���ø���Emloyee�Ĺ��췽��
		this.department=department;
	}
	public String getDetails(){
		//���ø���Employee�ĳ�Ա����
		return super.getDetails()+"\nDepartment:"+ department;
	}
}
public class TestSuper {
	public static void main(String[] args){
		Manager m=new Manager("Tom",2000,"Finance");
		System.out.println(m.getDetails());
	}

}
