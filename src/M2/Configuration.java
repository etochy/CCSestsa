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
