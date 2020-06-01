package igra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import igra.Mreza.Smer;

@SuppressWarnings("serial")
public class Mreza extends Panel implements Runnable {
	
	private Igra igra;
	private Polje[][] polja;
	private Igrac igrac;
	private ArrayList<Novcic> novcici;
	private ArrayList<Tenk> tenkovi;
	private int d;
	private Thread nit = new Thread(this);
	private int brNov;
	public enum Smer { GORE, DOLE, LEVO, DESNO };
	private Label labelPoeni;
	private int poeni;
	
	public Mreza(int dd, Igra ig) {
		igra = ig;
		d = dd;
		poeni = 0;
		labelPoeni = new Label();
		polja = new Polje[d][d];
		novcici = new ArrayList<Novcic>();
		tenkovi = new ArrayList<Tenk>();
		setLayout(new GridLayout(d, d, 2, 2));
		setBackground(new Color(127,127,127));
		
		brNov = 0;
		init();
	}
	
	public void init() {
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
	
	public synchronized void setBrojNovcica(int t) {
		brNov = t; 
		igrac = null;
		novcici = new ArrayList<Novcic>();
		tenkovi = new ArrayList<Tenk>();
		dodajFigure(brNov);
	}
	
	private void dodajFigure(int brnov) {
		Random r = new Random();
		int r1 = r.nextInt(d);
		int r2 = r.nextInt(d);
		while(!polja[r1][r2].mozeFigura(igrac)) {
			r1 = r.nextInt(d);
			r2 = r.nextInt(d);
		}
		igrac = new Igrac(polja[r1][r2]);
		
		
		for(int i = 0; i < brnov; i++) {
			r1 = r.nextInt(d);
			r2 = r.nextInt(d);
			while(!polja[r1][r2].mozeFigura(igrac)){
				r1 = r.nextInt(d);
				r2 = r.nextInt(d);
			}
			novcici.add(new Novcic(polja[r1][r2]));
		}
		
		for(int i = 0; i < brnov/3; i++) {
			r1 = r.nextInt(d);
			r2 = r.nextInt(d);
			while(!polja[r1][r2].mozeFigura(igrac)) {
				r1 = r.nextInt(d);
				r2 = r.nextInt(d);
			}
			tenkovi.add(new Tenk(polja[r1][r2]));
		}
	}
	
	public Mreza(Igra igra) { this(17, igra); } 
	
	public Polje[][] getPolja() { return polja; }

	public Igrac getIgrac() { return igrac; }

	public ArrayList<Novcic> getNovcici() { return novcici; }

	public ArrayList<Tenk> getTenkovi() { return tenkovi; }
	
	@Override
	public void paint(Graphics g) {
		
		for(int i = 0; i < d; i++) {
			for(int j = 0; j < d; j++) {
				if(polja[i][j] != null)
					polja[i][j].paint(g);
			}
		}
		if(igrac != null) igrac.crtaj();
		for(Novcic n : novcici)
			n.crtaj();
		for(Tenk t : tenkovi)
			t.crtaj();
	}
	
	public synchronized void pomeriIgraca(Smer s) {
		switch(s) {
		case GORE:
			igrac.pomeriNaPolje(igrac.getPolje().dohvatiPoljePomeraj(0, -1));
			break;
		case DOLE:
			igrac.pomeriNaPolje(igrac.getPolje().dohvatiPoljePomeraj(0, 1));
			break;
		case LEVO:
			igrac.pomeriNaPolje(igrac.getPolje().dohvatiPoljePomeraj(-1, 0));
			break;
		case DESNO:
			igrac.pomeriNaPolje(igrac.getPolje().dohvatiPoljePomeraj(1, 0));
			break;
		}
	}
	
	private synchronized void proveri() {
		
		for(Tenk t: tenkovi) {
			if(t.equals(igrac)) {
				zavrsi();
			}
		}
		
		ArrayList<Novcic> zaBrisanje = new ArrayList<Novcic>();
		for(Novcic n : novcici) {
			if(n.equals(igrac)) {
				zaBrisanje.add(n);
				poeni++;
				labelPoeni.setText("" + poeni);
			}
		}
		novcici.removeAll(zaBrisanje);
		if(novcici.size() == 0)
			zavrsi();
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				repaint();
				requestFocus();
				proveri();
				Thread.sleep(40);
			}
		}catch (InterruptedException e) {}		
	}
	
	public void pokreni() {
		if(nit == null)
			nit = new Thread(this);
		
		if(!nit.isAlive())
			nit.start();
		
		for(Tenk t : tenkovi)
			t.pokreni();
	}
	
	public void zavrsi() {		
		for(Tenk t : tenkovi)
			t.zaustavi();
		
		if(nit != null && nit.isAlive())
			nit.interrupt();
		nit = null;
	}

	public Label getLabel() { return labelPoeni; }

}
