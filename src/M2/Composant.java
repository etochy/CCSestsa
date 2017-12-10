package M2;

import java.util.ArrayList;
import java.util.List;

public class Composant implements GComposant{
	
	private Configuration context;
	
	private List<Configuration> listConfig;
	private List<Properties> listProperties;
	private List<Constraints> listConstraints;
	
	private InterfaceComposants interR;
	private InterfaceComposants interS;
	
	public Composant(Configuration c) {
		this.context = c;
		this.listConfig = new ArrayList<Configuration>();
		this.listConstraints = new ArrayList<Constraints>();
		this.listProperties = new ArrayList<Properties>();
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
		System.out.println("send Composant " + name.getName() + " : "+msg);
		this.context.send(msg, name);
		if(listConfig.size()>0)
			for(Configuration c : listConfig) {
				c.send(msg, name);
			}
	}
	public void receive(String msg, Port name) {
		// Do something, utilisation du domaine metier
		System.out.println("receive " + this.toString());
		if(listConfig.size()>0) {
			for(Configuration c : listConfig) {
				c.receive(msg, name);
			}
		}
	}
	
	
	
	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(Configuration e) {
		return listConfig.add(e);
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(Properties e) {
		return listProperties.add(e);
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(Constraints e) {
		return listConstraints.add(e);
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

	/**
	 * @return the interR
	 */
	public InterfaceComposants getInterR() {
		return interR;
	}

	/**
	 * @param interR the interR to set
	 */
	public void setInterR(InterfaceComposants interR) {
		this.interR = interR;
	}

	/**
	 * @return the interS
	 */
	public InterfaceComposants getInterS() {
		return interS;
	}

	/**
	 * @param interS the interS to set
	 */
	public void setInterS(InterfaceComposants interS) {
		this.interS = interS;
	}


	
}
