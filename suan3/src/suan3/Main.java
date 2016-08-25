package suan3;
public class Main {  
    public static void main(String[] args) {  
        Dijkstra shortpath=new Dijkstra();  
        Node start=shortpath.init();  
        shortpath.computePath(start);  
        shortpath.printPathInfo();  
    }  
}  