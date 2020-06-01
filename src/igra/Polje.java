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
	protected int xx, yy;
	
	public Polje(Mreza m) {
		mreza = m;
	}
	
	public int getID() { return id; }
	
	public Polje dohvatiPoljePomeraj(int offsx, int offsy) {
		int newX = xx + offsx;
		int newY = yy + offsy;
		
		if(newX < 0 || newY < 0 || newX >= mreza.getPolja().length || newY >= mreza.getPolja().length)
			return null;
		
		if(mreza.getPolja()[newY][newX] != null)
			return mreza.getPolja()[newY][newX];
		
		return null;
	}
	
	public void setPozicija(int x, int y) {
		xx = x;
		yy = y;
	}
	
	public int[] getPozicija() {
		int[] ret = new int[2];
		ret[0] = xx;
		ret[1] = yy;
		return ret;
	}
	
	public Mreza getMreza() { return mreza; }
	
	public boolean mozeFigura(Figura f) { return moze; }
	
	public boolean moze() { 
		return !(this instanceof Zid);
	}
}
