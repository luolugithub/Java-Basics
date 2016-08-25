package suan3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Dijkstra {
	Set<Node> open=new HashSet<Node>();
	Set<Node> close=new HashSet<Node>();
	Map<String,Integer> path=new HashMap<String,Integer>();//��װ·������
	Map<String,String> pathInfo=new HashMap<String,String>();//��װ·����Ϣ
	public Node init(){
		//��ʼ·��,��û��A->E����·��,����path(E)����ΪInteger.MAX_VALUE
		path.put("B", 1);
		pathInfo.put("B", "A->B");
		path.put("C", 1);
		pathInfo.put("C", "A->C");
		path.put("D", 4);
		pathInfo.put("D", "A->D");
		path.put("E", Integer.MAX_VALUE);
		pathInfo.put("E", "A");
		path.put("F", 2);
		pathInfo.put("F", "A->F");
		path.put("G", 5);
		pathInfo.put("G", "A->G");
		path.put("H", Integer.MAX_VALUE);
		pathInfo.put("H", "A");
		//����ʼ�ڵ����close,�����ڵ����open
		Node start=new MapBuilder().build(open,close);
		return start;
	}
	public void computePath(Node start){
		Node nearest=getShortestPath(start);//ȡ����start�ڵ�������ӽڵ�,����close
		if(nearest==null){
			return;
		}
		close.add(nearest);
		open.remove(nearest);
		Map<Node,Integer> childs=nearest.getChild();
		for(Node child:childs.keySet()){
			if(open.contains(child)){//����ӽڵ���open��
				Integer newCompute=path.get(nearest.getName())+childs.get(child);
				if(path.get(child.getName())>newCompute){//֮ǰ���õľ�������¼�������ľ���
					path.put(child.getName(), newCompute);
					pathInfo.put(child.getName(), pathInfo.get(nearest.getName())+"->"+child.getName());
				}
			}
		}
		computePath(start);//�ظ�ִ���Լ�,ȷ�������ӽڵ㱻����
		computePath(nearest);//����һ���ݹ�,ֱ�����ж��㱻����
	}
	public void printPathInfo(){
		Set<Map.Entry<String, String>> pathInfos=pathInfo.entrySet();
		for(Map.Entry<String, String> pathInfo:pathInfos){
			System.out.println(pathInfo.getKey()+":"+pathInfo.getValue());
		}
	}
	/**
	 * ��ȡ��node������ӽڵ�
	 */
	private Node getShortestPath(Node node){
		Node res=null;
		int minDis=Integer.MAX_VALUE;
		Map<Node,Integer> childs=node.getChild();
		for(Node child:childs.keySet()){
			if(open.contains(child)){
				int distance=childs.get(child);
				if(distance<minDis){
					minDis=distance;
					res=child;
				}
			}
		}
		return res;
	}
}