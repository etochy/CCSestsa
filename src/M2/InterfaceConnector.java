package M2;

import java.util.List;

public class InterfaceConnector {
	private Glue context;
	private List<Role> role;
	private String type;
	
	// Type : Supplied / Required
	// TODO : Change for a TYPE with two constants
	public InterfaceConnector (List<Role> r, String type, Glue parent) {
		this.role = r;
		this.type = type;
		this.context = parent;
	}
	
	public String getInterfaceType () {
		return type;
	}
	
	public void addRole (Role r) {
		role.add(r);
	}
	
	public Glue getContext () {
		return this.context;
	}
	
	public String getType () {
		System.out.println("Interface is " + type);
		return this.type;
	}
}
