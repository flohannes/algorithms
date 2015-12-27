package algo;

import graph.Arc;
import graph.Graph;
import graph.Vertex;

public class BellmanFord implements IShortestSinglePathSolver{

	@Override
	public double[] calcDistance(Graph graph, int s) {
		//Init
		Vertex[] predessessor = new Vertex[graph.getVertices().size()]; 
		double[] distance = new double[graph.getVertices().size()];
		for(Vertex v : graph.getVertices()){
			if(s == v.getId()){
				distance[v.getId()-1] = 0;
			} else {
				distance[v.getId()-1] = Double.POSITIVE_INFINITY;
			}
		}
		
		for(int i = 1; i < graph.getVertices().size(); i++){
			for(Arc a : graph.getArcs()){
				//Relax
				Vertex u = a.getTail();
				Vertex v = a.getHead();
				if(distance[v.getId()-1] > distance[u.getId()-1] + a.getWeight()){
					distance[v.getId()-1] = distance[u.getId()-1] + a.getWeight();
					predessessor[v.getId()-1] = u;
				}
			}
		}
		for(Arc a : graph.getArcs()){
			Vertex u = a.getTail();
			Vertex v = a.getHead();
			double ab = distance[v.getId()-1];
			if(distance[v.getId()-1] > distance[u.getId()-1] + a.getWeight()){
				return null;
			}
		}
		
		return distance;
	}

}
