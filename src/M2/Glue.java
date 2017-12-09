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
	
	public String processMessage (String message) {
		// Do something : has to be implemented for every class extending Glue
		return message;
		
	}
	
	public void send (String message) {
		interfaceSupplied.send(message, context.getConfiguration());
	}
	
	public void receive (String message) {
		send(processMessage(message));
	}
}
