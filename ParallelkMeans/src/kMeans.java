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
	private ArrayList<int[]> merkmale;
	private Vector<ArrayList<int[]>> einteilung;
	private ArrayList<double[]> lageVonK;
	
	public kMeans(int k, int maxMerkmal, int dimensionen){
		this.k = k;
		this.maxMerkmal = maxMerkmal;
		this.dimensionen = dimensionen;
		merkmale = new ArrayList<int[]>();
		einteilung = new Vector<ArrayList<int[]>>();
		for(int i = 0; i<this.k; i++){
			einteilung.add(new ArrayList<int[]>());
		}
		this.initialisierung();
	}
	
	public void setMerkmale(ArrayList<int[]> merkmale){
		this.merkmale = merkmale;
	}
	
	public Vector<ArrayList<int[]>> getEinteilung(){
		return einteilung;
	}
	
	public void addMerkmal(int[] m){
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
	
	public Vector<ArrayList<int[]>> calcKMeans(){	
		int c=0;
		while(true){
			//merkmale auf k Verteilen
			c++;
//			System.out.println("Runde: " + c);
			
//			for(int i = 0; i<this.k; i++){
//				//= new ArrayList<double[]>();
//			}
			Vector<int[]> tempNeueLage = new Vector<int[]>(this.k);
//			for(int i = 0; i<this.k;i++){
//				einteilung.get(i).clear();
//				tempNeueLage.add(new int[3]);
//			}
			int counterM = 0;
			for(int[] m : merkmale){
				if(counterM==0){
					double minDistance = Double.MAX_VALUE;
					int knum=-1;
					for(int i = 0; i<this.k;i++){
						einteilung.get(i).clear();
						tempNeueLage.add(new int[3]);
						int temp = 0;
						for(int j = 0; j<dimensionen; j++){
							temp += Math.pow(m[j]-lageVonK.get(i)[j], 2);
						}
						if(Math.sqrt(temp) <= minDistance){
							minDistance = Math.sqrt(temp);
							knum = i;
						}
					}
					einteilung.get(knum).add(m); //[knum].add(m);
					tempNeueLage.get(knum)[0] += m[0];
					tempNeueLage.get(knum)[1] += m[1];
					tempNeueLage.get(knum)[2] += m[2];
					counterM++;
				} else if(counterM==merkmale.size()-1){
					double minDistance = Double.MAX_VALUE;
					int knum=-1;
					for(int i = 0; i<this.k;i++){
						int temp = 0;
						for(int j = 0; j<dimensionen; j++){
							temp += Math.pow(m[j]-lageVonK.get(i)[j], 2);
						}
						if(Math.sqrt(temp) <= minDistance){
							minDistance = Math.sqrt(temp);
							knum = i;
						}
					}
					einteilung.get(knum).add(m); //[knum].add(m);
					tempNeueLage.get(knum)[0] += m[0];
					tempNeueLage.get(knum)[1] += m[1];
					tempNeueLage.get(knum)[2] += m[2];
					
				} else {
					double minDistance = Double.MAX_VALUE;
					int knum=-1;
					for(int i = 0; i<this.k;i++){
						int temp = 0;
						for(int j = 0; j<dimensionen; j++){
							temp += Math.pow(m[j]-lageVonK.get(i)[j], 2);
						}
						if(Math.sqrt(temp) <= minDistance){
							minDistance = Math.sqrt(temp);
							knum = i;
						}
					}
					einteilung.get(knum).add(m); //[knum].add(m);
//					tempNeueLage.get(knum)[0] += (lageVonK.get(knum)[0]-m[0]);
//					tempNeueLage.get(knum)[1] += (lageVonK.get(knum)[1]-m[1]);
//					tempNeueLage.get(knum)[2] += (lageVonK.get(knum)[2]-m[2]);
					tempNeueLage.get(knum)[0] += m[0];
					tempNeueLage.get(knum)[1] += m[1];
					tempNeueLage.get(knum)[2] += m[2];
					counterM++;
				}
			}
			
			double[] tempMovement = new double[this.k];
			for(int i =0;i<this.k;i++){
				for(int j = 0; j<this.dimensionen;j++){
					if(einteilung.get(i).size()!=0){
						double newPosition = tempNeueLage.get(i)[j]/einteilung.get(i).size();
						tempMovement[i] += Math.pow(lageVonK.get(i)[j]-newPosition, 2);
						lageVonK.get(i)[j] = newPosition;
					}
				}
				tempMovement[i] = Math.sqrt(tempMovement[i]);
			}

			
		//pruefen ob zentrum sich noch signifikant bewegt hat, wenn nicht return einteilung
		int counter=0;
		for(int i = 0; i<this.k; i++){
			if(tempMovement[i] < 25){
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
		//Verschmelze nahe,kleine k
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
				einteilung.add(new ArrayList<int[]>());
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
			for(int[] m : einteilung.get(i)){
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
