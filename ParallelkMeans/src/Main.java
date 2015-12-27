import java.io.IOException;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long timeInput=0;
		long timeRounds=0;
		long timeOutput=0;
		Stopwatch watch = new Stopwatch();
		watch.start();
		
		for(int i =0; i<10;i++){
		Input in = new Input();

		try {
			int k = 40;
			String dateiName = "DSC03239.jpg";
			in.readIn("pics/" + dateiName);
		
			Output out = new Output(in.getWidth(), in.getHeight());

			kMeans algo = new kMeans(k,255,3);
			algo.setMerkmale(in.getMerkmale());
			algo.calcKMeans();
			
			algo.einteilungAusgabe();

			out.drawMerkmaleImage(algo.getK(),("output/"+dateiName+"_"+k+"_"+Math.random()*100), algo.getEinteilung());


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		watch.stop();
		System.out.println("Time in ms: " +watch.getElapsedTime());
		
		//2.Round
//		watch.reset();
//		watch.start();
//		
//		for(int i =0; i<10;i++){
//		Input in = new Input();
//
//		try {
//			int k = 15;
//			String dateiName = "DSC03239.jpg";
//			in.readIn("pics/" + dateiName);
//		
//			Output out = new Output(in.getWidth(), in.getHeight());
//
//			kMeans algo = new kMeans(k,255,3);
//			algo.setMerkmale(in.getMerkmale());
//			algo.calcKMeans();
//			
//			algo.einteilungAusgabe();
//
//			out.drawMerkmaleImage(algo.getK(),("output/"+dateiName+"_"+k+"_"+Math.random()*100), algo.getEinteilung());
//
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
//		watch.stop();
//		System.out.println("Time in ms: " +watch.getElapsedTime());
//		
//		
//		watch.reset();
//		watch.start();
//		
//		for(int i =0; i<10;i++){
//		Input in = new Input();
//
//		try {
//			int k = 10;
//			String dateiName = "DSC03239.jpg";
//			in.readIn("pics/" + dateiName);
//		
//			Output out = new Output(in.getWidth(), in.getHeight());
//
//			kMeans algo = new kMeans(k,255,3);
//			algo.setMerkmale(in.getMerkmale());
//			algo.calcKMeans();
//			
//			algo.einteilungAusgabe();
//
//			out.drawMerkmaleImage(algo.getK(),("output/"+dateiName+"_"+k+"_"+Math.random()*100), algo.getEinteilung());
//
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
//		watch.stop();
//		System.out.println("Time in ms: " +watch.getElapsedTime());
	}

}
