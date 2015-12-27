import java.util.ArrayList;

import algo.BellmanFord;
import algo.Dijkstra;
import algo.Johnson;
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
		
		Dijkstra algo1 = new Dijkstra();
		double[] distance = algo1.calcDistance(graph, s);
		for(int i = 0; i < distance.length; i++){
			System.out.print(distance[i] + " ");
		}
		System.out.print("\n");
		
		BellmanFord algo2 = new BellmanFord();
		double[] distance2 = algo2.calcDistance(graph, s);
		for(int i = 0; i < distance2.length; i++){
			System.out.print(distance2[i] + " ");
		}
		System.out.print("\n");		
		
		Johnson algo3 = new Johnson();
		ArrayList<double[]> distances1 = algo3.calcDistance(graph);
		for(double[] d : distances1){
			for(int i = 0; i < d.length; i++){
				System.out.print(d[i] + " ");
			}
			System.out.print("\n");	
		}
	}

}
