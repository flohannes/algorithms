package parser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import graph.Arc;
import graph.Graph;
import graph.Vertex;

public class GraphToLP {

	private final String eol = System.getProperty("line.separator");
	
	public GraphToLP(Graph graph, int s, int t, String path){
		FileWriter fstream;
		try {
			fstream = new FileWriter(path);
			BufferedWriter out = new BufferedWriter(fstream);
			
			out.write("Maximize" + eol);
			String obj = "Obj: ";
			for(Arc a : graph.getVertices().get(s-1).getOutgoingArcs()){
				obj += " +1 x" + a.getTail().getId()+""+a.getHead().getId();
			}
//			for(Arc a : graph.getVertices().get(s-1).getIncommingArcs()){
//				obj += " -1 x" + a.getTail().getId()+""+a.getHead().getId();
//			}
			out.write(obj + eol);
			
			out.write("Subject to" + eol);
			int counter = 0;
			for(Vertex v : graph.getVertices()){
				if(v.getId()-1 == s || v.getId()-1 == t){
					continue;
				} else {
					String row = "";
					for(Arc a : graph.getVertices().get(v.getId()-1).getIncommingArcs()){
						row += " -1 x" + a.getTail().getId()+""+a.getHead().getId();
					}
					for(Arc a : graph.getVertices().get(v.getId()-1).getOutgoingArcs()){
						row += " +1 x" + a.getTail().getId()+""+a.getHead().getId();
					}
					row += " = 0";
					out.write("row" + counter + ": " + row + eol);
					counter++;
				}
			}
			
			for(Arc a : graph.getArcs()){
				String row = "";
				row += " +1 x" + a.getTail().getId()+""+a.getHead().getId();
				row += " <= ";
				row += a.getC();
				out.write("row" + counter + ": " + row + eol);
				counter++;
			}
			out.write("Bounds" + eol);
			out.write("End" + eol);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
