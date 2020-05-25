package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public abstract class Polje extends Canvas {
	
	protected Color boja;
	private Mreza mreza;
	protected boolean moze;
	private int[] pozicija;
	
	public Polje(Mreza m) {
		mreza = m;
		pozicija = new int[2];
	}
	
	public Polje dohvatiPoljePomeraj(int x, int y) {
		
		
		return null;
	}
	
	public void setPozicija(int x, int y) {
		pozicija[0] = x;
		pozicija[1] = y;
	}
	
	public int[] getPozicija() { return pozicija; }
	
	public Mreza getMreza() { return mreza; }
	
	public boolean mozeFigura(Figura f) { return moze; }
	
	public void paint(Graphics g) {
		g.setColor(this.boja);
		g.fillRect(pozicija[0], pozicija[1], 25, 25);
	}
}
