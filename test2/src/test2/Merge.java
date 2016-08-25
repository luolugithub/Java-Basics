package test2;

public class Merge{
private static Comparable[] aux;
public static void merge(Comparable[] a,int begin ,int mid,int end){  }
public static void sort(Comparable[] a){
    aux = new Comparable[a.length];       //初始化数组长度
    sort(a,0,a.length-1);
}
public static void sort(Comparable[] a,int begin,int end){
//子集排序，在这个递归过程中，每次中断，返回，数据都会加入栈中，然后依据先进后出完成合并操作
   if(end <= begin) return;            //如果数组本身不正确，退出
   int mid = begin+(end-begin)/2;     
   sort(a,mid+1,end);                //对后半部分进行排序
}
public static void show(Comparable [] a){
        for(int i=0;i<a.length;i++){
           System.out.print(a[i]+"、");
        }
    }
public static void main(String[] args) {
         String[] a ={"aaa","eee","qqq","ooo","ppp","www","nnn","mmm"};
         sort(a);
         show(a);
    }
}