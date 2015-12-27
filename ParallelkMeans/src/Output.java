
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;


public class Output {
	private BufferedImage img;

	public Output(int width, int height){
		this.img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
	}
	
	public void drawMerkmaleImage(int k, String path, Vector<ArrayList<int[]>> einteilung){

//		for(int i =0; i<k;i++){
//			System.out.println(i+". Teil: "+einteilung.get(i).size());
//		}
		
		for(int i = 0; i<k; i++){
			int c = (int)( Math.random()*0xffffff);
			for(int[] m : einteilung.get(i)){
				img.setRGB(m[3], m[4],c);
			}
		}
		
		File f = new File(path + "NewPic_k" + k  +".jpg");
		try {
			ImageIO.write(this.img, "jpeg", f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
}
