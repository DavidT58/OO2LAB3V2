package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public abstract class Polje extends Canvas {
	
	private static int nextid = 0;
	private int id = nextid++;
	
	protected Color boja;
	private Mreza mreza;
	protected boolean moze;
	private int[] pozicija;
	
	public Polje(Mreza m) {
		mreza = m;
		pozicija = new int[2];
		
		//addMouseListener(getMouseAdapter(this));
	}
	
	private MouseAdapter getMouseAdapter(Polje p) {
		MouseAdapter t = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mouse clicked" + e.getX() + ", " + e.getY());
				System.out.println(getComponentAt(e.getX(), e.getY()));
				if(getComponentAt(e.getX(), e.getY()) == p) 
					System.out.println(p.getID());
			}
		};
		return t;
	}
	
	public int getID() { return id; }
	
	public Polje dohvatiPoljePomeraj(int x, int y) {
		
		
		return null;
	}
	
	public void setPozicija(int x, int y) {
		pozicija[0] = x;
		pozicija[1] = y;
	}
	
	public int[] getPozicija() { return pozicija; }
	
	public Mreza getMreza() { return mreza; }
	
	public boolean mozeFigura(Figura f) { return moze; }
	
	
	public void paint(Graphics g) {
		g.setColor(this.boja);
		g.fillRect(getX(), getY(), 25, 25);
	}
}
