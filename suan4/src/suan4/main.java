package suan4;

import java.util.ArrayList;     
class Min {   //×îÐ¡Â·¾¶
  private ArrayList<Integer> List;   
 
  private int weight;   
 
  public Min(int node) {   
      List = new ArrayList<Integer>();   
      List.add(node);   
      weight = -1;   
  }   
  public int getFirstNode(){   
      int size=List.size();   
      return List.get(0);   
  }   
  public ArrayList<Integer> getNodeList(){   
      return List;   
  }   
 
  public void setNodeList(ArrayList<Integer> nodeList) {   
      List = nodeList;   
  }   
 
  public void addNode(int node) {   
      if (List == null)   
          List = new ArrayList<Integer>();   
      List.add(0, node);   
  }   
 
  public int getLastNode(){    
      int size = List.size();   
      return List.get(size - 1);   
 
  }   
 
  public int getWeight(){   
      return weight;   
  }   
 
  public void setWeight(int weight){   
      this.weight = weight;   
  }   
 
  public void Path(int node2){   
      Path(-1,node2);   
  }   
 
  public void Path(int Node,int node2){   
      String result = "[";   
      if (Node != -1)   
         List.add(Node);         
      for (int i=0; i < List.size(); i++){    
          result += "" +List.get(i);   
          if (i < List.size() - 1)   
              result += ",";   
      }            
           result += "]:" + weight;      
           if(List.get(0)==node2||List.get(List.size()-1)==node2)   
           System.out.println(result);               
       }   
              
     
 
  public void addWeight(int w){   
      if (weight == -1)   
          weight = w;   
      else   
          weight += w;   
  }   
}  