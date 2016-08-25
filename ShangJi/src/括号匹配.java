import java.util.ArrayDeque;  
import java.util.Deque;  
  
public class ¿®∫≈∆•≈‰ {  
  
    public static void main(String[] args) {  
        Deque<Character> stack = new ArrayDeque<Character>();  
        String str = "ab12+[b2(eef)w-45tyf[lk6{zxc29hg}]]";  
        boolean flag = true;  
        char ch;  
        for(int i = 0; i < str.length(); i++) {  
            ch = str.charAt(i);  
            if(ch == '(' || ch == '[' || ch == '{') {  
                stack.offerFirst(ch);  
            }  
              
            else if(ch == ')') {  
                if(stack.peekFirst() != null && stack.peekFirst() == '(') {  
                    stack.pollFirst();  
                }  
                else {  
                    flag = false;  
                    break;  
                }  
            }  
            else if(ch == ']') {  
                if(stack.peekFirst() != null && stack.peekFirst() == '[') {  
                    stack.pollFirst();  
                }  
                else {  
                    flag = false;  
                    break;  
                }  
            }  
            else if(ch == '}') {  
                if(stack.peekFirst() != null && stack.peekFirst() == '{') {  
                    stack.pollFirst();  
                }  
                else {  
                    flag = false;  
                    break;  
                }  
            }             
        }  
          
        if(flag) {  
            flag = stack.isEmpty();  
        }  
        System.out.println(" «∑Ò∆•≈‰£∫" + flag);  
    }  
}  