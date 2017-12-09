package M2;

public class Glue {
	
	private Connector context;
	private InterfaceConnector interfaceRequired;
	private InterfaceConnector interfaceSupplied;
	
	public Glue (InterfaceConnector req, InterfaceConnector sup, Connector parent) {
		this.interfaceRequired = req;
		this.interfaceSupplied = sup;
		this.context = parent;
	}
	
	public Connector getContext () {
		return this.context;
	}
}
