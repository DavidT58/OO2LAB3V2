package igra;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class Mreza extends Panel implements Runnable {
	
	private Polje[][] polja;
	private ArrayList<Figura> igraci;
	private int d;
	
	public Mreza(int dd) {
		d = dd;
		polja = new Polje[d][d];
		Random r = new Random();
		
		for(int i = 0; i < d; i++)
			for(int j = 0; j < d; j++) {
				polja[i][j] = null;
			}
				
	}
	
	public Mreza() { this(17); } 
	
	
	@Override
	public void run() {
		
		
	}

}
