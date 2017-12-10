package M1;

import M2.Composant;
import M2.Configuration;
import M2.InterfaceComposants;

public class Serveur extends Composant{

	public Serveur(Configuration c) {
		super(c);
		SystemeServeur systemS = new SystemeServeur(this);
		add(systemS);
	}

}
