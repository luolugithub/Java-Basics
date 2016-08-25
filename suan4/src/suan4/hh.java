package suan4;

import java.util.ArrayList;   
 
public class hh {   
  static ArrayList<Edge> graph = null;   
 
  static ArrayList<Integer> S = null;   
 
  static ArrayList<Integer> V = null;   
 
  static Edge[] ww = null;   
 
  public static void main(String[] args){           
        int[] nodes = new int[100];   
        for(int i=0;i<nodes.length;i++){   
          nodes[i]=i;   
    }    
      graph = new ArrayList<Edge>();   
      for(int i=0;i<nodes.length;i++)   
          for(int j=i+1;j<nodes.length;j++){   
             
                 graph.add(new Edge(i,j,(int)(Math.random()*100+1)));   
                 
          }   
      System.out.println("nodeA"+" "+"nodeB"+" "+"weight");   
      for(int i=0;i<graph.size();i++){   
         System.out.println(graph.get(i).getPreNode()+"       "+graph.get(i).getBenode()+"      "+graph.get(i).getWeight());   
      }   
      Initialization(nodes[0],nodes[6],nodes);//节点2结束 节点1开始    
  }  
     
     
 public static void Initialization(int node1,int node2,int nodes[]){   
     S = new ArrayList<Integer>();   
      S.add(node1);    // 输入开始节点 
 
        
     V = new ArrayList<Integer>();   
      for (int w = 0; w < nodes.length; w++)   
          if(nodes[w]!=node1)    
         V.add(nodes[w]);          
      int m=2*nodes.length;   
        
      ww = new Edge[m-1];   
      ww[0] = new Edge(-1, node1,0);   
 
      for (int w = 0; w <V.size(); w++){   
          int n =V.get(w);               
          ww[w + 1] = new Edge(node1, n, getWeight(node1, n));   
      }   
 
     for(int w=0 ;w<V.size();w++){   
             int n =V.get(w);               
             ww[w+50] = new Edge(n,node1, getWeight(n, node1));   
      }   
 
     
 //找到最短路径   
          while(V.size()>0) {         
          Min tt = getMinWeightNode();   
         if(tt.getWeight()==-1)   // 无法连接  
              tt.Path(node1,node2);   
          else    
             tt.Path(node2);   
       
          int node = tt.getLastNode();   
         S.add(node);             
          setWeight(node);   
          }   
 }   
     
     
//找父节点 
  public static int getParent(Edge[] parents, int node){   
      if (parents != null) {   
          for (Edge nd : ww){   
              if (nd.getBenode() == node){   
                  return nd.getPreNode();   
              }   
              if (nd.getPreNode()==node){   
                  return nd.getBenode();   
              }   
          }   
      }   
      return -1;   
  }   
 
  public static void setWeight(int preNode){   
      if (graph != null && ww != null &&V != null) {   
          for (int node :V){   
              Min msp=getShortPath(node);   
              int w1 = msp.getWeight();   
              if (w1 == -1)   
                  continue;   
              for (Edge n : ww){   
                  if (n.getBenode() == node){   
                      if (n.getWeight() == -1 || n.getWeight() > w1){   
                          n.setWeight(w1);   
                          n.setPreNode(preNode);   
                          break;   
                      }   
                  }                   
                      if (n.getPreNode() == node){   
                          if (n.getWeight() == -1 || n.getWeight() > w1){   
                              n.setWeight(w1);   
                              n.setBenode(preNode);   
                              break;   
                          }   
                  }   
              }               
          }   
          }   
  }   
//得到权重  
  public static int getWeight(int preNode, int node){   
      if (graph != null){   
          for (Edge s : graph){   
              if (s.getPreNode() == preNode && s.getBenode() == node)   
                  return s.getWeight();   
              if (s.getPreNode() == node && s.getBenode() == preNode)   
                  return s.getWeight();   
          }            
      }   
      return -1;   
  }   
 
 //找到V中权值最小的节点  
  public static Min getMinWeightNode(){   
      Min minMsp = null;   
      if (V.size() > 0){   
          int index = 0;   
          for (int j = 0; j <V.size(); j++) {   
              Min msp = getShortPath(V.get(j));   
              if (minMsp == null || msp.getWeight()!=-1 &&  msp.getWeight() < minMsp.getWeight()) {   
                  minMsp = msp;   
                  index = j;   
              }   
          }   
         V.remove(index);   
      }   
      return minMsp;   
  }   

 //找到最短路径   
  public static Min getShortPath(int node) {   
      Min mm = new Min(node);   
      if (ww != null &&S != null) {   
          for (int i = 0; i < S.size(); i++){   
              Min tempMsp = new Min(node);   
              int parent = S.get(i);   
              int currentNode = node;   
              while (parent > -1){   
                  int weight = getWeight(parent, currentNode);   
                  if (weight > -1) {   
                      tempMsp.addNode(parent);   
                      tempMsp.addWeight(weight);   
                      currentNode = parent;   
                      parent = getParent(ww, parent);   
                  } else   
                      break;   
              }   
 
              if (mm.getWeight() == -1 || tempMsp.getWeight()!=-1 && mm.getWeight() > tempMsp.getWeight())   
                  mm = tempMsp;   
          }   
      }   
      return mm;   
  }   
}  