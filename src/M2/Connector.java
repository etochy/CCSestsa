package M2;

import java.util.ArrayList;
import java.util.List;

public class Connector implements GConnector {
	
	private Configuration context;
	private Glue glue;
	private String description;
	
	public Connector() {
	}
	
	public Connector(Glue g) {
		this.glue = g;
	}
	
	public String getDescription () {
		System.out.println(description);
		return description;
	}

	/**
	 * @return the context
	 */
	public Configuration getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(Configuration context) {
		this.context = context;
	}

	/**
	 * @return the glue
	 */
	public Glue getGlue() {
		return glue;
	}

	/**
	 * @param glue the glue to set
	 */
	public void setGlue(Glue glue) {
		this.glue = glue;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
