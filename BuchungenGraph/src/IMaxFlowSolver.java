import graph.Graph;

public interface IMaxFlowSolver {

	public double calcMaxFlow(Graph graph, int s, int t);
}
