package M1;

import M2.Composant;
import M2.Configuration;
import M2.InterfaceComposants;
import M2.Port;

public class ConnexionManager extends Composant{

	/*
	 * pSConnexion
	 * pSConnexionBDD
	 * pSConnexionSecu
	 */
	
	public ConnexionManager(Configuration c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public void receive(String msg, Port p) {
		System.out.println("Connexion msg from server : "+p.getName() + " : " + msg);
		for(Port p2 : this.getInterS().getListPortS()) {
			System.out.println(p2.getName());
			if(p2.getName().equals("pSConnexionSecu")) {
				System.out.println("envoi");
				p2.send("Coucou ");
			}
		}
	}
}
