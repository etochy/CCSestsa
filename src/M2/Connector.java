package M2;

public class Connector implements GConnector {
	private Glue glue_1;
	private Glue glue_2;
	private String description;
	
	public Connector(Glue g1, Glue g2) {
		this.glue_1 = g1;
		this.glue_2 = g2;
	}
	
	@Override
	public void printConnectorDescription() {
		System.out.println(description);
	}
}
