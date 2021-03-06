package M2;

import java.util.ArrayList;
import java.util.List;

public class InterfaceConfiguration {
	private Configuration context;
	private Type type;
	
	private List<Port> listPortR;
	private List<Port> listPortS;
	
	public InterfaceConfiguration(Configuration context, Type type) {
		super();
		this.context = context;
		this.type = type;
		this.listPortR = new ArrayList<Port>();
		this.listPortS = new ArrayList<Port>();
	}

	public void send(String msg, Port name) {
		if(type == Type.REQUIRED) {
			System.out.println("Impossible dans ce sens");
		}else {
			System.out.println(this.getClass().toString() + " send " + msg + " from " + name.getName());
			this.context.send(msg, name); // si le type correspond, notifie le contexte
		}		
	}
	public void receive(String msg, Port name) {
		if(type == Type.REQUIRED) {
			System.out.println(this.getClass().toString() + " receive " + msg + " from " + name.getName());
			this.context.receive(msg, name);// si le type correspond, notifie le contexte
		}else {
			System.out.println("Impossible dans ce sens");
		}	
	}
	
	public boolean addR(Port e) {
		return listPortR.add(e);
	}
	public boolean addS(Port e) {
		return listPortS.add(e);
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
