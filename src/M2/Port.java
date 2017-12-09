package M2;

public abstract class Port {
	private InterfaceComposants context;

	public Port(InterfaceComposants context) {
		super();
		this.context = context;
	}

	public InterfaceComposants getContext() {
		return context;
	}

	public void setContext(InterfaceComposants context) {
		this.context = context;
	}
	
	
}
