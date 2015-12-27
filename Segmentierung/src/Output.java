import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Output {
	private BufferedImage img;
	private int width;
	private int height;

	public Output(int width, int height) {
		this.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		this.width = width;
		this.height = height;
	}

	public void drawMerkmaleImage(String path, ArrayList<Point> segmente,
			Color[][] imgOld) {
		// Graphics g2d = img.createGraphics();
		// g2d.setColor(Color.WHITE);
		// //...
		// g2d.dispose();
		// for(ArrayList<double[]> kListe : einteilung){
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				img.setRGB(x, y, imgOld[x][y].getRGB());
			}
			// System.out.println(i+". Teil: "+einteilung.get(i).size());
		}
		for (Point p : segmente) {
			img.setRGB((int) p.getX(), (int) p.getY(), 0xff0000);
		}

		File f = new File(path + "NewSegmentPic" + ".bmp");
		try {
			ImageIO.write(this.img, "bmp", f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
