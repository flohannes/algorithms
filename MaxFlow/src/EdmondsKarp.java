import java.util.LinkedList;
import java.util.Queue;

import graph.Arc;
import graph.Graph;
import graph.Vertex;


public class EdmondsKarp implements IMaxFlowSolver{

	@Override
	public double calcMaxFlow(Graph graph, int s, int t) {
		Vertex start = graph.getVertices().get(s-1);
		Vertex terminate = graph.getVertices().get(t-1);
		while (this.bfsDx(graph, start, terminate)){
		}
		double maxFlow = 0;
		for(Arc a : terminate.getIncommingArcs()){
			maxFlow = maxFlow + a.getF();
		}
		return maxFlow;
	}
	
	private boolean bfsDx(Graph graph, Vertex s, Vertex t){ 
		boolean isPathToT = false;
//		pathway = new ArrayList<Arc>();
		double[] maxValueToAugment = new double[graph.getVertices().size()];
		boolean[] vIsVisited = new boolean[graph.getVertices().size()];
		Vertex[] path = new Vertex[graph.getVertices().size()];
		for(Vertex v : graph.getVertices()){
			if(v.getId() == s.getId()){
				vIsVisited[v.getId()-1] = true;
				path[v.getId()-1] = null;
				maxValueToAugment[v.getId()-1] = Double.MAX_VALUE;
			} else {
				vIsVisited[v.getId()-1] = false;
				path[v.getId()-1] = null;
				maxValueToAugment[v.getId()-1] = Double.MAX_VALUE;
			}
		}
		Queue<Vertex> Q = new LinkedList<Vertex>();
		Q.add(s);
		while(!Q.isEmpty()){
			Vertex u = Q.poll();
			for(Arc a : u.getOutgoingArcs()){
				Vertex v = a.getHead();
				if(v.getId() == t.getId()  && (a.getC()-a.getF() > 0)){
					maxValueToAugment[v.getId()-1] = Math.min(maxValueToAugment[u.getId()-1], a.getC()-a.getF());
					vIsVisited[v.getId()-1] = true;
					path[v.getId()-1] = u;
					Q.clear();
					isPathToT = true;
					break;
				}
				if(vIsVisited[v.getId()-1] == false && (a.getC()-a.getF() > 0) ){
					maxValueToAugment[v.getId()-1] = Math.min(maxValueToAugment[u.getId()-1], a.getC()-a.getF());
					vIsVisited[v.getId()-1] = true;
					path[v.getId()-1] = u;
					Q.add(v);
				}
			} 
			if(!isPathToT){
				for(Arc a : u.getIncommingArcs()){
					Vertex v = a.getTail();
					if(v.getId() == t.getId()  && (a.getF() > 0)){
						maxValueToAugment[v.getId()-1] = Math.min(maxValueToAugment[u.getId()-1], a.getF());
						vIsVisited[v.getId()-1] = true;
						path[v.getId()-1] = u;
						Q.clear();
						isPathToT = true;
						break;
					}
					if(vIsVisited[v.getId()-1] == false && (a.getF() > 0) ){
						maxValueToAugment[v.getId()-1] = Math.min(maxValueToAugment[u.getId()-1], a.getF());
						vIsVisited[v.getId()-1] = true;
						path[v.getId()-1] = u;
						Q.add(v);
					}
				}
			}
		}
		//Weg von t zu s
		if(isPathToT){
			this.augmentPath(path, s, t, maxValueToAugment[t.getId()-1]);
		} else {
			return false;
		}
		return isAugPath;
	}
	
	private boolean isAugPath;

	private void augmentPath(Vertex[] path, Vertex s, Vertex v, double maxValueToAugment){
		if(s.getId() == v.getId()){
			isAugPath = true;
		}
		else if(path[v.getId()-1] == null){
			System.out.println("No path exists from " + s.getId() + " to " + v.getId());
			isAugPath = false;
		}
		else{
			for(Arc a : v.getIncommingArcs()){
				Vertex v2 = a.getTail();
				if(v2.getId() == path[v.getId()-1].getId()){
					a.setF(a.getF() + maxValueToAugment);
				}
			}
			for(Arc a : v.getOutgoingArcs()){
				Vertex v2 = a.getHead();
				if(v2.getId() == path[v.getId()-1].getId()){
					a.setF(a.getF() - maxValueToAugment);
				}
			}
			this.augmentPath(path, s, path[v.getId()-1], maxValueToAugment);
		}
	}
}
