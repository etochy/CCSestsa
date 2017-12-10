package M2;

import java.util.ArrayList;
import java.util.List;

public abstract class Configuration implements GComposant, GConnector{

	private List<GComposant> listComposants;
	private List<GConnector> listConnectors;

	private List<InterfaceConfiguration> listInterface;
	private List<Binding> listBindings;
	private List<Attachment> listAttachments;
	
	// si est contenu par un composant
	private Composant context = null;

	// Port recu precedent, permet d'eviter les boucles infinies dans certains cas
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
		String name = p.getName();
		if (listBindings.size() > 0) {
			// Parcours bindings puis attachements
			for(Binding b : listBindings) { //liste les bindings
				if(b.getPort1().getName().equals(name)) { //trouve le binding correspondant
					for(Attachment a : listAttachments) { // liste les attachements
						if (a.getPort().getName().equals(b.getPort2().getName())) { //trouve l'attachement correspondant au binding
							System.out.println(this.getClass().toString() + " send " + msg + " from " + p.getName() + " to "+a.getRole().getName());
							a.getRole().receive(msg); //envoi le message au role
						}
					}
					if(getContext() != null) {
						// Permet le passage d'un message dans une suite de bindings (exemple, entre ConnexionManager et Systeme clientServer)
						for(Binding b2 : listBindings) { //liste les bindings
							if(b.getPort2().getName().equals(b2.getPort2().getName()) && !b2.getPort1().getName().equals(name)) { //recupere le bon, evite les boucles
								for(Attachment a : getContext().getContext().getListAttachments()) { //recupere les attachements
									if (a.getPort().getName().equals(b2.getPort1().getName())) {
										System.out.println(this.getClass().toString() + " send " + msg + " from " + p.getName() + " to "+a.getRole().getName());
										a.getRole().receive(msg); //envoi le message au role

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
				System.out.println(this.getClass().toString() + " send " + msg + " from " + p.getName() + " to "+a.getRole().getName());
				a.getRole().receive(msg);
			}
		}
	}

	public void send(String msg, Role r) {
		String name = r.getName();
		// parcours des attachements liés a ce port
		for(Attachment a : listAttachments) {
			if (a.getRole().getName().equals(name)) { //si attachement
				a.getPort().receive(msg);
				for(Binding b : listBindings) { //envoi le message a travers les bindings existants
					if(b.getPort2().getName().equals(a.getPort().getName())) {
						System.out.println(this.getClass().toString() + " send " + msg + " from " + r.getName() + " to "+b.getPort1().getName());
						b.getPort1().receive(msg);
					}
				}
			}
		}
	}

	public void receive(String msg, Port p) {
		String name = p.getName();
		if (listBindings.size() > 0) {
			// Parcours bindings puis attachements
			for(Binding b : listBindings) {
				if(b.getPort1().getName().equals(name)) { //si binding Composant - Config
					recuPrec = p;
					System.out.println(this.getClass().toString() + " send " + msg + " from " + p.getName() + " to "+b.getPort2().getName());
					b.getPort2().receive(msg); // envoi le message au port
				}
				if(b.getPort2().getName().equals(name)) { //si binding Config - Composant
					// evite de boucler sur le precedent port
					if(recuPrec != null)
						if(!b.getPort1().getName().equals(recuPrec.getName())) {
							recuPrec = p;
							System.out.println(this.getClass().toString() + " send " + msg + " from " + p.getName() + " to "+b.getPort1().getName());
							b.getPort1().receive(msg); //envoi le message au port
						}
				}
			}
		}
	}

	public void receive(String msg, Role r) {
		// aucun msg ne doit remonter ici
		System.out.println("Ne dois pas venir ici");
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
		return listBindings.add(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(Attachment arg0) {
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
