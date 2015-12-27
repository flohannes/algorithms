import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Input {
	
	private BufferedImage img;
	private Color[][] pic;
	private int width;
	private int height;

	public void readIn(String path) throws IOException {
		int rgb;
//		Color c;
		img = ImageIO.read(new File(path));
		
		width = img.getWidth();
		height = img.getHeight();
		pic = new Color[width][height];
		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {
				rgb = img.getRGB(x, y);
//				c = new Color(rgb);
				pic[x][y] = new Color(rgb); // Color zur�ckgeben
//				System.out.println(x+ " , "+ y + " : "+ c.getRed());
			}
		}

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

	public Color[][] getPic() {
		return pic;
	}

	public void setPic(Color[][] pic) {
		this.pic = pic;
	}

}