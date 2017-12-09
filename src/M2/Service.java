package M2;

public abstract class Service {
	private InterfaceComposants context;

	public Service(InterfaceComposants context) {
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
