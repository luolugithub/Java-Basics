package �ϻ�2;
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
				chuli(f, guolvqi);		//�ݹ����
			}
			else{
				if(guolvqi.accept(dirtrue,f.getName())){
					
					path.add(f.getAbsolutePath());//��������
					filename.add(f.getName());
					System.out.println(" ·��:"+f.getAbsolutePath()+"    �ļ���:"+f.getName());
				}
			}
		}
	}	
	public static void pipei()throws Exception{
		Scanner reader=new Scanner(System.in);
		String type,dir;
		System.out.println("�������ļ�����Ŀ¼��");
		dir=reader.next();
		System.out.println("�������ļ����ͣ�");
		type=reader.next();	
		//reader.close();
		//�����ҵ���ȷ�ļ�
		File dirtrue = new File(dir);//�ҵ��ļ���
		FilenameFilter guolvqi = new FilenameFilter(){	//����������
			public boolean accept(File dirtrue, String name) {
				return name.endsWith(type);			//���ļ����µ��ļ�����ȷ���򷵻�true
			}
		};
		chuli(dirtrue,guolvqi);
	}

	public static void main(String[] args) throws Exception
	{
		//pipei();
		System.out.println("�����߳�");
		xiancheng ti=new xiancheng();
		xiancheng t2=new xiancheng();
		ti.start();
		ti.join();  		//�ȴ�t1���
		t2.start();
		t2.join();
		System.out.println("\nArrayList�����¼�����ݣ�");
		for(int i=0;i<path.size();i++){
			System.out.print("\n"+path.get(i)+" "+filename.get(i));
			//�ڶ���Ĺ��� ���ļ�����·��д�� logger.log�ļ���
			Logger.get(path.get(i));
			Logger.get(filename.get(i));
		}
	}		
}
class xiancheng extends Thread{	//�̳�Thread
	public void run(){
		try {
			SearchFile.pipei();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
