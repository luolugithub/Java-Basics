import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
  
public class MyOutputStream extends OutputStream {  
	private boolean isOpen;         // �Ƿ��Ѿ���  
    private long size;              // �����ܴ�С  
    private String backedFileName;  // ��������,Ҫд�뵽���ļ���  
    private OutputStream diskStream;// ��������,д�뵽�ļ���OutputStream  
    private byte[] buffer;          // ����  
    private long position;          // ��ǰλ��  
    private boolean recording;      // �Ƿ��¼������  
      
      
    public MyOutputStream(int bufferSize,String backedFileName){  
        this.buffer=new byte[bufferSize];  
        this.backedFileName=backedFileName;  
        this.recording=true;  
    }  
      
    public void open() throws IOException{  
        if(isOpen()){  
            throw new IOException("MyOutputStream already open for ".concat(Thread.currentThread().getName()));  
        }  
        isOpen=true;  
        this.position=0;  
        this.size=0;  
        this.recording=true;  
          
        closeDiskStream();  
          
        this.diskStream=new FileOutputStream(this.backedFileName);  
          
    }  
      
    private void closeDiskStream() throws IOException{  
        if(this.diskStream!=null){  
            diskStream.close();  
            diskStream=null;  
        }  
    }  
      
    public void closeRecorder() throws IOException{  
        recording=false;  
        closeDiskStream();  
        if(this.size==0){  
            this.size=position;  
        }  
    }  
      
    public boolean isOpen(){  
        return isOpen;  
    }  
    // ��¼һ���ֽ�  
    private void record(int b) throws IOException{  
        if(this.position>=this.buffer.length){  
            this.diskStream.write((byte)b);  
        }else{  
            buffer[(int)position]=(byte)b;  
        }  
        this.position++;  
    }  
    // ��¼����ֽ�  
    private void record(byte[] b,int off,int len) throws IOException{  
        if(position>=this.buffer.length){   // ��������Ѿ�����,��д��Ӳ��  
            if(this.diskStream==null){  
                throw new IOException("diskStream is null for ".concat(Thread.currentThread().getName()));  
            }  
            this.diskStream.write(b, off, len); // д��Ӳ��  
            this.position+=len; // λ������  
        }else{  // û��,��д�뻺��.�����ʱ����д����,����д�����  
            int toCopy=Math.min(this.buffer.length-(int)this.position, len);    // ����Ҫд�뻺��ĳ���,���û��汬��  
            System.arraycopy(b, off, this.buffer, (int)this.position, len);     // ����������  
            this.position+=toCopy;  
              
            if(toCopy<len){ // �����������,��ʣ�µ�����д��Ӳ��  
                //this.diskStream.write(b,off+toCopy,len-toCopy);       
                record(b,off+toCopy,len-toCopy);    // Ϊʲô��ֱ������һ�д��룿��Ҫ��֤diskStream  
            }  
        }  
    }  
    // д������  
    @Override  
    public void write(int b) throws IOException {  
        if(recording){  
            record(b);  
        }  
    }  
    // д������  
    @Override  
    public void write(byte[] b, int off, int len) throws IOException { 
  	       if(recording){  
           record(b,off,len);  
       }  
    }  
    // д������  
    @Override  
    public void write(byte[] b) throws IOException {  
        if(recording){  
            record(b,0,b.length);  
        }  
    }  
     
    // �ر�,�ر��˲��ܻ�ó���  
    @Override  
    public void close() throws IOException {  
        isOpen=false;  
        closeRecorder();  
    }  
      
      
     
    // ˢ��  
    @Override  
    public void flush() throws IOException {  
       if(this.diskStream!=null){  
           this.diskStream.flush();  
       }  
    }  
    // ������ݴ�С  
    public long getSize() {  
        return size;  
    }  
     
    public static void main(String[] args) {  
        String dir=new File("").getAbsolutePath().concat(File.separator);  
        String fileMemory=dir.concat("output.txt");  
        String fileDisk=dir.concat("output.txt");  
        int bufferSize=5;  
        MyOutputStream mosMemory=null;  
        MyOutputStream mosDisk=null;  
        try {  
            mosMemory=new MyOutputStream(bufferSize,fileMemory);  
            mosMemory.open();  
              
            mosDisk=new MyOutputStream(bufferSize,fileDisk);  
            mosDisk.open();  
              
            for(int i=0;i<100;i++){  
                if(i<bufferSize){  
                    mosMemory.write(i);  
                }  
                mosDisk.write(i);  
            }  
              
            mosMemory.close();  
            mosDisk.close();  
              
            System.out.println("mosMemory length:"+mosMemory.getSize());  
            System.out.println("mosDisk length:"+mosDisk.getSize());  
              
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }finally{  
              
        }  
    }  
  
}  
