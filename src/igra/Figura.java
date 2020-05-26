package igra;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {
	
	protected Color boja;
	protected Polje polje;
	protected int x, y;
	
	public Figura(Polje p) {
		polje = p;
		x = polje.getPozicija()[0];
		y = polje.getPozicija()[1];
	}
	
	public Polje getPolje() { return polje; }
	
	public void pomeriNaPolje(Polje p) {
		if(p.mozeFigura(this)) {
			polje = p;
			x = polje.getPozicija()[0];
			y = polje.getPozicija()[1];
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Figura))
			return false;
		
		Figura f = (Figura)o;
		
		return f.getPolje() == polje;
	}
	
	public abstract void crtaj();
}
