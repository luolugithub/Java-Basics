package suan4;

class Edge {   
    private int preNode;     
   
    private int benode;   
   
    private int weight;   
   
    public Edge(int preNode, int benode, int weight) {   //构造边，节点
        this.preNode = preNode;   
        this.benode = benode;   
        this.weight = weight;   
    }   
   
    public int getPreNode(){   
        return preNode;   
    }   
   
    public void setPreNode(int preNode){   
        this.preNode = preNode;   
    }   
   
    public int getBenode() {   
        return benode;   
    }   
   
    public void setBenode(int benode){   
        this.benode = benode;   
    }   
   
    public int getWeight(){   
        return weight;   
    }   
   
    public void setWeight(int weight){   
        this.weight = weight;   
    }   
   
}  