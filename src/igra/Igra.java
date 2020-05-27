package igra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Igra extends Frame {
	private Mreza mreza;
	private boolean rezim; //true rezim igre, false rezim izmena
	
	
	public Igra() {
		super("Tenkovi");
		setSize(650, 650);
		mreza = new Mreza(this);
		
		add(mreza, BorderLayout.CENTER);
		Label l1 = new Label("LMAO");
		l1.setBackground(Color.yellow);
		add(l1, BorderLayout.EAST);
		
		dodajMeni();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//mreza.zavrsi();
				dispose();
			}
		});
		
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
		
		rezimIzmena.addActionListener(e -> {
			rezim = false;
			System.out.println("Rezim Izmena");
		});
		
		rezimIgre.addActionListener(e -> {
			rezim = true;
			System.out.println("Rezim Igre");
		});
	}
}
