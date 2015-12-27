
public class ScharrOperator {

	private int[][] oldPic;
	private int[][] newPic;
	private int width;
	private int height;
	
	public ScharrOperator(int[][] pic, int width, int height){
		this.oldPic = pic;
		this.newPic = new int[width-2][height-2];
		this.width = width;
		this.height = height;
	}
	
	public int[][] calcPrewittX(){
		int[][] ergPic = new int[width-2][height-2];
		for(int x = 1; x < width-1; x++){
			for(int y = 1; y < height-1; y++){
				int newColor = 0;
				newColor -= oldPic[x-1][y-1];
				newColor -= oldPic[x-1][y];
				newColor -= oldPic[x-1][y+1];
				newColor += oldPic[x+1][y-1];
				newColor += oldPic[x+1][y];
				newColor += oldPic[x+1][y+1];
				ergPic[x-1][y-1] = (1/6)*newColor; 
			}
		}
		return ergPic;
	}
	
	public void calcPrewitt(){
		for(int x = 1; x < width-1; x++){
			for(int y = 1; y < height-1; y++){
				int newColor1 = 0;
				int newColor2 = 0;
				newColor1 -= (3*oldPic[x-1][y-1]);
				newColor1 -= (10*oldPic[x-1][y]);
//				newColor1 += (2*oldPic[x+1][y]);
				newColor1 -= (3*oldPic[x-1][y+1]);
				newColor1 += (3*oldPic[x+1][y-1]);
				newColor1 += (10*oldPic[x+1][y]);
//				newColor1 += (2*oldPic[x+1][y]);
				newColor1 += (3*oldPic[x+1][y+1]);
				newColor1 = newColor1/32;
				
				newColor2 -= (3*oldPic[x-1][y-1]);
				newColor2 -= (10*oldPic[x][y-1]);
//				newColor2 -= (2*oldPic[x][y-1]);
				newColor2 -= (3*oldPic[x+1][y-1]);
				newColor2 += (3*oldPic[x-1][y+1]);
				newColor2 += (10*oldPic[x][y+1]);
//				newColor2 += (2*oldPic[x][y+1]);
				newColor2 += (3*oldPic[x+1][y+1]);
				newColor2 = newColor2/32;
				newPic[x-1][y-1] = (int) Math.sqrt(Math.pow(newColor1, 2)+Math.pow(newColor2, 2)); 
			}
		}
	}

	public int[][] calcPrewittY(){
		int[][] ergPic = new int[width-2][height-2];
		for(int x = 1; x < width-1; x++){
			for(int y = 1; y < height-1; y++){
				int newColor = 0;
				newColor -= oldPic[x-1][y-1];
				newColor -= oldPic[x][y-1];
				newColor -= oldPic[x+1][y-1];
				newColor += oldPic[x-1][y+1];
				newColor += oldPic[x][y+1];
				newColor += oldPic[x+1][y+1];
				ergPic[x-1][y-1] = (1/6)*newColor; 
			}
		}
		return ergPic;
	}
	public int[][] getNewPic() {
		return newPic;
	}
	
}
