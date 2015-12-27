package parser;

import graph.Arc;
import graph.Fraction;
import graph.Graph;
import graph.Vertex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class writeOutput {

	private final String eol = System.getProperty("line.separator");
	
	public writeOutput(Graph graph, int s, int t, String path){
		FileWriter fstream;
		try {
			fstream = new FileWriter(path);
			BufferedWriter out = new BufferedWriter(fstream);
			
			Fraction maxFlow = new Fraction(0);
			Vertex start = graph.getVertices().get(s-1);
			for(Arc a : start.getOutgoingArcs()){
				maxFlow = maxFlow.add(a.getF());
			}
			
			out.write("Max Flow: " + maxFlow.doubleValue() + eol);
			
			for(Arc a : graph.getArcs()){
				if(a.getF().signum() != 0){
					out.write("(" + a.getTail().getId() + "," + a.getHead().getId() + ") : " + a.getF().doubleValue() + eol);
				}
			}
			
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
