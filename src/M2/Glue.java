package M2;

public class Glue {
	
	private Connector context;
	private InterfaceConnector interfaceRequired;
	private InterfaceConnector interfaceSupplied;
	public Glue (Connector parent) {
		this.context = parent;
	}
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
		for (Role r : interfaceSupplied.getRoles()) {
			this.context.send(message, r);
		}
	}
	
	public void receive (String message) {
		send(processMessage(message));
	}
	/**
	 * @return the interfaceRequired
	 */
	public InterfaceConnector getInterfaceRequired() {
		return interfaceRequired;
	}
	/**
	 * @param interfaceRequired the interfaceRequired to set
	 */
	public void setInterfaceRequired(InterfaceConnector interfaceRequired) {
		this.interfaceRequired = interfaceRequired;
	}
	/**
	 * @return the interfaceSupplied
	 */
	public InterfaceConnector getInterfaceSupplied() {
		return interfaceSupplied;
	}
	/**
	 * @param interfaceSupplied the interfaceSupplied to set
	 */
	public void setInterfaceSupplied(InterfaceConnector interfaceSupplied) {
		this.interfaceSupplied = interfaceSupplied;
	}
	/**
	 * @param context the context to set
	 */
	public void setContext(Connector context) {
		this.context = context;
	}
	
	
}
