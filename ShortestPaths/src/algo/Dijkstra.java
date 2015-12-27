package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graph.Arc;
import graph.Graph;
import graph.Vertex;

public class Dijkstra implements IShortestSinglePathSolver{

	@Override
	public double[] calcDistance(Graph graph, int s) {
		for(Arc a : graph.getArcs()){
			if(a.getWeight()<0){
				return null;
			}
		}
		
		//Init
		Vertex[] predessessor = new Vertex[graph.getVertices().size()]; 
		double[] distance = new double[graph.getVertices().size()];
		boolean[] isVisited = new boolean[graph.getVertices().size()];
		for(Vertex v : graph.getVertices()){
			if(s == v.getId()){
				distance[s-1] = 0;
				isVisited[v.getId()-1] = false;
			} else {
				distance[v.getId()-1] = Double.POSITIVE_INFINITY;
				isVisited[v.getId()-1] = false;
			}
		}
		ArrayList<Vertex> Q = new ArrayList<Vertex>();
		Q = (ArrayList<Vertex>) graph.getVertices().clone();
//		boolean 
		
		while(!Q.isEmpty()){
			//Extract Min
			Vertex u = null;
			for(Vertex v : Q){
				if(u == null){
					u = v;
				} else if (distance[v.getId()-1] < distance[u.getId()-1]){
					u = v;
				}
			}
			Q.remove(u);
			
			for(Arc a : u.getOutgoingArcs()){
				Vertex v = a.getHead();
				if(distance[v.getId()-1] > distance[u.getId()-1] + a.getWeight()){
					distance[v.getId()-1] = distance[u.getId()-1] + a.getWeight();
					predessessor[v.getId()-1] = u;
				}
			}
		}
		
		return distance;
	}

}
