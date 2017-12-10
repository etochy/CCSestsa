package M2;

public class Binding extends Lien{
	
	private Port port1; //port extern, en provenance d'un composant
	private Port port2; //port intern Config
	
	public Binding(Configuration context, Type t, Port p1, Port p2) {
		super(context,t);
		this.port1 = p1;
		this.port2 = p2;
		// TODO Auto-generated constructor stub
	}

	public Port getPort1() {
		return port1;
	}

	public void setPort1(Port port1) {
		this.port1 = port1;
	}

	public Port getPort2() {
		return port2;
	}

	public void setPort2(Port port2) {
		this.port2 = port2;
	}


}
