package M2;

import java.util.List;

public class InterfaceComposants {
	private Composant context;
	private String type;
	
	private List<ServiceR> listServR;
	private List<ServiceS> listServS;
	
	private List<PortRequired>listPortR;
	private List<PortSupplied>listPortS;
	
	public InterfaceComposants(Composant context, String type, List<ServiceR> listServR, List<ServiceS> listServS,
			List<PortRequired> listPortR, List<PortSupplied> listPortS) {
		super();
		this.context = context;
		this.type = type;
		this.listServR = listServR;
		this.listServS = listServS;
		this.listPortR = listPortR;
		this.listPortS = listPortS;
	}
	
	public Composant getContext() {
		return context;
	}
	public void setContext(Composant context) {
		this.context = context;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<ServiceR> getListServR() {
		return listServR;
	}
	public void setListServR(List<ServiceR> listServR) {
		this.listServR = listServR;
	}
	public List<ServiceS> getListServS() {
		return listServS;
	}
	public void setListServS(List<ServiceS> listServS) {
		this.listServS = listServS;
	}
	public List<PortRequired> getListPortR() {
		return listPortR;
	}
	public void setListPortR(List<PortRequired> listPortR) {
		this.listPortR = listPortR;
	}
	public List<PortSupplied> getListPortS() {
		return listPortS;
	}
	public void setListPortS(List<PortSupplied> listPortS) {
		this.listPortS = listPortS;
	}
	
	
	
}
