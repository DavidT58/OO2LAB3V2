package igra;

import java.awt.Graphics;

public class Tenk extends Figura implements Runnable {

	public enum Smer{ GORE, DOLE, LEVO, DESNO };
	
	
	public Tenk(Polje p) {
		super(p);
		
	}
	
	public void pomeri(Smer s) {
		switch(s) {
		case GORE:
			break;
		}
	}

	@Override
	public void crtaj() {
		Graphics g = polje.getGraphics();
		g.setColor(boja);
		g.drawLine(polje.getX(), polje.getY(), polje.getX() + polje.getWidth(), polje.getY() + polje.getHeight());
	}

	@Override
	public void run() {
			
	}

}
