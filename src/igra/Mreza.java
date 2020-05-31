package igra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class Mreza extends Panel implements Runnable {
	
	private Igra igra;
	private Polje[][] polja;
	private Igrac igrac;
	private ArrayList<Novcic> novcici;
	private ArrayList<Tenk> tenkovi;
	private int d;
	Thread nit = new Thread(this);
	
	public Mreza(int dd, Igra ig) {
		igra = ig;
		d = dd;
		polja = new Polje[d][d];
		novcici = new ArrayList<Novcic>();
		tenkovi = new ArrayList<Tenk>();
		setLayout(new GridLayout(d, d, 2, 2));
		
		azuriraj();
		dodajFigure();
		
	}
	
	private synchronized void dodajFigure() {
		Random r = new Random();
		int r1 = r.nextInt(d);
		int r2 = r.nextInt(d);
		while(!polja[r1][r2].moze()) {
			r1 = r.nextInt(d);
			r2 = r.nextInt(d);
		}
		igrac = new Igrac(polja[r1][r2]);
		
		r1 = r.nextInt(d);
		r2 = r.nextInt(d);
		while(!polja[r1][r2].moze()) {
			r1 = r.nextInt(d);
			r2 = r.nextInt(d);
		}
		novcici.add(new Novcic(polja[r1][r2]));
		
		r1 = r.nextInt(d);
		r2 = r.nextInt(d);
		while(!polja[r1][r2].moze()) {
			r1 = r.nextInt(d);
			r2 = r.nextInt(d);
		}
		tenkovi.add(new Tenk(polja[r1][r2]));
		tenkovi.get(0).pokreni();
	}
	
	public Mreza(Igra igra) { this(17, igra); } 
	
	public Polje[][] getPolja() { return polja; }

	public Igrac getIgrac() { return igrac; }

	public ArrayList<Novcic> getNovcici() { return novcici; }

	public ArrayList<Tenk> getTenkovi() { return tenkovi; }
	
	@Override
	public void paint(Graphics g) {
		setBackground(new Color(127,127,127));
		for(int i = 0; i < d; i++) {
			for(int j = 0; j < d; j++) {
				if(polja[i][j] != null)
					polja[i][j].paint(g);
			}
		}
		if(igrac != null)igrac.crtaj();
		for(Novcic n : novcici)
			n.crtaj();
		for(Tenk t : tenkovi)
			t.crtaj();
	}
	
	public synchronized void azuriraj() {
		for(int i = 0; i < d; i++) {
			for(int j = 0; j < d; j++) {
				double rand = Math.random();
				polja[i][j] = (rand < 0.8) ? new Trava(this) : new Zid(this);
				polja[i][j].setPozicija(j, i);
				polja[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						System.out.println("Mouse clicked " + e.getX() + ", " + e.getY());
					}
				});
				add(polja[i][j]);
			}
		}
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				
			repaint();
			Thread.sleep(40);
			}
		}catch (InterruptedException e) {}		
	}
	
	public synchronized void zavrsi() {
		nit.interrupt();
		
		for(Tenk t : tenkovi)
			t.zaustavi();
	}

}
