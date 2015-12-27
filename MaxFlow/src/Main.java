import graph.Graph;
import parser.GraphToLP;
import parser.readInput;
import parser.writeOutput;


public class Main {

	/**
	 * 1 : Endmond Karp
	 * 2 : Goldberg Tarjan
	 * 3 : Both
	 * @param args
	 */
	public static void main(String[] args) {
		String dateiname = "";
		int s = 1;
		int t = 1;
		String algo = "";
		String mitoutput = "";
		String outputPfad = "";
		if(args.length>0){
			dateiname = args[0];
		} 
		if (args.length>1){
			s = Integer.parseInt(args[1]);
		} 
		if (args.length>2){
			t = Integer.parseInt(args[2]);
		} 
		if (args.length>3){
			algo = args[3];
		} else {
			System.out.println("Nicht genug Eingabedaten vorhanden.");
		}
		if (args.length>4){
			mitoutput = args[4];
		}
		if (args.length>5 && (mitoutput.equals("1") || mitoutput.equals("2"))){
			outputPfad = args[5];
		}
		
		

		//Einbauen von Output File
		//Und LP output
		//Und beide Algos hintereinander ausführen
		//Und Eingabeparameter vorher prüfen catch exceptions
//		String dateiname = "C:/Users/UKM/workspace/ADM/MaxFlow/InputData/V5C.cat";
//		int s = 1;
//		int t = 5;
//		String algo = "1";
		
		readInput in = new readInput(dateiname);
		Graph graph = in.getGraph();

//		#####ALGO1######
		if(algo.equals("1")){
			EdmondsKarp algo1 = new EdmondsKarp();
			double maxFlow = algo1.calcMaxFlow(graph, s, t);
			System.out.println(maxFlow);
			
			if(mitoutput.equals("1") && !outputPfad.equals("")){
				writeOutput output = new writeOutput(graph, s, t, outputPfad+".sol");
			}
		}
				
//		#####ALGO2######
		if(algo.equals("2")){
			GoldbergTarjan algo2 = new GoldbergTarjan();
			double maxFlow2 = algo2.calcMaxFlow(graph, s, t);
			System.out.println(maxFlow2);
			
			if(mitoutput.equals("1") && !outputPfad.equals("")){
				writeOutput output = new writeOutput(graph, s, t, outputPfad+".sol");
			}
		}
		
		if(algo.equals("3")){
			EdmondsKarp algo1 = new EdmondsKarp();
			double maxFlow = algo1.calcMaxFlow(graph, s, t);
			System.out.println(maxFlow);
			
			if(mitoutput.equals("1") && !outputPfad.equals("")){
				writeOutput output = new writeOutput(graph, s, t, outputPfad+"_1.sol");
			}
			
			GoldbergTarjan algo2 = new GoldbergTarjan();
			double maxFlow2 = algo2.calcMaxFlow(graph, s, t);
			System.out.println(maxFlow2);
			
			if(mitoutput.equals("1") && !outputPfad.equals("")){
				writeOutput output = new writeOutput(graph, s, t, outputPfad+"_2.sol");
			}
		}
		
//		#####LP#####
		if(mitoutput.equals("2") && !outputPfad.equals("")){
			GraphToLP graphtolp = new GraphToLP(graph, s, t, outputPfad);
		}
		
	}

}
