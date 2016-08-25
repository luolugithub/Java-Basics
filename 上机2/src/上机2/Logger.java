package ио╩З2;
import java.io.*;
public class Logger {
	public static void get(String a) throws IOException{
		//FileOutputStream out=new FileOutputStream(logger);
		//File out=new File("logger.log");
		//DataOutputStream out=new DataOutputStream(new FileOutputStream("logger.txt"));
		FileWriter in=new FileWriter("logger2.log",true);
		for(int i=0;i<a.length();i++)
				in.write(a.charAt(i));		
		in.write('\n');
		in.flush();
		in.close();
	}
	public static void main(String[] args){
	}
}
