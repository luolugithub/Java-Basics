package ����;
//import java.util.ArrayList;
import java.util.*;
public class Compare2 {
	public static void Time(int[] a){
		long start1 = System.currentTimeMillis();
		Quick.sort(a);
		long end1 = System.currentTimeMillis();
		long time1=end1-start1;
		
		long start2 = System.currentTimeMillis();
		Quick3way.sort(a);
		long end2 = System.currentTimeMillis();
		long time2=end2-start2;
		
		long start3 = System.currentTimeMillis();
		//Quick.sort(a);
		long end3 = System.currentTimeMillis();
		long time3=end3-start3;
		
		System.out.println("���ţ�"+time1+"\n�����з֣�"+time2+"\nBM���������з�:"+time3);
	}
	public static void main(String[] args){
		
		int[] a=new int[60010];	//���ظ�����
		int[] b=new int[60010]; //�������ظ�����
		int[] c=new int[60010]; //�д����ظ����ݣ������м���Ԫ��
		int[] d=new int[60010]; //ȫ���ظ�
		Random rdm=new Random();
		for(int i=0;i<60000;i++){
			a[i]=rdm.nextInt();
			b[i]=rdm.nextInt()/10;
			c[i]=rdm.nextInt()/10000;
			d[i]=2;
		}
		
		System.out.println("���������㷨���ڡ���ͬ��ģ�����ɲ�ͬ�����ݡ������������õ�ʱ��:\n���ݹ�ģ��60000\n");
		
		System.out.println("���ظ�����:");
			Time(a);
		System.out.println("\n�������ظ�����:");
			Time(b);
		System.out.println("\n�д����ظ�����,�����м���Ԫ��:");
			Time(c);
		System.out.println("\nȫ���ظ�:");
			Time(d);
	}
}