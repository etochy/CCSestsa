package M1;

import java.util.List;

import M2.Attachment;
import M2.Binding;
import M2.Configuration;
import M2.GComposant;
import M2.GConnector;
import M2.InterfaceConfiguration;

public class SystemeServeur extends Configuration{
	private Serveur context;
	
	public SystemeServeur(Serveur c) {
		this.context = c;
	}
	public SystemeServeur(List<GComposant> listComposants, List<GConnector> listConnectors,
			List<InterfaceConfiguration> listInterface, List<Binding> listBindings, List<Attachment> listAttachments) {
		super(listComposants, listConnectors, listInterface, listBindings, listAttachments);
		// TODO Auto-generated constructor stub
	}

}
