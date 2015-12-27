import java.io.IOException;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input in = new Input();
		try {
			in.readIn("C:/Users/UKM/Desktop/Hände/hand5.jpeg");
			Output out = new Output(in.getWidth(), in.getHeight());

			PrewittOperator algo = new PrewittOperator(in.getPic(),in.getWidth(),in.getHeight());
			algo.calcPrewitt();
			out.drawImage("C:/Users/UKM/Desktop/Hände/PrewittBerlinKanten", algo.getNewPic());
			
			LaplaceOperator algo2 = new LaplaceOperator(in.getPic(),in.getWidth(),in.getHeight());
			algo2.calcPrewitt();
			out.drawImage("C:/Users/UKM/Desktop/Hände/LaplaceBerlinKanten", algo2.getNewPic());
			
			ScharrOperator algo3 = new ScharrOperator(in.getPic(),in.getWidth(),in.getHeight());
			algo3.calcPrewitt();
			out.drawImage("C:/Users/UKM/Desktop/Hände/ScharrBerlinKanten", algo3.getNewPic());
			
			SobelOperator algo4 = new SobelOperator(in.getPic(),in.getWidth(),in.getHeight());
			algo4.calcPrewitt();
			out.drawImage("C:/Users/UKM/Desktop/Hände/SobelBerlinKanten", algo4.getNewPic());
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

} 
