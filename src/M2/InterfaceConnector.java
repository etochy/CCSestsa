package M2;

import java.util.List;

public class InterfaceConnector {
	private Glue context;
	private List<Role> role;
	private Type type;
	
	public InterfaceConnector (List<Role> r, Type type, Glue parent) {
		this.role = r;
		this.type = type;
		this.context = parent;
	}
	
	public Type getInterfaceType () {
		return type;
	}
	
	public void addRole (Role r) {
		role.add(r);
	}
	
	public Glue getContext () {
		return this.context;
	}
}
