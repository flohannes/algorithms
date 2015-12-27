import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class ButtonClick implements ActionListener{
	
	private GUI gui;
	
	public ButtonClick(GUI gui){
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		gui.getCalcB().setText("Calculation, please wait!");
		gui.getCalcB().setEnabled(false);
		gui.getCalcB().updateUI();
		Input in = new Input();
		try {
//			System.out.println(Integer.parseInt(gui.getcT().getText()));
			int k = Integer.parseInt(gui.getcT().getText());
			in.readIn(this.gui.getInputT().getText());
			Output out = new Output(in.getWidth(), in.getHeight());

			kMeans algo = new kMeans(k,255,3);
			algo.setMerkmale(in.getMerkmale());
			algo.calcKMeans();
			out.drawMerkmaleImage(algo.getK(),this.gui.getOutputT().getText(), algo.getEinteilung());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		gui.getCalcB().setText("Create Artwork!");
		gui.getCalcB().setEnabled(true);
	}

}
