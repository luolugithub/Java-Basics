import java.util.*;
public class 泛型集合类使用测试 {
	public static void main(String args[]){
		List<Integer> listofInteger=new LinkedList<Integer>();
		listofInteger.add(new Integer(2000));
		listofInteger.add(8);
		Integer x=listofInteger.get(0);
		System.out.println(x);
		x=listofInteger.get(1);
		System.out.println(x);
	}

}
