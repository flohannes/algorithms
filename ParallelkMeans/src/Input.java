import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Input {
	
	private BufferedImage img;
	private ArrayList<int[]> merkmale;
	private int width;
	private int height;

	public void readIn(String path) throws IOException {
		int rgb;
		Color c;
		img = ImageIO.read(new File(path));
		merkmale = new ArrayList<int[]>();

		width = img.getWidth();
		height = img.getHeight();
		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {
				rgb = img.getRGB(x, y);
				c = new Color(rgb);
				int[] merkmal = new int[5];
				merkmal[0] = c.getRed();
				merkmal[1] = c.getGreen();
				merkmal[2] = c.getBlue();
				merkmal[3] = x;
				merkmal[4] = y;
				merkmale.add(merkmal);

				}
			}

		
		
	}


	public ArrayList<int[]> getMerkmale() {
		return merkmale;
	}


	public void setMerkmale(ArrayList<int[]> merkmale) {
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
