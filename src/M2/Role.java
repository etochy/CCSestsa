package M2;

public class Role {
	
	private InterfaceConnector context;
	private String roleDescription;
	private Type type;
	private String name;
	
	public Role (String description, Type type, InterfaceConnector parent, String name) {
		this.roleDescription = description;
		this.context = parent;
		this.type = type;
		this.name = name;
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
	
	public String getName () {
		return this.name;
	}
	
	public void receive (String message) {
		System.out.println("receive role " +this.getName());
		context.receive(message);
	}
}
