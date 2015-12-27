package graph;



public class Arc {
	private double weight;
	
	private Vertex head;
	private Vertex tail;
	
	public Arc(Vertex tail, Vertex head, double weight){
		this.tail = tail;
		this.head = head;
		this.setWeight(weight);
	}

	public Vertex getHead() {
		return head;
	}

	public void setHead(Vertex head) {
		this.head = head;
	}

	public Vertex getTail() {
		return tail;
	}

	public void setTail(Vertex tail) {
		this.tail = tail;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
		
}
