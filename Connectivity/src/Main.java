
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
		
	}

}
