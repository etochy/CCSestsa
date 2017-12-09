package M2;

import java.util.List;

public class Composant implements GComposant{
	
	private Configuration context;
	
	private List<Configuration> listConfig;
	private List<Properties> listProperties;
	private List<Constraints> listConstraints;
	
	private InterfaceComposants interR;
	private InterfaceComposants interS;
	
	public Composant(Configuration c, InterfaceComposants iS, InterfaceComposants iR) {
		this.context = c;
		this.interS = iS;
		this.interR = iR;
	}

	public Composant(Configuration c, InterfaceComposants iS, InterfaceComposants iR, List<Configuration> listC, List<Properties> listP, List<Constraints> listCo) {
		this.context = c;
		this.interS = iS;
		this.interR = iR;
		this.listConfig = listC;
		this.listProperties = listP;
		this.listConfig = listC;
	}
	
	public void send(String msg, Port name) {
		this.context.send(msg, name);	
	}
	public void receive(String msg, Port name) {
		// Do something, utilisation du domaine metier
	}
	
	public void addConfig(Configuration c) {
		listConfig.add(c);
	}
	public void addPropertie(Properties c) {
		listProperties.add(c);
	}
	public void addConstraint(Constraints c) {
		listConstraints.add(c);
	}
	
	public Configuration getContext() {
		return context;
	}

	public void setContext(Configuration context) {
		this.context = context;
	}

	public List<Configuration> getListConfig() {
		return listConfig;
	}

	public void setListConfig(List<Configuration> listConfig) {
		this.listConfig = listConfig;
	}

	public List<Properties> getListProperties() {
		return listProperties;
	}

	public void setListProperties(List<Properties> listProperties) {
		this.listProperties = listProperties;
	}

	public List<Constraints> getListConstraints() {
		return listConstraints;
	}

	public void setListConstraints(List<Constraints> listConstraints) {
		this.listConstraints = listConstraints;
	}


	
}
