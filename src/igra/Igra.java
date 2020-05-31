package igra;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Igra extends Frame {
	private Mreza mreza;
	public enum Rezim { IGRA, IZMENA };
	public Rezim rezim;
	MenuBar bar;
	Menu menu;
	MenuItem rezimIgre;
	MenuItem rezimIzmena;
	CheckboxGroup izbor;
	Checkbox trava;
	Checkbox zid;
	TextField brojNovcica;
	Label brojPoena;
	Button pocni;
	
	public Igra() {
		super("Tenkovi");
		setSize(650, 650);
		mreza = new Mreza(this);
		add(mreza, BorderLayout.CENTER);
		rezim = Rezim.IZMENA;
		
		dodajPanele();
		dodajMeni();
		dodajOsluskivace();
		
		setVisible(true);
	}
	
	private void dodajPanele() {
		Panel desni = new Panel();
		Panel donji = new Panel();
		desni.setLayout(new BorderLayout());
		Panel choice = new Panel();
		choice.setLayout(new GridLayout(2,0));
		desni.add(choice, BorderLayout.EAST);
		
		
		izbor = new CheckboxGroup();
		trava = new Checkbox("Trava", true, izbor);
		zid = new Checkbox("Zid", true, izbor);
		trava.setBackground(Color.GREEN);
		zid.setBackground(Color.LIGHT_GRAY);
		
		Label podloga = new Label("Podloga: ");
		
		desni.add(podloga, BorderLayout.WEST);
		choice.add(trava);
		choice.add(zid);
		
		
		Label novcici = new Label("Novcica: ");
		brojNovcica = new TextField(2);
		Label poeni = new Label("Poena: ");
		brojPoena = new Label("");
		pocni = new Button("Pocni");
		
		donji.add(novcici);
		donji.add(brojNovcica);
		donji.add(poeni);
		donji.add(brojPoena);
		donji.add(pocni);
		
		add(desni, BorderLayout.EAST);
		add(donji, BorderLayout.SOUTH);
		
	}
	
	private void dodajOsluskivace() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				mreza.zavrsi();
				dispose();
			}
		});
		
		rezimIzmena.addActionListener(e -> {
			rezim = Rezim.IZMENA;
			System.out.println("Rezim Izmena");
		});
		
		rezimIgre.addActionListener(e -> {
			rezim = Rezim.IGRA;
			System.out.println("Rezim Igre");
		});
	}
	
	private void dodajMeni() {
		bar = new MenuBar();
		menu = new Menu("Rezim");
		setMenuBar(bar);
		bar.add(menu);
		rezimIgre = new MenuItem("Rezim igre");
		rezimIzmena = new MenuItem("Rezim izmena");
		menu.add(rezimIzmena);
		//menu.addSeparator();
		menu.add(rezimIgre);
	}
}
