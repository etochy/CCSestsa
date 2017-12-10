package M2;

import java.util.ArrayList;
import java.util.List;

public abstract class Configuration implements GComposant, GConnector{

	private List<GComposant> listComposants;
	private List<GConnector> listConnectors;

	private List<InterfaceConfiguration> listInterface;
	private List<Binding> listBindings;
	private List<Attachment> listAttachments;

	private Composant context = null;

	private Port recuPrec;

	public Configuration() {
		//Permet construction des listes
		listComposants = new ArrayList<GComposant>();
		listConnectors = new ArrayList<GConnector>();
		listInterface = new ArrayList<InterfaceConfiguration>();
		listBindings = new ArrayList<Binding>();
		listAttachments = new ArrayList<Attachment>();
	}

	public Configuration(List<GComposant> listComposants, List<GConnector> listConnectors,
			List<InterfaceConfiguration> listInterface, List<Binding> listBindings, List<Attachment> listAttachments) {
		super();
		this.listComposants = listComposants;
		this.listConnectors = listConnectors;
		this.listInterface = listInterface;
		this.listBindings = listBindings;
		this.listAttachments = listAttachments;
	}

	public void send(String msg, Port p) {
//		System.out.println("send Config port " + p.getName() + " : "+msg);
		String name = p.getName();
		if (listBindings.size() > 0) {
			// Parcours bindings puis attachements
			for(Binding b : listBindings) {
//				System.out.println("binding : "+b.getPort1().getName() + " - "+b.getPort2().getName() + " - "+ name);
				if(b.getPort1().getName().equals(name)) {
					//					System.out.println("binding : "+b.getPort1().getName() + " - "+b.getPort2().getName());
					for(Attachment a : listAttachments) {
						//						System.out.println("att : " + a.getPort().getName() + " - " +b.getPort2().getName());
						if (a.getPort().getName().equals(b.getPort2().getName())) {
//							System.out.println("Envoi role : " + a.getPort().getName() + " - " +a.getRole().getName());
							//							System.out.println("envoi role");
							a.getRole().receive(msg);
						}
					}
					if(getContext() != null) {
//						System.out.println("binding : "+b.getPort1().getName() + " - "+b.getPort2().getName() + " - "+ name);
//						System.out.println("Port : "+b.getPort1().getName() + " - "+b.getPort2().getName());
						for(Binding b2 : listBindings) {
							if(b.getPort2().getName().equals(b2.getPort2().getName()) && !b2.getPort1().getName().equals(name)) {
								System.out.println("binding 2 : "+b2.getPort1().getName() + " - "+b2.getPort2().getName() + " - "+ name);

								for(Attachment a : getContext().getContext().getListAttachments()) {
									//									System.out.println("att : " + a.getPort().getName() + " - " +a.getRole().getName());

									if (a.getPort().getName().equals(b2.getPort1().getName())) {

										System.out.println("envoi role : " + a.getPort().getName() + " - "+a.getRole().getName());
										a.getRole().receive(msg);

									}


								}
							}
						}
					}
				}
			}
		}
		// parcours des attachements liés a ce port
		for(Attachment a : listAttachments) {
			if (a.getPort().getName().equals(name)) {
				a.getRole().receive(msg);
			}
		}
	}

	public void send(String msg, Role r) {
		//		System.out.println("send Config role " + r.getName() + " : "+msg);
		String name = r.getName();
		// parcours des attachements liés a ce port
		for(Attachment a : listAttachments) {
			if (a.getRole().getName().equals(name)) {
				a.getPort().receive(msg);
				for(Binding b : listBindings) {
					if(b.getPort2().getName().equals(a.getPort().getName())) {
						//						System.out.println("binding send");
						b.getPort1().receive(msg);
					}
				}
			}
		}
	}

	public void receive(String msg, Port p) {
		//		System.out.println("receive " + p.getName());
		String name = p.getName();
		//		System.out.println("----------------------------");
		if (listBindings.size() > 0) {
			// Parcours bindings puis attachements
			//			System.out.println("Bindings " + name);
			for(Binding b : listBindings) {
				if(b.getPort1().getName().equals(name)) {
					//					System.out.println("parcours bind : " + b.getPort1().getName() + " - " + b.getPort2().getName());
					recuPrec = p;
					b.getPort2().receive(msg);
				}
				if(b.getPort2().getName().equals(name)) {
					//					System.out.println("parcours bind 2 : " + b.getPort1().getName() + " - " + b.getPort2().getName());
					//					System.out.println("precedent : " + recuPrec.getName() + " p : "+b.getPort1().getName());
					if(recuPrec != null)
						if(!b.getPort1().getName().equals(recuPrec.getName())) {
							//						System.out.println("envoi : "+b.getPort1().getName());
							recuPrec = p;
							b.getPort1().receive(msg);
						}
				}
			}
		}
	}

	public void receive(String msg, Role r) {
		// je sais pas trop comment faire, ni même si le msg va remonter ici
		System.out.println("ntm");
	}



	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(GComposant arg0) {
		return listComposants.add(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(GConnector arg0) {
		return listConnectors.add(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(InterfaceConfiguration arg0) {
		return listInterface.add(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(Binding arg0) {
		System.out.println("============= bind " + arg0.getPort1().getName() + " - " + arg0.getPort2().getName());
		return listBindings.add(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(Attachment arg0) {
		System.out.println("============= att " + arg0.getPort().getName() + " - " + arg0.getRole().getName());
		return listAttachments.add(arg0);
	}

	public List<GComposant> getListComposants() {
		return listComposants;
	}
	public void setListComposants(List<GComposant> listComposants) {
		this.listComposants = listComposants;
	}
	public List<GConnector> getListConnectors() {
		return listConnectors;
	}
	public void setListConnectors(List<GConnector> listConnectors) {
		this.listConnectors = listConnectors;
	}
	public List<InterfaceConfiguration> getListInterface() {
		return listInterface;
	}
	public void setListInterface(List<InterfaceConfiguration> listInterface) {
		this.listInterface = listInterface;
	}
	public List<Binding> getListBindings() {
		return listBindings;
	}
	public void setListBindings(List<Binding> listBindings) {
		this.listBindings = listBindings;
	}
	public List<Attachment> getListAttachments() {
		return listAttachments;
	}
	public void setListAttachments(List<Attachment> listAttachments) {
		this.listAttachments = listAttachments;
	}

	/**
	 * @return the context
	 */
	public Composant getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(Composant context) {
		this.context = context;
	}

	/**
	 * @return the recuPrec
	 */
	public Port getRecuPrec() {
		return recuPrec;
	}

	/**
	 * @param recuPrec the recuPrec to set
	 */
	public void setRecuPrec(Port recuPrec) {
		this.recuPrec = recuPrec;
	}


}
