import java.util.ArrayList;

public class BranchingVC {

	//Botton up nun programmieren und G immer verkleinern! Bis auf Größe 3, 4, 5 Knoten und dann drauf branchen.
	private Graph graph;
	private int k;
	private ArrayList<Vertex> solution;
	
	public BranchingVC(Graph graph, int k){
		this.graph = graph;
	}
	
	//High degree rule, low degree rule / crown decomposition
	public ArrayList<Vertex> calcVC(){
		solution = new ArrayList<Vertex>();
		ArrayList<Vertex> S = new ArrayList<Vertex>();
		S = this.calcVCsubroutine(S);
		return solution;
	}
	
	private ArrayList<Vertex> calcVCsubroutine(ArrayList<Vertex> S){
		if(solution.size() == k){
			return null;
		}
		if(S.size() == k){
			if(checkLoesung(S)){
				solution = S;
				return S; //Hier vielleicht ein Globales break machen
			} else {
				return null;
			}
		}
		//Neues v suchen, was noch nicht in S enthalten ist
		ArrayList<Vertex> S1 = (ArrayList<Vertex>) S.clone();
		ArrayList<Vertex> S2 = (ArrayList<Vertex>) S.clone();
		for(Vertex v : graph.getVertices()){
			if(!S.contains(v)){
				S1.add(v);
				for(Arc a : v.getOutgoingArcs()){
					S2.add(a.getHead());
				}
				for(Arc a : v.getIncommingArcs()){
					S2.add(a.getTail());
				}
				break;
			}
		}
		calcVCsubroutine(S1);
		calcVCsubroutine(S2);
		return null;
	}
	
	private boolean checkLoesung(ArrayList<Vertex> S){
		ArrayList<Arc> arcList = new ArrayList<Arc>();
		for(Vertex v : S){
			//Suche alle Arcs heraus
			for(Arc a : v.getOutgoingArcs()){
				if(!arcList.contains(a)){
					arcList.add(a);
				}
			}
			for(Arc a : v.getIncommingArcs()){
				if(!arcList.contains(a)){
					arcList.add(a);
				}
			}
		}
		//Checke, ob alle gedeckt sind
		if(arcList.size() == graph.getArcs().size()){
			return true;
		}
		return false;
	}
}
