package M2;

public class Role {
	
	private InterfaceConnector context;
	private String roleDescription;
	private String type;
	
	public Role (String description, String type, InterfaceConnector parent) {
		this.roleDescription = description;
		this.context = parent;
		this.type = type;
	}
	
	public String getRoleDescription () {
		return this.roleDescription;
	}
	
	public InterfaceConnector getContext () {
		return this.context;
	}
	
	public String getType () {
		System.out.println("Role is " + type);
		return this.type;
	}

}
