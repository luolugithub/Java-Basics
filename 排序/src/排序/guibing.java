package ����;
public class guibing {
	private static Comparable[] aux;// �鲢����ĸ�������
	public static void merge(Comparable[] a,int lo,int mid,int hi)
	{//a[lo..mid]��a[mid+1..hi]�鲢
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)
		{
			aux[k]=a[k];
		}
		for(int k=lo;k<=hi;k++)
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(less(aux[j],aux[i])) a[k]=aux[j++];
			else a[k]=aux[i++];
	}
	public static void sort(Comparable[] a)//�Զ����¹鲢����
	{
		aux=new Comparable[a.length];//һ���Է���ռ�
		sort(a,0,a.length-1);
	}
	private static void sort(Comparable[] a,int lo,int hi){
		if(hi<=lo) return;
		int mid=lo+(hi-lo)/2;
		sort(a,lo,mid);//��������
		sort(a,mid+1,hi);//�Ұ������
		merge(a,lo,mid,hi);
	}
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	public static void main(String[] args){
		
	}
}
