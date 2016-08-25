import java.util.*;
class Cage<E> extends LinkedList<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;};
class animal{
	public void feedme(){};
}
class lion extends animal{
	public void feedme(){
		System.out.print("feeding lions");
	}
}
class butterfly extends animal{
	public void feedme(){
		System.out.print("feeding butterfly");
	}
}
public class ����ͨ���ʹ��ʾ�� {
	public static void main(String args[]){
		����ͨ���ʹ��ʾ�� t=new ����ͨ���ʹ��ʾ��();
		Cage<lion> lionCage=new Cage<lion>();
		Cage<butterfly> butterfly=new Cage<butterfly>();
		lionCage.add(new lion());
		butterfly.add(new butterfly());
		t.feedanimals(lionCage);
		t.feedanimals(butterfly);
	}
	void feedanimals(Cage<? extends animal>someCage){
		for(animal a:someCage)
			a.feedme();
	}

}
