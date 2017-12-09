package M2;

public class Glue {
	private InterfaceConnector interfaceRequired;
	private InterfaceConnector interfaceSupplied;
	
	public Glue (InterfaceConnector req, InterfaceConnector sup) {
		this.interfaceRequired = req;
		this.interfaceSupplied = sup;
	}
}
