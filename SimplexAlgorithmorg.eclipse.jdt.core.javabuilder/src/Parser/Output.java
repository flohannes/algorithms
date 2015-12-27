package Parser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Datenstrukturen.Vector;

public class Output {
	
	private ArrayList<String> cn;
	private Vector bQuer;
	private int[] basis;
	private String path;
	
	private final String eol = System.getProperty("line.separator");

	
	public Output(ArrayList<String> cn,
			Vector bQuer, int[] basis, double optimum, String path) {
		this.cn = cn;
		this.bQuer = bQuer;
		this.basis = basis;
		this.path = path;
		
		double optimalWert = optimum;
		
//		for(int i = 0; i < originalCostFunction.getVec().length; i++){
//			for(int j = 0; j < cn.size(); j++){
//				if(originalCostFunction.getVec()[i] == cn.get(j)){
//					
//				}
//			}
//		}
		
		FileWriter fstream;
//		fstream = new FileWriter(path + "/Ergebnis" + ".txt");
		try {
			fstream = new FileWriter(path);
			System.out.println(path);
			BufferedWriter out = new BufferedWriter(fstream);
			
//			out.write("Es folgen die Ergebnisse:" + eol);
			out.write(optimalWert + eol);
			for(int i = 0; i < basis.length; i++){
				if(bQuer.get(i) != 0 && basis[i]<cn.size()){
					out.write(cn.get(basis[i])+ "   "+ bQuer.get(i) + eol);
				}
			}
			//minimale Kosten ausgeben
			//weg angeben, zur zeit noch alle Kanten ausgaben:
	//		for(Arc a : graph.getArcs()){
	//			if(!(a.getTail() == null || a.getHead() == null || a==null )){
	//				out.write(a.getTail().getId() + " " + a.getHead().getId() + " " + a.getFlowX() + eol);
	//			}
	//		}	
			
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
