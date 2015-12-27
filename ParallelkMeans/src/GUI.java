import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUI extends JFrame {
	

	private JTextField inputT;
	private JTextField outputT;
	private JTextField cT;
	private JButton calcB;
	
	public GUI(){
		this.setTitle("cMeans Artwork Program");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4,1));
		
		JLabel inputL = new JLabel("Input:");
		inputT = new JTextField();
		inputT.setColumns(20);
		JComponent box1 = new JPanel();
		box1.add(inputL);
		box1.add(inputT);
		
		JLabel outputL = new JLabel("Output:");
		outputT = new JTextField();
		outputT.setColumns(19);
		JComponent box2 = new JPanel();
		box2.add(outputL);
		box2.add(outputT);
		
		JLabel cL = new JLabel("c:");
		cT = new JTextField();
		cT.setText("2");
		cT.setColumns(3);
		JComponent box3 = new JPanel();
		box3.add(cL);
		box3.add(cT);
		
		calcB = new JButton("Create Artwork!");
		calcB.addActionListener(new ButtonClick(this));
		
		this.add(box1);
		this.add(box2);
		this.add(box3);
		this.add(calcB);
		
		this.pack();
		this.setVisible(true);
	}

	public JTextField getInputT() {
		return inputT;
	}

	public void setInputT(JTextField inputT) {
		this.inputT = inputT;
	}

	public JTextField getOutputT() {
		return outputT;
	}

	public void setOutputT(JTextField outputT) {
		this.outputT = outputT;
	}

	public JTextField getcT() {
		return cT;
	}

	public void setcT(JTextField cT) {
		this.cT = cT;
	}

	public JButton getCalcB() {
		return calcB;
	}

	public void setCalcB(JButton calcB) {
		this.calcB = calcB;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI gui = new GUI();
	}


}
