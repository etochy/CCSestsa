package M1;

import M2.Composant;
import M2.Configuration;
import M2.InterfaceComposants;
import M2.Port;

public class BDD extends Composant{

	public BDD(Configuration c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	public void receive(String msg, Port p) {
		System.out.println("BDD msg from server : " + msg);
	}
	

}
