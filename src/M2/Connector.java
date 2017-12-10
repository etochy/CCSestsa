package M2;

public class Connector implements GConnector {
	
	private Configuration context;
	private Glue glue;
	private String description = "No description";
	
	public Connector(Configuration c) {
		this.context = c;
	}
	
	public Connector(Glue g) {
		this.glue = g;
	}
	
	public void send (String message, Role role) {
		context.send(message, role);
	}
	
	public String getDescription () {
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
