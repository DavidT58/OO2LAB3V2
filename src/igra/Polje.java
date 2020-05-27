package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


@SuppressWarnings("serial")
public abstract class Polje extends Canvas {
	
	protected static int nextid = 0;
	protected int id = nextid++;
	
	protected Color boja;
	protected Mreza mreza;
	protected boolean moze;
	protected int[] pozicija;
	
	public Polje(Mreza m) {
		mreza = m;
		pozicija = new int[2];
	}
	
	public int getID() { return id; }
	
	public Polje dohvatiPoljePomeraj(int offsx, int offsy) {
		int newX = pozicija[0] + offsx;
		int newY = pozicija[1] + offsy;
		
		if(newX < 0 || newY < 0 || newX >= mreza.getPolja().length || newY >= mreza.getPolja().length)
			return null;
		
		if(mreza.getPolja()[newX][newY] != null)
			return mreza.getPolja()[pozicija[0]+offsx][pozicija[1]+offsy];
		
		return null;
	}
	
	public void setPozicija(int x, int y) {
		pozicija[0] = x;
		pozicija[1] = y;
	}
	
	public int[] getPozicija() { return pozicija; }
	
	public Mreza getMreza() { return mreza; }
	
	public boolean mozeFigura(Figura f) { return moze; }
	
	public boolean moze() { 
		return !(this instanceof Zid);
	}
	
	
}
