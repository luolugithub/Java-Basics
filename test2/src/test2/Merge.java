package test2;

public class Merge{
private static Comparable[] aux;
public static void merge(Comparable[] a,int begin ,int mid,int end){  }
public static void sort(Comparable[] a){
    aux = new Comparable[a.length];       //��ʼ�����鳤��
    sort(a,0,a.length-1);
}
public static void sort(Comparable[] a,int begin,int end){
//�Ӽ�����������ݹ�����У�ÿ���жϣ����أ����ݶ������ջ�У�Ȼ�������Ƚ������ɺϲ�����
   if(end <= begin) return;            //������鱾����ȷ���˳�
   int mid = begin+(end-begin)/2;     
   sort(a,mid+1,end);                //�Ժ�벿�ֽ�������
}
public static void show(Comparable [] a){
        for(int i=0;i<a.length;i++){
           System.out.print(a[i]+"��");
        }
    }
public static void main(String[] args) {
         String[] a ={"aaa","eee","qqq","ooo","ppp","www","nnn","mmm"};
         sort(a);
         show(a);
    }
}