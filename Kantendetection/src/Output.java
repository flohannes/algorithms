import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Output {
	private BufferedImage img;
	private int width;
	private int height;
	
	public Output(int width, int height){
		this.img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		this.width = width;
		this.height = height;
	}
	
	public void drawImage(String path, int[][] pic){
		for(int x = 0; x<width-2; x++){
			for(int y =0; y<height-2; y++){
				Color c = new Color(pic[x][y], pic[x][y], pic[x][y]);
				img.setRGB(x,y,c.getRGB());
			}
		}

		File f = new File(path + "NewPic_k5"  +".bmp");
		try {
			ImageIO.write(this.img, "bmp", f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
}
