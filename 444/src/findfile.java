
import java.util.*;
import java.io.File;
import java.io.FilenameFilter;
class DataFileFilter implements FilenameFilter{//过滤得到当前目录指定类型文件  
  String type;  
  DataFileFilter(String type){  
      this.type = type;  
  }        
  public boolean accept(File dir, String filname) {  
      return filname.endsWith(type);   //是 返回true
  }    
}
class chuli{
	public void chuli1(File f,String type){
	//File folder=new File(dir);//找到文件架	
	//File []	files = folder.listFiles();//返回此文件夹下的所有文件和子文件夹
	List<String> allfilename=new ArrayList<String>();//记录所有合格文件的文件名
	DataFileFilter filter=new DataFileFilter(type);
	String[] filenames=f.list(filter); //查找合格文件
	allfilename.addAll(Arrays.asList(filenames));//记录文件名称
	System.out.println(f.getAbsolutePath());
	Iterator<String> it=allfilename.iterator(); //遍历arraylist 并输出
	while(it.hasNext()){
	   System.out.println(it.next());
	   //allfilename.clear();
	   }
	}
/*class floder{
	private static final String String = null;
	File flod=new File(String);
	File[] f=flod.listFiles();
}*/
public class findfile{
	public void main(String args[]){
		
		String type,dir;
		System.out.println("请输入文件查找目录：");
		Scanner reader=new Scanner(System.in);
		dir=reader.next();
		System.out.println("请输入文件类型：");
		Scanner reader1=new Scanner(System.in);
		type=reader1.next();	
		
		File folder=new File(dir);//找到文件架	
		File []	files = folder.listFiles();//返回此文件夹下的所有文件和子文件夹
		for(File f : files){
			if(f.isDirectory()){
						
			}else{
				chuli t=new chuli();
				t.chuli1(f, type);
				/*List<String> allfilename=new ArrayList<String>();//记录所有合格文件的文件名
				DataFileFilter filter=new DataFileFilter(type);
				String[] filenames=folder.list(filter); //查找合格文件
				allfilename.addAll(Arrays.asList(filenames));//记录文件名称
				System.out.println(f.getAbsolutePath());
				Iterator<String> it=allfilename.iterator(); //遍历arraylist 并输出
				while(it.hasNext()){
				   System.out.println(it.next());
				   allfilename.clear();*/
				}	
			}
		}
	}
}
