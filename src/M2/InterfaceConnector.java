package M2;

import java.util.List;

public abstract class InterfaceConnector {
	private List<Role> role;
	private String type;
	
	// Type : Supplied / Required
	// TODO : Change for a TYPE with two constants
	public InterfaceConnector (List<Role> r, String type) {
		this.role = r;
	}
	
	public String getInterfaceType () {
		return type;
	}
	
	public void addRole (Role r) {
		role.add(r);
	}
}
