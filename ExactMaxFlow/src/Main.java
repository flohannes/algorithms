import graph.Fraction;
import graph.Graph;
import parser.readInput;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String dateiName = "V200E800";
		int s = 1;
		int t = 200;
		
		readInput in = new readInput("InputData/"+ dateiName +".cat");
		Graph graph = in.getGraph();

//		#####ALGO1######
		EdmondsKarp algo1 = new EdmondsKarp();
		Fraction maxFlow = algo1.calcMaxFlow(graph, s, t);
		System.out.println(maxFlow.doubleValue());
//		writeOutput output = new writeOutput(graph, s, t, "OutputData/"+dateiName+".sol");
		
//		#####ALGO2######
		GoldbergTarjan algo2 = new GoldbergTarjan();
		Fraction maxFlow2 = algo2.calcMaxFlow(graph, s, t);
		System.out.println(maxFlow2.doubleValue());
	
	}

}
