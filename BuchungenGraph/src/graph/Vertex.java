package graph;

import java.util.ArrayList;

public class Vertex {
	
	private String id;
	
	private ArrayList<Arc> outgoingArcs;
	private ArrayList<Arc> incommingArcs;
	
	public Vertex(String id){
		this.id = id;
		
		this.outgoingArcs = new ArrayList<Arc>();
		this.incommingArcs = new ArrayList<Arc>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Arc> getOutgoingArcs() {
		return outgoingArcs;
	}

	public void setOutgoingArcs(ArrayList<Arc> outgoingArcs) {
		this.outgoingArcs = outgoingArcs;
	}

	public ArrayList<Arc> getIncommingArcs() {
		return incommingArcs;
	}

	public void setIncommingArcs(ArrayList<Arc> incommingArcs) {
		this.incommingArcs = incommingArcs;
	}

}
