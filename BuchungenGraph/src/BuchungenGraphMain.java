import java.util.ArrayList;

import graph.Arc;
import graph.Graph;
import graph.Vertex;
import parser.readInput;


public class BuchungenGraphMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String dateiname = "input/buchungen(2).csv";
		
		readInput in = new readInput(dateiname);
		Graph graph = in.getGraph();	
		
		ArrayList<Vertex> vertices = graph.getVertices();
		ArrayList<Arc> arcs = graph.getArcs();
		for(Vertex v : vertices){
			double ex = 0;
			double inv = 0;
			double outv = 0;
			for(Arc a : v.getOutgoingArcs()){
				outv = outv+a.getC();
			}
			for(Arc a : v.getIncommingArcs()){
				inv = inv+a.getC();
			}
			ex = outv-inv;
			System.out.println(v.getId() + " : " + inv+ " / " + outv + " => " + ex);
			
		}
		for(Arc a : arcs){
			System.out.println(a.getTail().getId() + "," + a.getHead().getId() + " : " + a.getC());
		}
	}

}
