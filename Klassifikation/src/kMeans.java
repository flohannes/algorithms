import java.util.ArrayList;
import java.util.Vector;


public class kMeans {
	
	/*
	 * Wichtige Parameter:
	 * k
	 * Ereignisraumgrenzen
	 * Dimension des Ereignisraums
	 * 
	 * Liste von Merkmalen
	 */
	private int k;
	private int maxMerkmal;
	private int dimensionen;
	private ArrayList<double[]> merkmale;
	private Vector<ArrayList<double[]>> einteilung;
	private ArrayList<double[]> lageVonK;
	
	public kMeans(int k, int maxMerkmal, int dimensionen){
		this.k = k;
		this.maxMerkmal = maxMerkmal;
		this.dimensionen = dimensionen;
		merkmale = new ArrayList<double[]>();
		einteilung = new Vector();
		for(int i = 0; i<this.k; i++){
			einteilung.add(new ArrayList<double[]>());
		}
		this.initialisierung();
	}
	
	public void setMerkmale(ArrayList<double[]> merkmale){
		this.merkmale = merkmale;
	}
	
	public Vector<ArrayList<double[]>> getEinteilung(){
		return einteilung;
	}
	
	public void addMerkmal(double[] m){
		merkmale.add(m);
	}
	
	public void gibListeAus(){
		for(double[] m : lageVonK){
			for(int j = 0; j<this.dimensionen; j++){
				System.out.print(m[j] + ", ");
			}
			System.out.println("\t");
		}
	}
	private void initialisierung(){
		//Initialisierung
				//k zufaelling ueber merkmalraum verteilen
				lageVonK = new ArrayList<double[]>(this.k);
				
				for(int j = 0; j<this.k; j++){
					double[] point = new double[dimensionen];
					for(int i = 0; i < dimensionen; i++){
						point[i] = Math.random() * maxMerkmal;
					}
					lageVonK.add(point);
				}
	}
	
	public Vector<ArrayList<double[]>> calcKMeans(){	
		
//		this.gibListeAus(lageVonK);
		
		int c=0;
		int x=0;
		while(true){
			x++;
		//merkmale auf k Verteilen
		c++;
		System.out.println("Runde: " + c);
//		this.gibListeAus(lageVonK);

		for(int i = 0; i<this.k; i++){
			einteilung.get(i).clear();//= new ArrayList<double[]>();
		}
		for(double[] m : merkmale){
			double minDistance = Double.MAX_VALUE;
			int knum=-1;
			for(int i = 0; i<this.k;i++){
				double temp = 0;
				for(int j = 0; j<dimensionen; j++){
					temp += Math.pow(m[j]-lageVonK.get(i)[j], 2);
				}
				if(Math.sqrt(temp) <= minDistance){
					minDistance = Math.sqrt(temp);
					knum = i;
				}
			}
			einteilung.get(knum).add(m); //[knum].add(m);
		}
		
		//zentrum der k's neu verschieben
		double[] movementOfK = new double[this.k];
		
		for(int i = 0; i < this.k; i++){
			double movementTemp=0;
			for(int j =0; j<this.dimensionen;j++){
				double newPosition=0;
				if(einteilung.get(i).size()==0){
					lageVonK.get(i)[j] = newPosition;
				}else{
				for(double[] m: einteilung.get(i)){
					newPosition += m[j];
				}
				newPosition = newPosition / einteilung.get(i).size();
//				System.out.println(newPosition);
				movementTemp += Math.pow(lageVonK.get(i)[j]-newPosition, 2);
				lageVonK.get(i)[j] = newPosition;
				}
			}
//			System.out.println(Math.sqrt(movementTemp));
			movementOfK[i] = Math.sqrt(movementTemp);
		}
			
		//pruefen ob zentrum sich noch signifikant bewegt hat, wenn nicht return einteilung
		int counter=0;
		for(int i = 0; i<this.k; i++){
			if(movementOfK[i] < 10){
				counter++;
			}
		}
		if(counter == this.k){
			break;
		}
		}
		
		return einteilung;
	}
	
	public void isoData(){
		loescheLeereK();
		teileGrosseK();
		
	}
	
	private void loescheLeereK(){
//		int newK = 0;
		for(int i = 0; i < this.k;i++){
			if(einteilung.get(i).size() == 0){
				einteilung.remove(i);
				lageVonK.remove(i);
				this.k--;
			}
		}
	}
	
	private void teileGrosseK(){
		for(int i = 0; i < this.k;i++){
			//Die If Bedingung muesste noch so veraendert werden, dass nur stark streuende K geteilt werden
//			double streuung = 
			if(einteilung.get(i).size() > 2*(merkmale.size()/this.k)){
				einteilung.add(new ArrayList<double[]>());
				double[] point = new double[dimensionen];
				for(int j = 0; j < dimensionen; j++){
					point[j] = Math.random() + lageVonK.get(i)[j];
				}
				lageVonK.add(point);
				this.k++;
			}
		}
	}
	
	private double calcStreuung(int ik){
		double streuung = 0;
		for(int i =0; i<dimensionen;i++){
			//Distanz Tabelle berechnen und davon streuung: 1/n * (i-j)^2...
//			Math.pow(einteilung.get(ik)[j] - lageVonK.get(ik)[j], 2);
		}
		return streuung;
	}
	
	private void findeUnklassifizierbareK(){
		//sind Ks mit wenig eintraegen
	}
	
	public void einteilungAusgabe(){
		for(int i = 0; i < this.k ; i++){
//			System.out.println("K = " + i);
			for(double[] m : einteilung.get(i)){
				for(int j = 0; j<this.dimensionen; j++){
//					System.out.print(m[j] + ", ");
				}
//				System.out.println("\t");
			}
		}
	}
	
	public int getK(){
		return k;
	}

}
