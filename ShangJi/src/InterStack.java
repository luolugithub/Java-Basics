import java.util.ArrayDeque;
import java.util.Deque;
 
public class InterStack {
  private Deque<Character> data = new ArrayDeque<Character>();
 
  public void push(char element) {
    data.addFirst(element);
  }
 
  public char pop() {
    return data.removeFirst();
  }
  public String toString() {
    return data.toString();
  }
 
  public static void main(String[] args) {
	  String ss="+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
	  int len=ss.length();
		char c,d;
		InterStack stack = new InterStack();
		for(int i=0;i<len;i++){
			//if(i-1>=0)
			//	f=ss.charAt(i);
			//if(i>=0&&i-1<=len)
				d=ss.charAt(i+1);
			c=ss.charAt(i);
			if(c=='+'){
				stack.push(d);
				}
			else if(c=='-'){
				System.out.print(stack.pop());
				
			}
    }
  }
}