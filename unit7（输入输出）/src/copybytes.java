import java.io.*;
public class copybytes {
	public static void main(String[] args)throws IOException{
		File inputFile=new File("inputfile.txt");
		File outputFile=new File("outputfile.txt");
		
		FileInputStream in=new FileInputStream(inputFile);
		FileOutputStream out=new FileOutputStream(outputFile);
		int c;
		while((c=in.read())!=-1)
			out.write(c);
		in.close();
		out.close();
	}
}
