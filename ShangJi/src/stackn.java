import java.util.ArrayDeque;
import java.util.Deque;

class linklist{
	private Deque<Character> stack = new ArrayDeque<Character>();
	public void chuli(String aa){
		int len=aa.length();
		char c,b = 0,f = 0;
		for(int i=0;i<len;i++){
			c=aa.charAt(i);
			if(i+1<len){
				b=aa.charAt(i+1);
			}				
			if(i-1>0)
				f=aa.charAt(i-1);
			if(c=='+'&&b!='+'&&b!='-'){
				stack.addFirst(aa.charAt(i+1));
			}
			if(c=='-'/*&&f!='-'*/&&f!='+')
				System.out.print(" "+stack.removeFirst());
		}
	}
}
public class stackn {
	public static void main(String args[]){
		String ss="+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
		linklist a=new linklist();
		a.chuli(ss);
	}
}
