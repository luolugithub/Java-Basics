/* 1.������д��������ֵ�븸����ͬ
 * 2.������д��������Ȩ�޲�����С
 * 3.���಻���׳��쳣
 * 4.ע������salary����ʾ���
 */
package ����;
class Employee{
	String name;
	int salary;
	public Employee(String name,int salary){  //���췽��
		this.name=name;
		this.salary=salary;
	}
	public String getDetails(){  //���巽��
		return "Name:"+name+"\nsalary"+salary;
	}
}

class Manager extends Employee{   //�̳и���
	protected String department;
	public Manager(String name,int salary,String department){
		super(name,salary);    //���ø��๹�췽��
		this.department=department;
	}
	public String getDetails(){   //��д�����еĸ÷���
		return "\nname��"+name+"\nsalary:"+salary;
	}
}
class Secretary extends Employee{
	public Secretary(String name,int salary){
		super(name,salary);
	}
}
public class ������д {
	public static void main(String[] args){
		Manager m=new Manager("Tom",2000,"Finance");
		Secretary s=new Secretary("Mary",1500);
		System.out.println(m.getDetails());
		System.out.println(s.getDetails());
	}

}
