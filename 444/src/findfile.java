
import java.util.*;
import java.io.File;
import java.io.FilenameFilter;
class DataFileFilter implements FilenameFilter{//���˵õ���ǰĿ¼ָ�������ļ�  
  String type;  
  DataFileFilter(String type){  
      this.type = type;  
  }        
  public boolean accept(File dir, String filname) {  
      return filname.endsWith(type);   //�� ����true
  }    
}
class chuli{
	public void chuli1(File f,String type){
	//File folder=new File(dir);//�ҵ��ļ���	
	//File []	files = folder.listFiles();//���ش��ļ����µ������ļ������ļ���
	List<String> allfilename=new ArrayList<String>();//��¼���кϸ��ļ����ļ���
	DataFileFilter filter=new DataFileFilter(type);
	String[] filenames=f.list(filter); //���Һϸ��ļ�
	allfilename.addAll(Arrays.asList(filenames));//��¼�ļ�����
	System.out.println(f.getAbsolutePath());
	Iterator<String> it=allfilename.iterator(); //����arraylist �����
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
		System.out.println("�������ļ�����Ŀ¼��");
		Scanner reader=new Scanner(System.in);
		dir=reader.next();
		System.out.println("�������ļ����ͣ�");
		Scanner reader1=new Scanner(System.in);
		type=reader1.next();	
		
		File folder=new File(dir);//�ҵ��ļ���	
		File []	files = folder.listFiles();//���ش��ļ����µ������ļ������ļ���
		for(File f : files){
			if(f.isDirectory()){
						
			}else{
				chuli t=new chuli();
				t.chuli1(f, type);
				/*List<String> allfilename=new ArrayList<String>();//��¼���кϸ��ļ����ļ���
				DataFileFilter filter=new DataFileFilter(type);
				String[] filenames=folder.list(filter); //���Һϸ��ļ�
				allfilename.addAll(Arrays.asList(filenames));//��¼�ļ�����
				System.out.println(f.getAbsolutePath());
				Iterator<String> it=allfilename.iterator(); //����arraylist �����
				while(it.hasNext()){
				   System.out.println(it.next());
				   allfilename.clear();*/
				}	
			}
		}
	}
}
