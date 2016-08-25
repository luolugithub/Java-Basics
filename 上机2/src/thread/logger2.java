package thread;
import java .io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class logger2 {
public static File file;
public static FileWriter fileWriter;
public static void main(String[] args) throws Exception{ 
	System.out.println("logger's name(loaction included)");
	String pathname="";
Scanner pScanner=new Scanner(System.in);
pathname=pScanner.next();
	file=new File(pathname);
	fileWriter=new FileWriter(file);
 Thread  t1= new  threadfunction();
 Thread t2=new  threadfunction();
 t1.start();
 t1.join();
 t2.start();
 t2.join();
}

static class threadfunction extends Thread{
	public void run(){
		synchronized (file) {
			
		Scanner in=new Scanner(System.in);
		String path=in.next();
		String name=in.next();
		ArrayList<String> fileList=new ArrayList<String>();
		pro.findFiles(path, name, fileList);
		for(int i=0;i<fileList.size();i++){
		//	System.out.println(fileList.get(i));
		try {
			fileWriter.write(fileList.get(i)+"\n");
		//	fileWriter.write("aadq");
		//	System.out.println("have");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
				}
		  try {
			fileWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
			}
		}
	}




