package M1;

import java.util.List;

import M2.Attachment;
import M2.Binding;
import M2.Composant;
import M2.Configuration;
import M2.Connector;
import M2.GComposant;
import M2.GConnector;
import M2.Glue;
import M2.InterfaceComposants;
import M2.InterfaceConfiguration;
import M2.InterfaceConnector;
import M2.Port;
import M2.Role;
import M2.Type;

public class SystemeServeur extends Configuration{

	public SystemeServeur(Composant c) {
		super();
		this.setContext(c);
	}
	public SystemeServeur(List<GComposant> listComposants, List<GConnector> listConnectors,
			List<InterfaceConfiguration> listInterface, List<Binding> listBindings, List<Attachment> listAttachments) {
		super(listComposants, listConnectors, listInterface, listBindings, listAttachments);
		// TODO Auto-generated constructor stub
	}

	public void creerSystemServ() {
		// CREATION INTERFACE SYSTEME ET PORTS
		InterfaceConfiguration interR = new InterfaceConfiguration(this, Type.REQUIRED);
		InterfaceConfiguration interS = new InterfaceConfiguration(this, Type.SUPPLIED);

		//ports
		Port pRSys = new Port(interR, Type.REQUIRED, "pRSysServer");
		Port pSSys = new Port(interS, Type.SUPPLIED, "pSSysServer");

		interR.addR(pRSys);
		interS.addS(pSSys);

		// BINDING AVEC SERVEUR
		for(Port b : this.getContext().getInterS().getListPortS())
			System.out.println("============= Port " + b.getName());
		this.add(new Binding(this, Type.REQUIRED, this.getContext().getInterR().getListPortR().get(0), pRSys)); //un seul port requis sur server
		this.add(new Binding(this, Type.SUPPLIED, this.getContext().getInterS().getListPortS().get(0), pSSys)); //un seul port fourni sur server

		// CREATION CONNEXION_MANAGER
		ConnexionManager connexionManager = new ConnexionManager(this);

		InterfaceComposants iRConnexion = new InterfaceComposants(connexionManager, Type.REQUIRED);
		InterfaceComposants iSConnexion = new InterfaceComposants(connexionManager, Type.SUPPLIED);

		Port pRConnexion = new Port(iRConnexion, Type.REQUIRED, "pRConnexion");
		Port pSConnexion = new Port(iSConnexion, Type.SUPPLIED, "pSConnexion");

		Port pRConnexionBDD = new Port(iRConnexion, Type.REQUIRED, "pRConnexionBDD");
		Port pSConnexionBDD = new Port(iSConnexion, Type.SUPPLIED, "pSConnexionBDD");
		Port pRConnexionSecu = new Port(iRConnexion, Type.REQUIRED, "pRConnexionSecu");
		Port pSConnexionSecu = new Port(iSConnexion, Type.SUPPLIED, "pSConnexionSecu");

		iRConnexion.addR(pRConnexion);
		iSConnexion.addS(pSConnexion);

		iRConnexion.addR(pRConnexionBDD);
		iSConnexion.addS(pSConnexionBDD);
		iRConnexion.addR(pRConnexionSecu);
		iSConnexion.addS(pSConnexionSecu);

		connexionManager.setInterR(iRConnexion);
		connexionManager.setInterS(iSConnexion);

		add(connexionManager);
		// BINDING AVEC CONNEXION_MANAGER
		this.add(new Binding(this, Type.REQUIRED, pRConnexion, pRSys));
		this.add(new Binding(this, Type.SUPPLIED, pSConnexion, pSSys));
		
		// CREATION SECURITY_MANAGER
		SecurityManager securityManager = new SecurityManager(this);

		InterfaceComposants iRSecurity = new InterfaceComposants(securityManager, Type.REQUIRED);
		InterfaceComposants iSSecurity = new InterfaceComposants(securityManager, Type.SUPPLIED);

		Port pRSecuConnexion = new Port(iRSecurity, Type.REQUIRED, "pRSecuConnexion");
		Port pSSecuConnexion = new Port(iSSecurity, Type.SUPPLIED, "pSSecuConnexion");
		Port pRSecuBDD = new Port(iRSecurity, Type.REQUIRED, "pRSecuBDD");
		Port pSSecuBDD = new Port(iSSecurity, Type.SUPPLIED, "pSSecuBDD");

		iRSecurity.addR(pRSecuConnexion);
		iSSecurity.addS(pSSecuConnexion);
		iRSecurity.addR(pRSecuBDD);
		iSSecurity.addS(pSSecuBDD);

		securityManager.setInterR(iRSecurity);
		securityManager.setInterS(iSSecurity);

		add(securityManager);

		// CREATION BDD
		BDD bdd = new BDD(this);

		InterfaceComposants iRBdd = new InterfaceComposants(bdd, Type.REQUIRED);
		InterfaceComposants iSBdd = new InterfaceComposants(bdd, Type.SUPPLIED);

		Port pRBddConnexion = new Port(iRBdd, Type.REQUIRED, "pRBddConnexion");
		Port pSBddConnexion = new Port(iSBdd, Type.SUPPLIED, "pSBddConnexion");
		Port pRBddSecu = new Port(iRBdd, Type.REQUIRED, "pRBddSecu");
		Port pSBddSecu = new Port(iSBdd, Type.SUPPLIED, "pSBddSecu");

		iRBdd.addR(pRBddConnexion);
		iSBdd.addS(pSBddConnexion);
		iRBdd.addR(pRBddSecu);
		iSBdd.addS(pSBddSecu);

		bdd.setInterR(iRBdd);
		bdd.setInterS(iSBdd);

		add(bdd);

		// ATTACHMENTS CONNEXION-SECU
		// connSecu1
		Connector connSecu1 = new Connector(this);
		Glue grconnSecu1 = new Glue(connSecu1);
		InterfaceConnector interRconnSecu1 = new InterfaceConnector(Type.REQUIRED, grconnSecu1);
		InterfaceConnector interSconnSecu1 = new InterfaceConnector(Type.SUPPLIED, grconnSecu1);
		Role rconnSecu1R = new Role("Role connSecu 1 Requis", Type.REQUIRED, interRconnSecu1, "rconnSecu1R");
		Role rconnSecu1S = new Role("Role connSecu 1 Fourni", Type.SUPPLIED, interSconnSecu1, "rconnSecu1S");
		interRconnSecu1.addRole(rconnSecu1R);
		interSconnSecu1.addRole(rconnSecu1S);
		grconnSecu1.setInterfaceRequired(interRconnSecu1);
		grconnSecu1.setInterfaceSupplied(interSconnSecu1);
		connSecu1.setGlue(grconnSecu1);
		this.add(new Attachment(this, Type.REQUIRED, pRConnexionSecu, rconnSecu1S)); //port requis vers role fourni
		this.add(new Attachment(this, Type.SUPPLIED, pSSecuConnexion, rconnSecu1R)); //port fourni vers role requis
		add(connSecu1);
		// connSecu2
		Connector connSecu2 = new Connector(this);
		Glue grconnSecu2 = new Glue(connSecu2);
		InterfaceConnector interRconnSecu2 = new InterfaceConnector(Type.REQUIRED, grconnSecu2);
		InterfaceConnector interSconnSecu2 = new InterfaceConnector(Type.SUPPLIED, grconnSecu2);
		Role rconnSecu2R = new Role("Role connSecu 1 Requis", Type.REQUIRED, interRconnSecu2, "rconnSecu2R");
		Role rconnSecu2S = new Role("Role connSecu 1 Fourni", Type.SUPPLIED, interSconnSecu2, "rconnSecu2S");
		interRconnSecu2.addRole(rconnSecu2R);
		interSconnSecu2.addRole(rconnSecu2S);
		grconnSecu2.setInterfaceRequired(interRconnSecu2);
		grconnSecu2.setInterfaceSupplied(interSconnSecu2);
		connSecu2.setGlue(grconnSecu2);
		this.add(new Attachment(this, Type.REQUIRED, pRSecuConnexion, rconnSecu2S)); //port requis vers role fourni
		this.add(new Attachment(this, Type.SUPPLIED, pSConnexionSecu, rconnSecu2R)); //port fourni vers role requis
		add(connSecu2);

		// ATTACHMENTS CONNEXION-BDD
		// connBdd1
		Connector connBdd1 = new Connector(this);
		Glue grconnBdd1 = new Glue(connBdd1);
		InterfaceConnector interRconnBdd1 = new InterfaceConnector(Type.REQUIRED, grconnBdd1);
		InterfaceConnector interSconnBdd1 = new InterfaceConnector(Type.SUPPLIED, grconnBdd1);
		Role rconnBdd1R = new Role("Role connBdd 1 Requis", Type.REQUIRED, interRconnBdd1, "rconnBdd1R");
		Role rconnBdd1S = new Role("Role connBdd 1 Fourni", Type.SUPPLIED, interSconnBdd1, "rconnBdd1S");
		interRconnBdd1.addRole(rconnBdd1R);
		interSconnBdd1.addRole(rconnBdd1S);
		grconnBdd1.setInterfaceRequired(interRconnBdd1);
		grconnBdd1.setInterfaceSupplied(interSconnBdd1);
		connBdd1.setGlue(grconnBdd1);
		this.add(new Attachment(this, Type.REQUIRED, pRConnexionBDD, rconnBdd1S)); //port requis vers role fourni
		this.add(new Attachment(this, Type.SUPPLIED, pSBddConnexion, rconnBdd1R)); //port fourni vers role requis
		add(connBdd1);
		// connBdd2
		Connector connBdd2 = new Connector(this);
		Glue grconnBdd2 = new Glue(connBdd2);
		InterfaceConnector interRconnBdd2 = new InterfaceConnector(Type.REQUIRED, grconnBdd2);
		InterfaceConnector interSconnBdd2 = new InterfaceConnector(Type.SUPPLIED, grconnBdd2);
		Role rconnBdd2R = new Role("Role connBdd 1 Requis", Type.REQUIRED, interRconnBdd2, "rconnBdd2R");
		Role rconnBdd2S = new Role("Role connBdd 1 Fourni", Type.SUPPLIED, interSconnBdd2, "rconnBdd2S");
		interRconnBdd2.addRole(rconnBdd2R);
		interSconnBdd2.addRole(rconnBdd2S);
		grconnBdd2.setInterfaceRequired(interRconnBdd2);
		grconnBdd2.setInterfaceSupplied(interSconnBdd2);
		connBdd2.setGlue(grconnBdd2);
		this.add(new Attachment(this, Type.REQUIRED, pRBddConnexion, rconnBdd2S)); //port requis vers role fourni
		this.add(new Attachment(this, Type.SUPPLIED, pSConnexionBDD, rconnBdd2R)); //port fourni vers role requis
		add(connBdd2);

		// ATTACHMENTS BDD-SECU
		// secuBdd1
		Connector secuBdd1 = new Connector(this);
		Glue grsecuBdd1 = new Glue(connSecu1);
		InterfaceConnector interRsecuBdd1 = new InterfaceConnector(Type.REQUIRED, grsecuBdd1);
		InterfaceConnector interSsecuBdd1 = new InterfaceConnector(Type.SUPPLIED, grsecuBdd1);
		Role rsecuBdd1R = new Role("Role connBdd 1 Requis", Type.REQUIRED, interRsecuBdd1, "rsecuBdd1R");
		Role rsecuBdd1S = new Role("Role connBdd 1 Fourni", Type.SUPPLIED, interSsecuBdd1, "rsecuBdd1S");
		interRsecuBdd1.addRole(rsecuBdd1R);
		interSsecuBdd1.addRole(rsecuBdd1S);
		grsecuBdd1.setInterfaceRequired(interRsecuBdd1);
		grsecuBdd1.setInterfaceSupplied(interSsecuBdd1);
		secuBdd1.setGlue(grsecuBdd1);
		this.add(new Attachment(this, Type.REQUIRED, pRSecuBDD, rsecuBdd1S)); //port requis vers role fourni
		this.add(new Attachment(this, Type.SUPPLIED, pSBddSecu, rsecuBdd1R)); //port fourni vers role requis
		add(secuBdd1);
		// secuBdd2
		Connector secuBdd2 = new Connector(this);
		Glue grsecuBdd2 = new Glue(secuBdd2);
		InterfaceConnector interRsecuBdd2 = new InterfaceConnector(Type.REQUIRED, grsecuBdd2);
		InterfaceConnector interSsecuBdd2 = new InterfaceConnector(Type.SUPPLIED, grsecuBdd2);
		Role rsecuBdd2R = new Role("Role secuBdd 1 Requis", Type.REQUIRED, interRsecuBdd2, "rsecuBdd2R");
		Role rsecuBdd2S = new Role("Role secuBdd 1 Fourni", Type.SUPPLIED, interSsecuBdd2, "rsecuBdd2S");
		interRsecuBdd2.addRole(rsecuBdd2R);
		interSsecuBdd2.addRole(rsecuBdd2S);
		grsecuBdd2.setInterfaceRequired(interRsecuBdd2);
		grsecuBdd2.setInterfaceSupplied(interSsecuBdd2);
		secuBdd2.setGlue(grsecuBdd2);
		this.add(new Attachment(this, Type.REQUIRED, pRBddSecu, rsecuBdd2S)); //port requis vers role fourni
		this.add(new Attachment(this, Type.SUPPLIED, pSSecuBDD, rsecuBdd2R)); //port fourni vers role requis
		add(secuBdd2);
	}
}
