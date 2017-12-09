package M2;

public class Binding extends Lien{
	
	private Port port;
	
	public Binding(Configuration context, Type t, Port p) {
		super(context,t);
		this.port = p;
		// TODO Auto-generated constructor stub
	}

	public Port getPort() {
		return port;
	}

	public void setPort(Port port) {
		this.port = port;
	}
	
}
