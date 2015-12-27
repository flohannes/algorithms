import graph.Arc;
import graph.Graph;
import graph.Vertex;


public class GoldbergTarjan implements IMaxFlowSolver{

	@Override
	public double calcMaxFlow(Graph graph, int s, int t) {
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
		
		double maxFlow = 0;
		for(Arc a : terminate.getIncommingArcs()){
			maxFlow = maxFlow + a.getF();
		}
		return maxFlow;
	}
	
	private Vertex getActiveNode(Graph graph, Vertex s, Vertex t, int[] d){
		Vertex vmax = null;
		double exmax = 0;
		double smallNumber = 0.0000001;
		for(Vertex v : graph.getVertices()){
			
			if(!(v.getId() == s.getId() || v.getId()==t.getId())){
				double ex = 0;
				for(Arc a : v.getIncommingArcs()){
					ex = ex + a.getF();
				}
				for(Arc a : v.getOutgoingArcs()){
					ex = ex - a.getF();
				}
				if(Math.abs(ex)>smallNumber){
//					System.out.println(v.getId() + " " +ex);
//					return v;
					if(vmax==null){
						vmax = v;
						exmax = ex;
					} else {
						if(exmax<ex){
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
		double maxFlow = 0;
		for(Arc a : v.getOutgoingArcs()){
			Vertex w = a.getHead();
			if(d[v.getId()-1] == d[w.getId()-1] + 1 && (a.getC()-a.getF() > 0)){
//				return a;
				if(admissibleArc==null){
					admissibleArc = a;
					maxFlow = a.getC()-a.getF();
				} else {
					if(maxFlow < a.getC()-a.getF()){
						admissibleArc = a;
						maxFlow = a.getC()-a.getF();
					}
				}
			}
		}
		for(Arc a : v.getIncommingArcs()){ 
			Vertex w = a.getTail();
			if(d[v.getId()-1] == d[w.getId()-1] + 1 && (a.getF() > 0)){
//				return a;
				if(admissibleArc==null){
					admissibleArc = a;
					maxFlow = a.getF();
				} else {
					if(maxFlow < a.getF()){
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
			if(a.getC()-a.getF() > 0){
				dv = Math.min(dv, d[w.getId()-1] + 1);
			}
		}
		for(Arc a : v.getIncommingArcs()){
			Vertex w = a.getTail();
			if(a.getF() > 0){
				dv = Math.min(dv, d[w.getId()-1] + 1);
			}
		}
		d[v.getId()-1] = dv;
		return d;
	}
	
	private void push(Vertex v, Arc a){
		double ex = 0;
		for(Arc av : v.getIncommingArcs()){
			ex = ex + av.getF();
		}
		for(Arc av : v.getOutgoingArcs()){
			ex = ex - av.getF();
		}

		if(v.getId() == a.getTail().getId()){
			double gamma = Math.min(ex, a.getC()-a.getF());
			a.setF(a.getF() + gamma);
		} else if (v.getId() == a.getHead().getId()){
			double gamma = Math.min(ex, a.getF());
			a.setF(a.getF() - gamma);
		}
	}
	
}
