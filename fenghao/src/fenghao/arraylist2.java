package fenghao;

import java.lang.Object;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
//import java.util.*;
class MyArrayList extends AbstractList<Object> implements List<Object> {
 private Object [] obj = null;//创建一个数组用来存储数据
 private int size = 0;//集合的长度
 private int count=1 ;//控制新生成数组的长度的变量
 public MyArrayList(int a){
  size = a;
  obj = new Object[a];
 }
 public MyArrayList(){
  this(10);
 }
 public Object get(int index) { //获得index的值
  checkValue(index); 	
  return obj[index];
 }
 public int size() {  //获得数组大小
  return obj.length-1;
 } 
 private void checkValue(int index){
  if(index>size||index<0){
   new IndexOutOfBoundsException();
  }
 }
 public boolean add(Object e){ // 添加元素
  obj[count-1] = e;
  Object [] o = Arrays.copyOf(obj,++count);
  obj = o;
  return true;
 }
 public Object remove(int index){ //移除index处元素
  Object object = obj[index];
  obj[index] = null;
  obj = Arrays.copyOf(obj, size());
  return object;
 }
 public void clearAll(){  //清空此数组
  obj = null;
 }
}
/*long start = System.currentMillSeconds();//计时函数
long end = System.currentMillSeconds();
long costtime = end - start;*/
public class arraylist2{
	public static void main(String args[]){
		long start1 = System.currentTimeMillis();
	    ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i=0;i<100000;i++)
			a.add(i);
		long end1 = System.currentTimeMillis();
		long costtime1 = end1 - start1;		//ArrayList用时
		long start2 =System.currentTimeMillis();
		MyArrayList b=new MyArrayList();
		for(int i=0;i<100000;i++)
			b.add(i);
		long end2 = System.currentTimeMillis();
		long costtime2 = end2 - start2;   //MyArrayList用时
		double s=(double)costtime1/(double)costtime2;
		System.out.println("效率:"+s);
	}
}