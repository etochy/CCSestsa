package M2;

public class Role {
	
	private InterfaceConnector context;
	private String roleDescription;
	private Type type;
	
	public Role (String description, Type type, InterfaceConnector parent) {
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
	
	public Type getType () {
		System.out.println("Role is " + type);
		return this.type;
	}

}
