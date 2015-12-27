import graph.Fraction;
import graph.Graph;

public interface IMaxFlowSolver {
	public Fraction calcMaxFlow(Graph graph, int s, int t);
}
