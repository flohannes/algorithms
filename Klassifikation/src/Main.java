import java.io.IOException;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i =0; i<2;i++){
		Input in = new Input();
		try {
			int k = 12;
			in.readIn("C:/Users/UKM/Desktop/Hände/37081_4710171147718_1720947909_n.jpg");
			Output out = new Output(in.getWidth(), in.getHeight());

			kMeans algo = new kMeans(k,255,3);
			algo.setMerkmale(in.getMerkmale());
			algo.calcKMeans();
			algo.einteilungAusgabe();
//			algo.gibListeAus();
			out.drawMerkmaleImage(algo.getK(),("C:/Users/UKM/Desktop/Hände/BerlinKlassifikation37081_4710171147718_1720947909_n_n0"+i), algo.getEinteilung());

//			algo.isoData();
//			algo.calcKMeans();
//			algo.einteilungAusgabe();
////			algo.gibListeAus();
//			out.drawMerkmaleImage(algo.getK(),"C:/Users/UKM/Desktop/TestBilder/Berlin2", algo.getEinteilung());
//			
//			algo.isoData();
//			algo.calcKMeans();
//			algo.einteilungAusgabe();
////			algo.gibListeAus();
//			out.drawMerkmaleImage(algo.getK(),"C:/Users/UKM/Desktop/TestBilder/Berlin3", algo.getEinteilung());
//			
//			algo.isoData();
//			algo.calcKMeans();
//			algo.einteilungAusgabe();
////			algo.gibListeAus();
//			out.drawMerkmaleImage(algo.getK(),"C:/Users/UKM/Desktop/TestBilder/Berlin4", algo.getEinteilung());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
