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
		g.fillOval(0, 0, polje.getWidth()-1, polje.getHeight()-1);
	}

}
