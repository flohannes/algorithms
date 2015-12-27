
public class LaplaceOperator {

	private int[][] oldPic;
	private int[][] newPic;
	private int width;
	private int height;
	
	public LaplaceOperator(int[][] pic, int width, int height){
		this.oldPic = pic;
		this.newPic = new int[width-2][height-2];
		this.width = width;
		this.height = height;
	}
	
	
	public void calcPrewitt(){
		for(int x = 1; x < width-1; x++){
			for(int y = 1; y < height-1; y++){
				int newColor1 = 0;
				int newColor2 = 0;
				newColor1 += oldPic[x-1][y];
				newColor1 -= (2*oldPic[x][y]);
				newColor1 += oldPic[x+1][y];
				
				newColor2 += oldPic[x][y-1];
				newColor2 -= (2*oldPic[x][y]);
				newColor2 += oldPic[x][y+1];
				
				newPic[x-1][y-1] = Math.min(Math.abs(newColor1+newColor2),255); 
			}
		}
	}

	public int[][] getNewPic() {
		return newPic;
	}
	
}
