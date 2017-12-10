package M1;

import java.util.ArrayList;
import java.util.List;

import M2.Composant;
import M2.Configuration;
import M2.InterfaceComposants;
import M2.Port;

public class SecurityManager extends Composant{

	/*
	 * pSSecuConnexion
	 * pSSecuBDD
	 */
	
	private List<String> listOK;
	
	public SecurityManager(Configuration c) {
		super(c);
		listOK = new ArrayList<String>();
		listOK.add("Client");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void receive(String msg, Port p) {
		System.out.println("security msg from : "+ p.getName() +" : " + msg);
		String res="non";
		String delims = "[,]+";
		String[] tokens = msg.split(delims);
		for(String s : listOK) {
			if(tokens[0].equals(tokens[0])) {
				res = "oui";
			}
		}
		for(Port p2 : this.getInterS().getListPortS()) {
			if(p2.getName().equals("pSSecuConnexion")) {
				p2.send(msg+","+res);
			}
		}
	}
}
