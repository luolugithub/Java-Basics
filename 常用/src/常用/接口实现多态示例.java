package ����;

import java.util.*;
//package ����;
interface Shape{ //��shape����Ϊ�ӿ� �ؼ���
	void draw();
	void erase();
}
class circle implements Shape{  //����circle��ʵ�ֽӿ�shape
	public void draw(){
		System.out.print("calling circle.draw()");
	}
	public void erase(){
		System.out.print("calling circle.erase()");
	}
	
}
public class �ӿ�ʵ�ֶ�̬ʾ�� {
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
