package algo;

import java.util.LinkedList;
import java.util.Queue;

import graph.Arc;
import graph.Graph;
import graph.Vertex;

public class BFS implements IBFSDFS{

	@Override
	public void calc(Graph graph, Vertex s) {
		double[] distance = new double[graph.getVertices().size()];
		boolean[] vIsVisited = new boolean[graph.getVertices().size()];
		Vertex[] path = new Vertex[graph.getVertices().size()];
		for(Vertex v : graph.getVertices()){
			if(v.getId() == s.getId()){
				vIsVisited[v.getId()-1] = true;
				path[v.getId()-1] = null;
				distance[v.getId()-1] = Double.MAX_VALUE;
			} else {
				vIsVisited[v.getId()-1] = false;
				path[v.getId()-1] = null;
				distance[v.getId()-1] = Double.MAX_VALUE;
			}
		}
		Queue<Vertex> Q = new LinkedList<Vertex>();
		Q.add(s);
		while(!Q.isEmpty()){
			Vertex u = Q.poll();
			for(Arc a : u.getOutgoingArcs()){
				Vertex v = a.getHead();
				if(!vIsVisited[v.getId()-1]){
					vIsVisited[v.getId()-1] = true;
					distance[v.getId()-1] = distance[v.getId()-1] + 1;
					path[v.getId()-1] = u;
					Q.add(v);
				}
			}
		}
	}
	
	public void printPath(Vertex[] path, Vertex s, Vertex v){
		if(v.getId() == s.getId())
			System.out.println(s.getId());
		else if(path[v.getId()-1] == null)
			System.out.println("No path exists from " + s.getId() + " to " + v.getId());
		else{
			printPath(path, s, path[v.getId()-1]);
			System.out.println(v.getId());
		}
	}

}
