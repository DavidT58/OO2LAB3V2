package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Novcic extends Figura {
	
	public Novcic(Polje p) {
		super(p);
	}
	
	@Override
	public void crtaj() {
		Graphics g = polje.getGraphics();
		g.setColor(Color.YELLOW);
		g.fillOval(polje.getWidth()/4, polje.getWidth()/4, polje.getWidth()/2, polje.getHeight()/2);
	}

}
