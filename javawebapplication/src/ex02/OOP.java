package ex02;

public class OOP {
	private String name;
	private String description;
	
	public OOP() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OOP(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "OOP [name=" + name + ", description=" + description + "]";
	}
}
