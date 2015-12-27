import graph.Arc;
import graph.Fraction;
import graph.Graph;
import graph.Vertex;


public class EdmondsKarp implements IMaxFlowSolver{

	@Override
	public Fraction calcMaxFlow(Graph graph, int s, int t) {
		Vertex start = graph.getVertices().get(s-1);
		Vertex terminate = graph.getVertices().get(t-1);
		while (graph.bfsDx(start, terminate)){
		}
		Fraction maxFlow = new Fraction(0);
		for(Arc a : start.getOutgoingArcs()){
			maxFlow = maxFlow.add(a.getF());
		}
		return maxFlow;
	}
}
