import java.util.LinkedList;

public class stack {

 static LinkedList l = new LinkedList();

 public static void main(String[] args) {
  for (int i = 0; i < 10; i++) {
   stack.add(i);
  }
  System.out.print("ջ�еĳ�ʼԪ��Ϊ:" + l + "\n");
  System.out.println("��ջ���Ԫ��10��11");
  stack.add(10);
  stack.add(11);
  System.out.println("��Ӻ�ջ�е�Ԫ��Ϊ:" + l + "\n");
  int listsize = l.size();
  for (int i = 0; i < listsize; i++)
   System.out.println("ȡ��Ԫ��" + stack.get() + "��ջ��Ԫ��Ϊ��" + l);
 }

 public static Object get() {
  return l.removeLast();
 }

 public static void add(Object obj) {
  l.addLast(obj);
 }
}