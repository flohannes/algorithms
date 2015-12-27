package algo;

import graph.Arc;
import graph.Graph;
import graph.Vertex;



public class DFS implements IBFSDFS{

	private int time;
	private boolean[] isVisited;
	private int[] distance;
	private int[] finishingTime;
	private Vertex[] path;
	
	@Override
	public void calc(Graph graph, Vertex s) {
		isVisited = new boolean[graph.getVertices().size()];
		distance = new int[graph.getVertices().size()];
		finishingTime = new int[graph.getVertices().size()];
		path = new Vertex[graph.getVertices().size()];
		
		//Init
		for(Vertex u : graph.getVertices()){
			isVisited[u.getId()-1] = false;
			path[u.getId()-1] = null;
		}
		time = 0;
		
		//Step2
		for(Vertex u : graph.getVertices()){
			if(isVisited[u.getId()-1] == false){
				//Subroutine
				this.dfsVisit(graph, u);
			}
		}
	}
	
	private void dfsVisit(Graph graph, Vertex u){
		time = time + 1;
		distance[u.getId()-1] = time;
		isVisited[u.getId()-1] = true;
		for(Arc a : u.getOutgoingArcs()){
			Vertex v = a.getHead();
			if(isVisited[v.getId()-1] == false){
				path[v.getId()-1] = u;
				dfsVisit(graph, v);
			}
		}
		isVisited[u.getId()-1] = true;
		time = time + 1;
		finishingTime[u.getId()-1] = time;
	}
	
	public int[] getFinishingTime(){
		return this.finishingTime;
	}

}
