package ����;
import java.util.*;
/**
 * @author feng
 *
 */
class deal{
	public static void main(String args[]){
		int numhands=Integer.parseInt(args[0]);
		int cardsperhand=Integer.parseInt(args[1]);
		//����һ��ֽ��
		String[] suit=new String[]{"spades","hearts","diamonds","clubs"};
		String[] rank=new String[]{
				"ace","2","3","4","5","6","7","8","9","10","jack","queen","King"
		};
		List<String> deck=new ArrayList<String>();
		for(String ss:suit)
			for(String sr:rank)
				deck.add(sr+"of"+ss);
		Collections.shuffle(deck);
		for(int i=0;i<numhands;i++)
			System.out.println(dealhand(deck,cardsperhand));//ϴ��
	}

public static List dealhand(List<String>deck,int n) {
		int deckSize=deck.size();
		//��deck�н�ȡһ������
		List<String>handview=deck.subList(deckSize-n,deckSize);
		List<String>hand=new ArrayList<String>(handview);
		handview.clear();
		return hand;
	}
}
