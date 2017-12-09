package M2;

import java.util.List;

public class Configuration implements GComposant, GConnector{

	private List<GComposant> listComposants;
	private List<GConnector> listConnectors;
	
	private List<InterfaceConfiguration> listInterface;
	private List<Binding> listBindings;
	private List<Attachment> listAttachments;
	
	public Configuration(List<GComposant> listComposants, List<GConnector> listConnectors,
			List<InterfaceConfiguration> listInterface, List<Binding> listBindings, List<Attachment> listAttachments) {
		super();
		this.listComposants = listComposants;
		this.listConnectors = listConnectors;
		this.listInterface = listInterface;
		this.listBindings = listBindings;
		this.listAttachments = listAttachments;
	}
	
	public void send(String msg, Port p) {
		String name = p.getName();
		if (listBindings.size() > 0) {
			// Parcours bindings puis attachements
			for(Binding b : listBindings) {
				if(b.getPort1().getName().equals("name")) {
					for(Attachment a : listAttachments) {
						if (a.getPort().equals(b.getPort2().getName())) {
							a.getRole().receive(msg);
						}
					}
				}
			}
		}
		// parcours des attachements liés a ce port
		for(Attachment a : listAttachments) {
			if (a.getPort().equals("name")) {
				a.getRole().receive(msg);
			}
		}
	}
	
	public void send(String msg, Role r) {
		String name = r.getName();
		// parcours des attachements liés a ce port
		for(Attachment a : listAttachments) {
			if (a.getRole().equals("name")) {
				a.getPort().receive(msg);
				for(Binding b : listBindings) {
					if(b.getPort2().getName().equals(a.getPort().getName())) {
						b.getPort1().receive(msg);
					}
				}
			}
		}
	}
	
	public void receive(String msg, Port p) {
		String name = p.getName();
		if (listBindings.size() > 0) {
			// Parcours bindings puis attachements
			for(Binding b : listBindings) {
				if(b.getPort1().getName().equals(name)) {
					b.getPort1().receive(msg);
				}
			}
		}
	}
	
	public void receive(String msg, Role r) {
		// je sais pas trop comment faire, ni même si le msg va remonter ici
	}
	
	
	public List<GComposant> getListComposants() {
		return listComposants;
	}
	public void setListComposants(List<GComposant> listComposants) {
		this.listComposants = listComposants;
	}
	public List<GConnector> getListConnectors() {
		return listConnectors;
	}
	public void setListConnectors(List<GConnector> listConnectors) {
		this.listConnectors = listConnectors;
	}
	public List<InterfaceConfiguration> getListInterface() {
		return listInterface;
	}
	public void setListInterface(List<InterfaceConfiguration> listInterface) {
		this.listInterface = listInterface;
	}
	public List<Binding> getListBindings() {
		return listBindings;
	}
	public void setListBindings(List<Binding> listBindings) {
		this.listBindings = listBindings;
	}
	public List<Attachment> getListAttachments() {
		return listAttachments;
	}
	public void setListAttachments(List<Attachment> listAttachments) {
		this.listAttachments = listAttachments;
	}
	
	
}
