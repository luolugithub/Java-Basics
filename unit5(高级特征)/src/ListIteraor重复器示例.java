import java.util.*;
public class ListIteraor�ظ���ʾ�� {
	public static void main(String[] args){
		List<Integer>list =new ArrayList<Integer>();
		for(int i=0;i<5;i++){//��list�����Ԫ��
			list.add(new Integer(i));
		}
		System.out.println("the original list :"+list);
		
		ListIterator<Integer>listIter=list.listIterator();//create the iterator of list
		listIter.add(new Integer(0));//add an elem before the zero enem
		System.out.println("after add at the begining:"+list);
		
		if(listIter.hasNext()){
			int i=listIter.nextIndex();//i will be 1
			listIter.next(); //return the 1 elems
			listIter.set(new Integer(9));//�޸�list�����Ϊ1��Ԫ��
			System.out.println("after set at"+i+":"+list);
		}
		if(listIter.hasNext()){
			int i=listIter.nextIndex(); //i��ֵ��Ϊ2
			listIter.next();
			listIter.remove();//ɾ�����Ϊ2��Ԫ��
			System.out.println("after remove at"+i+":"+list);
		}
	}
}
