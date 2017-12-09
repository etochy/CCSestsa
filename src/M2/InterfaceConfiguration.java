package M2;

import java.util.List;

public class InterfaceConfiguration {
	private Configuration context;
	private Type type;
	
	private List<Port> listPortR;
	private List<Port> listPortS;
	
	public InterfaceConfiguration(Configuration context, Type type, List<Port> listPortR,
			List<Port> listPortS) {
		super();
		this.context = context;
		this.type = type;
		this.listPortR = listPortR;
		this.listPortS = listPortS;
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

	public List<Port> getListPortR() {
		return listPortR;
	}

	public void setListPortR(List<Port> listPortR) {
		this.listPortR = listPortR;
	}

	public List<Port> getListPortS() {
		return listPortS;
	}

	public void setListPortS(List<Port> listPortS) {
		this.listPortS = listPortS;
	}

	
}
