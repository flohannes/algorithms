import graph.Arc;
import graph.Fraction;
import graph.Graph;
import graph.Vertex;


public class GoldbergTarjan implements IMaxFlowSolver{

	@Override
	public Fraction calcMaxFlow(Graph graph, int s, int t) {
		Vertex start = graph.getVertices().get(s-1);
		Vertex terminate = graph.getVertices().get(t-1);
		//Schritt 1
		for(Arc a : start.getOutgoingArcs()){
			a.setF(a.getC());
		}
		int[] d = new int[graph.getVertices().size()];
		d[start.getId()-1] = graph.getVertices().size();
	
		//Schritt 2
		while(true){
			Vertex v = getActiveNode(graph, start, terminate, d);
			if(v == null){
				break;
			}
			//Schritt 3
			Arc a = getAdmissibleArc(v, d);
			if(a==null){				
				d = relabel(v, d);
				a = getAdmissibleArc(v, d);
			}else{
				push(v, a);
			}
//			push(v, a);
		}
		
		Fraction maxFlow = new Fraction(0);
		for(Arc a : terminate.getIncommingArcs()){
			maxFlow = maxFlow.add(a.getF());
		}
		return maxFlow;
	}
	
	private Vertex getActiveNode(Graph graph, Vertex s, Vertex t, int[] d){
		Vertex vmax = null;
		Fraction exmax = new Fraction(0);
		Fraction smallNumber = new Fraction(0.0000001);
		for(Vertex v : graph.getVertices()){
			
			if(!(v.getId() == s.getId() || v.getId()==t.getId())){
				Fraction ex = new Fraction(0);
				for(Arc a : v.getIncommingArcs()){
					ex = ex.add(a.getF());
				}
				for(Arc a : v.getOutgoingArcs()){
					ex = ex.subtract(a.getF());
				}
				if(ex.signum()>0){
//					System.out.println(v.getId() + " " +ex);
//					return v;
					if(vmax==null){
						vmax = v;
						exmax = ex;
					} else {
						if(exmax.compareTo(ex)<0){
							vmax = v;
							exmax = ex;
						}
//						if(d[v.getId()-1] > d[vmax.getId()-1]){
//							vmax = v;
//						}
					}
				}
			}
		}
		return vmax;
	}
	
	//Hier mal ausprobieren, wenn man den groessten gewinn nehmen würde
	private Arc getAdmissibleArc(Vertex v, int[] d){ //active[IST bereits geprüft] und a(v,w): d(v)=d(w)+1
		Arc admissibleArc = null;
		Fraction maxFlow = new Fraction(0);
		for(Arc a : v.getOutgoingArcs()){
			Vertex w = a.getHead();
			if(d[v.getId()-1] == d[w.getId()-1] + 1 && (a.getC().subtract(a.getF()).signum() > 0)){
//				return a;
				if(admissibleArc==null){
					admissibleArc = a;
					maxFlow = a.getC().subtract(a.getF());
				} else {
					if(maxFlow.compareTo(a.getC().subtract(a.getF())) < 0){
						admissibleArc = a;
						maxFlow = a.getC().subtract(a.getF());
					}
				}
			}
		}
		for(Arc a : v.getIncommingArcs()){ 
			Vertex w = a.getTail();
			if(d[v.getId()-1] == d[w.getId()-1] + 1 && (a.getF().signum() > 0)){
//				return a;
				if(admissibleArc==null){
					admissibleArc = a;
					maxFlow = a.getF();
				} else {
					if(maxFlow.compareTo(a.getF()) < 0){
						admissibleArc = a;
						maxFlow = a.getF();
					}
				}
			}
		}
		return admissibleArc;
	}
	
	private int[] relabel(Vertex v, int[] d){
		int dv = Integer.MAX_VALUE;
		for(Arc a : v.getOutgoingArcs()){
			Vertex w = a.getHead();
			if(a.getC().subtract(a.getF()).signum() > 0){
				dv = Math.min(dv, d[w.getId()-1] + 1);
			}
		}
		for(Arc a : v.getIncommingArcs()){
			Vertex w = a.getTail();
			if(a.getF().signum() > 0){
				dv = Math.min(dv, d[w.getId()-1] + 1);
			}
		}
		d[v.getId()-1] = dv;
		return d;
	}
	
	private void push(Vertex v, Arc a){
		Fraction ex = new Fraction(0);
		for(Arc av : v.getIncommingArcs()){
			ex = ex.add(av.getF());
		}
		for(Arc av : v.getOutgoingArcs()){
			ex = ex.subtract(av.getF());
		}

		if(v.getId() == a.getTail().getId()){
			Fraction gamma = ex.min(a.getC().subtract(a.getF()));
			a.setF(a.getF().add(gamma));
		} else if (v.getId() == a.getHead().getId()){
			Fraction gamma = ex.min(a.getF());
			a.setF(a.getF().subtract(gamma));
		}
	}
	
}
