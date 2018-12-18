import java.util.Observable;
import java.util.Observer;

public class Interface implements Observer {

	@Override
	public void update(Observable o, Object arg) {		
		((Bord) arg).show();
	}
	
}
