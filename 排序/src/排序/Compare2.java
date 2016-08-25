package 排序;
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
		
		System.out.println("快排："+time1+"\n三向切分："+time2+"\nBM快速三向切分:"+time3);
	}
	public static void main(String[] args){
		
		int[] a=new int[60010];	//无重复数据
		int[] b=new int[60010]; //有少量重复数据
		int[] c=new int[60010]; //有大量重复数据，即仅有几个元素
		int[] d=new int[60010]; //全部重复
		Random rdm=new Random();
		for(int i=0;i<60000;i++){
			a[i]=rdm.nextInt();
			b[i]=rdm.nextInt()/10;
			c[i]=rdm.nextInt()/10000;
			d[i]=2;
		}
		
		System.out.println("三种排序算法对于“相同规模但构成不同的数据”进行排序所用的时间:\n数据规模：60000\n");
		
		System.out.println("无重复数据:");
			Time(a);
		System.out.println("\n有少量重复数据:");
			Time(b);
		System.out.println("\n有大量重复数据,即仅有几个元素:");
			Time(c);
		System.out.println("\n全部重复:");
			Time(d);
	}
}