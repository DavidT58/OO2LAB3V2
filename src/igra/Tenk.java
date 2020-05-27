package igra;

import java.awt.Graphics;

public class Tenk extends Figura implements Runnable {

	//public enum Smer{ GORE, DOLE, LEVO, DESNO };
	Thread nit = new Thread(this);
	
	public Tenk(Polje p) {
		super(p);
		
	}
	
	public void pokreni() { nit.start(); }
	
	public void zaustavi() { nit.interrupt(); }

	@Override
	public void crtaj() {
		Graphics g = polje.getGraphics();
		g.setColor(boja);
		g.drawLine(0, 0, polje.getWidth(), polje.getHeight());
		g.drawLine(polje.getWidth(), 0, 0, polje.getHeight());
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					polje.getMreza().repaint();
					pomeriNaPolje(polje.dohvatiPoljePomeraj(1, 0));
					polje.getMreza().repaint();
					System.out.println("Pomeren tenk");
				}
			Thread.sleep(500);
			}
		}catch (InterruptedException e) {}		
	}

}
