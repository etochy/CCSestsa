package M2;

import java.util.ArrayList;
import java.util.List;

public class Connector implements GConnector {
	
	private Configuration context;
	private Glue glue;
	private String description;
	
	public Connector(Glue g) {
		this.glue = g;
	}
	
	public String getDescription () {
		System.out.println(description);
		return description;
	}
	
	public Configuration getConfiguration () {
		return this.context;
	}
}
