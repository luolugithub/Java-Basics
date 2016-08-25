package suan3;

class Graph {
/** ***************��Ա���� ��ʼ��************************* */
private final int MAX_VERTS = 20;
private final int INFINTY = 100000;
//���ж���ļ���
private Vertex vertexList[];
//�ö�ά�������ʾ���ڽӾ��󣬼�ͼ
private int adjMat[][];
//��ǰ�������Ŀ
private int nVerts;
//����������е���Ŀ
private int nTree;
//���·������
private DistPar sPath[];
//��ǰ������±�
private int currentVent;
//��ǰ�������Դ��ľ���
private int startToCurrent;
/** ***************��ʼ�� ����************************* */
/** ***************���캯�� ��ʼ��************************* */
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
/** ***************���캯�� ����************************* */
/** ***************����ͼ ��ʼ************************* */
//	��Ӷ���
public void addVertex(char vertex) {
vertexList[nVerts++] = new Vertex(vertex);
}
//	��ӱߺ�Ȩֵ
public void addEdge(int start, int end, int weight) {
adjMat[start][end] = weight;
}
/** ***************����ͼ ����************************* */
/**  * Dijkstra�㷨 ��ʼ***********************/
public void path() {
//	 ��Դ�ڵ���뵽���� 
int startTree = 0;
vertexList[startTree].isInTree = true;
nTree = 1;
//	 ��Դ�ڵ��Ӧ���к��������д��ڽӾ���洢�����·��������
for (int i = 0; i < nVerts; i++) {
int tempDist = adjMat[startTree][i];
sPath[i] = new DistPar(startTree, tempDist);
}
//	 �����нڵ���뵽���У�����ѭ��
System.out.println("�������·������˳��");
while (nTree < nVerts) {
displayPaths();//��ӡ·��
int indexMin = getMin();//�õ���С����Ľڵ���±�
int minDist = sPath[indexMin].distance;
if (minDist == INFINTY) {
System.out.println("û�пɵ���Ľڵ㣡");
break;
} else {
currentVent = indexMin;
startToCurrent = sPath[indexMin].distance;
}
vertexList[currentVent].isInTree = true;
nTree++;
adjust_sPath();//����sPath[]�����·������
}//end while
System.out.println("���·����");
displayPaths();//��ӡ·��
for (int i = 0; i < nVerts; i++) {
vertexList[i].isInTree = false;
}
}//end path
//��ѯ���·�������У�δ�����еĽڵ㲢���Ǵ�Դ�㵽�����Ľڵ��������̵�·����ÿ�ν������Ľڵ���뵽����
public int getMin() {
int indexMin = 0;
int minDist = INFINTY;
for (int i = 0; i < nVerts; i++) {
if (!vertexList[i].isInTree && sPath[i].distance < minDist) {
minDist = sPath[i].distance;//�����С�Ľڵ�·��
indexMin = i;//������С�ڵ���±�
}
}// end for
return indexMin;
}
public void adjust_sPath() {
int column = 1; //����Դ��
while (column < nVerts) {
if (vertexList[column].isInTree) {
column++;
continue;
}
int currentToFringe = adjMat[currentVent][column];//�õ���ǰ�ڵ㵽ĳ�ڵ�ľ���ֵ
int startToFringe = startToCurrent + currentToFringe;//�õ���Դ�㵽��ǰ�ڵ�ľ���ֵ��Ҳ�����µľ���ֵ
int minDist = sPath[column].distance;//�õ�δ����ǰ�����·�������У���Դ�㵽���ж�Ӧ�Ķ���ľ���ֵ��Ҳ���Ǿɵľ���ֵ
//	 ���µľ���ֵ�;ɵľ���ֵ���Ƚ�
if (startToFringe < minDist) {
//	 ����µľ���ֵС�ھ�ֵ�����sPath����������
sPath[column].parentVert = currentVent;//���¸��ڵ㣬�øո���ӵ����еĽڵ���Ϊ���������ڵ�ĸ��ڵ�
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
char parent = vertexList[sPath[i].parentVert].vertex;//�����ڵ��ӡ
System.out.print("(" + parent + ")");
}// end for
System.out.println("");//����س�
}
}
class DistPar {
int parentVert;//ֻ�����洢���ڵ���±�
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
this.isInTree = false;//Ĭ�Ͻڵ㶼��δ��ӵ�����
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
System.out.println("��ʼDijkstra�㷨��");
theGraph.path();
System.out.println();
}// end main
}// end class PathApp