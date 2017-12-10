package M1;

import M2.Composant;
import M2.Configuration;
import M2.Port;

public class Client extends Composant{

	public Client(Configuration c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	public void ecrireServeur(String msg) {
		for(Port p : this.getInterS().getListPortS()) {
			if(p.getName().equals("pSClient")) {
				p.send("Client,"+msg);
			}
		}
	}
	
	public void recupererBdd() {
		for(Port p : this.getInterS().getListPortS()) {
			if(p.getName().equals("pSClient")) {
				p.send("Client,lecture");
			}
		}
	}

	public void receive(String msg, Port p) {
		System.out.println("Client : msg from server : " + msg);
	}

}
