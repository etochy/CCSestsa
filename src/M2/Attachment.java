package M2;

public class Attachment extends Lien{
	
	private Port port;
	private Role role;
	
	
	public Attachment(Configuration context, Type t, Port p, Role r) {
		super(context, t);
		this.port = p;
		this.role = r;
		// TODO Auto-generated constructor stub
	}

	public Port getPort() {
		return port;
	}

	public void setPort(Port port) {
		this.port = port;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
