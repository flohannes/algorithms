package parser;

import graph.Fraction;
import graph.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readInput {
	
	private Graph graph;
	private boolean isDirected;
	
	public readInput(String path){
		graph = new Graph();
		isDirected = true;
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			String line = null;
			while ((line = in.readLine()) != null) {
				if(line.isEmpty()){
					continue;
				} else if(line.equals("graph:") || line.equals("scroller:")){
					continue;
				}
				line = line.trim();
				String[] splitLine = line.split(";");
				if(splitLine[0].equals("dir:0")){
					isDirected = false;
					continue;
				}
				if(splitLine[0].split(":")[0].equals("vertices")){
					int numOfvertices = Integer.parseInt(splitLine[0].split(":")[1]);
					graph.createVertices(numOfvertices);
				} else if(splitLine[0].split(":")[0].equals("edges")){
					int numOfedges = Integer.parseInt(splitLine[0].split(":")[1]);
					graph.createEdges(numOfedges);
				} else if(splitLine[0].split(":")[0].equals("n")){
					int id = Integer.parseInt(splitLine[0].split(":")[1]);
					int x = Integer.parseInt(splitLine[1].split(":")[1]);
					int y = Integer.parseInt(splitLine[2].split(":")[1]);
					graph.addVertex(id, x, y);
				} else if(splitLine[0].split(":")[0].equals("h")){
					if(isDirected){
						int head = Integer.parseInt(splitLine[0].split(":")[1]);
						int tail = Integer.parseInt(splitLine[1].split(":")[1]);
						double c = Double.parseDouble(splitLine[3].split(":")[1]);
						graph.addArc(head, tail, new Fraction(c));
					} else {
						int head = Integer.parseInt(splitLine[0].split(":")[1]);
						int tail = Integer.parseInt(splitLine[1].split(":")[1]);
						double c = Double.parseDouble(splitLine[3].split(":")[1]);
						graph.addArc(head, tail, new Fraction(c));
						graph.addArc(tail, head, new Fraction(c));
					}
				}
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

	public boolean isDirected() {
		return isDirected;
	}

}
