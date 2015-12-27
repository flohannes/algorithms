package graph;

import java.util.ArrayList;

public class Graph {

	private ArrayList<Vertex> vertices;
	private ArrayList<Arc> arcs;
	
	public void createVertices(int numOfvertices){
		this.vertices = new ArrayList<Vertex>(numOfvertices);
	}
	
	public void addVertex(int id){
		Vertex v = new Vertex(id);
		this.vertices.add(id-1, v);
	}
	
	public void createEdges(int numOfedges){
		this.arcs = new ArrayList<Arc>(numOfedges);
	}
	
	public void addArc(int head, int tail, double weight){
		Vertex v_head = this.vertices.get(head-1);
		Vertex v_tail = this.vertices.get(tail-1);
		Arc a = new Arc(v_tail, v_head, weight);
		
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

	public void setVertices(ArrayList<Vertex> vertices) {
		this.vertices = vertices;
	}

	public void setArcs(ArrayList<Arc> arcs) {
		this.arcs = arcs;
	}
}
