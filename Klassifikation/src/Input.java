import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Input {
	
	private BufferedImage img;
	private String path;
	private ArrayList<double[]> merkmale;
	private int width;
	private int height;

	public void readIn(String path) throws IOException {
		this.path = path;
		int rgb;
		Color c;
		img = ImageIO.read(new File(path));
		merkmale = new ArrayList();
		
//		width = img.getWidth();
//		height = img.getHeight();
//		datamap = new int[width][height];
//		foodsources = new int[width][height];	
		width = img.getWidth();
		height = img.getHeight();
		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {
				rgb = img.getRGB(x, y);
				c = new Color(rgb);
				double[] merkmal = new double[5];
				merkmal[0] = c.getRed();
				merkmal[1] = c.getGreen();
				merkmal[2] = c.getBlue();
				merkmal[3] = x;
				merkmal[4] = y;
				merkmale.add(merkmal);
//					// Foodsource
//					if (c.getRed() > 245 && c.getGreen() > 245
//							&& c.getBlue() < 10) {
//						datamap[x][y] = 2;
//						foodsources[x][y] = 1;
//						numberOnFoodsource++;
//						numberOfAgents++;
//					}// Agent
//					else if (c.getRed() == 255 && c.getGreen() == 0
//							&& c.getBlue() == 0) {
//						datamap[x][y] = 1;
//					}// No Land
//					else if (c.getRed() < 10 && c.getGreen() < 10
//							&& c.getBlue() < 10) {
//						datamap[x][y] = -1;
//					}
				}
			}

		
		
	}


	public ArrayList<double[]> getMerkmale() {
		return merkmale;
	}


	public void setMerkmale(ArrayList<double[]> merkmale) {
		this.merkmale = merkmale;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}

}
