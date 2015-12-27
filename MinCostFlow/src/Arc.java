

public class Arc {
	private double c; //Kapazität der Kante
	private double f; //Fluss der durchgeschickt wird aktuell
	private double cost; //Kosten für eine Einheit des Flusses
	
	private Vertex head;
	private Vertex tail;
	
	public Arc(Vertex tail, Vertex head, double c, double cost){
		this.tail = tail;
		this.head = head;
		this.c = c;
		this.f = 0;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
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
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	
}
