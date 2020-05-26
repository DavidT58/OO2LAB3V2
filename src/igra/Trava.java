package igra;

import java.awt.Color;

public class Trava extends Polje {
	public Trava(Mreza m) {
		super(m);
		moze = true;
		boja = Color.GREEN;
		setBackground(boja);
	}
}
