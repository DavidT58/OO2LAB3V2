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
		//g.drawRect(x, y, 10, 10);
		g.drawLine(polje.getX()+polje.getWidth()-1, polje.getY(), polje.getX(), polje.getY() + polje.getHeight()-1);
		g.drawLine(polje.getX(), polje.getY(), polje.getX() + polje.getWidth(), polje.getY() + polje.getHeight());
	}
}
