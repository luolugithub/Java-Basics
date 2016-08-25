package 上机_4;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Scanner;
public class SearchFile {
	private static Scanner reader1;
	private static Scanner reader;
	static ArrayList<String> ad=new ArrayList<String>();
	//static int i=0;
	public static void chuli(File dirtrue, FilenameFilter guolvqi) {	
		File[] files = dirtrue.listFiles();
		for(File f : files){
			if(f.isDirectory()){
				chuli(f, guolvqi);		//递归调用
			}
			else{
				if(guolvqi.accept(dirtrue,f.getName())){
					System.out.println(" 路径:"+f.getAbsolutePath()+"    文件名:"+f.getName());
					String a=f.getAbsolutePath().toString();
					ad.add(a);
				}
			}
		}
	}	
	public static void findDirectory(String dir,String type){//找到文件架
		File dirtrue = new File(dir);//找到文件架
		FilenameFilter guolvqi = new FilenameFilter(){	//创建过滤器
			public boolean accept(File dirtrue, String name) {
				return name.endsWith(type);			//该文件夹下的文件若正确，则返回true
			}
		};
		chuli(dirtrue,guolvqi);
	}
	public static void xiancheng(){
		String type,dir;
		System.out.println("请输入文件查找目录：");
		reader = new Scanner(System.in);
		dir=reader.next();
		System.out.println("请输入文件类型：");
		reader1 = new Scanner(System.in);
		type=reader1.next();
		findDirectory(dir,type);
	}
	public static void main(String[] args) //throws Exception
	{
		int num;
		System.out.println("创建几个查找线程？");
		reader=new Scanner(System.in);
		num=reader.nextInt();
		for(int i=0;i<num;i++)
			xiancheng();
		for(int i=0;i<ad.size();i++)
			System.out.println(ad.get(i));
	}
}