package M2;

public abstract class InterfaceConnector {
	private Role role;
	private String type;
	
	// Type : Supplied / Required
	// TODO : Change for a TYPE with two constants
	public InterfaceConnector (Role r, String type) {
		this.role = r;
	}
	
	public String getInterfaceType () {
		return type;
	}
}
