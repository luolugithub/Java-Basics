package ����;

public class ��һ���ַ�����Ĳ������ݸ��Ƶ���һ�������� {
	public static void main(String[] args){
		char[] copyfrom={'a','b','c','f','e','g','k','m','o'};
		char  copyto[]=new char[4];
		
		System.arraycopy(copyfrom, 3, copyto, 0, 4);//�ص�
		System.out.println(new String(copyto));
	}
}
