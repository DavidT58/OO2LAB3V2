package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Figura {
	
	public Igrac(Polje p) {
		super(p);
		boja = Color.RED;
	}
	
	public void pomeriIgraca(Mreza.Smer s) {
		switch(s) {
		case GORE:
			//if(polje.dohvatiPoljePomeraj(0, -1).mozeFigura(this))
			System.out.println("Pomeren igrac GORE");
				pomeriNaPolje(polje.dohvatiPoljePomeraj(0, -1));
			break;
		case DOLE:
			//if(polje.dohvatiPoljePomeraj(0, 1).mozeFigura(this))
				pomeriNaPolje(polje.dohvatiPoljePomeraj(0, 1));
			break;
		case LEVO:
			//if(polje.dohvatiPoljePomeraj(-1, 0).mozeFigura(this))
				pomeriNaPolje(polje.dohvatiPoljePomeraj(-1, 0));
			break;
		case DESNO:
			//if(polje.dohvatiPoljePomeraj(1, 0).mozeFigura(this))
				pomeriNaPolje(polje.dohvatiPoljePomeraj(1, 0));
			break;
		}
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
