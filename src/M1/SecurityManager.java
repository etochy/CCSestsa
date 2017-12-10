package M1;

import M2.Composant;
import M2.Configuration;
import M2.InterfaceComposants;
import M2.Port;

public class SecurityManager extends Composant{

	public SecurityManager(Configuration c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void receive(String msg, Port p) {
		System.out.println("security msg from server : " + msg);
		for(Port p2 : this.getInterS().getListPortS()) {
			System.out.println(p2.getName());
			if(p2.getName().equals("pSSecuBDD")) {
				System.out.println("envoi");
				p2.send("Coucou 2");
			}
		}
	}
}
