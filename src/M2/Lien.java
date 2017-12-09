package M2;

public abstract class Lien {
	private Configuration context;
	private Type type;
	
	public Lien(Configuration context, Type t) {
		super();
		this.type = t;
		this.context = context;
	}

	public Configuration getContext() {
		return context;
	}

	public void setContext(Configuration context) {
		this.context = context;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
}
