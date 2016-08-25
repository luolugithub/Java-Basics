import java.util.LinkedList;

public class stack {

 static LinkedList l = new LinkedList();

 public static void main(String[] args) {
  for (int i = 0; i < 10; i++) {
   stack.add(i);
  }
  System.out.print("栈中的初始元素为:" + l + "\n");
  System.out.println("向栈添加元素10和11");
  stack.add(10);
  stack.add(11);
  System.out.println("添加后栈中的元素为:" + l + "\n");
  int listsize = l.size();
  for (int i = 0; i < listsize; i++)
   System.out.println("取出元素" + stack.get() + "后栈中元素为：" + l);
 }

 public static Object get() {
  return l.removeLast();
 }

 public static void add(Object obj) {
  l.addLast(obj);
 }
}