package algorithms2;

import java.util.Random;  
import java.util.Scanner; 
public class Compare2 {
		public static void Quick3way_sort(int[] a,int lo,int hi){	//快速三向切分
			if(hi<=lo) return;
			int lt=lo,i=lo+1,gt=hi;
			int v=a[lo];
			while(i<=gt){
				int cmp=less(a[i],v);
				if(cmp<0) exch(a,lt++,i++);
				else if(cmp>0) exch(a,i,gt--);
				else i++;
			}
			Quick3way_sort(a,lo,lt-1);
			Quick3way_sort(a,gt+1,hi);
		}
		public static void Quick_Sort(int[] a,int lo,int hi){ //quicksort
			if(hi<=lo) return;
			int mid=lo+(hi-lo)/2;
			Quick_Sort(a,lo,mid);
			Quick_Sort(a,mid+1,hi);
			qie_sort(a,lo,mid,hi);
		}
		public static void qie_sort(int[] a,int lo,int mid,int hi){ //切分时处理
			int[] aux = new int[a.length];
			int i=lo,j=hi;
			for(int k=lo;k<=hi;k++){      
				if(k>mid) 
					aux[k]=a[hi-(k-mid-1)];//倒序
				else 
					aux[k]=a[k];
			}
			for(int k=lo;k<=hi;k++){
				if(i>j) 
					break;          //判断结束
				else if(aux[i]<=aux[j]) 
						a[k]=aux[i++];
				else  	a[k]=aux[j--];
			}
		}
		public static void BMQuick_sort(int[] a,int lo,int hi){//BM三向切分
				if(hi<=lo) return;
				else if(hi-lo<=7) {
					//int mid=lo+(hi-lo)/2;
					Insert_sort(a,lo,hi);	//如果数据规模较小，则用插入排序
				}
				else if(hi-lo<40){
					int k=(hi-lo)/3;
					int mid=partition(a,(lo+hi)/2+k,(lo+hi)/2-k,(lo+hi)/2);	//切分处
					quick(a,lo,mid,hi);		//数据规模较大，则用快速排序
				}
				else{
					int k1=(hi-lo)/5;
					int mid1=partition(a,(lo+hi)/2+k1+1,(lo+hi)/2-k1-1,(lo+hi)/2);
					int mid2=partition(a,(lo+hi)/2+k1*2,(lo+hi)/2+k1,(lo+hi)/2+1);
					int mid3=partition(a,(lo+hi)/2-k1*2,(lo+hi)/2-k1,(lo+hi)/2-1);
					int mid=partition(a,mid1,mid2,mid3);
					quick(a,lo,mid,hi);
				}
		}
		public static void  Insert_sort(int[] a,int lo,int hi){	//插入排序，数据量较小时
			int N=hi;
			for(int i=lo;i<N;i++){
				for(int j=i;j>0&&(a[j]<a[j-1]);j--){
					int ack=a[j-1];
					a[j-1]=a[j];
					a[j]=ack;
				}
			}
		}
		public static int  partition(int a[],int m,int n,int k){ 	//数组切分，找到切分处
			if(a[m]>a[n]){
				if(a[n]>a[k])
					return n;
				else
					return k;
			}
			else{
				if(a[m]>a[k]) return m;
				else return k;
			}
		}
		public static void quick(int[] a,int lo,int mid,int hi){	//切分快排
			if(hi<=lo) return;
			exch(a,lo,mid);
			int lt=lo,i=lo+1,gt=hi;
			int v=a[lo];
			while(i<=gt){
				int cmp=less(a[i],v);
				if(cmp<0) exch(a,lt++,i++);
				else if(cmp>0) exch(a,i,gt--);
				else i++;
			}
			BMQuick_sort(a,lo,lt-1);
			BMQuick_sort(a,gt+1,hi);
		}
		public static int less(int a,int b){ //比较两数大小
			if(a>b) return 1;
			else if(a<b) return -1;
			else return 0;
		}
		public static void exch(int[] a,int m,int n){ // 交换
			int k=a[m];
			a[m]=a[n];
			a[n]=k;
		}
		public static void Time(int[] a,int N){
			double start=System.currentTimeMillis();;
			Quick_Sort(a,0,N-1);
			double end=System.currentTimeMillis();
			System.out.println("普通快排时间："+(end-start)+"ms");
		   
			double start2=System.currentTimeMillis();
			Quick3way_sort(a,0,N-1);
			double end2=System.currentTimeMillis();
			System.out.println("三向切分时间："+(end2-start2)+"ms");
			
			double start3=System.currentTimeMillis();
			BMQuick_sort(a,0,N-1);
			double end3=System.currentTimeMillis();
			System.out.println("BMQuick_sort时间："+(end3-start3)+"ms");
		}
	public static void main(String[] args){
		
		System.out.println("三种排序算法对于“相同规模但构成不同的数据”进行排序所用的时间：");
		System.out.println("请输入要排序的数据规模（>=50000）:");
		
		Scanner input=new Scanner(System.in);
		int N=input.nextInt(); 	//输入数据规模
		
		int[] a=new int[N+1];	//无重复数据
		int[] b=new int[N+1];   //有少量重复数据
		int[] c=new int[N+1]; 	//有大量重复数据，即仅有几个元素
		int[] d=new int[N+1]; 	//全部重复
		Random rdm=new Random();
		for(int i=0;i<N;i++){
			a[i]=rdm.nextInt();
			b[i]=rdm.nextInt()/10;
			c[i]=rdm.nextInt()/10000;
			d[i]=2;
		}
	
		System.out.println("无重复数据:");
			Time(a,N);
		System.out.println("\n有少量重复数据:");
			Time(b,N);
		System.out.println("\n有大量重复数据,即仅有几个元素:");
			Time(c,N);
		System.out.println("\n全部重复:");
			Time(d,N);		
	}
}

