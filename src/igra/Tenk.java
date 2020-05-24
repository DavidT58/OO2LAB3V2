package igra;

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
		

	}

	@Override
	public void run() {
			
	}

}
