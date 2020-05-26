package igra;

import java.awt.Color;

@SuppressWarnings("serial")
public class Zid extends Polje {
	public Zid(Mreza m) {
		super(m);
		moze = false;
		boja = Color.LIGHT_GRAY;
		setBackground(boja);
	}
}
