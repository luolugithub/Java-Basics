package 常用;

import java.util.*;
//package 常用;
interface Shape{ //将shape定义为接口 关键词
	void draw();
	void erase();
}
class circle implements Shape{  //定义circle类实现接口shape
	public void draw(){
		System.out.print("calling circle.draw()");
	}
	public void erase(){
		System.out.print("calling circle.erase()");
	}
	
}
public class 接口实现多态示例 {
	public static void main(String args[]){
		Random rand=new Random();
		Shape[] s=new Shape[9];
		for(int i=0;i<s.length;i++){
			switch(rand.nextInt(3)){
			case 0:s[i]=new circle();break;
			}
		}
	}
}
