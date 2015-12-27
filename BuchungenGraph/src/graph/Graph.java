package graph;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private ArrayList<Vertex> vertices;
	private ArrayList<Arc> arcs;
	
	public Graph(){
		this.arcs = new ArrayList<Arc>();
		this.vertices = new ArrayList<Vertex>();
	}
	
	public void addVertex(String id){
		Vertex v = new Vertex(id);
		boolean isNotInArray = true;
		for(Vertex u : vertices){
			if(u.getId().equals(v.getId())){
				isNotInArray = false;
			}
		}
		if(isNotInArray){
			vertices.add(v);
		}
	}
	
	public void addArc(String head, String tail){
		Vertex v_head = null;
		Vertex v_tail = null;
		for(Vertex v : vertices){
			if(v.getId().equals(head)){
				v_head = v;
				break;
			}
		}
		for(Vertex v : vertices){
			if(v.getId().equals(tail)){
				v_tail = v;
				break;
			}
		}
		
		boolean isNotInArray = true;
		for(Arc a : arcs){
			Vertex a_tail = a.getTail();
			Vertex a_head = a.getHead();
			if(a_tail.getId().equals(v_tail.getId()) && a_head.getId().equals(v_head.getId())){
				a.increaseC(1);
				isNotInArray = false;
				break;
			}
		}
		if(isNotInArray){
			Arc a = new Arc(v_tail, v_head);
			this.arcs.add(a);
			v_head.getIncommingArcs().add(a);
			v_tail.getOutgoingArcs().add(a);
		}		
		
	}

	public ArrayList<Vertex> getVertices() {
		return vertices;
	}

	public ArrayList<Arc> getArcs() {
		return arcs;
	}
	
}
