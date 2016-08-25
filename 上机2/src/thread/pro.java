package thread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pro {
public static void main(String[] args) throws Exception{
	Thread thread1=new duoxiancheng();
	Thread thread2=new duoxiancheng();
	thread1.start();
	System.out.println("thread 1:");
	thread1.join();
	thread2.start();
	System.out.println("thread 2:");
	thread2.join();
	
}

public static void findFiles(String path, String name, List fileList) {
    
    String tempName ="";
    File file = new File(path);
    if (!file.exists() || !file.isDirectory()){
        System.out.println("error");
    } else {
    	String[] filelist = file.list();
	    for (int i = 0; i < filelist.length; i++) {
	    	File readfile = new File(path + "/" + filelist[i]);
	        if(!readfile.isDirectory()) {
	        	tempName =  readfile.getName(); 
	        	//System.out.println(tempName);
	        	String testName=tempName.substring(tempName.lastIndexOf(".")+1);
	        	//System.out.println("testName"+testName);
                if ( name.equals(testName)==true) {
                	String absolutepath=readfile.getAbsolutePath();
                    // String path1=absolutepath.substring(path.length()+1);
                   // fileList.add(path1); 
                	fileList.add(readfile.getAbsolutePath());
                }
	        } else if(readfile.isDirectory()){
	        	findFiles(path + "/" + filelist[i],name,fileList);
	        }
	    }
    }
}
}
class duoxiancheng extends Thread{
	public void run() {
		 
		Scanner in=new Scanner(System .in);
		String path=in.next();
		String name=in.next();
		ArrayList<String> fileList=new ArrayList<String>();
		pro.findFiles(path, name, fileList);
		for(int i=0;i<fileList.size();i++){
			System.out.println(fileList.get(i));
		}
	}
	
}