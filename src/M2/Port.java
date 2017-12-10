package M2;

public class Port {
	private InterfaceComposants contextComp = null;
	private InterfaceConfiguration contextConf = null;
	private Type type;
	private String name;

	public Port(InterfaceComposants context, Type t, String n) {
		super();
		this.contextComp = context;
		this.type = t;
		this.name = n;
	}

	public Port(InterfaceConfiguration context, Type t, String n) {
		super();
		this.contextConf = context;
		this.type = t;
		this.name = n;
	}

	public void send(String msg) {
		if(type == Type.REQUIRED) {
			System.out.println("Impossible dans ce sens");
		}else {
			System.out.println("send port : "+this.name + " : " + msg);
			if(contextComp == null)
				this.contextConf.send(msg, this);
			else
				this.contextComp.send(msg, this);
		}		
	}
	public void receive(String msg) {
		if(type == Type.REQUIRED) {
			System.out.println("receive port : " +this.name + " : " + msg);
			if(contextComp == null)
				this.contextConf.receive(msg, this);
			else
				this.contextComp.receive(msg, this);

		}else {
			System.out.println("Impossible dans ce sens");
		}	
	}

	// getters setters


	public Type getType() {
		return type;
	}

	public InterfaceComposants getContextComp() {
		return contextComp;
	}

	public void setContextComp(InterfaceComposants contextComp) {
		this.contextComp = contextComp;
	}

	public InterfaceConfiguration getContextConf() {
		return contextConf;
	}

	public void setContextConf(InterfaceConfiguration contextConf) {
		this.contextConf = contextConf;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String n) {
		this.name = n;
	}


}
