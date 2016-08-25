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
public class 泛型通配符使用示例 {
	public static void main(String args[]){
		泛型通配符使用示例 t=new 泛型通配符使用示例();
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
