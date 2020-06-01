package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Figura {
	
	public Igrac(Polje p) {
		super(p);
		boja = Color.RED;
	}

	@Override
	public void crtaj() {
		Graphics g = polje.getGraphics();
		g.setColor(boja);
		//g.fillRect(0, 0, polje.getWidth()-1, polje.getHeight()-1);
		g.drawLine(polje.getWidth()/2, 0, polje.getWidth()/2, polje.getHeight()-1);
		g.drawLine(0, polje.getHeight()/2, polje.getWidth(), polje.getHeight()/2);
	}
}
