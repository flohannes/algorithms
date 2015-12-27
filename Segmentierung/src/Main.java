import java.awt.Color;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input in = new Input();
		try {
			int k = 4;
			in.readIn("C:/Users/UKM/Desktop/Hände/PrewittBerlinKantenNewPic_k5.bmp");
			Output out = new Output(in.getWidth(), in.getHeight());

			ArrayList p = new ArrayList();
			p.add(in.getPic());
			Point point = new Point(210,310);
			Segmentierung algo = new Segmentierung(p,in.getWidth(), in.getHeight(), point);
			algo.segmentiereBereich(0, point,0);
			out.drawMerkmaleImage("C:/Users/UKM/Desktop/Hände/BerlinKlassifikation2", algo.getSegment(), (Color[][]) p.get(0));

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
