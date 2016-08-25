import java.util.ArrayList;
import java.util.Arrays;    
class MyArrayListttt<E> implements java.io.Serializable{ 
    private static final long serialVersionUID = 1L;  
    private static final int MAX_SIZE = Integer.MAX_VALUE-1;   
    private int size;  //��������ʵ�ʴ�С
    private int currentSize = -1;  
    private Object[] elementData;   //���MyArrayListttt�����ݵĶ�������
    public MyArrayListttt(){  //Ĭ�Ϲ��췽��
        this(10);  
    }  
    public MyArrayListttt(int initCapacity){   // initCapacity ��ʼ������
        if(initCapacity < 0)  
            throw new ExceptionInInitializerError();  
        if(initCapacity > MAX_SIZE)    
            throw new ArrayIndexOutOfBoundsException();          
        this.elementData = new Object[initCapacity]; // ��ʼ������  
        this.size = initCapacity; // ͬʱ��ʼ��MyArrayListttt�Ĵ�С  
    }  
    private void ensureCapacity(int requireCapacity){  //ȷ�������MyArrayListttt����û�г�����ʼ�������� 
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
    public int getSize(){   //���˳���MyArrayListttt������ 
        return this.size;  
    }  
    public int getCurrentSize(){  	//���˳���MyArrayListttt��ʵ�ʴ洢��С
        return this.currentSize+1;  
    }  
    public boolean isEmply(){  // �ж�˳���MyArrayListttt�Ƿ�Ϊ�� 
        return (this.currentSize==-1);  
    } 
    @SuppressWarnings("unchecked")
	private E elementData(int index) {  //���ӷ��͵�֧�֣�ʹÿ������MyArrayListttt������Ԫ�ز��ᶪʧ����������
        checkRange(index);          
        return (E) elementData[index];  
    }  
    public boolean add(E e){  	//��˳���MyArrayListtttβ�����Ԫ�صķ���
        ensureCapacity(currentSize+1);  
        elementData[currentSize+1] = e;  
        currentSize++; // ����˳���ʵ�ʴ�����ݵĴ�С  
        return true;  
    }  
    public boolean addAtIndex(E e, int index){  //��˳���MyArrayListtttָ��λ�����Ԫ�صķ���,index Ҫ��ӵ�˳������λ������ 
        checkRange(index);       
        ensureCapacity(currentSize+1);      
        for(int i=currentSize; i>=index; i--){  
            elementData[i+1] = elementData[i];  
        }  
        elementData[index] = e;  
        currentSize++; // ����˳���ʵ�ʴ�����ݵĴ�С  
        return true;  
    }  
    public boolean removeByIndex(int index){  //ɾ��ָ������λ�õ�MyArraList���Ԫ�� 
        checkRange(index);  
          
        elementData[index] = null;  
        currentSize--; // ˳����ȼ�һ  
        return true;  
    }  
    public boolean removeByElement(E e){  //ɾ��ָ��MyArraList���Ԫ�� , e Ҫɾ����Ԫ��
        int index = indexOf(e);  
        elementData[index] = null;  
        currentSize--; // ˳����ȼ�һ  
        return true;  
    }  
    public boolean removeAll(){  	//ɾ������MyArraList���Ԫ�� 
        for(int i=0; i<currentSize; i++){  
            elementData[i] = null;  
        }  
        currentSize = -1;  
        return true;  
    }
    public E get(int index){  //��ȡָ������λ�õ�MyArrayListttt���Ԫ��,index Ҫ��ȡ��Ԫ�ص����� 
        return (elementData(index));  
    }  
    public boolean replaceByIndex(E e, int index){  //�滻ָ��λ�õ�Ԫ��, e Ҫ�滻��Ԫ��,index  Ҫ�滻��Ԫ�ص����� 
        checkRange(index);  
        elementData[index] = e;  
        return true;  
    }  
    public boolean replaceByElement(E e1, E e2){  // �滻ָ����Ԫ�� ,e1 �滻ǰ��Ԫ�� ,e2  �滻���Ԫ��
        if(e1.getClass() != e2.getClass())  
            throw new ClassCastException();  
        int index = indexOf(e1);  
            elementData[index] = e2;  
        return true;  
    }  
    public boolean contains(Object e){  //����ָ��Ԫ���Ƿ������MyArrayListttt�� ,e Ҫ����Ԫ�� 
        return indexOf(e) != -1;  
    }  
    public int indexOf(Object e){  //����ָ��Ԫ����MyArrayListttt�������λ�� ,���ظ�Ԫ�����ڵ�������û�з���-1
        if(e==null || e=="" || e.equals(null) || e.equals(""))  
            return -1;  
        else {  
            for(int i=0; i<=currentSize; i++)  
                if(e.equals(elementData[i]) || e.hashCode()==elementData[i].hashCode())  
                    return i;  
            }  
        return -1;  
    }  
    private void checkRange(int index){ 	// �ж������ķ�Χ ,index ��Ҫ�жϵ�����
        if(index<0 || index>currentSize)  
            throw new ArrayIndexOutOfBoundsException();  
    }     
}  
public class ArrayListTest{
	public static void main(String args[]){
		
		long start1 = System.currentTimeMillis();
		 ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i=0;i<10000;i++)
			a.add(i);
		long end1 = System.currentTimeMillis();
		long costtime1 = end1 - start1;		//ArrayList��ʱ
		
		long start2 =System.currentTimeMillis();
		MyArrayListttt b=new MyArrayListttt();
		for(int i=0;i<10000;i++)
			b.add(i);
		long end2 = System.currentTimeMillis();
		long costtime2 = end2 - start2;   //MyArrayListttt��ʱ
		
		double s=(double)costtime1/(double)costtime2;  //��ʱ֮��
		
		System.out.println("add��������10000�Σ� MyArrayListttt��ʱ �� ArrayList��ʱ ֮��---Ч��:"+s);
	}
}