package 上机2;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Thread;
public class SearchFile {
	static List<String> path=new ArrayList<String>();
	static List<String> filename=new ArrayList<String>();
	public static void chuli(File dirtrue, FilenameFilter guolvqi) {	
		File[] files = dirtrue.listFiles();
		for(File f : files){
			if(f.isDirectory()){
				chuli(f, guolvqi);		//递归调用
			}
			else{
				if(guolvqi.accept(dirtrue,f.getName())){
					
					path.add(f.getAbsolutePath());//加入数组
					filename.add(f.getName());
					System.out.println(" 路径:"+f.getAbsolutePath()+"    文件名:"+f.getName());
				}
			}
		}
	}	
	public static void pipei()throws Exception{
		Scanner reader=new Scanner(System.in);
		String type,dir;
		System.out.println("请输入文件查找目录：");
		dir=reader.next();
		System.out.println("请输入文件类型：");
		type=reader.next();	
		//reader.close();
		//过滤找到正确文件
		File dirtrue = new File(dir);//找到文件架
		FilenameFilter guolvqi = new FilenameFilter(){	//创建过滤器
			public boolean accept(File dirtrue, String name) {
				return name.endsWith(type);			//该文件夹下的文件若正确，则返回true
			}
		};
		chuli(dirtrue,guolvqi);
	}

	public static void main(String[] args) throws Exception
	{
		//pipei();
		System.out.println("两个线程");
		xiancheng ti=new xiancheng();
		xiancheng t2=new xiancheng();
		ti.start();
		ti.join();  		//等待t1完成
		t2.start();
		t2.join();
		System.out.println("\nArrayList里面记录的数据：");
		for(int i=0;i<path.size();i++){
			System.out.print("\n"+path.get(i)+" "+filename.get(i));
			//第二题的功能 把文件名和路径写入 logger.log文件中
			Logger.get(path.get(i));
			Logger.get(filename.get(i));
		}
	}		
}
class xiancheng extends Thread{	//继承Thread
	public void run(){
		try {
			SearchFile.pipei();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
