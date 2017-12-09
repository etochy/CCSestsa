package M2;

public class Role {
	
	private InterfaceConnector context;
	private String roleDescription;
	
	public Role (String description, InterfaceConnector parent) {
		this.roleDescription = description;
		this.context = parent;
	}
	
	public String getRoleDescription () {
		return this.roleDescription;
	}
	
	public InterfaceConnector getContext () {
		return this.context;
	}

}
