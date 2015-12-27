import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Segmentierung {

	private ArrayList<Color[][]> pictures; // Color[][] wäre eine Möglichkeit
	private ArrayList<Point> segment;
	private int width;
	private int height;
	private Point ersterPunkt;
	private boolean[][] pixelDone;

	public Segmentierung(ArrayList<Color[][]> pictures, int width, int height,
			Point ersterPunkt) {
		this.pictures = pictures;
		this.segment = new ArrayList<Point>();
		this.width = width;
		this.height = height;
		this.ersterPunkt = ersterPunkt;
		this.pixelDone = new boolean[width+1][height+1];
	}
	private int counter=0;
	public void segmentiereBereich(int picNum, Point momentanerPunkt, int maxD) {
		// 6er Nachbarschaft (3D)
		// Erstmal 2D
		if (momentanerPunkt.getX() > 0 && momentanerPunkt.getX() < width
				&& momentanerPunkt.getY() > 0
				&& momentanerPunkt.getY() < height) {
			if(!pixelDone[(int) momentanerPunkt.getX()][(int) momentanerPunkt.getY()]){
			if (pictures.get(picNum)[(int) momentanerPunkt.getX()][(int) momentanerPunkt
					.getY()].getRed() <= pictures.get(picNum)[(int) ersterPunkt
					.getX()][(int) ersterPunkt.getY()].getRed() + maxD
					&& pictures.get(picNum)[(int) momentanerPunkt.getX()][(int) momentanerPunkt
							.getY()].getRed() >= pictures.get(picNum)[(int) ersterPunkt
							.getX()][(int) ersterPunkt.getY()].getRed() - maxD
					&& pictures.get(picNum)[(int) momentanerPunkt.getX()][(int) momentanerPunkt
							.getY()].getBlue() <= pictures.get(picNum)[(int) ersterPunkt
							.getX()][(int) ersterPunkt.getY()].getBlue() + maxD
					&& pictures.get(picNum)[(int) momentanerPunkt.getX()][(int) momentanerPunkt
							.getY()].getBlue() >= pictures.get(picNum)[(int) ersterPunkt
							.getX()][(int) ersterPunkt.getY()].getBlue() - maxD
					&& pictures.get(picNum)[(int) momentanerPunkt.getX()][(int) momentanerPunkt
							.getY()].getGreen() <= pictures.get(picNum)[(int) ersterPunkt
							.getX()][(int) ersterPunkt.getY()].getGreen()
							+ maxD
					&& pictures.get(picNum)[(int) momentanerPunkt.getX()][(int) momentanerPunkt
							.getY()].getGreen() >= pictures.get(picNum)[(int) ersterPunkt
							.getX()][(int) ersterPunkt.getY()].getGreen()
							- maxD) { // Hier muss man die einzelnen Farben eig
										// vergleichen
				segment.add(momentanerPunkt);
				pixelDone[(int) momentanerPunkt.getX()][(int) momentanerPunkt.getY()]=true;
				counter++;
				System.out.println(counter);
				this.segmentiereBereich(picNum, new Point(
						(int) (momentanerPunkt.getX() - 1),
						(int) (momentanerPunkt.getY())), maxD);
				this.segmentiereBereich(picNum, new Point(
						(int) (momentanerPunkt.getX() + 1),
						(int) (momentanerPunkt.getY())), maxD);
				this.segmentiereBereich(picNum,
						new Point((int) (momentanerPunkt.getX()),
								(int) (momentanerPunkt.getY() - 1)), maxD);
				this.segmentiereBereich(picNum,
						new Point((int) (momentanerPunkt.getX()),
								(int) (momentanerPunkt.getY() + 1)), maxD);
			}
		}}
	}

	public void segmentiereGanzesBild(int picNum, int maxD) {
		// 6er Nachbarschaft (3D)
		// Erstmal 2D
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (pictures.get(picNum)[x][y].getRGB() == maxD) { // Hier
																	// vielleicht
																	// einen
																	// Toleranzbereich
																	// angeben
					segment.add(new Point(x, y));
				}
			}
		}
	}

	public ArrayList<Point> getSegment() {
		return segment;
	}
}
