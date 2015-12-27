package graph;

import java.util.ArrayList;

public class Vertex {
	
	private int id;
	private int x; //x koordinate;
	private int y; //y koordinate;
	
	private ArrayList<Arc> outgoingArcs;
	private ArrayList<Arc> incommingArcs;
	
	public Vertex(int id, int x, int y){
		this.id = id;
		this.x = x;
		this.y = y;
		
		this.outgoingArcs = new ArrayList<Arc>();
		this.incommingArcs = new ArrayList<Arc>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
