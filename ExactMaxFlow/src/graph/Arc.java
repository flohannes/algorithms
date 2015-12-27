package graph;

public class Arc {
	private Fraction c; //Kapazität der Kante
	private Fraction f; //Fluss der durchgeschickt wird aktuell
	
	private Vertex head;
	private Vertex tail;
	
	public Arc(Vertex tail, Vertex head, Fraction c){
		this.tail = tail;
		this.head = head;
		this.c = c;
		this.f = new Fraction(0);
	}

	public Fraction getC() {
		return c;
	}

	public void setC(Fraction c) {
		this.c = c;
	}

	public Fraction getF() {
		return f;
	}

	public void setF(Fraction f) {
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
	
	
	
}
