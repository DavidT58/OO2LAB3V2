package igra;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Igra extends Frame {
	private Mreza mreza;
	private boolean rezim; //true rezim igre, false rezim izmena
	
	
	public Igra() {
		super("Tenkovi");
		mreza = new Mreza();
		setSize(600, 600);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		dodajMeni();
		
		setVisible(true);
	}
	
	private void dodajMeni() {
		MenuBar bar = new MenuBar();
		Menu menu = new Menu("Rezim");
		setMenuBar(bar);
		bar.add(menu);
		MenuItem rezimIgre = new MenuItem("Rezim igre");
		MenuItem rezimIzmena = new MenuItem("Rezim izmena");
		menu.add(rezimIzmena);
		menu.addSeparator();
		menu.add(rezimIgre);
		
	}
}
