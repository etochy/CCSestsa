package M1;

import java.util.List;

import M2.Attachment;
import M2.Binding;
import M2.Configuration;
import M2.GComposant;
import M2.GConnector;
import M2.Glue;
import M2.InterfaceComposants;
import M2.InterfaceConfiguration;
import M2.InterfaceConnector;
import M2.Port;
import M2.Role;
import M2.Type;

public class SystemeC_S extends Configuration{
	Client client;
	public SystemeC_S() {
		// CREATION INTERFACE SYSTEME ET PORTS
		InterfaceConfiguration interR = new InterfaceConfiguration(this, Type.REQUIRED);
		InterfaceConfiguration interS = new InterfaceConfiguration(this, Type.SUPPLIED);
		
		//ports vers client
		Port pRSys = new Port(interR, Type.REQUIRED, "pRSys");
		Port pSSys = new Port(interS, Type.SUPPLIED, "pSSys");
		
		interR.addR(pRSys);
		interS.addS(pSSys);
		
		// CREATION CLIENT
		this.client = new Client(this);
		
		InterfaceComposants iRClient = new InterfaceComposants(client, Type.REQUIRED);
		InterfaceComposants iSClient = new InterfaceComposants(client, Type.SUPPLIED);
		
		Port pRClient = new Port(iRClient, Type.REQUIRED, "pRClient");
		Port pSClient = new Port(iSClient, Type.SUPPLIED, "pSClient");
		
		iRClient.addR(pRClient);
		iSClient.addS(pSClient);
		
		client.setInterR(iRClient);
		client.setInterS(iSClient);

		add(client);
		// BINDING AVEC CLIENT
		this.add(new Binding(this, Type.REQUIRED, pRClient, pRSys));
		this.add(new Binding(this, Type.SUPPLIED, pSClient, pSSys));
		
		// Création serveur
		Serveur serveur = new Serveur(this);
		InterfaceComposants iRServeur = new InterfaceComposants(serveur, Type.REQUIRED);
		InterfaceComposants iSServeur = new InterfaceComposants(serveur, Type.SUPPLIED);
		
		Port pRServeur = new Port(iRServeur, Type.REQUIRED, "pRServeur");
		Port pSServeur = new Port(iSServeur, Type.SUPPLIED, "pSServeur");
		
		iRServeur.addR(pRServeur);
		iSServeur.addS(pSServeur);
		
		serveur.setInterR(iRServeur);
		serveur.setInterS(iSServeur);
		
		add(serveur);
		// ATTACHMENTS AVEC SERVEUR
		// rpc1
		RPC rpc1 = new RPC(this);
		Glue gr1 = new Glue(rpc1);
		InterfaceConnector interRrpc1 = new InterfaceConnector(Type.REQUIRED, gr1);
		InterfaceConnector interSrpc1 = new InterfaceConnector(Type.SUPPLIED, gr1);
		Role rRpc1R = new Role("Role rpc 1 Requis", Type.REQUIRED, interRrpc1, "rRpc1R");
		Role rRpc1S = new Role("Role rpc 1 Fourni", Type.SUPPLIED, interSrpc1, "rRpc1S");
		interRrpc1.addRole(rRpc1R);
		interSrpc1.addRole(rRpc1S);
		gr1.setInterfaceRequired(interRrpc1);
		gr1.setInterfaceSupplied(interSrpc1);
		rpc1.setGlue(gr1);
		this.add(new Attachment(this, Type.REQUIRED, pRSys, rRpc1S)); //port requis vers role fourni
		this.add(new Attachment(this, Type.SUPPLIED, pSServeur, rRpc1R)); //port fourni vers role requis
		add(rpc1);
		// rpc2
		RPC rpc2 = new RPC(this);
		Glue gr2 = new Glue(rpc2);
		InterfaceConnector interRrpc2 = new InterfaceConnector(Type.REQUIRED, gr2);
		InterfaceConnector interSrpc2 = new InterfaceConnector(Type.SUPPLIED, gr2);
		Role rRpc2R = new Role("Role rpc 2 Requis", Type.REQUIRED, interRrpc2, "rRpc2R");
		Role rRpc2S = new Role("Role rpc 2 Fourni", Type.SUPPLIED, interSrpc2, "rRpc2S");
		interRrpc2.addRole(rRpc2R);
		interSrpc2.addRole(rRpc2S);
		gr2.setInterfaceRequired(interRrpc2);
		gr2.setInterfaceSupplied(interSrpc2);
		rpc2.setGlue(gr2);
		this.add(new Attachment(this, Type.REQUIRED, pRServeur, rRpc2S)); //port requis vers role fourni
		this.add(new Attachment(this, Type.SUPPLIED, pSSys, rRpc2R)); //port fourni vers role requis
		add(rpc2);
		
		serveur.creerServ();// créer l'interieur du serveur une fois la premiere config fini
	}
	
	public SystemeC_S(List<GComposant> listComposants, List<GConnector> listConnectors,
			List<InterfaceConfiguration> listInterface, List<Binding> listBindings, List<Attachment> listAttachments) {
		super(listComposants, listConnectors, listInterface, listBindings, listAttachments);
		// TODO Auto-generated constructor stub
	}
	
	public Client getClient() {
		return client;
	}

}
