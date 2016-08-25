import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
  
public class MyOutputStream extends OutputStream {  
	private boolean isOpen;         // 是否已经打开  
    private long size;              // 数据总大小  
    private String backedFileName;  // 超出缓存,要写入到的文件名  
    private OutputStream diskStream;// 超出缓存,写入到文件的OutputStream  
    private byte[] buffer;          // 缓存  
    private long position;          // 当前位置  
    private boolean recording;      // 是否记录数据中  
      
      
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
    // 记录一个字节  
    private void record(int b) throws IOException{  
        if(this.position>=this.buffer.length){  
            this.diskStream.write((byte)b);  
        }else{  
            buffer[(int)position]=(byte)b;  
        }  
        this.position++;  
    }  
    // 记录多个字节  
    private void record(byte[] b,int off,int len) throws IOException{  
        if(position>=this.buffer.length){   // 如果缓存已经满了,则写入硬盘  
            if(this.diskStream==null){  
                throw new IOException("diskStream is null for ".concat(Thread.currentThread().getName()));  
            }  
            this.diskStream.write(b, off, len); // 写入硬盘  
            this.position+=len; // 位置增加  
        }else{  // 没满,则写入缓存.如果此时缓存写满了,则再写入磁盘  
            int toCopy=Math.min(this.buffer.length-(int)this.position, len);    // 计算要写入缓存的长度,不让缓存爆掉  
            System.arraycopy(b, off, this.buffer, (int)this.position, len);     // 拷贝到缓存  
            this.position+=toCopy;  
              
            if(toCopy<len){ // 如果缓存已满,则将剩下的数据写入硬盘  
                //this.diskStream.write(b,off+toCopy,len-toCopy);       
                record(b,off+toCopy,len-toCopy);    // 为什么不直接用上一行代码？需要验证diskStream  
            }  
        }  
    }  
    // 写入数据  
    @Override  
    public void write(int b) throws IOException {  
        if(recording){  
            record(b);  
        }  
    }  
    // 写入数据  
    @Override  
    public void write(byte[] b, int off, int len) throws IOException { 
  	       if(recording){  
           record(b,off,len);  
       }  
    }  
    // 写入数据  
    @Override  
    public void write(byte[] b) throws IOException {  
        if(recording){  
            record(b,0,b.length);  
        }  
    }  
     
    // 关闭,关闭了才能获得长度  
    @Override  
    public void close() throws IOException {  
        isOpen=false;  
        closeRecorder();  
    }  
      
      
     
    // 刷新  
    @Override  
    public void flush() throws IOException {  
       if(this.diskStream!=null){  
           this.diskStream.flush();  
       }  
    }  
    // 获得数据大小  
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
