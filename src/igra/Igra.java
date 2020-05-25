package igra;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Igra extends Frame {
	private Mreza mreza;
	private boolean rezim; //true rezim igre, false rezim izmena
	
	
	public Igra() {
		super("Tenkovi");
		mreza = new Mreza(this);
		setBounds(0, 0, 500, 500);
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	
		add(mreza, BorderLayout.CENTER);
		
		dodajMeni();
		
		//setResizable(false);
		setVisible(true);
		
		mreza.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mouse clicked" + e.getX() + ", " + e.getY());
				System.out.println(getComponentAt(e.getX(), e.getY()));
			}
		});
		
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
