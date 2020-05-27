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
		g.drawLine(0, 0, polje.getWidth(), polje.getHeight());
		g.drawLine(polje.getWidth(), 0, 0, polje.getHeight());
	}

	@Override
	public void run() {
			
	}

}
