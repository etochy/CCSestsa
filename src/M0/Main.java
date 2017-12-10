package M0;

import M1.SystemeC_S;

public class Main {

	public static void main(String[] args) {
		System.out.println("Creation system");
		SystemeC_S sys = new SystemeC_S();
		sys.getClient().ecrireServeur("test");
		sys.getClient().ecrireServeur("lecture");
	}

}
