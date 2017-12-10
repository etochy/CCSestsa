package M1;

import M2.Composant;
import M2.Configuration;
import M2.InterfaceComposants;

public class Serveur extends Composant{
	SystemeServeur systemS;
	public Serveur(Configuration c) {
		super(c);
		systemS = new SystemeServeur(this); //initialise la config
		add(systemS);
	}
	public void creerServ() {
		systemS.creerSystemServ(); // construit l'interieur de la config
	}
}
