package igra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class Mreza extends Panel implements Runnable {
	
	private Igra igra;
	private Polje[][] polja;
	private ArrayList<Igrac> igraci;
	private ArrayList<Novcic> novcici;
	private ArrayList<Tenk> tenkovi;
	private int d;
	
	public Mreza(int dd, Igra ig) {
		igra = ig;
		d = dd;
		polja = new Polje[d][d];
		igraci = new ArrayList<Igrac>();
		novcici = new ArrayList<Novcic>();
		tenkovi = new ArrayList<Tenk>();
		setBounds(0, 54, igra.getWidth() - 100, igra.getHeight()-100);
		
		
		for(int i = 0; i < d; i++)
			for(int j = 0; j < d; j++) {
				double rand = Math.random();
				polja[i][j] = (rand < 0.8) ? new Trava(this) : new Zid(this);
				//polja[i][j].setPozicija(i*25 + i*4, j*25 + j*4);
				polja[i][j].setBounds(i*25 + i*4, j*25 + j*4 + 54, 25, 25);
				//add(polja[i][j], BorderLayout.CENTER);
			}
		
	}
	
	public Mreza(Igra igra) { this(17, igra); } 
	
	
	public Polje[][] getPolja() { return polja; }

	public ArrayList<Igrac> getIgraci() { return igraci; }

	public ArrayList<Novcic> getNovcici() { return novcici; }

	public ArrayList<Tenk> getTenkovi() { return tenkovi; }

	
	@Override
	public void paint(Graphics g) {
		setBackground(new Color(127,127,127));
		for(int i = 0; i < d; i++)
			for(int j = 0; j < d; j++) {
				polja[i][j].paint(g);
			}
	}
	
	@Override
	public void run() {
		
		
	}

}
