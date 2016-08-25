package suan3;

class Graph {
/** ***************成员变量 初始化************************* */
private final int MAX_VERTS = 20;
private final int INFINTY = 100000;
//所有顶点的集合
private Vertex vertexList[];
//用二维数组组表示的邻接矩阵，即图
private int adjMat[][];
//当前顶点的数目
private int nVerts;
//顶点放入树中的数目
private int nTree;
//最短路径数组
private DistPar sPath[];
//当前顶点的下标
private int currentVent;
//当前顶点距离源点的距离
private int startToCurrent;
/** ***************初始化 结束************************* */
/** ***************构造函数 初始化************************* */
public Graph() {
super();
vertexList = new Vertex[MAX_VERTS];
adjMat = new int[MAX_VERTS][MAX_VERTS];
nVerts = 0;
nTree = 0;
for (int i = 0; i < MAX_VERTS; i++) {
for (int j = 0; j < MAX_VERTS; j++) {
adjMat[i][j] = INFINTY;
}
}
sPath = new DistPar[MAX_VERTS];
}
/** ***************构造函数 结束************************* */
/** ***************构造图 开始************************* */
//	添加顶点
public void addVertex(char vertex) {
vertexList[nVerts++] = new Vertex(vertex);
}
//	添加边和权值
public void addEdge(int start, int end, int weight) {
adjMat[start][end] = weight;
}
/** ***************构造图 结束************************* */
/**  * Dijkstra算法 开始***********************/
public void path() {
//	 对源节点放入到树中 
int startTree = 0;
vertexList[startTree].isInTree = true;
nTree = 1;
//	 将源节点对应的行和其所有列从邻接矩阵存储在最短路径数组中
for (int i = 0; i < nVerts; i++) {
int tempDist = adjMat[startTree][i];
sPath[i] = new DistPar(startTree, tempDist);
}
//	 将所有节点加入到树中，结束循环
System.out.println("更新最短路径数组顺序：");
while (nTree < nVerts) {
displayPaths();//打印路径
int indexMin = getMin();//得到最小距离的节点的下标
int minDist = sPath[indexMin].distance;
if (minDist == INFINTY) {
System.out.println("没有可到达的节点！");
break;
} else {
currentVent = indexMin;
startToCurrent = sPath[indexMin].distance;
}
vertexList[currentVent].isInTree = true;
nTree++;
adjust_sPath();//更新sPath[]即最短路径数组
}//end while
System.out.println("最短路径：");
displayPaths();//打印路径
for (int i = 0; i < nVerts; i++) {
vertexList[i].isInTree = false;
}
}//end path
//查询最短路径数组中，未在树中的节点并且是从源点到这样的节点距离中最短的路径，每次将这样的节点放入到树中
public int getMin() {
int indexMin = 0;
int minDist = INFINTY;
for (int i = 0; i < nVerts; i++) {
if (!vertexList[i].isInTree && sPath[i].distance < minDist) {
minDist = sPath[i].distance;//查出最小的节点路径
indexMin = i;//更新最小节点的下标
}
}// end for
return indexMin;
}
public void adjust_sPath() {
int column = 1; //跳过源点
while (column < nVerts) {
if (vertexList[column].isInTree) {
column++;
continue;
}
int currentToFringe = adjMat[currentVent][column];//得到当前节点到某节点的距离值
int startToFringe = startToCurrent + currentToFringe;//得到从源点到当前节点的距离值，也就是新的距离值
int minDist = sPath[column].distance;//得到未更新前的最短路径数组中，从源点到该列对应的顶点的距离值，也就是旧的距离值
//	 将新的距离值和旧的距离值作比较
if (startToFringe < minDist) {
//	 如果新的距离值小于旧值，则对sPath数组作更新
sPath[column].parentVert = currentVent;//更新父节点，用刚刚添加到树中的节点作为更新其他节点的父节点
sPath[column].distance = startToFringe;
}// end if
column++;
}// end while
}
public void displayPaths() {
for (int i = 0; i < nVerts; i++) {
System.out.print(vertexList[i].vertex + "=");
if (sPath[i].distance == INFINTY) {
System.out.print("inf");
} else {
System.out.print(sPath[i].distance);
}
char parent = vertexList[sPath[i].parentVert].vertex;//将父节点打印
System.out.print("(" + parent + ")");
}// end for
System.out.println("");//输出回车
}
}
class DistPar {
int parentVert;//只用来存储父节点的下标
int distance;
public DistPar(int parentVert, int distance) {
super();
this.distance = distance;
this.parentVert = parentVert;
}
}
class Vertex {
char vertex;
boolean isInTree;
public Vertex(char vertex) {
super();
this.vertex = vertex;
this.isInTree = false;//默认节点都是未添加到树中
}
}
public class PathApp {
/**
* @param args
*/
public static void main(String[] args) {
//TODO Auto-generated method stub
Graph theGraph = new Graph();
theGraph.addVertex('A');
theGraph.addVertex('B');
theGraph.addVertex('C');
theGraph.addVertex('D');
theGraph.addVertex('E');
theGraph.addEdge(0, 1, 50);
theGraph.addEdge(0, 3, 80);
theGraph.addEdge(1, 2, 60);
theGraph.addEdge(1, 3, 90);
theGraph.addEdge(2, 4, 40);
theGraph.addEdge(3, 2, 20);
theGraph.addEdge(3, 4, 70);
theGraph.addEdge(4, 1, 50);
System.out.println("开始Dijkstra算法：");
theGraph.path();
System.out.println();
}// end main
}// end class PathApp