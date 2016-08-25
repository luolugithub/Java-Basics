package suan4;

//构图 
import java.util.ArrayList;   
 
public class Dijkstra {   
  static ArrayList<Edge> graph = null;   
 
  static ArrayList<Integer> S = null;   
 
  static ArrayList<Integer> V = null;   
 
  static Edge[] ww = null;   
 
  public static void main(String[] args){           
         
      int[] nodes = new int[60];   
      for(int i=0;i<nodes.length;i++){   
          nodes[i]=i;   
  }   
        
      graph = new ArrayList<Edge>();   
      
      for(int i=0;i<nodes.length;i++)   
          for(int j=0;j<nodes.length;j++){   
              if(i!=j){   
                 graph.add(new Edge(i,j,(int)(Math.random()*100+1)));   
              }   
          }   
      System.out.println("prenode"+" "+"benode"+" "+"weight");   
      for(int i=0;i<graph.size();i++){   
         System.out.println(graph.get(i).getPreNode()+"       "+graph.get(i).getBenode()+"      "+graph.get(i).getWeight());   
      }    
      Initialization(nodes[0],nodes[6],nodes);      
  }     
 public static void Initialization(int node1,int node2,int nodes[]){   
     S = new ArrayList<Integer>();   
      S.add(node1);    // 输入起始节点          
     V = new ArrayList<Integer>();   
      for (int w = 0; w < nodes.length; w++)   
          if(nodes[w]!=node1)    
         V.add(nodes[w]);         
      ww = new Edge[nodes.length];   
      ww[0] = new Edge(-1, node1,0);   
      for (int w = 0; w <V.size(); w++){   
          int n =V.get(w);   
          ww[w + 1] = new Edge(node1, n, getWeight(node1, n));   
      }   
          while(V.size()>0) {         
          Min tt = getMinWeightNode();   
         if(tt.getWeight()==-1)   //无连接   
              tt.Path(node1,node2);   
          else    
             tt.Path(node2);    
          int node = tt.getLastNode();   
         S.add(node);             
          setWeight(node);   
          }   
 }       
//找到父节点 
  public static int getParent(Edge[] parents, int node){   
      if (parents != null) {   
          for (Edge nd : ww){   
              if (nd.getBenode() == node){   
                  return nd.getPreNode();   
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
              }   
          }   
      }   
  }   
//得到两节点间的权重  
  public static int getWeight(int preNode, int node){   
      if (graph != null){   
          for (Edge s : graph){   
              if (s.getPreNode() == preNode && s.getBenode() == node)   
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
 
 // 找到最短路径   
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