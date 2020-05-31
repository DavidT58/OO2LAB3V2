package igra;

import java.awt.Graphics;
import java.util.Random;

public class Tenk extends Figura implements Runnable {

	//public enum Smer{ GORE, DOLE, LEVO, DESNO };
	Thread nit;
	
	public Tenk(Polje p) {
		super(p);
		
	}
	
	public void pokreni() {
		if(nit == null)
			nit = new Thread(this);
		if(!nit.isAlive())
			nit.start();
	}
	
	public void zaustavi() {
		if(nit != null)
			nit.interrupt(); 
		nit = null;
	}

	@Override
	public synchronized void crtaj() {
		Graphics g = polje.getGraphics();
		g.setColor(boja);
		g.drawLine(0, 0, polje.getWidth(), polje.getHeight());
		g.drawLine(polje.getWidth(), 0, 0, polje.getHeight());
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Random r = new Random();
				int t  = r.nextInt(4);
				/*
				 * 0 - gore
				 * 1 - dole
				 * 2 - desno
				 * 3 - levo
				 */
				switch(t) {
				case 0:
					pomeriNaPolje(polje.dohvatiPoljePomeraj(0, -1));
					System.out.println("Pomeren tenk na gore");
					break;
				case 1:
					pomeriNaPolje(polje.dohvatiPoljePomeraj(0, 1));
					System.out.println("Pomeren tenk na dole");
					break;
				case 2:
					pomeriNaPolje(polje.dohvatiPoljePomeraj(1, 0));
					System.out.println("Pomeren tenk u desno");
					break;
				case 3:
					pomeriNaPolje(polje.dohvatiPoljePomeraj(-1, 0));
					System.out.println("Pomeren tenk u levo");
					break;
				}
				
				Thread.sleep(500);
			}
		}catch (InterruptedException e) {}		
	}

}
