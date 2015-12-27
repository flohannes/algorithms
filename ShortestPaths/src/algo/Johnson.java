package algo;

import java.util.ArrayList;

import graph.Arc;
import graph.Graph;
import graph.Vertex;

public class Johnson implements IShortestAllPathsSolver{

	@Override
	public ArrayList<double[]> calcDistance(Graph graph) {
		ArrayList<double[]> distances = new ArrayList<double[]>();
		Graph graphTemp = new Graph();
		graphTemp.setVertices((ArrayList<Vertex>) graph.getVertices().clone());
		graphTemp.setArcs((ArrayList<Arc>) graph.getArcs().clone());
		graphTemp.addVertex(graphTemp.getVertices().size());
		for(int i = 1; i < graphTemp.getVertices().size(); i++){
			graphTemp.addArc(i, graphTemp.getVertices().size()-1, 0);
		}
		
		BellmanFord bellmanFordAlgo = new BellmanFord();
		double[] bellmanFord = bellmanFordAlgo.calcDistance(graphTemp, graph.getVertices().size());
		if(bellmanFord==null){
			return null;
		}
		
		double[] h = new double[graphTemp.getVertices().size()];
		for(Vertex v : graphTemp.getVertices()){
			h[v.getId()-1] = bellmanFord[v.getId()-1];
		}
		for(Arc a : graphTemp.getArcs()){
			Vertex u = a.getTail();
			Vertex v = a.getHead();
			double oldWeight = a.getWeight();
			a.setWeight( (oldWeight + h[u.getId()-1] - h[v.getId()-1]) );
		}
		
		for(Vertex u : graphTemp.getVertices()){
			if(u.getId() != graphTemp.getVertices().size()-1){
				Dijkstra dijkstraAlgo = new Dijkstra();
				double[] d = dijkstraAlgo.calcDistance(graphTemp, u.getId());
				for(int i = 0; i < d.length; i++){
					d[i] = d[i] + h[i] - h[u.getId()-1];
				}
				distances.add(d);
			}
		}
		
		return distances;
	}

}
