package parser;

import graph.Graph;
import graph.Vertex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readInput {
	
	private Graph graph;
	private boolean isDirected;
	
	public readInput(String path){
		graph = new Graph();
		graph.addVertex("root");
//		graph.addVertex("12");
//		graph.addVertex("2");
//		graph.addVertex("6");
//		graph.addVertex("8");
//		graph.addVertex("9");
//		graph.addVertex("10");
//		graph.addVertex("13");
//		graph.addVertex("7");

		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			String line = null;
			String ql = "";
			String oldVertex = "";
			while ((line = in.readLine()) != null) {
				
				line = line.trim();
				String[] splitLine = line.split(";");
				if(!splitLine[2].equals(ql)){
					ql = splitLine[2];
					oldVertex = "root";
				} 
				String vertex_head = splitLine[3];
				
				graph.addVertex(vertex_head);
				graph.addArc(vertex_head, oldVertex);
				oldVertex = vertex_head;
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Graph getGraph() {
		return graph;
	}
}
