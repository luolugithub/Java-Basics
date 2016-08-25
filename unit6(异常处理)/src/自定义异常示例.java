class myexception extends Exception{
	myexception(){}
	myexception(String msg){
		super(msg);
	}
}
class usingmyexception{
	void f() throws myexception{
		System.out.println("throw exception from f()");
		throw new myexception();
	}
	void g() throws myexception{
		System.out.println("throw exception from g()");
		throw new myexception();
	}
}
public class 自定义异常示例 {
	public static void main(String args[]){
		usingmyexception m=new usingmyexception();
		try{
			m.f();
		}catch(myexception e){
			e.printStackTrace();
		}
		try{
			m.g();
		}catch(myexception e){
			e.printStackTrace();
		}
	}
}
