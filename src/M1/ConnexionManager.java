package M1;

import M2.Composant;
import M2.Configuration;
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
		System.out.println(" ==================== Connexion msg from : "+ p.getName() +" : " + msg);

		if(p.getName().equals("pRConnexion")) { //si msg en provenance du client
			for(Port p2 : this.getInterS().getListPortS()) {
				if(p2.getName().equals("pSConnexionSecu")) {
					p2.send(msg); //envoi une demande au security manager
				}
			}	
		}
		else if(p.getName().equals("pRConnexionSecu")) { //si recoit une reponse du security
			String delims = "[,]+";
			String[] tokens = msg.split(delims);
			if(tokens[2].equals("oui")) { // si reponse positive, envoi le message a la bdd
				for(Port p2 : this.getInterS().getListPortS()) {
					if(p2.getName().equals("pSConnexionBDD")) {
						p2.send(tokens[0] +"," +tokens[1]);
					}
				}	
			}
			else {
				for(Port p2 : this.getInterS().getListPortS()) { //sinon, previen le client
					if(p2.getName().equals("pSConnexion")) {
						p2.send("Impossible d'acceder a la BDD");
					}
				}	
			}
		}
		else{
			for(Port p2 : this.getInterS().getListPortS()) { // si provient de la bdd, fait suivre au client
				if(p2.getName().equals("pSConnexion")) {
					p2.send(msg);
				}
			}	
		}
	}
}
