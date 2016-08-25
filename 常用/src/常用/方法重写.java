/* 1.子类重写方法返回值与父类相同
 * 2.子类重写方法访问权限不能缩小
 * 3.子类不能抛出异常
 * 4.注意两个salary的显示结果
 */
package 常用;
class Employee{
	String name;
	int salary;
	public Employee(String name,int salary){  //构造方法
		this.name=name;
		this.salary=salary;
	}
	public String getDetails(){  //定义方法
		return "Name:"+name+"\nsalary"+salary;
	}
}

class Manager extends Employee{   //继承父类
	protected String department;
	public Manager(String name,int salary,String department){
		super(name,salary);    //引用父类构造方法
		this.department=department;
	}
	public String getDetails(){   //重写父类中的该方法
		return "\nname："+name+"\nsalary:"+salary;
	}
}
class Secretary extends Employee{
	public Secretary(String name,int salary){
		super(name,salary);
	}
}
public class 方法重写 {
	public static void main(String[] args){
		Manager m=new Manager("Tom",2000,"Finance");
		Secretary s=new Secretary("Mary",1500);
		System.out.println(m.getDetails());
		System.out.println(s.getDetails());
	}

}
