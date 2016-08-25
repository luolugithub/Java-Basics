package 上机4;
import java.util.*;
import java.io.File;
import java.io.FilenameFilter;

class DataFileFilter implements FilenameFilter{//过滤得到当前目录指定类型文件  
  String type;  
  DataFileFilter(String type){  
      this.type = type;  
  }        
  public boolean accept(File directory, String filname) {  
      return filname.endsWith(type);   //是 返回true
  }    
}
public class findfile{
	private static Scanner reader;
	private static Scanner reader1;

	public static void main(String args[]){
		String type,dir;
		System.out.println("请输入文件查找目录：");
		reader = new Scanner(System.in);
		dir=reader.next();
		System.out.println("请输入文件类型：");
		reader1 = new Scanner(System.in);
		type=reader1.next();		
	/*	static HashMap<String, String> filelist=new HashMap<String, String>();
		public static void find(String path){
			File file=new File(path);
			File[] files = file.listFiles();
			if (files == null) //如果文件数组为null则返回
	            return; 
	        for (int i = 0; i < files.length; i++) { 
	            if (files[i].isDirectory()) { 		//判断是不是文件夹，如果是文件夹则继续向下查找文件
	            	find(files[i].getAbsolutePath()); 
	            } 
	            else {  
	            	String filePath = files[i].getAbsolutePath().toLowerCase();//记录文件路径
	                String fileName=files[i].getName().toLowerCase(); //记录文件名
	              //System.out.println("---"+strFileName);
	                filelist.put(fileName, filePath);
	            } 
	        } 
*/
		File filef=new File(dir);//进入输入路径
	//	if()
		List<String> allfilename=new ArrayList<String>();//记录所有合格文件的文件名
		List<String> filepath=new ArrayList<String>();//记录合格文件的相对路径
		DataFileFilter filter=new DataFileFilter(type);
		String[] filenames=filef.list(filter);//查找合格文件
		while(filter.accept(filef, type)){
			filepath.add(filef.getAbsolutePath());
		}
		allfilename.addAll(Arrays.asList(filenames));//记录文件名称
		//filter.getAbsolutePath();
		Iterator<String> it=allfilename.iterator();//遍历arraylist 并输出
		Iterator<String> pt=allfilename.iterator();
		while(it.hasNext()&&pt.hasNext()){
		    System.out.println(it.next()+"  "+pt.next());
		}
	}
}
