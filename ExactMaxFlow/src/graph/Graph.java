package graph;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private ArrayList<Vertex> vertices;
	private ArrayList<Arc> arcs;
	
	public void createVertices(int numOfvertices){
		this.vertices = new ArrayList<Vertex>(numOfvertices);
	}
	
	public void addVertex(int id, int x, int y){
		Vertex v = new Vertex(id, x, y);
		this.vertices.add(id-1, v);
	}
	
	public void createEdges(int numOfedges){
		this.arcs = new ArrayList<Arc>(numOfedges);
	}
	
	public void addArc(int head, int tail, Fraction c){
		Vertex v_head = this.vertices.get(head-1);
		Vertex v_tail = this.vertices.get(tail-1);
		Arc a = new Arc(v_tail, v_head, c);
		
		this.arcs.add(a);
		
		v_head.getIncommingArcs().add(a);
		v_tail.getOutgoingArcs().add(a);
	}

	public ArrayList<Vertex> getVertices() {
		return vertices;
	}

	public ArrayList<Arc> getArcs() {
		return arcs;
	}
	
	//ToDo: stop for t einbauen CHECK
	//		weitere Kanten aus Dx einbauen CHECK
	//		Pfad zurück als ArrayList bauen CHECK
	//		Direkt augmentieren beim Pfad erstellen CHECK
	public boolean bfsDx(Vertex s, Vertex t){ 
		boolean isPathToT = false;
//		pathway = new ArrayList<Arc>();
		Fraction[] maxValueToAugment = new Fraction[this.vertices.size()];
		boolean[] vIsVisited = new boolean[this.vertices.size()];
		Vertex[] path = new Vertex[this.vertices.size()];
		for(Vertex v : this.vertices){
			if(v.getId() == s.getId()){
				vIsVisited[v.getId()-1] = true;
				path[v.getId()-1] = null;
				maxValueToAugment[v.getId()-1] = new Fraction(Double.MAX_VALUE);
			} else {
				vIsVisited[v.getId()-1] = false;
				path[v.getId()-1] = null;
				maxValueToAugment[v.getId()-1] =new Fraction(Double.MAX_VALUE);
			}
		}
		Queue<Vertex> Q = new LinkedList<Vertex>();
		Q.add(s);
		while(!Q.isEmpty()){
			Vertex u = Q.poll();
			for(Arc a : u.getOutgoingArcs()){
				Vertex v = a.getHead();
				if(v.getId() == t.getId()  && (a.getC().subtract(a.getF()).signum() > 0)){
					maxValueToAugment[v.getId()-1] = maxValueToAugment[u.getId()-1].min(a.getC().subtract(a.getF()));
					vIsVisited[v.getId()-1] = true;
					path[v.getId()-1] = u;
					Q.clear();
					isPathToT = true;
					break;
				}
				if(vIsVisited[v.getId()-1] == false && (a.getC().subtract(a.getF()).signum() > 0) ){
					maxValueToAugment[v.getId()-1] = maxValueToAugment[u.getId()-1].min(a.getC().subtract(a.getF()));
					vIsVisited[v.getId()-1] = true;
					path[v.getId()-1] = u;
					Q.add(v);
				}
			} 
			if(!isPathToT){
				for(Arc a : u.getIncommingArcs()){
					Vertex v = a.getTail();
					if(v.getId() == t.getId()  && (a.getF().signum() > 0)){
						maxValueToAugment[v.getId()-1] = maxValueToAugment[u.getId()-1].min(a.getF());
						vIsVisited[v.getId()-1] = true;
						path[v.getId()-1] = u;
						Q.clear();
						isPathToT = true;
						break;
					}
					if(vIsVisited[v.getId()-1] == false && (a.getF().signum() > 0) ){
						maxValueToAugment[v.getId()-1] = maxValueToAugment[u.getId()-1].min(a.getF());
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

	private void augmentPath(Vertex[] path, Vertex s, Vertex v, Fraction maxValueToAugment){
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
					a.setF(a.getF().add(maxValueToAugment));
				}
			}
			for(Arc a : v.getOutgoingArcs()){
				Vertex v2 = a.getHead();
				if(v2.getId() == path[v.getId()-1].getId()){
					a.setF(a.getF().subtract(maxValueToAugment));
				}
			}
			this.augmentPath(path, s, path[v.getId()-1], maxValueToAugment);
		}
	}
}
