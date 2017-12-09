package M2;

public class Service {
	private InterfaceComposants context;
	private String type;
	
	public Service(InterfaceComposants context, String t) {
		super();
		this.context = context;
		this.type = t;
	}

	public InterfaceComposants getContext() {
		return context;
	}

	public void setContext(InterfaceComposants context) {
		this.context = context;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
