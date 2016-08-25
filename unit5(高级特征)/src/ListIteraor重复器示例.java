import java.util.*;
public class ListIteraor重复器示例 {
	public static void main(String[] args){
		List<Integer>list =new ArrayList<Integer>();
		for(int i=0;i<5;i++){//向list中添加元素
			list.add(new Integer(i));
		}
		System.out.println("the original list :"+list);
		
		ListIterator<Integer>listIter=list.listIterator();//create the iterator of list
		listIter.add(new Integer(0));//add an elem before the zero enem
		System.out.println("after add at the begining:"+list);
		
		if(listIter.hasNext()){
			int i=listIter.nextIndex();//i will be 1
			listIter.next(); //return the 1 elems
			listIter.set(new Integer(9));//修改list中序号为1的元素
			System.out.println("after set at"+i+":"+list);
		}
		if(listIter.hasNext()){
			int i=listIter.nextIndex(); //i的值将为2
			listIter.next();
			listIter.remove();//删除序号为2的元素
			System.out.println("after remove at"+i+":"+list);
		}
	}
}
