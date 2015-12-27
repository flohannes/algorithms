import java.util.ArrayList;


public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> liste = new ArrayList<String>(4);
		
		liste.add("Hallo");
		liste.add(", ");
		liste.add("wie geht es ");
		liste.add("dir");
		liste.add("?");
		
		liste.remove(1);
		liste.add(1,",");
		
		for(int i = 0; i < liste.size(); i++){
			System.out.println(liste.get(i));
		}
		
	}
	

}
