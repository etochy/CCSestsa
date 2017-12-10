package M1;

import M2.Composant;
import M2.Configuration;
import M2.Port;

public class BDD extends Composant{
/*
 * pSBddConnexion
 * pSBddSecu
 */
	private boolean ouvert = true;
	private String bdd = "";
	
	public BDD(Configuration c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	public void receive(String msg, Port p) {
		System.out.println("BDD msg from : "+ p.getName() +" : " + msg);
		String delims = "[,]+";
		String[] tokens = msg.split(delims);
		
		if(tokens[1].equals("lecture")) {
			for(Port p2 : this.getInterS().getListPortS()) {
				if(p2.getName().equals("pSBddConnexion")) {
					p2.send(bdd);
				}
			}
		}
		else {
			while(!ouvert) {
				System.out.println("Non ouvert");
			}
			ouvert = false;
			bdd += tokens[1];
			ouvert = true;
		}
	}
	

}
