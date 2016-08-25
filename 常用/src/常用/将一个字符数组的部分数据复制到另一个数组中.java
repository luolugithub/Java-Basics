package 常用;

public class 将一个字符数组的部分数据复制到另一个数组中 {
	public static void main(String[] args){
		char[] copyfrom={'a','b','c','f','e','g','k','m','o'};
		char  copyto[]=new char[4];
		
		System.arraycopy(copyfrom, 3, copyto, 0, 4);//重点
		System.out.println(new String(copyto));
	}
}
