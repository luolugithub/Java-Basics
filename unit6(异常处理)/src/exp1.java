import java.io.*;
import java.util.*;
class listofnumber{
	private ArrayList<Integer> list;
	private static final int size=10;
	public listofnumber(){
		list=new ArrayList<Integer>(size);
		for(int i=0;i<size;i++){
			list.add(new Integer(i));
		}
	}
	public void writelist(){
		PrintWriter out=null;
		try{
			System.out.println("entering try statement");
			out=new PrintWriter(new FileWriter("outfile.txt"));
			for(int i=0;i<size;i++){
				out.println("value at:"+i+"="+list.get(i));
			}
		}catch(ArrayIndexOutOfBoundsException e){//��������Խ���쳣
			System.err.println("Caught ArrayIndexOutOfBoundsException:"+e.getMessage());
		}catch(IOException e){ //����i/o�쳣
			System.err.println("caught IOException:"+e.getMessage());
		}finally{ //�������
			if(out!=null){
				System.out.println("clossing printwriter");
				out.close();
			}else{
				System.out.println("printerwriter not open");
			}
		}
	}
}
public class exp1 {
	public static void main(String[] args){
		listofnumber list=new listofnumber();
		list.writelist();
	}
}
