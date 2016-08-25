//待修改
import java.util.ArrayList;
import java.util.Arrays;    
/** 
 * 这是一个线性表的顺序存储结构，即顺序表。 这个类是一个顺序表数据结构的一般实现。 
 *  
 * @version 1.0 
 * @start_time 2013-06-07 
 * @end_time 2013-06-09 
 * @author whw 
 * @param <E> 
 *  
 */  
class MyArrayList<E> implements java.io.Serializable{  
    private static final long serialVersionUID = 1L;  
    private static final int MAX_SIZE = Integer.MAX_VALUE-1;   
    private int size;  //保存数据实际大小
    private int currentSize = -1;  
    private Object[] elementData;   //存放MyArrayList的数据的对象数组
    public MyArrayList(){  //默认构造方法
        this(10);  
    }  
    public MyArrayList(int initCapacity){   // initCapacity 初始化容量
        if(initCapacity < 0)  
            throw new ExceptionInInitializerError();  
        if(initCapacity > MAX_SIZE)    
            throw new ArrayIndexOutOfBoundsException();          
        this.elementData = new Object[initCapacity]; // 初始化数组  
        this.size = initCapacity; // 同时初始化MyArrayList的大小  
    }  
    private void ensureCapacity(int requireCapacity){  //确保所需的MyArrayList容量没有超过初始化的容量 
        if(requireCapacity < 0)  
            throw new ExceptionInInitializerError();  
        if(requireCapacity >= this.size){  
            int newCapacity = requireCapacity+10;  // 每次扩展容量只扩展10个单位的容量。  
            if(newCapacity > MAX_SIZE){  
                newCapacity = requireCapacity + (10 - (newCapacity - MAX_SIZE)); // 重新计算新的容量  
            }  
            this.size = newCapacity;  
            elementData = Arrays.copyOf(elementData, newCapacity);        
        }  
    }  
    public int getSize(){   //获得顺序表MyArrayList的容量 
        return this.size;  
    }  
    public int getCurrentSize(){  	//获得顺序表MyArrayList的实际存储大小
        return this.currentSize+1;  
    }  
    public boolean isEmply(){  // 判断顺序表MyArrayList是否为空 
        return (this.currentSize==-1);  
    } 
    @SuppressWarnings("unchecked") 
    private E elementData(int index) {  //增加泛型的支持，使每个放入MyArrayList容器的元素不会丢失其数据类型
        checkRange(index);          
        return (E) elementData[index];  
    }  
    public boolean add(E e){  	//往顺序表MyArrayList尾部添加元素的方法
        ensureCapacity(currentSize+1);  
        elementData[currentSize+1] = e;  
        currentSize++; // 更新顺序表实际存放数据的大小  
        return true;  
    }  
    public boolean addAtIndex(E e, int index){  //往顺序表MyArrayList指定位置添加元素的方法,index 要添加到顺序表里的位置索引 
        checkRange(index);       
        ensureCapacity(currentSize+1);      
        for(int i=currentSize; i>=index; i--){  
            elementData[i+1] = elementData[i];  
        }  
        elementData[index] = e;  
        currentSize++; // 更新顺序表实际存放数据的大小  
        return true;  
    }  
    public boolean removeByIndex(int index){  //删除指定索引位置的ArraList里的元素 
        checkRange(index);  
          
        elementData[index] = null;  
        currentSize--; // 顺序表长度减一  
        return true;  
    }  
    public boolean removeByElement(E e){  //删除指定ArraList里的元素 , e 要删除的元素
        int index = indexOf(e);  
        elementData[index] = null;  
        currentSize--; // 顺序表长度减一  
        return true;  
    }  
    public boolean removeAll(){  	//删除所有ArraList里的元素 
        for(int i=0; i<currentSize; i++){  
            elementData[i] = null;  
        }  
        currentSize = -1;  
        return true;  
    }
    public E get(int index){  //获取指定索引位置的MyArrayList里的元素,index 要获取的元素的索引 
        return (elementData(index));  
    }  
    public boolean replaceByIndex(E e, int index){  //替换指定位置的元素, e 要替换的元素,index  要替换的元素的索引 
        checkRange(index);  
        elementData[index] = e;  
        return true;  
    }  
    public boolean replaceByElement(E e1, E e2){  // 替换指定的元素 ,e1 替换前的元素 ,e2  替换后的元素
        if(e1.getClass() != e2.getClass())  
            throw new ClassCastException();  
        int index = indexOf(e1);  
            elementData[index] = e2;  
        return true;  
    }  
    public boolean contains(Object e){  //搜索指定元素是否包含在MyArrayList里 ,e 要搜索元素 
        return indexOf(e) != -1;  
    }  
    public int indexOf(Object e){  //搜索指定元素在MyArrayList里的索引位置 ,返回该元素所在的索引，没有返回-1
        if(e==null || e=="" || e.equals(null) || e.equals(""))  
            return -1;  
        else {  
            for(int i=0; i<=currentSize; i++)  
                if(e.equals(elementData[i]) || e.hashCode()==elementData[i].hashCode())  
                    return i;  
            }  
        return -1;  
    }  
    private void checkRange(int index){ 	// 判断索引的范围 ,index 需要判断的索引
        if(index<0 || index>currentSize)  
            throw new ArrayIndexOutOfBoundsException();  
    }     
}  
/*public class ArrayListT{
	public static void main(String args[]){
		long start1 = System.currentTimeMillis();
		 ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i=0;i<100000;i++)
			a.add(i);
		long end1 = System.currentTimeMillis();
		long costtime1 = end1 - start1;		//ArrayList用时
		long start2 =System.currentTimeMillis();
		MyArrayList b=new MyArrayList();
		for(int i=0;i<100000;i++)
			b.add(i);
		long end2 = System.currentTimeMillis();
		long costtime2 = end2 - start2;   //MyArrayList用时
		double s=(double)costtime1/(double)costtime2;
		System.out.println("效率:"+s);
	}
}*/