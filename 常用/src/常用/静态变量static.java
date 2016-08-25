package 常用;

//静态语句块是在类加载是运行 所以类的结果先出来
class staticInitDemo{
	static int i;
	static{
		i=5;
		System.out.println("static code:"+i++);
	}
}
public class 静态变量static {
	public static void main(String args[]){
		System.out.println("Main code:"+staticInitDemo.i);
	}

}
