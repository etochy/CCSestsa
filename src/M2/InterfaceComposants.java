package M2;

import java.util.List;

public class InterfaceComposants {
	private Composant context;
	private Type type;
	
	private List<Service> listServR;
	private List<Service> listServS;
	
	private List<Port>listPortR;
	private List<Port>listPortS;
	
	public InterfaceComposants(Composant context, Type type, List<Service> listServR, List<Service> listServS,
			List<Port> listPortR, List<Port> listPortS) {
		super();
		this.context = context;
		this.type = type;
		this.listServR = listServR;
		this.listServS = listServS;
		this.listPortR = listPortR;
		this.listPortS = listPortS;
	}
	
	public void send(String msg, Port name) {
		if(type == Type.REQUIRED) {
			System.out.println("Impossible dans ce sens");
		}else {
			System.out.println("send port : " + msg);
			this.context.send(msg, name);
		}		
	}
	public void receive(String msg, Port name) {
		if(type == Type.REQUIRED) {
			System.out.println("receive port : " + msg);
			this.context.receive(msg, name);
		}else {
			System.out.println("Impossible dans ce sens");
		}	
	}
	
	public Composant getContext() {
		return context;
	}
	public void setContext(Composant context) {
		this.context = context;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	public List<Service> getListServR() {
		return listServR;
	}

	public void setListServR(List<Service> listServR) {
		this.listServR = listServR;
	}

	public List<Service> getListServS() {
		return listServS;
	}

	public void setListServS(List<Service> listServS) {
		this.listServS = listServS;
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
