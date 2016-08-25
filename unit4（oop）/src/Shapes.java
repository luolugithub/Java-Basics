//Java中的多态示例  运行时编译器将方法调用与方法体连接在一起，叫做 晚联编 技术，
//除了final定义的方法，其余所有方法均采用晚联编技术，每次运行结果会有所不同；
import java.util.*;

//定义Shape类
class Shape{
	void draw(){}
	void erase(){}
}

//定义Circle类
class Circle extends Shape{
	void draw(){
		System.out.println("Calling Circle.draw()");
	}
	void erase(){
		System.out.println("Calling Circle.erase()");
	}
}

//定义Square类
class Square extends Shape{
	void draw(){
		System.out.println("Calling Square.draw()");
	}
	void erase(){
		System.out.println("Calling Square.erase()");
	}
}

//定义Triangle类
class Triangle extends Shape{
	void draw(){
		System.out.println("Calling Triangle.draw()");
	}
	void erase(){
		System.out.println("Calling Triangle.erase()");
	}
}

//包含main()的测试类
public class Shapes {
	static void drawOneShape(Shape s){
		s.draw();
	}
	static void drawShapes(Shape[] ss){
		for(int i=0;i<ss.length;i++){
			ss[i].draw();
		}
	}
public static void main(String args[]){
	Random rand =new Random();
	Shape[] s=new Shape[9];
	for(int i=0;i<s.length;i++){
		switch(rand.nextInt(3)){
		case 0:s[i]=new Circle();break;
		case 1:s[i]=new Square();break;
		case 2:s[i]=new Triangle();break;
		}
	}
	drawShapes(s);
}
}
