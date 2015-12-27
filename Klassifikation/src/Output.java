import java.awt.Color;
import java.awt.Graphics;
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
	
	public void drawMerkmaleImage(int k, String path, Vector<ArrayList<double[]>> einteilung){
//		Graphics g2d = img.createGraphics();
//		g2d.setColor(Color.WHITE);
//		//...
//		g2d.dispose();
//		for(ArrayList<double[]> kListe : einteilung){
		for(int i =0; i<k;i++){
			System.out.println(i+". Teil: "+einteilung.get(i).size());
		}
		
		for(int i = 0; i<k; i++){
			int c = (int)( Math.random()*0xffffff);
			for(double[] m : einteilung.get(i)){
				img.setRGB((int)m[3], (int)m[4],c);
			}
		}
//			for(double[] m : einteilung.get(0)){
////				System.out.println("(" + (int)m[3] +" , "+ (int)m[4] + ")");
//				Color c = new Color((int)m[0],(int)m[1],(int)m[2]);
//				img.setRGB((int)m[3], (int)m[4], Color.GREEN.getRGB());
//			}
////		}
//			for(double[] m : einteilung.get(1)){
////				System.out.println("(" + (int)m[3] +" , "+ (int)m[4] + ")");
//				Color c = new Color((int)m[0],(int)m[1],(int)m[2]);
//				img.setRGB((int)m[3], (int)m[4], Color.GRAY.getRGB());
//			}
//			for(double[] m : einteilung.get(2)){
////				System.out.println("(" + (int)m[3] +" , "+ (int)m[4] + ")");
//				Color c = new Color((int)m[0],(int)m[1],(int)m[2]);
//				img.setRGB((int)m[3], (int)m[4], c.getRGB());
//			}
//			for(double[] m : einteilung.get(3)){
////				System.out.println("(" + (int)m[3] +" , "+ (int)m[4] + ")");
//				Color c = new Color((int)m[0],(int)m[1],(int)m[2]);
//				img.setRGB((int)m[3], (int)m[4], c.getRGB());
//			}
//			for(double[] m : einteilung.get(4)){
////				System.out.println("(" + (int)m[3] +" , "+ (int)m[4] + ")");
//				Color c = new Color((int)m[0],(int)m[1],(int)m[2]);
//				img.setRGB((int)m[3], (int)m[4], c.getRGB());
//			}
//			for(double[] m : einteilung.get(5)){
////				System.out.println("(" + (int)m[3] +" , "+ (int)m[4] + ")");
//				Color c = new Color((int)m[0],(int)m[1],(int)m[2]);
//				img.setRGB((int)m[3], (int)m[4], c.getRGB());
//			}
		
		File f = new File(path + "NewPic_k" + k  +".jpg");
		try {
			ImageIO.write(this.img, "jpeg", f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
}
