package �ϻ�4;
import java.util.*;
import java.io.File;
import java.io.FilenameFilter;

class DataFileFilter implements FilenameFilter{//���˵õ���ǰĿ¼ָ�������ļ�  
  String type;  
  DataFileFilter(String type){  
      this.type = type;  
  }        
  public boolean accept(File directory, String filname) {  
      return filname.endsWith(type);   //�� ����true
  }    
}
public class findfile{
	private static Scanner reader;
	private static Scanner reader1;

	public static void main(String args[]){
		String type,dir;
		System.out.println("�������ļ�����Ŀ¼��");
		reader = new Scanner(System.in);
		dir=reader.next();
		System.out.println("�������ļ����ͣ�");
		reader1 = new Scanner(System.in);
		type=reader1.next();		
	/*	static HashMap<String, String> filelist=new HashMap<String, String>();
		public static void find(String path){
			File file=new File(path);
			File[] files = file.listFiles();
			if (files == null) //����ļ�����Ϊnull�򷵻�
	            return; 
	        for (int i = 0; i < files.length; i++) { 
	            if (files[i].isDirectory()) { 		//�ж��ǲ����ļ��У�������ļ�����������²����ļ�
	            	find(files[i].getAbsolutePath()); 
	            } 
	            else {  
	            	String filePath = files[i].getAbsolutePath().toLowerCase();//��¼�ļ�·��
	                String fileName=files[i].getName().toLowerCase(); //��¼�ļ���
	              //System.out.println("---"+strFileName);
	                filelist.put(fileName, filePath);
	            } 
	        } 
*/
		File filef=new File(dir);//��������·��
	//	if()
		List<String> allfilename=new ArrayList<String>();//��¼���кϸ��ļ����ļ���
		List<String> filepath=new ArrayList<String>();//��¼�ϸ��ļ������·��
		DataFileFilter filter=new DataFileFilter(type);
		String[] filenames=filef.list(filter);//���Һϸ��ļ�
		while(filter.accept(filef, type)){
			filepath.add(filef.getAbsolutePath());
		}
		allfilename.addAll(Arrays.asList(filenames));//��¼�ļ�����
		//filter.getAbsolutePath();
		Iterator<String> it=allfilename.iterator();//����arraylist �����
		Iterator<String> pt=allfilename.iterator();
		while(it.hasNext()&&pt.hasNext()){
		    System.out.println(it.next()+"  "+pt.next());
		}
	}
}
