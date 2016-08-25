package �ϻ�2;

import java.util.ArrayList;
import java.util.Arrays;    
class MyArrayList<E> implements java.io.Serializable{ 
    private static final long serialVersionUID = 1L;  
    private static final int MAX_SIZE = Integer.MAX_VALUE-1;   
    private int size;  //��������ʵ�ʴ�С
    private int currentSize = -1;  
    private Object[] elementData;   //���MyArrayList�����ݵĶ�������
    public MyArrayList(){  //Ĭ�Ϲ��췽��
        this(10);  
    }  
    public MyArrayList(int initCapacity){   // initCapacity ��ʼ������
        if(initCapacity < 0)  
            throw new ExceptionInInitializerError();  
        if(initCapacity > MAX_SIZE)    
            throw new ArrayIndexOutOfBoundsException();          
        this.elementData = new Object[initCapacity]; // ��ʼ������  
        this.size = initCapacity; // ͬʱ��ʼ��MyArrayList�Ĵ�С  
    }  
    private void ensureCapacity(int requireCapacity){  //ȷ�������MyArrayList����û�г�����ʼ�������� 
        if(requireCapacity < 0)  
            throw new ExceptionInInitializerError();  
        if(requireCapacity >= this.size){  
            int newCapacity = requireCapacity+10;  // ÿ����չ����ֻ��չ10����λ��������  
            if(newCapacity > MAX_SIZE){  
                newCapacity = requireCapacity + (10 - (newCapacity - MAX_SIZE)); // ���¼����µ�����  
            }  
            this.size = newCapacity;  
            elementData = Arrays.copyOf(elementData, newCapacity);        
        }  
    }  
    public int getSize(){   //���˳���MyArrayList������ 
        return this.size;  
    }  
    public int getCurrentSize(){  	//���˳���MyArrayList��ʵ�ʴ洢��С
        return this.currentSize+1;  
    }  
    public boolean isEmply(){  // �ж�˳���MyArrayList�Ƿ�Ϊ�� 
        return (this.currentSize==-1);  
    } 
    public boolean add(E e){  	//��˳���MyArrayListβ�����Ԫ�صķ���
        ensureCapacity(currentSize+1);  
        elementData[currentSize+1] = e;  
        currentSize++; // ����˳���ʵ�ʴ�����ݵĴ�С  
        return true;  
    }  
    public boolean removeAll(){  	//ɾ������MyArraList���Ԫ�� 
        for(int i=0; i<currentSize; i++){  
            elementData[i] = null;  
        }  
        currentSize = -1;  
        return true;  
    }
    public boolean replaceByElement(E e1, E e2){  // �滻ָ����Ԫ�� ,e1 �滻ǰ��Ԫ�� ,e2  �滻���Ԫ��
        if(e1.getClass() != e2.getClass())  
            throw new ClassCastException();  
        int index = indexOf(e1);  
            elementData[index] = e2;  
        return true;
    }  
    public boolean contains(Object e){  //����ָ��Ԫ���Ƿ������MyArrayList�� ,e Ҫ����Ԫ�� 
        return indexOf(e) != -1;  
    }  
    public int indexOf(Object e){  //����ָ��Ԫ����MyArrayList�������λ�� ,���ظ�Ԫ�����ڵ�������û�з���-1
        if(e==null || e=="" || e.equals(null) || e.equals(""))  
            return -1;  
        else {  
            for(int i=0; i<=currentSize; i++)  
                if(e.equals(elementData[i]) || e.hashCode()==elementData[i].hashCode())  
                    return i;  
            }  
        return -1;  
    }  
 
}  
public class ArrayListTest2{
	public static void main(String args[]){
		
		long start1 = System.currentTimeMillis();// add����
		 ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i=0;i<10000;i++)
			a.add(i);
		long end1 = System.currentTimeMillis();
		long costtime1 = end1 - start1;		//ArrayList��ʱ
		
		long start2 =System.currentTimeMillis();
		MyArrayList b=new MyArrayList();
		for(int i=0;i<10000;i++)
			b.add(i);
		long end2 = System.currentTimeMillis();
		long costtime2 = end2 - start2;   //MyArrayList��ʱ
		
		double s=(double)costtime1/(double)costtime2;  //��ʱ֮��
		System.out.println("add��������10000�Σ� MyArrayList��ʱ �� ArrayList��ʱ ֮��---Ч��: "+s);
		
		long start3 = System.currentTimeMillis();
		 ArrayList<Integer> c=new ArrayList<Integer>();
		for(int i=0;i<10000;i++)
			c.indexOf(i);
		long end3 = System.currentTimeMillis();
		long costtime3 = end3 - start3;		//ArrayList��ʱ
		
		long start4 =System.currentTimeMillis();
		MyArrayList d=new MyArrayList();
		for(int i=0;i<10000;i++)
			d.indexOf(i);
		long end4 = System.currentTimeMillis();
		long costtime4 = end4 - start4;   //MyArrayList��ʱ
		
		double p=(double)costtime3/(double)costtime4;  //��ʱ֮��
		System.out.println("indexOf(Object e)����(����Ԫ����MyArrayList��λ��),����10000�Σ� MyArrayList��ʱ �� ArrayList��ʱ ֮��---Ч��: "+p);
		
		
	}
}