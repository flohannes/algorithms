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
			
//			double maxFlow = 0;
//			Vertex start = graph.getVertices().get(s-1);
//			for(Arc a : start.getOutgoingArcs()){
//				maxFlow = maxFlow + a.getF();
//			}
//			
//			out.write("Max Flow: " + maxFlow + eol);
//			
//			for(Arc a : graph.getArcs()){
//				if(a.getF() != 0){
//					out.write("(" + a.getTail().getId() + "," + a.getHead().getId() + ") : " + a.getF() + eol);
//				}
//			}
			
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
