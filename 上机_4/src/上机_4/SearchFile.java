package �ϻ�_4;
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
				chuli(f, guolvqi);		//�ݹ����
			}
			else{
				if(guolvqi.accept(dirtrue,f.getName())){
					System.out.println(" ·��:"+f.getAbsolutePath()+"    �ļ���:"+f.getName());
					String a=f.getAbsolutePath().toString();
					ad.add(a);
				}
			}
		}
	}	
	public static void findDirectory(String dir,String type){//�ҵ��ļ���
		File dirtrue = new File(dir);//�ҵ��ļ���
		FilenameFilter guolvqi = new FilenameFilter(){	//����������
			public boolean accept(File dirtrue, String name) {
				return name.endsWith(type);			//���ļ����µ��ļ�����ȷ���򷵻�true
			}
		};
		chuli(dirtrue,guolvqi);
	}
	public static void xiancheng(){
		String type,dir;
		System.out.println("�������ļ�����Ŀ¼��");
		reader = new Scanner(System.in);
		dir=reader.next();
		System.out.println("�������ļ����ͣ�");
		reader1 = new Scanner(System.in);
		type=reader1.next();
		findDirectory(dir,type);
	}
	public static void main(String[] args) //throws Exception
	{
		int num;
		System.out.println("�������������̣߳�");
		reader=new Scanner(System.in);
		num=reader.nextInt();
		for(int i=0;i<num;i++)
			xiancheng();
		for(int i=0;i<ad.size();i++)
			System.out.println(ad.get(i));
	}
}